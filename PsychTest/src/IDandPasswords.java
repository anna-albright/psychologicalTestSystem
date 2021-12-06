import java.util.HashMap;

public class IDandPasswords {

    static HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPasswords(){

        loginInfo.put("Chester", "Password");
        loginInfo.put("Sam", "Password");
        loginInfo.put("Anna", "Password");

    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }

    static void putEntry(String userName,String password){
        loginInfo.put(userName,password);
    }
}
