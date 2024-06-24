package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private List<Wave> waves;
    private int currentWaveIndex;

    public Game() {
        this.map = new Map();
        this.player = new Player();
        this.waves = new ArrayList<>();
        this.currentWaveIndex = 0;
    }

    // Metodo poner la posicion y el tipo de la Torre
    public void placeTower(String towerType, int x, int y) {
        TowerFactory factory;
        switch (towerType.toLowerCase()) {
            case "cannon":
                factory = new CannonTowerFactory();
                break;
            case "laser":
                factory = new LaserTowerFactory();
                break;
            case "arrow":
                factory = new ArrowTowerFactory();
                break;
            default:
                System.out.println("Invalid tower type!");
                return;
        }
        Tower tower = factory.createTower();
        map.insertarTower(tower, x, y);
        System.out.println("Torre " + towerType + " colocada en (" + x + ", " + y + ")");
    }

    // Metodo para iniciar la ola
    public void startWave() {
        if (currentWaveIndex >= waves.size()) {
            Wave newWave = new Wave(currentWaveIndex + 1);
            waves.add(newWave);
        }
        Wave wave = waves.get(currentWaveIndex);
        System.out.println("Oleada " + (currentWaveIndex + 1) + " iniciada");
        System.out.println("Enemigos en camino...");
        // Aquí va la lógica para mover los enemigos y permitir que las torres ataquen
        currentWaveIndex++;
    }

    // Metodo para imprimir el estado del Juego
    public void printGameState() {
        System.out.println("Estado del juego:");
        map.imprimirMapa();
        System.out.println("Puntuación: " + player.getScore());
        System.out.println("Vida de la base: " + player.getBaseHealth());
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0].toUpperCase()) {
                case "PLACE_TOWER":
                    String towerType = parts[1];
                    int x = Integer.parseInt(parts[2]);
                    int y = Integer.parseInt(parts[3]);
                    game.placeTower(towerType, x, y);
                    break;
                case "START_WAVE":
                    game.startWave();
                    break;
                case "PRINT_STATE":
                    game.printGameState();
                    break;
                default:
                    System.out.println("Comando no reconocido");
            }
        }
    }
}
