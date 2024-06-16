package org.example;

public class Jugador {
    private int posX;
    private int posY;
    private int puntaje;
    private int vidas;

    public Jugador(int posX, int posY, int vidas) {
        this.posX = posX;
        this.posY = posY;
        this.vidas = vidas;
        this.puntaje = 0;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getVidas() {
        return vidas;
    }
    public void actualizarPos(char direccion){
        switch (direccion) {
            case 'N': posX -= 1; break;
            case 'S': posX += 1; break;
            case 'E': posY += 1; break;
            case 'O': posY -= 1; break;
        }
    }

    public void mover(char direccion) {
        actualizarPos(direccion);
    }

    public void perderVida() {
        vidas -= 1;
    }

    public void verificarColisiones(char[][] laberinto) {
        if (laberinto[posX][posY] == 'T') {
            recogerTesoro();
            laberinto[posX][posY] = '.';
        } else if (laberinto[posX][posY] == 'X') {
            perderVida();
            laberinto[posX][posY] = '.';
        }
    }

    public void recogerTesoro() {
        puntaje += 1;
    }

}
