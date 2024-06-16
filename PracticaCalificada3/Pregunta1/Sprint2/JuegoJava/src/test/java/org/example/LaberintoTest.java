package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaberintoTest {


    @Test
    public void testInicializarLaberinto() {
        Laberinto laberinto = new Laberinto(10);
        assertEquals(10,laberinto.getTamano());
        assertNotNull(laberinto.getCeldas(9,9));
    }

    @Test
    public void testMostrarLaberinto() {
        Laberinto laberinto = new Laberinto(10);
        assertDoesNotThrow(() -> laberinto.mostrarLaberinto());
    }

    @Test
    public void testColocarTesorosYTrampas() {
        Laberinto laberinto = new Laberinto(10);
        laberinto.colocarTesorosYTrampas(5, 5);
        int tesoros = 0;
        int trampas = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (laberinto.getCeldas(i, j).getTipo() == 'T') {
                    tesoros++;
                } else if (laberinto.getCeldas(i, j).getTipo() == 'X') {
                    trampas++;
                }
            }
        }

        assertEquals(5, tesoros);
        assertEquals(5, trampas);
    }

    @Test
    public void testActualizarCelda() {
        Laberinto laberinto = new Laberinto(10);
        laberinto.actualizarCelda(0, 0, 'T');
        assertEquals('T', laberinto.getCeldas(0, 0).getTipo());

        laberinto.actualizarCelda(0, 0, 'X');
        assertEquals('X', laberinto.getCeldas(0, 0).getTipo());
    }

}