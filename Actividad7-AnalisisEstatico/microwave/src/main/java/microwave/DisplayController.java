package microwave;
import java.util.Arrays;
public class DisplayController { //Clase que controla el display del microondas

	public static final int NO_PRESS = -1;//cte para indicar que ningun boton fue presionado
	
	// la representacion de digitos es 'big endian'.
	// ctes para representar las posiciones de los digitos en el display
	public static final int TENS_OF_MINUTES = 0;
	public static final int MINUTES = 1;
	public static final int TENS_OF_SECONDS = 2;
	public static final int SECONDS = 3;
	// valor de rollover para cada digito del display (cuando llega al maximo y vuelve a cero)
	static final byte [] ROLLOVER = {5, 9, 5, 9};

	private boolean [] digitPressed = new boolean [10];//arreglo que guarda los botones presionados
	private byte [] digits = new byte[4];//array que guarda los digitos que muestra el display
	private int tickRateInHz; // taza de refresco del display en Hz
	private int ticks;// contador de ticks
	
	public DisplayController(int tickRateInHz) {//constructor de la clase
		this.tickRateInHz = tickRateInHz;
		this.ticks = 0;
	}
	
	//Metodo para marcar un digito como presionado
	public synchronized void digitPressed(int key) {
		if (key >= 0 && key <= 9) {
			digitPressed[key] = true;
		}
	}

	//Metodo para limpiar la lista de botones presionados
	public synchronized void clearDigitPressed() {
		for (int i=0; i < 10; i++) {
			digitPressed[i] = false;
		}
	}
	//Metodo para limpiar los digitos mostrados en el display en ciertos modos
	public synchronized void clearKeyPressed(Mode m) {
		if (m == Mode.Suspended ||
			m == Mode.Setup) {
			Arrays.fill(digits,(byte) 0);
		}
	}
	//Metodo para calcular el tiempo total de coccion en segundos
	public synchronized int timeToCook() {
		return digits[SECONDS] + 
			   10*digits[TENS_OF_SECONDS] + 
			   60*digits[MINUTES] + 
			   600*digits[TENS_OF_MINUTES];
	}
	//Metodo para verificar si ha pasado un segundo
	public boolean secondElapsed() {
		return (ticks % tickRateInHz) == 0;
	}
	
	//Metodo que actualiza el display en funcion del modo actual del microondas
	public synchronized void tick(Mode mode) {

		switch (mode) {
			case Setup:
				setUp();
				break;
			case Suspended: /* No hace nada espera al usuario */
				break;
			case Cooking:
				cooking();
		}
		clearDigitPressed();
	}
	/*
	Refactorizacion del codigo
	 */
	//===========================================================
	private void setUp(){
		int tamanoArray=digits.length;
		byte numberPressed = NO_PRESS;
		ticks = 0 ;
		//Busca si se ha presionado un boton
		for (byte i = 0; i < 10; i++) {
			if (digitPressed[i]) {
				numberPressed = i;
				break;
			}
		}
		//Si se ha presionado un boton, actualiza los digitos mostrados
		if (numberPressed != NO_PRESS) {
			for (int i = 0; i < tamanoArray - 1; i++) {
				digits[i] = digits[i+1];
			}
			digits[tamanoArray - 1] = numberPressed;
		}
	}

	private void cooking(){
		int tamanoArray = digits.length;
		ticks++;
		//si ha pasado un segundo y el tiempo de coccion es diferente de cero, decrementa los digitos
		if (secondElapsed() && timeToCook() != 0) {
			for (int i = tamanoArray - 1; i >= 0; i--) {
				if (digits[i] != 0) {
					digits[i]--;
					break;
				} else {
					digits[i] = ROLLOVER[i];
					// no lleva al siguiente digito...oops.
				}
			}
		}
	}
	//===========================================================
	//Metodo para obtener los digitos mostrados en el display
	byte [] getDigits() {
		return digits;
	}
	//metodo para obtener la taza de refresco en el display
	int getTickRateInHz() {
		return tickRateInHz;
	}
	//Metodo para establecer la taza de refresco en el display
	void setTickRateInHz(int tickRate) {
		tickRateInHz = tickRate;
	}
	//Metodo para establecer los digitos mostrados en el display
	void setDigits(byte [] digits) {
		if (digits.length != 4) {
			throw new IllegalArgumentException("Wrong number of digits!");
		}
		for (byte d: digits) {
			if (d < 0 || d > 9) {
				throw new IllegalArgumentException("digits must be between 0..9");
			}
		}
		this.digits = digits;
	}
	//Metodo para establecer el metodo de coocion en segundos y actualizar los digitos mostrados
	void setTimeToCook(int time) {
		if (time < 0 || time >= 6000) {
			throw new IllegalArgumentException("setTimeToCook: Time must be positive and < 6000 seconds");
		}
		byte seconds = (byte)(time % 10);
		byte tensOfSeconds = (byte)((time / 10) % 6); 
		byte minutes = (byte)((time / 60) % 10); 
		byte tensOfMinutes = (byte)((time / 600) % 10);
		byte [] myArray = {tensOfMinutes, minutes, tensOfSeconds, seconds}; 
		setDigits(myArray);
	}
}
