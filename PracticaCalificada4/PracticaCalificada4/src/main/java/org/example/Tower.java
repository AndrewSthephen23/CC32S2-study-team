package org.example;

import java.util.List;

public class Tower {
    private int damage; // Cantidad de daño que inflige a los enemigos
    private int range; // Número de celdas a las que puede atacar desde su posición
    private int fireRate; // Turnos entre disparos
    private int[] position;

    // Constructor de la clase Tower
    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
    }

    // Getters y Setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    // Método para atacar a un enemigo
    public void attack(List<Enemy> enemies, Map map) {
        boolean enemiesWithinRange = areEnemiesWithinRange(map);

        if (enemiesWithinRange) {
            for (Enemy enemy : enemies) {
                enemy.setHealth(enemy.getHealth() - damage);
            }
        }
    }

    // Metodo para buscar enemigos en el Rango.
    private boolean areEnemiesWithinRange(Map map) {
        int xStart = Math.max(0, position[0] - range);
        int xEnd = Math.min(map.getMapa().length - 1, position[0] + range);
        int yStart = Math.max(0, position[1] - range);
        int yEnd = Math.min(map.getMapa()[0].length - 1, position[1] + range);

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if (map.getMapa()[i][j] == 'E') {
                    return true;
                }
            }
        }
        return false;
    }
}


