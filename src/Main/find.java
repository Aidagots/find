package Main;

import java.io.File;

public class find {

    public static void main(String[] args) {
        new find().start(args);
    }

    private void start(String[] args) {
        boolean r = false;
        boolean d = true;
        String namefile = null;

        File f = new File("");
        String namedir = f.getAbsolutePath();

        for (int i = 1; i < args.length; i++) {
            if ("-r".equals(args[i])) {
                r = true;
            }
            if ("-d".equals(args[i])) {
                namedir = args[i + 1];
            }
            if (!("-r".equals(args[i])) && !("-d".equals(args[i])) && !("-d".equals(args[i - 1]))) {
                namefile = args[i];
            }
        }


        DopFind.search(namedir, namefile, d, r);
        System.out.print(DopFind.getFile());
    }
}