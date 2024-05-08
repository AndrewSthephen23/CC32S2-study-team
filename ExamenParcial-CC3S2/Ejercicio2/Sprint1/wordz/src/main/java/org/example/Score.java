package org.example;

import java.util.ArrayList;
import java.util.List;
public class Score {
    private final String correct;
    private Letter resultado = Letter.INCORRECT;
    private int position;
    public Score(String correct) {
        this.correct = correct;
    }
    public Letter letter(int position){
        return resultado;
    }
    public void assess(int position, String attempt){
        if(isCorrectLetter(position, attempt)){
            resultado = Letter.CORRECT;
        }
    }
    private boolean isCorrectLetter(int position, String attempt){
        return correct.charAt(position)==attempt.charAt(position);
    }


}