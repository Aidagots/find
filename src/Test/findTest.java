package Test;

import Main.find;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class findTest {
    private static void assertFileContent(String name, String expectedContent) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(name));
            String curr;
            while ((curr = br.readLine()) != null) {
                content.append(curr);
                content.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int length = content.length();
        if (length > 0) content.deleteCharAt(length - 1);
        assertEquals(expectedContent, content.toString());
    }

    @org.junit.jupiter.api.Test
    void findcTest() {
        String[] arg = {"find", "-d" , "file//", "log.txt"};
        find.main(arg);
        assertFileContent("file/log.txt" , "pls.txt");
        String[] arg1 = {"find", "-r" , "-d" , "Aida//", "hof.txt"};
        find.main(arg1);
        assertFileContent("file/log.txt" , "hof.txt");
        String[] arg2 = {"find", "-d" , "Aida//", "rov.txt"};
        find.main(arg2);
        assertFileContent("file/log.txt" , "rov.txt");
    }

}
