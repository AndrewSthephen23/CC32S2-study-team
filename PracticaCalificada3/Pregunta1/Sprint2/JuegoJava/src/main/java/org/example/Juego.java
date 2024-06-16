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

    public void iniciarJuego(){
        laberinto.colocarTesorosYTrampas(5, 5);
        laberinto.actualizarCelda(jugador.getPosX(), jugador.getPosY(), 'P');
        laberinto.mostrarLaberinto();
    }


    public void procesarComandos(String comando){
        laberinto.actualizarCelda(jugador.getPosX(), jugador.getPosY(), '.');
        jugador.mover(comando.charAt(0));
        jugador.verificarColisiones(laberinto.getCeldas());
        laberinto.actualizarCelda(jugador.getPosX(), jugador.getPosY(), 'P');
        laberinto.mostrarLaberinto();
    }


    public boolean verificarEstadoDelJuego() {
        return verificarVictoriaODerrota();
    }
    

    public boolean verificarVictoriaODerrota() {
        if (jugador.getVidas() <= 0) {
            System.out.println("Has perdido todas tus vidas. ¡Juego terminado!");
            return true;
        }

        int tesorosRestantes = 0;
        for (int i = 0; i < laberinto.getCeldas().length; i++) {
            for (int j = 0; j < laberinto.getCeldas()[i].length; j++) {
                if (laberinto.getCeldas()[i][j].getTipo() == 'T') {
                    tesorosRestantes++;
                }
            }
        }

        if (tesorosRestantes == 0) {
            System.out.println("Has recogido todos los tesoros. ¡Ganaste!");
            return true;
        }

        return false;
    }

    public void actualizarEstadoDelJuego() {
        if (verificarVictoriaODerrota()) {
            System.out.println("El estado del juego ha sido actualizado: Juego Terminado.");
        } else {
            System.out.println("El estado del juego ha sido actualizado: Juego en progreso.");
        }
    }
}
