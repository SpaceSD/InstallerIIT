package action.BrowserIE;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BrowserIE {
    public static boolean BrowserIE() throws IOException {
        String value = "";
        Process regadd001 = Runtime.getRuntime().exec("cmd /C reg add \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Domains\\egais.ru\" /v http /t REG_DWORD /d 00000002 ");
        Process regadd002 = Runtime.getRuntime().exec("cmd /C reg add \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\ZoneMap\\Domains\\egais.ru\" /v https /t REG_DWORD /d 00000002");
        Process p = Runtime.getRuntime().exec("cmd /C reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Internet Explorer\" /v \"Version\" > \"C:\\ProgramData\\IEV.txt\"");
        try {
            regadd001.destroy();
            regadd002.destroy();
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
