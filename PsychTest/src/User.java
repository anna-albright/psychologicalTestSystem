import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class User {
    public static final String FILE_NAME = "account.txt";
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
//        username = getName();
//        int int_random = ThreadLocalRandom.current().nextInt();
//        return (username.substring(0,1) + String.valueOf(int_random));
          return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public int getAge(){
        return this.age;
    }

    public void createAccount() throws IOException {
              Scanner keyboard;
              String username, password;
              keyboard = new Scanner(System.in);
              System.out.println("Username:");
              username = keyboard.next();
              //setUsername(username);
              System.out.println("Password:");
              password = keyboard.next();
              //setPassword(password);
              keyboard.close();

              String[] infos = Read.fileToArray("user/accountInfo/account.txt");
              boolean existed = false;
              for (String s:infos){
                  String[] pair = s.split(" ");
                  if(pair[0].equals(username)){
                      existed=true;
                      break;
                  }
              }
              if(existed == false){
                  writeAccount(username, password);
              }else{
                  System.out.println("Already exists. Please use another name and password");
              }
        }

        public void verifyCredentials(){

        }

        public void writeAccount(String username, String password) throws  IOException{

            BufferedWriter writer = new BufferedWriter(new FileWriter("./PsychTest/data/user/accountInfo/account.txt", true));
            writer.append("\n");
            writer.append(username+" "+ password);
            writer.close();
        }

    }



