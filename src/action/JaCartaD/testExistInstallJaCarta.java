package action.JaCartaD;

import java.io.File;

public class testExistInstallJaCarta {

    public static boolean testExistInstallJaCarta() {
        String fileP = "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Аладдин Р.Д\\Единый Клиент JaCarta.lnk";
        File file = new File(fileP);
        if (file.exists()) {

            return true;

        }
        else return false;
    }

}
