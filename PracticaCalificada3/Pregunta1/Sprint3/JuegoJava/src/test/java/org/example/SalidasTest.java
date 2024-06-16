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

    @Test
    public void testImprimirMensajes() {
        juego.getJugador().actualizarPos(5, 5);
        juego.getLaberinto().actualizarCelda(4, 5, 'T');
        juego.procesarComandos("N");
        System.out.println("x: " +juego.getJugador().getPosX()+ " y: " +juego.getJugador().getPosY());
        assertEquals(1, juego.getJugador().getPuntaje());

        juego.getLaberinto().actualizarCelda(5, 5, 'X');
        System.out.println(juego.getJugador().getVidas());
        juego.procesarComandos("S");
        salidas.imprimirMensajeCaerTrampa();
        assertEquals(2, juego.getJugador().getVidas());
    }

    @Test
    public void testMostrarPuntajeYVidas() {
        salidas.mostrarPuntajeYVidas();
        assertEquals(3, juego.getJugador().getVidas());
        assertEquals(0, juego.getJugador().getPuntaje());
    }

}