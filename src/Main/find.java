package Main;

import java.io.File;
import java.util.Objects;

public class find {
    public static void main(String[] args){
        new find().start(args);
    }

    public void start(String[] args){
        boolean r = false;
        boolean d = false;
        String namedir = null;
        String namefile = null;
        boolean count = false ;
        for (int i = 1 ; i < args.length ; i++){
            if ("-r".equals(args[i])){
                r = true;
            }
            if ("-d".equals(args[i])){
                d = true;
                namedir = args[i+1];
            }
            if (!("-r".equals(args[i]))&&!("-d".equals(args[i]))&&!("-d".equals(args[i-1]))){
                namefile = args[i];
            }
        }

        if (d) {
            String s;
            File dir = new File(namedir);
            if(dir.isDirectory()){
                for(File item : Objects.requireNonNull(dir.listFiles())){
                    if (!item.isDirectory() && (item.getName()).equals(namefile)){
                        System.out.print(item.getName());
                        count = true;
                    }
                }
            }
        }

        if (r&&!count) {
            String str;
            assert namedir != null;
            File dir = new File(namedir);

            if(dir.isDirectory()){
                for(File item : Objects.requireNonNull(dir.listFiles())){
                    if (item.isDirectory()) {
                        str = namedir + "//" + item.getName();
                        searchpodDir(str , namefile);
                    }
                }

            }
        }



    }


    private void searchpodDir(String str , String filename) {
        File dir = new File(str);
        for (File item : Objects.requireNonNull(dir.listFiles())) {
            if (item.isDirectory()){
                String l = str + "//" + item.getName();
                searchpodDir(l , filename);
            } else {
                if(item.getName().equals(filename)){
                    System.out.print(item.getName());
                    break;
                }
            }
        }
    }
}
