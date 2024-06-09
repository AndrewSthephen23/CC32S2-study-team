package org.example;

import org.junit.jupiter.api.Test;

import static org.example.stringUtils.substringsBetween;

public class stringUtilsTest {
    @Test
    void strIsNullOrEmpty(){
        //T1
        assertThat(substringsBetween(null,"a","b")).isEqualTo(null);
        //T2
        assertThat(substringsBetween("","a","b")).isEqualTo(new String[]{});

    }

    //T16: str no contien la etiqueta de open ni la de close
    @test
    void ignoresSpecialCharacters(){
        assertThat(substringsBetween("","a","b")).isEqualTo(new String[]{});
    }
}
