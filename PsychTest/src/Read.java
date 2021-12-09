import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Read {
    static String LOCATION_PRESET="./PsychTest/data/";
    //static String LOCATION_PRESET="";
    //returns each line of the file as an array
    public static ArrayList<String> fileToArrayList(String fileName)
    {
        try {
            ArrayList<String> temp = new ArrayList<>();
            File myObj = new File(LOCATION_PRESET+fileName);
            Scanner inFile = new Scanner(myObj);
            while (inFile.hasNextLine()) {
                temp.add(inFile.nextLine());
            }
            inFile.close();
            return temp;

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            e.printStackTrace();
        }
        return null;
    }
    public static void arrayListToFile(String fileName, ArrayList<String> temp)
    {
        try {
            FileWriter writer = new FileWriter(LOCATION_PRESET+fileName);

            for (String s : temp)
            {
                writer.write(s);
            }
            writer.close();

            System.out.println("Success: Wrote to file!");

        } catch (IOException e) {
            System.out.println("Error: Could not write to file!");
            e.printStackTrace();
        }
    }
    public static void previewArrayList(ArrayList<String> temp){
        for (String s : temp)
        {
            System.out.println(s);
        }
    }
    //prints file contents to console for your convenience
    public static void previewFileContents(String fileName)
    {
        System.out.println("\n");
        for (String s : fileToArrayList(fileName)){
            System.out.println(s);
        }
        System.out.println("\n------------------------------------------------------");
    }
}
