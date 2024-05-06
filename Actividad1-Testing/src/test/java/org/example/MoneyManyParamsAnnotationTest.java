package org.example;
import org.junit.jupiter.params.ParameterizedTest; //anotacion para pruebas parametrizadas
/*
Importa la anotacion "CsvSource" que proporciona los valores para los parametros
del metodo de prueba desde una fuente CSV
 */
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
//Clase MoneyMuchosParametrosAnotacionPrueba
public class MoneyManyParamsAnnotationTest {
    @ParameterizedTest //indica que el siguiente metodo es una prueba parametrizada
    @CsvSource({ //Proporciona valores a los parametros del metodo de prueba desde una fuente CSV
            "10,USD",// primer set de argumentos
            "15,EUR",//Segundo set de argumentos
            "50,CHF" //tercer set de argumentos
    })
    //constructorDebeAjustarCantidadYDivisa
    void constructorShouldSetAmountAndCurrency(int amount,String currency){
        Money money = new Money(amount,currency);//se crea un objeto Money
        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);
    }
}
