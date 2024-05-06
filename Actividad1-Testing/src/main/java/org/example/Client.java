package org.example;

import java.util.ArrayList;//Importa la clase Arralist que se utiliza para crear la lista de direcciones del cliente
import java.util.List;//Importa la interfaz List que se utilizara como tipo de lista de direcciones del cliente
public class Client {
    /*
    Declara una lista de direcciones 'addresses' como una variable de tipo List
    que contiene objetos de tipo Address.
     */
    private List<Address> addresses;
    //Constructor de la clase cliente
    public Client() {
        //inicializa la lista de direcciones como una nueva instancia de ArrayList
        //esto garantiza que la lista este vacia al principio
        addresses = new ArrayList<>();
    }
    //Metodo permite agregar una nueva dirreccion a la lista de direcciones del cliente
    public void addAddress(Address address){
        //Toma un objeto de tipo "Address" y lo agrega a la lista "addresses"
        addresses.add(address);
    }
    //  Este método puede ser necesario para sus afirmaciones de prueba
    public List<Address> getAddresses() {
        return addresses;
    }
}
