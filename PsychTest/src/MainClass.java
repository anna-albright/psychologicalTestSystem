import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainClass {
    public static void main(String[] args) throws IOException, URISyntaxException {

        //Note that the file reader is already pre set to read files within the "data" folder :)

        //converts entire file to an array
        //Read.fileToArray("consentForm.txt");

        //prints entire file contents to the console for our convenience
        //Read.previewFileContents("surveys/PERSONALITY - 16 Personality Factors.txt");
        User newuser = new User();
        String[] info = newuser.input();
        //System.out.println(newuser.verifyCredentials(info));
        newuser.createAccount(info);
    }
}
