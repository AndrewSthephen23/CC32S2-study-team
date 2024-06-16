package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaberintoTest {

    @Test
    public void testInicializarLaberinto() {
        Laberinto laberinto = new Laberinto(10);
        assertEquals(10,laberinto.getTamano());
        assertNotNull(laberinto.getCeldas());
    }

    @Test
    public void testMostrarLaberinto() {
        Laberinto laberinto = new Laberinto(10);
        assertDoesNotThrow(() -> laberinto.mostrarLaberinto());
    }

}