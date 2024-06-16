package LCOM;

import java.util.*;

public class ClassInfo{
    List<String> methods = new ArrayList<>();//Lista de nombres de metodos
    Map<String, Set<String>> methodAttributes = new HashMap<>();//Mapa de metodos y los atributos que usan
    Set<String> attributes = new HashSet<>();// Conjunto de todos los atributos de la clase

    //Metodo para agregar un metodo y los atributos que usa
    public void addMethod(String methodName, Set<String> attrs) {
        methods.add(methodName);//Agrega el nombre del metodo a la lista de metodos
        methodAttributes.put(methodName, attrs);//Asocia el metodo con sus atributos
        attributes.addAll(attrs);//Agrega todos los atributos al conjunto de atributos de la Clase.
    }
}
