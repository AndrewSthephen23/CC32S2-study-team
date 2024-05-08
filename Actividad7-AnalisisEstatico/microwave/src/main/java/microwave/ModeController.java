package microwave;
//Clase que controla los modos del microondas
public class ModeController {
	//variables de instancia
	private boolean startPressed = false;
	private boolean clearPressed = false;
	private Mode mode = Mode.Setup;
	private Mode preMode = Mode.Setup;
	//Metodo para verificar si se ha presionado el boton de inicio
	public synchronized boolean isStartPressed() {
		return startPressed;
	}
	//Metodo para establecer si se ha presionado el boton de inicio
	public synchronized void setStartPressed(boolean startPressed) {
		this.startPressed = startPressed;
	}
	//Metodo para verificar si se ha presionado el boton de limpiar
	public synchronized boolean isClearPressed() {
		return clearPressed;
	}
	//Metodo para establecer si se ha presionado el boton de limpiar
	public synchronized void setClearPressed(boolean clearPressed) {
		this.clearPressed = clearPressed;
	}
	//Metodo para obtener el modo actual del microondas
	public synchronized Mode getMode() {
	 	return mode;
	}
	//Metodo que actualiza el modo del microondas basado en las condiciones actuales
	synchronized Mode tick(boolean doorOpen, boolean timeRemaining) {

		if (!timeRemaining) {
			mode = Mode.Setup;
		}
		else if (doorOpen && mode == Mode.Cooking) {
			mode = Mode.Suspended;
		} 
		else if (clearPressed) {
			if (mode == Mode.Cooking) {
				mode = Mode.Suspended; 
			} else if (mode == Mode.Suspended) {
				mode = Mode.Setup;
			}
		} 
		else if (startPressed && !doorOpen) {
			mode = Mode.Cooking;
		}
		//Reinicia los estados de los botones
		startPressed = false;
		clearPressed = false;
		
		return mode;
	}
	//Metodo para verificar si el modo ha cambiado desde la ultima vez
	public boolean modeChanged() {
		return mode != preMode;
	}
	//Metodo para verificar si el microondas esta en modo de coccion
	public boolean inCooking() {
		return (mode == preMode &&
				mode == Mode.Cooking);
	}
	
}
