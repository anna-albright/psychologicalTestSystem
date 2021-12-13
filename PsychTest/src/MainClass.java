import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws IOException {

        //Note that the file reader is already pre set to read files within the "data" folder :)

        //converts entire file to an array
        //Read.fileToArray("consentForm.txt");

        //prints entire file contents to the console for our convenience
        //Read.previewFileContents("surveys/PERSONALITY - 16 Personality Factors.txt");

/*       User newuser = new User();
        String[] info = newuser.input();
        newuser.createAccount(info);
        System.out.println(newuser.verifyCredentials(info));*/

        //Read.previewArrayList(testing);

        //Read.previewArrayList(Survey.map.get("APTITUDE"));
        //Survey.printAvailableSurveys();
        Survey newSurveyInstance=new Survey("NEUROPSYCHOLOGY", "Beck Depression Index");
        Statistics newStatsInstance=new Statistics();
        newSurveyInstance.addObserver(newStatsInstance);
        newSurveyInstance.updateAvailableSurveys();
        //Read.previewArrayList(newSurveyInstance.prepareSurveyAll());
        newSurveyInstance.takeSurvey();
        //newSurveyInstance.takeSurvey();
        //Read.previewFileContents("surveys/NEUROPSYCHOLOGY - Beck Depression Index.txt");
    }
}
