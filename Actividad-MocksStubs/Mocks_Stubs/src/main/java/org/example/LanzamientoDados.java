package org.example;

import java.util.random.RandomGenerator;

public class LanzamientoDados {
    private final int NUMERO_LADOS=6;
    private final RandomGenerator rnd;
    public LanzamientoDados(NumerosAleatorios r) {
        this.rnd = r;
    }
    public String asText(){
        int lanzado = rnd.nextInt(NUMERO_LADOS)+1;

        return String.format("El lanzamiento es %d",lanzado);
    }
}
