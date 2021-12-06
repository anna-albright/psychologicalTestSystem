import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
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
   /* public String getUsername(){
        username = getName();
        return username.charAt(0)+;
    } */
    public String getPassword(){
        return this.password;
    }
    public int getAge(){
        return this.age;
    }

    public void createAccaunt() throws IOException {
//            PrintWriter outputStream = null;
//            try{
//                outputStream =  new PrintWriter(new FileOutputStream("accaunt.txt"));
//            }
//            catch (FileNotFoundException e) {
//                System.out.println("Error opening the file stuff.txt.");
//                System.exit(0);
//            }
//            outputStream.println(getUsername() + getUsername());
//            outputStream.close();
        }

    }



