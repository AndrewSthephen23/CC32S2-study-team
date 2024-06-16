package LCOM;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo(); // Crea una instancia de ClassInfo

        // Simulación de entrada de métodos y sus accesos a atributos
        try {
            classInfo.addMethod("mostrarLaberintoInicial", new HashSet<>(Arrays.asList("juego")));
            classInfo.addMethod("permitirMovimiento", new HashSet<>(Arrays.asList("juego")));
            classInfo.addMethod("imprimirMensajeRecolectarTesoro", new HashSet<>());
            classInfo.addMethod("imprimirMensajeCaerTrampa", new HashSet<>());
            classInfo.addMethod("mostrarPuntajeYVidas", new HashSet<>(Arrays.asList("juego")));
            //classInfo.addMethod("mover", new HashSet<>(Arrays.asList("posX","posY")));
            //classInfo.addMethod("colocarTesorosYTrampas", new HashSet<>());
            //classInfo.addMethod("perderVida", new HashSet<>(Arrays.asList("vidas")));
            //classInfo.addMethod("verificarColisiones", new HashSet<>(Arrays.asList("posX","posY")));
            //classInfo.addMethod("recogerTesoro", new HashSet<>(Arrays.asList("puntaje")));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Calcula el LCOM
        int lcom = LCOMCalculator2.calculateLCOM(classInfo);
        System.out.println("LCOM = " + lcom); // Imprime el valor de LCOM
    }
}
