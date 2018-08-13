package action;

import java.io.File;

public class lengthFile {

    public static double lengthFile(String st) {

        File file = new File(st);
        if (file.exists()) {

            return (double) file.length()/1024;

            }
        else return 0;
    }
}



