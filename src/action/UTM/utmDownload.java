package action.UTM;


import action.downloadFileFromURL;

import java.io.File;
import java.io.IOException;

public class utmDownload            //Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{


    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        try {
            downloadFileFromURL.downloadFileFromURL("https://egais.ru/files/realegaissetup-3_0_8.exe", new File("C:\\ProgramData\\realegaissetup-3_0_8.exe"));

            Process p = Runtime.getRuntime().exec("cmd /c \"C:\\ProgramData\\realegaissetup-3_0_8.exe\"");//Запустить ЕХЕ
            p.waitFor();
            System.out.println("метод загрузки закончился");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

