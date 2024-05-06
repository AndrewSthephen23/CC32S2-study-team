package org.example;
/*
Importa la notacion "BeforeEach" que se utiliza para marcar un metodo
que se ejecutara antes de cada metodo de prueba
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ClientTest {
    private Address address = new Address("street A");
    private Address secondAddress = new Address("street B");
    private Client client;
    @BeforeEach //anotacion que indica que el metodo que sigue se ejecuta antes de cada prueba
    void setUp(){ //
        client = new Client();
    }
    @Test //Marca un metodo de prueba
    //despuesCreationDebeNoTenerDireccion
    void afterCreationShouldHaverNoAddress(){ //se tiene que afirmar que el cliente no tiene direccion
        assertThat(client.getAddresses()).isEmpty();//verifica que el nuevo cliente su lista de direcciones este vacia(isEmpty)
    }
    @Test
    //debePermitirAñadirDireccion
    void shouldAllowToAddAddress(){ //se tiene que afirma que el cliente tiene esta direccion
        client.addAddress(address);
        assertThat(client.getAddresses()).containsExactly(address);//containsExactly verifica que la lista de direcciones contenta exactamente los elemtos proporcionados en orden
    }
    @Test
    //debePermitirAñadirMuchasDirecciones
    void shouldAllowToAddManyAddresses(){//se debe afirmar que el cliente tiene 2 direcciones
        client.addAddress(address);
        client.addAddress(secondAddress);
        assertThat(client.getAddresses()).containsExactlyInAnyOrder(address,secondAddress);
        //containsExactlyInAnyOrder verifica que la lista de direcciones contenga exactamente los elementos proporcionados en cualquier orden
    }
}
