import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    @Test
    void getSurveyQuestion() {
        Survey survey = new Survey("NEUROPSYCHOLOGY", "Beck Depression Index");
        ArrayList<String> result = survey.getSurveyQuestion(1);
        Read.previewArrayList(result);
        ArrayList<String> expected = new ArrayList<>();

        expected.add("1. Choose the option that is most applicable to you.");
        expected.add("a. I do not feel sad.");
        expected.add("b. I feel sad");
        expected.add("c. I am sad all the time and I can't snap out of it.");
        expected.add("d. I am so sad and unhappy that I can't stand it. ");

        assertArrayEquals(expected.toArray(), result.toArray());

    }
}