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
    public void actualizarPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void mover(char direccion){
        switch (direccion) {
            case 'N': posX -= 1; break;
            case 'S': posX += 1; break;
            case 'E': posY += 1; break;
            case 'O': posY -= 1; break;
        }
    }

    public void verificarTrampa(Celda celda){
        if (celda.getTipo() == 'X'){
            perderVida();
        }
    }

    public void perderVida() {
        vidas -= 1;
    }


    public void verificarColisiones(Celda[][] celdas){
        Celda celdaActual = celdas[posX][posY];
        if (celdaActual.getTipo() == 'T'){
            recogerTesoro(celdaActual);
        } else if (celdaActual.getTipo() == 'X') {
            verificarTrampa(celdaActual);
        }
    }


    public void recogerTesoro(Celda celda){
        if (celda.getTipo() == 'T'){
            puntaje++;
            celda = new Celda('.');
        }
    }

}
