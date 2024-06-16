package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {
    private Juego juego;

    @BeforeEach
    public void setUp() {
        juego = new Juego(10);
    }

    @Test
    public void testIniciarJuego() {
        assertNotNull(juego.getLaberinto());
        assertNotNull(juego.getJugador());
    }

    @Test
    public void testProcesarComandos() {
        int x = juego.getJugador().getPosX();
        int y = juego.getJugador().getPosY();
        juego.procesarComandos("N");
        assertEquals(x - 1, juego.getJugador().getPosX());
        assertEquals(y, juego.getJugador().getPosY());

        juego.procesarComandos("S");
        assertEquals(x, juego.getJugador().getPosX());
        assertEquals(y, juego.getJugador().getPosY());

        juego.procesarComandos("E");
        assertEquals(x, juego.getJugador().getPosX());
        assertEquals(y + 1, juego.getJugador().getPosY());

        juego.procesarComandos("O");
        assertEquals(x, juego.getJugador().getPosX());
        assertEquals(y, juego.getJugador().getPosY());
    }
    @Test
    public void testVerificarEstadoDelJuego() {
        char[][] laberinto = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'T', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'T', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        juego.getJugador().setPosX(5);
        juego.getJugador().setPosY(4);
        juego.getLaberinto().setCeldas(laberinto);
        assertFalse(juego.verificarEstadoDelJuego());

        juego.getJugador().mover('E');
        juego.getJugador().verificarColisiones(laberinto);
        assertFalse(juego.verificarEstadoDelJuego());

        juego.getJugador().mover('O');
        juego.getJugador().verificarColisiones(laberinto);
        assertFalse(juego.verificarEstadoDelJuego());

        juego.getJugador().mover('N');
        juego.getJugador().verificarColisiones(laberinto);
        assertTrue(juego.verificarEstadoDelJuego());
    }
}