package action.FsrarCrypto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testExistInstallFsrarCrypto {

    public static boolean testExistInstallFsrarCrypto(){
        String value = "";
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("cmd /C reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Installer\\UserData\\S-1-5-18\\Products\\FCE9D6F0A960E344B95824553DE57D17\\InstallProperties\" /v \"DisplayVersion\" > \"C:\\ProgramData\\FSRARC.txt\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream inFile = new FileInputStream("C:\\ProgramData\\FSRARC.txt");
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            value = new String(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (value.contains("2.00.0000") == true){
            return true;
        } else return false;
    }

}
