package org.example;

public class Address { //Clase Direccion
    private String street; //Variable de Calle

    public Address(String street) {
        this.street = street;
    }
    //suponiendo que por la noche necesites un getter para pruebas u otros

    public String getStreet() {
        return street;
    }
}
