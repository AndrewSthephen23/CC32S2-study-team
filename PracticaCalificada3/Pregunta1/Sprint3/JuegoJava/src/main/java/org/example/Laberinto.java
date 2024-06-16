package org.example;

import java.util.Random;

public class Laberinto {
    private Celda[][] celdas;
    private int tamano;


    public Laberinto(int tamano) {
        this.tamano = tamano;
        celdas = new Celda[tamano][tamano];
        inicializarLaberinto();
    }

    public int getTamano() {
        return tamano;
    }

    public Celda getCeldas(int fila, int columna) {
        return celdas[fila][columna];
    }

    public Celda[][] getCeldas() {
        return celdas;
    }


    public void setCeldas(Celda[][] celdas) {
        this.celdas = celdas;
    }


    private void inicializarLaberinto() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                celdas[i][j] = new Celda('.');
            }
        }
    }

    public void colocarTesorosYTrampas(int cantidadTesoros, int cantidadTrampas) {
        Random rand = new Random();
        colocarElemento('T', cantidadTesoros, rand);
        colocarElemento('X', cantidadTrampas, rand);
    }

    private void colocarElemento(char tipo, int cantidad, Random rand) {
        int colocados = 0;
        while (colocados < cantidad) {
            int fila = rand.nextInt(tamano);
            int columna = rand.nextInt(tamano);
            if (celdas[fila][columna].getTipo() == '.') {
                celdas[fila][columna] = new Celda(tipo);
                colocados++;
            }
        }
    }

    public void actualizarCelda(int fila, int columna, char tipo) {
        celdas[fila][columna] = new Celda(tipo);
    }

    public void mostrarLaberinto() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.print(celdas[i][j].getTipo() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

