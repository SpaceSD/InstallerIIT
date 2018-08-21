package action.RutokenD;


import action.downloadFileFromURL;
import action.lengthFile;

import java.io.File;
import java.io.IOException;

public class rutokenDownload 			//Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{


    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        try {
            downloadFileFromURL.downloadFileFromURL("http://files.iitrust.ru/utils/Rutoken/rtDrivers_4.3.2.0.exe", new File("C:\\ProgramData\\rtDrivers_4.3.2.0.exe"));
            //System.out.println(lengthFile.lengthFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe"));
            while ( lengthFile.lengthFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe") < 14992){



            }
            Process p = Runtime.getRuntime().exec("C:\\ProgramData\\rtDrivers_4.3.2.0.exe");//Запустить ЕХЕ
            p.waitFor();
            System.out.println("метод загрузки закончился");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

