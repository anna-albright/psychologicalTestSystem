import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
    static User user;
    static private int bodyFontSize=15;
    static private String bodyFontName="Inter Light";
    static String headerFontName="EB Garamond";
    static Font bodyFontNormal=new Font(bodyFontName, Font.PLAIN, bodyFontSize);
    static Font bodyFontSelected=new Font(bodyFontName, Font.BOLD, bodyFontSize);
    static Color customBlue = new Color (8,161,177);

    public static void main(String[] args) {
        //implement custom fonts
        try {
            registerCustomFonts();
        } catch (IOException | FontFormatException e)
        {
            System.out.println("Error!");
            e.printStackTrace();
        }

        Survey newSurveyInstance=new Survey("NEUROPSYCHOLOGY", "Beck Depression Index"); //choose survey
        newSurveyInstance.updateAvailableSurveys(); //update all available surveys
        //Survey.printAvailableSurveys();
        //System.out.println(Survey.surveyMap.get("NEUROPSYCHOLOGY"));
        //Read.previewArrayList(Read.fileNamesInFolderToArrayList("surveys/"));
        Read.previewArrayList(Survey.surveyMap.get("PERSONALITY"));

        Statistics newStatsInstance=new Statistics(); //new stats instance
        newSurveyInstance.addObserver(newStatsInstance); //add observer, do not uncomment

        new PageLogin();
        //new PageConsent();
        //PageSurvey surveyPage = new PageSurvey(newSurveyInstance);



    }
    public static void registerCustomFonts() throws IOException, FontFormatException { //wip
        String locationPreset="./PsychTest/data/fonts/";
        ArrayList<String> fontStrList=new ArrayList<>();
        ArrayList<Font> fontList=new ArrayList<>();

        fontStrList.add("EB Garamond/EBGaramond-VariableFont_wght.ttf");
        fontStrList.add("Inter/Inter-VariableFont_slnt,wght.ttf");
        fontStrList.add("Inter/static/Inter-Light.ttf");
        fontStrList.add("Inter/static/Inter-Thin.ttf");
        for (String s : fontStrList)
        {
            fontList.add(Font.createFont(Font.TRUETYPE_FONT, new File(locationPreset+s)));
        }

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (Font f : fontList)
        {
            ge.registerFont(f);
        }

        //display fonts family
/*        JList fonts = new JList( ge.getAvailableFontFamilyNames() );
        JOptionPane.showMessageDialog(null, new JScrollPane(fonts));*/

    }
}
