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

    public void createAccount(String[] input) throws IOException {
              String[] infos = Read.fileToArray("C:/Users/annak/Desktop/final_project/out/production/final_project/user/accountInfo/account.txt");
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
                  //setUsername(username);
                  //setPassword(password);
              }else{
                  System.out.println("Already exists. Please use another name and password");
              }
//        URL res = getClass().getClassLoader().getResource("account.txt");
//        File file = Paths.get(res.toURI()).toFile();
//        String absolutePath = file.getAbsolutePath();

    }

        public String verifyCredentials(String[] input){
            String[] infos = Read.fileToArray("C:/Users/annak/Desktop/final_project/out/production/final_project/user/accountInfo/account.txt");
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
            //String username, password;
            keyboard = new Scanner(System.in);
            System.out.println("Username:");
            input[0] = keyboard.next();
            System.out.println("Password:");
            input[1] = keyboard.next();
            keyboard.close();
            return input;
        }
        public void writeAccount(String username, String password) throws  IOException{

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/annak/Desktop/final_project/out/production/final_project/user/accountInfo/account.txt", true));
            writer.append("\n");
            writer.append(username+" "+ password);
            writer.close();
        }

    }



