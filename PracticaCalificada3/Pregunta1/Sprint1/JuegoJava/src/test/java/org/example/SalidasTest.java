package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalidasTest {
    private Juego juego;
    private Salidas salidas;

    @BeforeEach
    public void setUp() {
        juego = new Juego(10);
        salidas = new Salidas(juego);
    }

    @Test
    public void testMostrarLaberintoInicial() {
        assertDoesNotThrow(() -> salidas.mostrarLaberintoInicial());
    }

    @Test
    public void testPermitirMovimiento() {
        assertDoesNotThrow(() -> salidas.permitirMovimiento("N"));
    }
}