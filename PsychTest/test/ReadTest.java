import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ReadTest {
    @org.junit.jupiter.api.Test

    public static ArrayList<String> fileToArrayList(){
        //Read read = new Read();
        //ArrayList<String> temp = Read.fileToArrayList("testRead.txt");
        ArrayList<String> result = Read.fileToArrayList("testRead.txt");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Testing Read class");
        assertArrayEquals(expected.toArray(), result.toArray());
        //return result;
    }
    //static String fileName = "testRead.txt";

}