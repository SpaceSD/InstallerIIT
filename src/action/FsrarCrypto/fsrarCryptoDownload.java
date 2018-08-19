package action.FsrarCrypto;


import action.downloadFileFromURL;

import java.io.File;
import java.io.IOException;

public class fsrarCryptoDownload            //Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{


    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        try {
            downloadFileFromURL.downloadFileFromURL("https://service.egais.ru/files/setup-ie.exe", new File("C:\\ProgramData\\setup-ie.exe"));

            Process p = Runtime.getRuntime().exec("cmd /c \"C:\\ProgramData\\setup-ie.exe\"");//Запустить ЕХЕ
            p.waitFor();
            System.out.println("метод загрузки закончился");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

