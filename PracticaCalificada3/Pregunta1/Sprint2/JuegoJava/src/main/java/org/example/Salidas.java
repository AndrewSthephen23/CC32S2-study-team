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

    public void imprimirMensajeRecolectarTesoro() {
        System.out.println("¡Has recogido un tesoro!");
    }

    public void imprimirMensajeCaerTrampa() {
        System.out.println("¡Has caído en una trampa!");
    }

    public void mostrarPuntajeYVidas() {
        System.out.println("Puntaje: " + juego.getJugador().getPuntaje());
        System.out.println("Vidas restantes: " + juego.getJugador().getVidas());
    }
}
