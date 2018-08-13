package action;

import java.io.File;

public class testExistsFile {

    public static boolean testExistsFile(String fileP) {

        File file = new File(fileP);
        if (file.exists()) {

            return true;

        }
        else return false;
    }

}

