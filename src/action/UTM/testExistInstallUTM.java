package action.UTM;

import java.io.File;

public class testExistInstallUTM {

    public static boolean testExistInstallUTM(){

        String fileP = "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\ФСРАР УТМ\\UTM.lnk";
        File file = new File(fileP);
        if (file.exists()) {

            return true;

        }
        else return false;

    }

}
