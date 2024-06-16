package org.example;

public class Laberinto {
    private char[][] celdas;
    private int tamano;


    public Laberinto(int tamano) {
        this.tamano = tamano;
        celdas = new char[tamano][tamano];
        inicializarLaberinto();
    }

    public int getTamano() {
        return tamano;
    }

    public char[][] getCeldas() {
        return celdas;
    }

    public void setCeldas(char[][] celdas) {
        this.celdas = celdas;
    }

    private void inicializarLaberinto() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                celdas[i][j] = '.';
            }
        }
    }

    public void mostrarLaberinto() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.print(celdas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

