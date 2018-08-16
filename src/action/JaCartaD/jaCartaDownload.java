package action.JaCartaD;


import action.downloadFileFromURL;

import java.io.File;
import java.io.IOException;

public class jaCartaDownload            //Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{


    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        try {
            ///написать условие по системе 86 64 d cmd: systeminfo | find /i "based PC" > "C:\ProgramData\xXX-based PC.txt"
            downloadFileFromURL.downloadFileFromURL("http://files.iitrust.ru/utils/JaCarta/JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi", new File("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi"));
            Process p = null;
            if ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi")) == true){
                p = Runtime.getRuntime().exec("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi");
            } else if ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi")) == true){
                p = Runtime.getRuntime().exec("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi");
            }
            p.waitFor();
            System.out.println("метод загрузки закончился");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

