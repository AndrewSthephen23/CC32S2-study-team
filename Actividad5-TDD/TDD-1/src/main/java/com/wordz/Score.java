package com.wordz;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Score {

    private String word;
    private String attempt;

    /* EL constructor toma la palabra word y la palabra intento */
    public Score(String word,String attempt) {
        this.word = word;
        this.attempt = attempt;
    }

    /* Verifica si el caracter de la palabra word y el caracter de la palabra intento:
     1. coinciden (CORRECT)
     2. no coinciden pero se encuentra en la cadena (PART_CORRECT)
     3. no coinciden pero se encuentra en la cadena (INCORRECT)
    */
    public Letter letter(int position){

        // tomamos el caracter de la palabra word en la posicion=position
        char correct = word.charAt(position);

        // tomamos el caracter de la palabra intento en la posicion=position
        char letterP = attempt.charAt(position);

        // si son iguales, retorna un letter CORRECT
        if(correct==letterP){
            return Letter.CORRECT;
        }
        // sino son iguales, verifica que si se encuentre en la cadena, retorna un letter PART_CORERCT
        else if(word.indexOf(letterP)!=-1){
            return Letter.PART_CORRECT;
        }

        // sino esta en la cadena, retorna un letter INCORRECT
        return Letter.INCORRECT;
    }

    public ArrayList<Letter> letters(){
        // tomamos el tamanio de la palabra
        int size = word.length();

        //  Instanciamos una lista de Letters
        ArrayList<Letter>lettersGuess = new ArrayList<>();
        for(int i=0;i<size;i++){
            // para cada posicion = i, recibe un letter que puede ser CORRECT,INCORRECT o PAST_CORRECT
            lettersGuess.add(letter(i));
        }

        // Retorna un ArrayList de letters
        return lettersGuess;
    }

}
