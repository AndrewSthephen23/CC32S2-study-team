package org.example;
/*
Esta anotacion se utiliza para indicar que el metodo es un caso de prueba
parametrizado,lo que significa que se ejecutara varias veces con diferentes
argumentos
 */
import org.junit.jupiter.params.ParameterizedTest;
/*
Esta anotacion proporciona valores para los parametros de un metodo de
prueba parametrizado.
 */
import org.junit.jupiter.params.provider.ValueSource;
/*
Importa el metodo 'assertThatExceptionOfType' de AssertJ. Este metodo se
utiliza para realizar afirmaciones sobre valores
 */
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoneyIATest { //Prueba de Money Ilegal Argumento
    private final static String VALID_CURRENCY="USD"; //Divisa valida para las pruebas
    @ParameterizedTest//Indica que el metodo siguiente es una prueba parametrizada
    /*
    Esta notacion proporciona valores para los parametros del metodo de prueba
    Proporciona una lista de negativos que se utilizaran como cantidades de dinero invalidas
     */
    @ValueSource(ints = {-12387,-5,-1})
    //ConstructorDebeTirarIAPorCantidadInvalida
    void constructorShouldThrowIAForInvalidAmount(int invalidAmount){//invalidAmount es una de las cantidades de dinero proporcionada por @ValueSource
        assertThatExceptionOfType(IllegalArgumentException.class)//Indica que espera que el constructor de Money lance una excepcion de tipo 'IllegalArgumentException'
                .isThrownBy(()->{//Este metodo  indica que se espera que el codigo dentro de las llaves lance una excepcion
                    new Money(invalidAmount,VALID_CURRENCY);//Intenta crear un nuevo objeto Money con cantidad invalida y divisa valida
                });
    }
}
