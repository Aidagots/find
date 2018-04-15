package Main;

public class find {

    public static void main(String[] args){
        new find().start(args);
    }

    private void start(String[] args){
        boolean r = false;
        boolean d = false;
        String namedir = "out//artifacts//find_jar//";
        String namefile = null;

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
            DopFind.d(namedir , namefile);
        }

        if (r) {
            DopFind.r(namedir , namefile);
        }

    }
}
