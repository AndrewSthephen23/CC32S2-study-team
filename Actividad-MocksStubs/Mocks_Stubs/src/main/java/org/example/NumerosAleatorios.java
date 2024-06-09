package org.example;
import java.util.random.RandomGenerator;

public interface NumerosAleatorios extends RandomGenerator {
    int nextInt(int upperBoundExclusive);
}
