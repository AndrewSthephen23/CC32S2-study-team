package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    Calculadora cal;

    @BeforeEach
    void setUp() {
        cal = new Calculadora();
    }
    @Test
    void testadd() {
        assertThat(cal.add(2,3)).isEqualTo(5);
    }

    @Test
    void testsubtract() {
        assertThat(cal.subtract(3,2)).isEqualTo(1);
    }

    @Test
    void testmultiply() {
        assertThat(cal.multiply(3,2)).isEqualTo(6);
    }

    @Test
    void testdivide() {
        assertThat(cal.divide(6,2)).isEqualTo(3);
    }
    /*
    @Test testDivideByZero(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->cal.divide(1,0));
    }
     */
}