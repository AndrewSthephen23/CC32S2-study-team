package org.example;

import java.util.Random;

public class Juego {

    private Laberinto laberinto;
    private Jugador jugador;

    public Juego(int tamano) {
        laberinto = new Laberinto(tamano);
        Random rand = new Random();
        int posX = rand.nextInt(tamano);
        int posY = rand.nextInt(tamano);
        jugador = new Jugador(posX, posY, 3);
    }

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void iniciarJuego() {
        laberinto.mostrarLaberinto();
    }

    public void procesarComandos(String comando) {
        jugador.mover(comando.charAt(0));
        laberinto.mostrarLaberinto();
    }

    public boolean verificarEstadoDelJuego() {
        if (jugador.getVidas() <= 0) {
            System.out.println("El jugador ha perdido todas sus vidas. Fin del juego.");
            return true;
        }

        for (int i = 0; i < laberinto.getTamano(); i++) {
            for (int j = 0; j < laberinto.getTamano(); j++) {
                if (laberinto.getCeldas()[i][j] == 'T') {
                    return false;
                }
            }
        }

        System.out.println("El jugador ha recogido todos los tesoros. ¡Ganaste!");
        return true;
    }

}
