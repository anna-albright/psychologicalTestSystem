import java.io.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Read {
    static String LOCATION_PRESET="./PsychTest/data/";

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
            BufferedWriter writer = new BufferedWriter(new FileWriter(LOCATION_PRESET+fileName, true));
            for (String s : temp)
            {
                writer.append(s);
                writer.append("\n");
            }
            writer.close();
            //System.out.println("Success: Wrote to file!");

        } catch (IOException e) {
            System.out.println("Error: Could not write to file!");
            e.printStackTrace();
        }
    }
    public static void arrayListToExistingFile(String fileName, ArrayList<String> temp) throws IOException {
        FileWriter fw = new FileWriter(LOCATION_PRESET+fileName, true);
        for (String s : temp)
        {
            fw.append(s);
            fw.append("\n");
        }
        fw.close();
    }

    //prints a list
    public static void previewArrayList(List temp){
        for (Object s : temp)
        {
            System.out.println((String)s);
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

    //prints out names of files in a folder
    public static ArrayList<String> fileNamesInFolderToArrayList(String fileName)
    {
        ArrayList<String> temp = new ArrayList<>();
        File folder = new File(LOCATION_PRESET+fileName);
        for(File s : folder.listFiles())
        {
            temp.add(s.getName()); //can use isFile or isDirectory for more specificity
        }
        return temp;

    }
}
