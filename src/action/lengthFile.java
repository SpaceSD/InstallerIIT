package action;

import java.io.File;

public class lengthFile {

    public static String lengthFile(String st) {

        File file = new File(st);
        if (file.exists()) {

            return String.valueOf((double) file.length()/1024);

            }
        else System.out.println("Файла нет!");

        return st;
    }
}



