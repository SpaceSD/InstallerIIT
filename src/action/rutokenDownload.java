package action;

import java.io.File;

public class rutokenDownload 			//Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{
    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        downloadFileFromURL.downloadFileFromURL("https://files.infotecs.ru/_dl/sess/vipnet_csp/full/a16756dd816b7287770577e7080b113e/vipnet_csp_4.2_cert.zip", new File("C:\\Users\\Public\\vipnet_csp_4.2_cert.zip"));
    }
}

