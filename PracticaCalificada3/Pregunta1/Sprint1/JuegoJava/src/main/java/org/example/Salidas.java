package org.example;

public class Salidas {

    private Juego juego;

    public Salidas(Juego juego) {
        this.juego = juego;
    }

    public void mostrarLaberintoInicial() {
        juego.iniciarJuego();
    }

    public void permitirMovimiento(String comando) {
        juego.procesarComandos(comando);
        if (juego.verificarEstadoDelJuego()) {
            System.out.println("El juego ah Terminado!");
        }
    }

}
