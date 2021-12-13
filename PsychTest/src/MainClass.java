import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {


        //Note that the file reader is already pre set to read files within the "data" folder :)

        //converts entire file to an array
        //Read.fileToArray("consentForm.txt");

        //prints entire file contents to the console for our convenience
        //Read.previewFileContents("surveys/PERSONALITY - 16 Personality Factors.txt");

        IDandPasswords idandpasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage(idandpasswords.getLoginInfo());

        Survey newSurveyInstance=new Survey("NEUROPSYCHOLOGY", "Beck Depression Index");
        Statistics newStatsInstance=new Statistics();
        newSurveyInstance.addObserver(newStatsInstance);
        newSurveyInstance.updateAvailableSurveys();

    }
}
