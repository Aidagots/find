package Main;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;

public class DopFind {
    static ArrayList<String> list = new ArrayList<String>();

    private static void searchpodDir(File file, String filename) {
        for (File item : Objects.requireNonNull(file.listFiles())) {
            if (item.isDirectory()) {
                searchpodDir(item, filename);
            } else {
                if (item.getName().equals(filename)) {
                    System.out.print(item.getName());
                    list.add(item.getName());
                }
            }
        }
    }



    public static void d(String namedir, String namefile){
        File dir = new File(namedir);
        if(dir.isDirectory()){
            for(File item : Objects.requireNonNull(dir.listFiles())){
                if (!item.isDirectory() && (item.getName()).equals(namefile)){
                    System.out.print(item.getName());
                    list.add(item.getName());
                }
            }
        }
    }

    public static void r(String namedir, String namefile){
        String str;
        assert namedir != null;
        File dir = new File(namedir);

        if(dir.isDirectory()){
            for(File item : Objects.requireNonNull(dir.listFiles())){
                if (item.isDirectory()) {
                    searchpodDir(item, namefile);
                }else if((item.getName()).equals(namefile)){
                    System.out.print(item.getName());
                }
            }

        }
    }


    public static ArrayList<String> getFile() {
        return list;
    }
}
