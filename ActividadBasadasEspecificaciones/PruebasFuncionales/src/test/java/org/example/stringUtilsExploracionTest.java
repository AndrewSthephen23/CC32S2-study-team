package org.example;

import static org.assertj.core.api.Assertons.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class stringUtilsExploracionTest {
    @Test
    void testSubstringsBetween(){
        Assertions.assertThat(stringUtils.substringsBetween("axcaycazc","a","c")).isEqual(new String[]{"x","y","z"});
    }
    @Test
    void simpleCase(){

    }
    @Test
    void manyStrings(){

    }
    @Test
    void openAndCloseTagsThatAreLongerThat1Char(){

    }

}