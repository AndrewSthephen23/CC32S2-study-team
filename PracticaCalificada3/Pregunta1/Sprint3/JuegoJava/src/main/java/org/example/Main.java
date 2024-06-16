package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego(10);
        juego.iniciarJuego();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Introduce un comando para moverte (N/S/E/O) o 'Q' para salir:");
            String comando = scanner.nextLine().trim().toUpperCase();

            if (comando.equals("Q")) {
                System.out.println("¡Gracias por jugar!");
                break;
            }

            if (comando.equals("N") || comando.equals("S") || comando.equals("E") || comando.equals("O")) {
                juego.procesarComandos(comando);
                if (juego.verificarEstadoDelJuego()) {
                    break;
                }
            } else {
                System.out.println("Comando no válido. Intenta nuevamente.");
            }
        }

        scanner.close();
    }
}
