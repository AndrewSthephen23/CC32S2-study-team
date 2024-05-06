package org.example;
import org.junit.jupiter.api.Test;//reconoce como una linea de prueba
import static org.assertj.core.api.Assertions.assertThat;//hace una importacion estatica de la clase assertj

class MoneyTest {//tiene que terminar en la palabra test, no tiene que ser publico
    @Test
    // El constructor debe establecer la cantidad y la moneda
    void constructorShouldSetAmountAndCurrency() { //Es el metodo de prueba
        // isEqualTo compara , assert (afirmar)
        Money money = new Money(10,"USD");// Se crea al SUT
        assertThat(money.getCurrency()).isEqualTo("USD");//El SUT se pone a prueba
        assertThat(money.getAmount()).isEqualTo(10);//El SUT se pone a prueba
    }

}