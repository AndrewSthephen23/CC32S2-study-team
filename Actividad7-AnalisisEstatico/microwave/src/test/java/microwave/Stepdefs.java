package microwave;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
//Clase que define los pasos para las pruebas de Cucumber
public class Stepdefs {
	//instancia de un microondas
	public Microwave microwave;
	//Metodo para convertir un mapa en un objeto Preset
	/*@DataTableType
	public Preset convertToPreset(Map<String, String> entry) {
		return new Preset(
				entry.get("name"),
				Integer.parseInt(entry.get("timeToCook")),
				Integer.parseInt(entry.get("powerLevel"))
		);
	}
	 */
	//Metodo para imprimir los digitos
	public void printDigits(byte [] digits) {
    	System.out.println("Digits is: " + 
    			digits[DisplayController.TENS_OF_MINUTES] + " " + 
    			digits[DisplayController.MINUTES] + " " + 
    			digits[DisplayController.TENS_OF_SECONDS] + " " + 
    			digits[DisplayController.SECONDS]);
	}
	//Metodo para imprimir el estado actual
	public void printStatus() {
		printDigits(microwave.digits());
		System.out.println("Mode is: " + microwave.getMode()); 
	}

 	//Metodo para configurar los presets
	@Given("^presets are$")
	public void presets_are(DataTable dataTable) throws Throwable{
		List<Preset> presets = new ArrayList<>();
		List<Map<String,String>> dataTableMaps = dataTable.asMaps(String.class, String.class);
		for (Map<String,String> row: dataTableMaps) {
			presets.add(new Preset(row.get("name")
					,Integer.parseInt(row.get("timeToCook"))
					,Integer.parseInt(row.get("powerLevel"))));
		}
		microwave = new Microwave(new ModeController(), new DisplayController(100), presets);
		microwave.setDoorOpen(false);
		presets.stream().forEach(p -> System.out.println(p));
	}
	/*
	//Metodo para manejar foobars como una tabla
	@Given("^foobars are$")
    // public void presets_are(List<List<String>> arg) throws Throwable {
    public void foobars_are(DataTable arg) throws Throwable {
		List<List<String>> doubleList = arg.asLists(String.class);// arg.raw();
		List<Map<String, String>> keyValueList = arg.asMaps(String.class, String.class);
		System.out.println("foobars (as list list) are: " + doubleList);
		System.out.println("foobars (as list map) are: " + keyValueList.toString());
		// System.out.println("This next one will fail!");
		// System.out.println("foobars (as map) are:" + arg.asMap(String.class, String.class));
	}
	 */
	//Metodo para configurar la tasa de refresco
    @Given("^polling rate is (\\d+) ms$")
    public void polling_rate_is_ms(int rate) throws Throwable {
    	microwave.setTickRateInHz(rate);
        // System.out.println("polling rate is " + rate + " ms.");
    }
	//Metodo para que un usuario presione un solo boton
	@Given("^([A-Za-z]+) presses the (\\d+) key$")
    public void user_presses_the_key(String user, int key) throws Throwable {
        // System.out.println(user + " presses the " + key + " key.");
        microwave.digitPressed(key); 
        microwave.tick();
        // printStatus();
	}
	//Metodo para que un usuario presione multiples botones
	/*
	@Given("^([A-Za-z]+) presses the following keys: (.*)$")

	public void user_presses_keys(String user, String keysString) {
		List<Integer> keys = Arrays.stream(keysString.split(" "))
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		for (Integer key : keys) {
			microwave.digitPressed(key);
			microwave.tick();
		}
	}

	public void user_presses_keys(String user, List<Integer> keys) {
        // System.out.println(user + " presses the following keys: " + keys.toString());
		for (Integer key: keys) {
			microwave.digitPressed(key);
			microwave.tick();
		}
	}
	 */
	//Metodo para que un usuario presione multiples botones utilizando una tabla
	@Given("^([A-Za-z]+) presses the following keys as a table:")
	public void user_presses_keys_table(String user, List<Integer> keys) {
        // System.out.println(user + " presses the following keys (using a table): " + keys.toString());
		for (Integer key: keys) {
			microwave.digitPressed(key);
			microwave.tick();
		}
	}
	//Metodo para que un usuario presione el boton de inicio
    @When("^([A-Za-z]+) presses the start key$")
    public void user_presses_the_start_key(String user) throws Throwable {
        // System.out.println(user + " presses the start key.");
        microwave.startPressed();
        microwave.tick();
        // printStatus();
    }
	//Metodo para simular el paso del tiempo
    @When("^(\\d+) seconds elapse$")
    public void seconds_elapse(int time) throws Throwable {
        // System.out.println("" + time + " seconds elapse.");
        for (int i = 0; i < 20*time; i++) {
        	microwave.tick(); 
        }
        // printStatus();
    }
	//Metodo para verificar que los digitos leidos son los esperados
    @Then("^digits reads (\\d)(\\d)(\\d)(\\d)$")
    public void digits_reads(int tensOfMinutes, int minutes, int tensOfSeconds, int seconds) throws Throwable {
    	// System.out.println("Digits expects: " + tensOfMinutes + " " + minutes + " " + tensOfSeconds + " " + seconds);
    	byte [] digits = microwave.digits();
		for (byte b:microwave.digits()){
			System.out.println(b);
		}
    	assertEquals((int)digits[DisplayController.TENS_OF_MINUTES], tensOfMinutes);
    	assertEquals((int)digits[DisplayController.MINUTES], minutes);
    	assertEquals((int)digits[DisplayController.TENS_OF_SECONDS], tensOfSeconds);
    	assertEquals((int)digits[DisplayController.SECONDS], seconds); 
    }
	//Metodo para verificar que el modo es de coccion
    @Then("^mode is cooking$")
    public void mode_is_cooking() throws Throwable {
    	// System.out.println("Mode is cooking");
    	assertEquals(Mode.Cooking , microwave.getMode());
    }
	//Metodo para verificar que el modo es de configuracion
    @Then("^mode is setup$")
    public void mode_is_setup() throws Throwable {
    	// System.out.println("Mode is setup");
    	assertEquals(Mode.Setup,microwave.getMode());
    }
	//Metodo para verificaar que el modo es suspendido
    @Then("^mode is suspended$")
    public void mode_is_suspended() throws Throwable {
    	// System.out.println("Mode is suspended");
    	assertEquals(Mode.Suspended,microwave.getMode());
    }
	//Metodo para que Bob presione una tecla de escenario
    @Given("^Bob presses the (\\d+) scenario key$")
    public void bob_presses_the_scenario_key(int arg1) throws Throwable {
    	microwave.presetPressed(arg1);
    }

	//Metodo para verificar que una tecla de escenario fuera de rango fallara
    @When("^Bob presses the (\\d+) scenario key it will out-of-range fail$")
    public void bob_presses_the_scenario_key_it_will_out_of_range_fail(int arg1) throws Throwable {
        try {
        	microwave.presetPressed(arg1);
        	fail("Test should have failed with out-of-range exception");
        } catch (IllegalArgumentException e) { }
    }
	//Metodo para verificar que una tecla de escenario en modo fallara
    @Then("^Bob presses the (\\d+) scenario key it will mode fail$")
    public void bob_presses_the_scenario_key_it_will_mode_fail(int arg1) throws Throwable {
        try {
        	microwave.presetPressed(arg1);
        	fail("Test should have failed with mode exception");
        } catch (IllegalArgumentException e) { }
    }
	//Metodo para que Bob presione el boton de limpiar
    @When("^Bob presses the clear key$")
    public void bob_presses_the_clear_key() throws Throwable {
    	microwave.clearPressed();
		microwave.tick();
    }

}
