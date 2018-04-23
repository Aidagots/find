package Test;

import Main.DopFind;
import Main.find;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class findTest {

    @org.junit.jupiter.api.Test
    void findcTest() {
        ArrayList<String> list = new ArrayList<>();
        String[] arg = {"find", "-r", "log.txt"};
        find.main(arg);
        list.add("log.txt");
        assertEquals(list, DopFind.getFile());
        String[] arg1 = {"find", "-r", "-d", "Aida//", "rov.txt"};
        find.main(arg1);
        list.add("rov.txt");
        assertEquals(list, DopFind.getFile());
        String[] arg2 = {"find", "pls.txt"};
        find.main(arg2);
        list.add("pls.txt");
        assertEquals(list, DopFind.getFile());
        String[] arg3 = {"find", "-d", "Aida//KEK", "hof.txt"};
        find.main(arg3);
        list.add("hof.txt");
        assertEquals(list, DopFind.getFile());
    }

}
