import java.util.HashMap;
import java.io.*;
import java.util.Map;

public class IDandPasswords {

    static File file = new File("PsychTest/src/AllAccounts");

    static HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPasswords() {

        loginInfo.put("Chester", "Password");
        loginInfo.put("Sam", "Password");
        loginInfo.put("Anna", "Password");

    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }

    /** Saves a new user's username and password
     *
     * @param userName the userName for a new account
     * @param password the password for a new account
     */
    static void putEntry(String userName, String password) {
        loginInfo.put(userName, password);
        // placing existing people in the file from above
        writePersonToFile(loginInfo);
    }

    static BufferedWriter bw = null;

    /** Write Users information to a file
     *
     * @param info The hashmap with the key(username) and value(password)
     */
    public static void writePersonToFile(HashMap<String,String> info)
    {
        try {
            // create new BufferedWriter for the output file
            bw = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Map.Entry<String, String> entry :
                    loginInfo.entrySet()) {

                // put key and value separated by a colon
                bw.write(entry.getKey() + ":"
                        + entry.getValue());

                // new line
                bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            bw.close(); // to close the file
        }catch(Exception e){
            System.out.println("Unable to close file.");
        }

    }
}
