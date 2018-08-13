package action;


import java.io.File;
import java.io.IOException;

public class rutokenDownload 			//Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{


    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        downloadFileFromURL.downloadFileFromURL("http://files.iitrust.ru/utils/Rutoken/rtDrivers_4.3.2.0.exe", new File("C:\\ProgramData\\rtDrivers_4.3.2.0.exe"));
        try {
            Runtime.getRuntime().exec("C:\\ProgramData\\rtDrivers_4.3.2.0.exe");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

