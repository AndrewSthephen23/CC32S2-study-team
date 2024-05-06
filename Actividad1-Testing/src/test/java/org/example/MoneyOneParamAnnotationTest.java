package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

//Clase MoneyUnParametroAnotacionPrueba
public class MoneyOneParamAnnotationTest {
    @ParameterizedTest
    @ValueSource(ints = {10,15,50}) //proveedor de datos de prueba
    //constructorDebeConfigurarCantidadYDivisa
    void constructorShouldSetAmountAndCurrency(int amount){
        Money money = new Money(amount,"USD");
        assertThat(money.getAmount()).isEqualTo(amount);
    }
}
