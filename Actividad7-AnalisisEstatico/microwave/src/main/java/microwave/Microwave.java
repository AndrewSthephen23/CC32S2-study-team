package microwave;
import java.util.List;
// Clase que representa a un microondas
public class Microwave {
	private ModeController mc; // Controlador de modos
	private DisplayController dc; // Controlador de display
	List<Preset> presets; // Lista de presets
	private int powerLevel; // Nivel de potencia

	private boolean doorOpen, cooking; // Estado de la puerta y de cocción
	private Mode mode = Mode.Setup; // Modo actual
	//Constructor del microondas
	public Microwave(ModeController mc, DisplayController dc, 
			List<Preset> presets) {
		this.mc = mc;
		this.dc = dc;
		cooking = false;
		doorOpen = true; // Se inicia en estado de seguridad
		this.presets = presets;
	}

	//Metodo para presionar el boton de inicio
	public void startPressed() { mc.setStartPressed(true); }
	//Metodo para presionar el boton de limpiar
	public void clearPressed() { mc.setClearPressed(true); 
								 dc.clearKeyPressed(mc.getMode()); }
	// Método para presionar un dígito
	public void digitPressed(int digit) {
		dc.digitPressed(digit);
	}
	// Método para presionar un preset
	public void presetPressed(int preset) {
		if (preset < 1 || preset > presets.size()) {
			throw new IllegalArgumentException("Preset out of range for presetPressed.");
		}
		if (mode != Mode.Setup) {
			throw new IllegalArgumentException("Presets can only be used in setup mode");
		}
		// Seeded fault here
		Preset p = presets.get(preset - 1);
		
		dc.setTimeToCook(p.getTimeToCook());
		setPowerLevel(p.getPowerLevel());
	}
	// Método para establecer si la puerta está abierta o cerrada
	public void setDoorOpen(boolean doorOpen) { this.doorOpen = doorOpen; }
	// Método para establecer el nivel de potencia
	public void setPowerLevel(int powerLevel) { 
		if (powerLevel >= 1 && powerLevel <= 10) {
			this.powerLevel = powerLevel; 
		} else {
			throw new IllegalArgumentException("power level out of range");
		}
	}
	// Método para obtener el nivel de potencia
	public int getPowerLevel() {
		return this.powerLevel; 
	}
	// Método para verificar si la puerta está abierta
	public boolean isDoorOpen() {
		return doorOpen;
	}
	// Método de simulación del tiempo
	public void tick() {
		dc.tick(mode);
		mode = mc.tick(doorOpen, dc.timeToCook() != 0);
		cooking = (mode == Mode.Cooking);
	}
	// Método para verificar si está cocinando
	public boolean isCooking() { return cooking; }
	
	// Método para obtener los dígitos del display
	public byte [] digits() { return dc.getDigits(); } ;
	// Método para obtener el modo actual
	public Mode getMode() { return mode; }
	// Método para obtener la tasa de refresco del display
	public int getTickRateInHz() { return dc.getTickRateInHz(); }
	// Método para establecer la tasa de refresco del display
	public void setTickRateInHz(int tickRate) { dc.setTickRateInHz(tickRate); }
}
