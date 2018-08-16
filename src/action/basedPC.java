package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class basedPC {

    public static String basedPC() {
        String cmdZ = "cmd /C systeminfo | find /i \"based PC\" > \"C:\\ProgramData\\xXX-based_PC.txt\"";
        String text = "";
        Scanner in = null;

        Thread cmd = new Thread(() -> {
            try {
                Process prX = Runtime.getRuntime().exec(cmdZ);
                prX.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        cmd.start();
        try {
            cmd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream inFile = new FileInputStream("C:\\ProgramData\\xXX-based_PC.txt");
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;

    }


}
