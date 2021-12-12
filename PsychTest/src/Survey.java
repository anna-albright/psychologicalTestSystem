
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Survey {
    String categoryName; //category of current survey
    String surveyName; //name of current survey
    ArrayList<String> userSurveyAnswers=new ArrayList<>(); //arrayList to store user responses
    static Map<String, List<String>> map = new HashMap<String, List<String>>(); //hashmap to store categories and surveys
    boolean consentChoice; //user's informed consent choice

    public Survey()
    {
        refreshAvailableSurveys();
    }
    public Survey(String categoryName, String surveyName)
    {
        refreshAvailableSurveys();
        this.categoryName=categoryName;
        this.surveyName=surveyName;
    }
    public ArrayList<String> showSurvey()
    {
        ArrayList<String> rawSurvey = Read.fileToArrayList("surveys/"+this.categoryName+" - "+this.surveyName+".txt");
        ArrayList<String> temp = new ArrayList<>();
        int replaceQ=1;
        char replaceA='a';
        for (String s : rawSurvey)
        {
            if (s.contains("Q |"))
            {
                s=s.replace("Q |", String.valueOf(replaceQ)+".");
                replaceQ++;
                replaceA='a';
            }
            else if (s.contains("A |"))
            {
                s=s.replace("A |", (Character.toString((char)replaceA))+".");
                replaceA++;
            }
            temp.add(s);
        }
        return temp;

    }
    public ArrayList<String> showConsentForm()
    {
        return(Read.fileToArrayList("consentForm.txt"));
    }
    public void takeSurvey()
    {
        //will need a variable to store user answers

    }
    public void showResult()
    {

    }
    //checks what the current survey files are

    public static void refreshAvailableSurveys() {
        for (String s : Read.fileNamesInFolderToArrayList("surveys/"))
        {
            String[] temp = s.substring(0,s.length()-4).split(" - ");

            if (map.containsKey(temp[0])) //if already contains key (category), update value's list to include the new value
                map.replace(temp[0], Stream.of(map.get(temp[0]), Arrays.asList(temp[1]))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));
            else
                map.put(temp[0], Arrays.asList(temp[1]));
        }
    }
    public static void printAvailableSurveys(){
        map.forEach((k, v) -> System.out.println(k+"\n"+v));
    }
// will implement observer stuff later
/*    public void setState(){

    }
    public  getState(){

    }*/
  /*  public void notifyObservers()
    {

    }*/
}
