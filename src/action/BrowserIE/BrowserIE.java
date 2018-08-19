package action.BrowserIE;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BrowserIE {
    public static boolean BrowserIE() throws IOException {
        String value = "";
        Process p = Runtime.getRuntime().exec("cmd /C reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Internet Explorer\" /v \"Version\" > \"C:\\ProgramData\\IEV.txt\"");

        try {
            FileInputStream inFile = new FileInputStream("C:\\ProgramData\\IEV.txt");
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            value = new String(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (value.contains("    9.") == true){
            return true;
        } else return false;

    }
}
