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
    public void testActualizarEstadoDelJuego() {

        juego.iniciarJuego();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (juego.getLaberinto().getCeldas(i, j).getTipo() == 'X') {
                    juego.getJugador().actualizarPos(i, j);
                    juego.getJugador().verificarColisiones(juego.getLaberinto().getCeldas());
                }
            }
        }
        juego.actualizarEstadoDelJuego();
        assertNotNull(juego.getLaberinto());
        assertNotNull(juego.getJugador());
        assertTrue(juego.verificarVictoriaODerrota());
    }

    @Test
    public void testVerificarVictoriaODerrota() {
        assertTrue(juego.verificarVictoriaODerrota());
    }
}