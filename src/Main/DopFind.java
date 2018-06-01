package Main;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

public class DopFind {
    private static ArrayList<String> list = new ArrayList<String>();

    private static void searchInDir(File file, String filename) {
        for (File item : Objects.requireNonNull(file.listFiles())) {
            if (item.isDirectory()) {
                searchInDir(item, filename);
            } else {
                if (item.getName().equals(filename)) {
                    list.add(item.getName());
                }
            }
        }
    }

    public static void search(String namedir, String namefile, boolean d, boolean r) {
        assert namedir != null;
        File dir = new File(namedir);

        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if ((!item.isDirectory() && (item.getName()).equals(namefile)) && d) {
                    list.add(item.getName());
                }
                if (item.isDirectory() && r) {
                    searchInDir(item, namefile);
                }
            }

        }
    }


    public static ArrayList<String> getFile() {
        return list;
    }
}


