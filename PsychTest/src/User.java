import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class User {
    private String name, gender, username, password;
    private int age;

    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public String getGender(){
        return this.gender;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public int getAge(){
        return this.age;
    }

    public void createAccount(String[] input) throws IOException {
        ArrayList<String> infos = Read.fileToArrayList(Singleton.getInstance().getAccountFilePath());
        boolean existed = false;
        for (String s:infos){
            String[] pair = s.split(" ");
            if(pair[0].equals(input[0]) && pair[1].equals(input[1])){
                existed=true;
                break;
            }
        }
        if(existed == false){
            writeAccount(input[0], input[1]);
            setUsername(input[0]);
            setPassword(input[1]);
        }else{
            System.out.println("Already exists. Please use another name and password");
        }
    }

    public String verifyCredentials(String[] input){
        ArrayList<String> infos = Read.fileToArrayList(Singleton.getInstance().getAccountFilePath());
        boolean existed = false;
        for (String s:infos){
            String[] pair = s.split(" ");
            if(pair[0].equals(input[0]) && pair[1].equals(input[1])){
                existed=true;
                break;
            }
        }
        if(existed == false){
            return "We have a problem with sign you in.";
        }else{
            return "You are sign in!";
        }
    }

    public String[] input(){
        String[] input = new String[2];
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        System.out.println("Username:");
        input[0] = keyboard.next();
        System.out.println("Password:");
        input[1] = keyboard.next();
        keyboard.close();
        return input;
    }
    public void writeAccount(String username, String password) throws  IOException{

        ArrayList<String> temp = new ArrayList<>();
        temp.add(username+" "+ password);
        Read.arrayListToFile(Singleton.getInstance().getAccountFilePath(), temp);
    }

}
