package LCOM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCOMCalculator2 {
    public static int calculateLCOM(ClassInfo classInfo) {
        int p = 0, q = 0;
        //Obtiene la lista de metodos de la Clase
        List<String> methods = classInfo.methods;

        // Itera sobre todos los pares de metodos
        for (int i = 0; i < methods.size(); i++) {
            for (int j = i + 1; j < methods.size(); j++) {
                String method1 = methods.get(i);// Obtiene el nombre del primer metodo del par
                String method2 = methods.get(j);// Obtiene el segundo nombre del metodo del par
                // Obtiene los atributos usados por el primer metodo
                Set<String> attrs1 = classInfo.methodAttributes.get(method1);
                // Obtiene los atributos usados por el segundo metodo
                Set<String> attrs2 = classInfo.methodAttributes.get(method2);
                // Calcula la interseccion de los conjuntos de atributos de ambos metodos
                Set<String> intersection = new HashSet<>(attrs1);
                intersection.retainAll(attrs2);

                if (intersection.isEmpty()) {
                    p++; // Si la interseccion esta vacia, incrementa el contador de metodos que no comparten atributos
                } else {
                    q++; // Si la interseccion no esta vacia, incrementa el contador de metodos que comparten al menos un atributo
                }
            }
        }
        //Calcula el LCOM
        int lcom = p - q;
        return lcom;
    }
}
