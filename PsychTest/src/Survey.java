
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Survey extends Observable {
    private String categoryName, surveyName; //category and survey name
    private static ArrayList<String> userAnswers=new ArrayList<>(); //arrayList to store user responses
    private static int currentNum=1;
    private boolean consentChoice=false; //user's informed consent choice
    public static Map<String, List<String>> surveyMap = new HashMap<String, List<String>>(); //hashmap to store categories and surveys

    public static int getCurrentNum() {
        return currentNum;
    }

    public static void setCurrentNum(int currentNum) {
        Survey.currentNum = currentNum;
    }

    public static ArrayList<String> getUserAnswers(){
        return Survey.userAnswers;
    }

    public static void addUserAnswers(String temp){
        Survey.userAnswers.add(temp);
    }



    public String getCategoryName() {return categoryName;};
    public void setCategoryName(String categoryName) {this.categoryName=categoryName;}
    public String getSurveyName() {return surveyName;};
    public void setSurveyName(String categoryName) {this.surveyName=surveyName;}
    public boolean getConsentChoice() {
        return consentChoice;
    }
    public void setConsentChoice(boolean consentChoice) {
        this.consentChoice = consentChoice;
    }

    public Survey()
    {
        updateAvailableSurveys();
    }
    public Survey(String categoryName, String surveyName)
    {
        this.categoryName=categoryName;
        this.surveyName=surveyName;
        updateAvailableSurveys();
        setChanged();
        notifyObservers();

    }
   
    public ArrayList<String> showConsentForm()
    {
        return(Read.fileToArrayList("consentForm.txt"));
    }
    public void takeSurvey()
    {
        //add mouse click functionality with java fx later
        String[] validInput=new String[]{"1aq","2bw","3ce","4dr","5et","6ey"};
        String[] finalOutput=new String[]{"a","b","c","d","e","f"};

        Scanner keyboard;
        keyboard = new Scanner(System.in);

        int currentQuestionNum=1;
        do {
            Read.previewArrayList(getSurveyQuestion(currentQuestionNum));
            String currentResponse="";
            do {
                String input = keyboard.next().toLowerCase();
                for (int i = 0; i < finalOutput.length; i++) {
                    //currentResponse = (validInput[i].contains(input)) ? finalOutput[i] : "";
                    if (validInput[i].contains(input))
                        currentResponse = finalOutput[i];
                }
            }
            while (currentResponse == "");
            userAnswers.add(currentResponse);
            currentQuestionNum++;
        } while (getSurveyQuestion(currentQuestionNum)!=null);

        System.out.println("Temp: Survey completed :)!");
        writeSurveyAnswersToFile(userAnswers);
        keyboard.close();

        setChanged();
        notifyObservers();
    }
    public void writeSurveyAnswersToFile(ArrayList<String> temp){
        SimpleDateFormat formatter = new SimpleDateFormat("MM_dd_yyyy - HH_mm");
        Date date = new Date();
        String fileName="user/surveyAnswers/"+this.categoryName+" - "+this.surveyName+" (Completed "+formatter.format(date)+")"+".txt";
        Read.previewArrayList(temp);
        Read.arrayListToFile(fileName, temp);
        System.out.println("Wrote "+fileName+" to file!");
    }
    public ArrayList<String> getSurveyQuestion(int num){
        ArrayList<String> raw = Read.fileToArrayList("surveys/"+this.categoryName+" - "+this.surveyName+".txt");
        ArrayList<String> temp = new ArrayList<>();
        boolean add=false;
        for (String s : raw) {

            if (s.contains(String.valueOf(num)+"."))
                add=true;
            else if (s.contains(String.valueOf(num+1))) {
                add=false;
                break;
            }
            if(add)
            {
                temp.add(s);
                //System.out.println(s);
            }

        }

        if (temp.size()>1)
            return temp;
        return null;
    }
    public void showResult()
    {

    }
    //checks what the current survey files are
    public void updateAvailableSurveys() {
        for (String s : Read.fileNamesInFolderToArrayList("surveys/"))
        {
            String[] temp = s.substring(0,s.length()-4).split(" - ");
            if (surveyMap.containsKey(temp[0]) && !surveyMap.get(temp[0]).equals(Arrays.asList(temp[1]))) //if already contains key (category), update value's list to include the new value
                surveyMap.replace(temp[0], Stream.of(surveyMap.get(temp[0]), Arrays.asList(temp[1]))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));
            else
                surveyMap.put(temp[0], Arrays.asList(temp[1]));
        }
        setChanged();
        notifyObservers();
    }
    public static void printAvailableSurveys(){
        surveyMap.forEach((k, v) -> System.out.println(k+"\n"+v));
    }



// will implement observer stuff later
/*    public void setState(){

    }
    public  getState(){

    }*/

}
