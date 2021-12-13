import java.util.Observable;
import java.util.Observer;

public class Statistics implements Observer {

    private String description;
    private String result;

    public Statistics()
    {
        //test
    }
    public Statistics (String description, String result)
    {
        this.description=description;
        this.result=result;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public boolean checkAccountType(){
        return false;
    }
    public void showStatisticsPatient()
    {

    }
    public void showStatisticsPsychologist(){

    }


    /**
     * This method is called whenever the observed object is changed. An
     * application calls an {@code Observable} object's
     * {@code notifyObservers} method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Statistics class recieved an update from Survey class!");
    }
}
