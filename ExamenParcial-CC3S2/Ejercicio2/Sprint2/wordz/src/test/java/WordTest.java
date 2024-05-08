import org.example.Letter;
import org.example.Score;
import org.example.Word;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Letter.*;
public class WordTest {
    @Test
    public void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("Z");
        assertScoreForLetter(score,0,INCORRECT);
    }
    @Test
    public void oneCorrectLetter(){
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForLetter(score,0,CORRECT);
    }
    @Test
    void secondLetterWrongPossition(){//segunda letra posicion incorrecta
        var word = new Word("AR");
        var score = word.guess("ZA");
        assertScoreForLetter(score,1,PART_CORRECT);
    }

    private void assertScoreForLetter(Score score,int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }
}