package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaTest {
    @Test
    public void testConstructorYObtenerTipo() {
        Celda tesoro = new Celda('T');
        assertEquals('T', tesoro.getTipo());

        Celda trampa = new Celda('X');
        assertEquals('X', trampa.getTipo());

        Celda vacia = new Celda('.');
        assertEquals('.', vacia.getTipo());
    }

}