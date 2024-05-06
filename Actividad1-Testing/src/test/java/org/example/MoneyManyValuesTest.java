package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; //hace una importacion estatica de la clase assertj
public class MoneyManyValuesTest { //Prueba de muchos valores de Moneda
    public static final String USD="USD";
    @Test
    //El constructor debe establecer la cantidad y la divisa
    void constructorShouldSetAmountAndCurrency(){
        Money money = new Money(10,USD); //El SUT
        assertThat(money.getAmount()).isEqualTo(10);
        assertThat(money.getCurrency()).isEqualTo(USD);
        money = new Money(20,USD);
        assertThat(money.getAmount()).isEqualTo(20);
        assertThat(money.getCurrency()).isEqualTo(USD);
        // y asi 100,999,23908423 USD
    }

}
