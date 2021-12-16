import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    @Test
    void getSurveyQuestion() {
        Survey survey = new Survey("NEUROPSYCHOLOGY", "Beck Depression Index");
        ArrayList<String>  result = survey.getSurveyQuestion(1);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Choose the option that is most applicable to you.");
        assertArrayEquals(expected.toArray(), result.toArray());

    }
}