package Main;

import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

public class DopFind {
    private static void searchpodDir(String str, String filename) {
        File dir = new File(str);
        for (File item : Objects.requireNonNull(dir.listFiles())) {
            if (item.isDirectory()) {
                String l = str + "//" + item.getName();
                searchpodDir(l, filename);
            } else {
                if (item.getName().equals(filename)) {
                    System.out.print(item.getName());
                    try {
                        FileWriter write = new FileWriter("file/log.txt");
                        write.append(item.getName());
                        write.close();
                    } catch (Exception e) {
                        System.out.print(e.toString());
                    }
                    break;
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
                    try {
                        FileWriter write = new FileWriter("file/log.txt");
                        write.append(item.getName());
                        write.close();
                    } catch (Exception e) {
                        System.out.print(e.toString());
                    }
                    break;
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
                    str = namedir + "//" + item.getName();
                    searchpodDir(str , namefile);
                }else if((item.getName()).equals(namefile)){
                    System.out.print(item.getName());
                    try {
                        FileWriter write = new FileWriter("file/log.txt");
                        write.append(item.getName());
                        write.close();
                    } catch (Exception e) {
                        System.out.print(e.toString());
                    }
                    break;
                }
            }

        }
    }
}
