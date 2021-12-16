
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ReadTest {
    @org.junit.jupiter.api.Test
    void fileToArrayList() {
        //Read read = new Read();
        //ArrayList<String> temp = Read.fileToArrayList("testRead.txt");
        ArrayList<String> result = Read.fileToArrayList("testRead.txt");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Testing Read class");
        //return result;
        //if (true) return result;
        assertArrayEquals(expected.toArray(), result.toArray());

    }
}


