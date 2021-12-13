public class Singleton {
    private static Singleton uniqueInstance = null;

    public String getAccountFilePath() {
        return accountFilePath;
    }

    public String accountFilePath;
    private Singleton(){
        accountFilePath = "user/accountInfo/account.txt";
    }
    public  static  Singleton getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Singleton();
        return  uniqueInstance;
    }

}