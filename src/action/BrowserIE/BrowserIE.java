package action.BrowserIE;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BrowserIE {
    public static boolean BrowserIE() throws IOException {
        String value = "";
        String valueOK = "";

        Process re = Runtime.getRuntime().exec("cmd /C reg query \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\" /v \"ok\" > \"C:\\ProgramData\\reOK.txt\"");
        try {

            re.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream inFileOK = new FileInputStream("C:\\ProgramData\\reOK.txt");
            byte[] strOK = new byte[inFileOK.available()];
            inFileOK.read(strOK);
            valueOK = new String(strOK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (valueOK.contains("0x1") == false){
            Process regadd000 = Runtime.getRuntime().exec("cmd /c start /wait C:\\GitSpace\\InstallerIIT\\src\\action\\BrowserIE\\egais.bat");
        }


        Process p = Runtime.getRuntime().exec("cmd /C reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Internet Explorer\" /v \"Version\" > \"C:\\ProgramData\\IEV.txt\"");
        try {

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
