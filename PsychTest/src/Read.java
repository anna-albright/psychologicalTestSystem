import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Read {
    static String LOCATION_PRESET="./PsychTest/data/";

    //returns each line of the file as an array
    public static String[] fileToArray(String fileName)
    {
        try {
            ArrayList<String> temp = new ArrayList<>();
            File myObj = new File(LOCATION_PRESET+fileName);
            Scanner inFile = new Scanner(myObj);
            while (inFile.hasNextLine()) {
                temp.add(inFile.nextLine());
            }
            inFile.close();
            return temp.toArray(new String[0]);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return null;

    }

    //prints file contents to console for your convenience
    public static void previewFileContents(String fileName)
    {
        System.out.println("\n");
        for (String s : fileToArray(fileName)){
            System.out.println(s);
        }
        System.out.println("\n------------------------------------------------------");
    }
}
