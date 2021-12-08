public class Singleton {
    private static Singleton uniqueInstance = null;
    public String filePath;
    private Singleton(){
        filePath = "";
    }
    public  static  Singleton getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Singleton();
        return  uniqueInstance;
    }

}
