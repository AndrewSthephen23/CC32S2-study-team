package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        jugador = new Jugador(5, 5, 3);
    }

    @Test
    public void testMoverJugador() {
        jugador.mover('N');
        assertEquals(4, jugador.getPosX());
        assertEquals(5, jugador.getPosY());

        jugador.mover('S');
        assertEquals(5, jugador.getPosX());
        assertEquals(5, jugador.getPosY());

        jugador.mover('E');
        assertEquals(5, jugador.getPosX());
        assertEquals(6, jugador.getPosY());

        jugador.mover('O');
        assertEquals(5, jugador.getPosX());
        assertEquals(5, jugador.getPosY());
    }

    @Test
    public void testPerderVida() {
        int vidasIniciales = jugador.getVidas();
        jugador.perderVida();
        assertEquals(vidasIniciales - 1, jugador.getVidas());
    }

    @Test
    public void testVerificarColisionesTesoro() {
        char[][] laberinto = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'T', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        jugador.verificarColisiones(laberinto);
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void testVerificarColisionesTrampa() {
        char[][] laberinto = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'X', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        jugador.verificarColisiones(laberinto);
        assertEquals(2, jugador.getVidas());
    }

}