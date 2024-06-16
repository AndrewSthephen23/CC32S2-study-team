package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    private Jugador jugador;
    private Laberinto laberinto;
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
        Celda[][] laberinto = new Celda[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                laberinto[i][j] = new Celda('.');
            }
        }
        laberinto[5][5] = new Celda('T');
        jugador.verificarColisiones(laberinto);
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void testVerificarColisionesTrampa() {
        Celda[][] laberinto = new Celda[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                laberinto[i][j] = new Celda('.');
            }
        }
        laberinto[5][5] = new Celda('X');
        jugador.verificarColisiones(laberinto);
        assertEquals(2, jugador.getVidas());
    }

    @Test
    public void testRecogerTesoro() {
        laberinto = new Laberinto(10);
        laberinto.actualizarCelda(5, 5, 'T');
        jugador.recogerTesoro(laberinto.getCeldas(5, 5));
        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void testVerificarTrampa() {
        laberinto = new Laberinto(10);
        laberinto.actualizarCelda(5, 5, 'X');
        jugador.verificarTrampa(laberinto.getCeldas(5, 5));
        assertEquals(2, jugador.getVidas());
    }

}