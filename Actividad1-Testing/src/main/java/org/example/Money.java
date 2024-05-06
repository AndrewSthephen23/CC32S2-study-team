package org.example;

public class Money {
    /*
    final significa que una ves se inicializa
    en el constructor no puede ser cambiado
     */
    private final int amount; //Cantidad de dinero
    private final String currency; //Divisa tipo de moneda


    //======================Se Modifica el constructor para que
    /*
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
     */
    //=======================pase la prueba MoneyIATest

    //===> Nuevo Constructor
    public Money(int amount,String currency){
        if (amount<0){
            throw new IllegalArgumentException(
                    "illegal amount:[" + amount + "]");
        }
        this.amount = amount;
        this.currency = currency;
    }
    public int getAmount() {
        return amount; //retorna la cantidad
    }
    public String getCurrency() {
        return currency;//retorna la divisa
    }

    /*
    Metodo "equals" que compara si dos objetos de tipo Money son iguales
    "onObject" es el objeto a comparar
     */
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) { //Veridica si el objeto "anObject" es una instancia de la Clase Money
            Money money = (Money) anObject;// Se hace un casting del objeto "anObject" a "Money" y se le asigna la variable money
            /*
            Compara si la divisa y la cantidad de dinero son iguales en ambos objetos
             */
            return getCurrency().equals(money.getCurrency())
                    && getAmount() == money.getAmount();
        }
        return false;
    }

}
