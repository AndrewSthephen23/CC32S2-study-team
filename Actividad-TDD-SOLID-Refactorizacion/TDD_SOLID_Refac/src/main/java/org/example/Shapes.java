package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shapes {
    //Lista para almacenar objetos de tipo shape
    private final List<Shape> all = new ArrayList<>();
    private final Graphics graphics;
    //Constructor
    public Shapes(Graphics graphics) {
        this.graphics = graphics;
    }

    //Metodo para administrar la lista de formas
    public void add(Shape s) {
        all.add(s);
    }
    //Metodo para dibujar todas las formas de la lista
    public void draw() {
        all.forEach(shape -> shape.draw(graphics));
    }
}
