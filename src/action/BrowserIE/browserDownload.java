package action.BrowserIE;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class browserDownload            //Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{


    public void run()		//Этот метод будет выполняться в побочном потоке
    {

        try {
            Desktop.getDesktop().browse(new URI("http://windows.microsoft.com/ru-ru/internet-explorer/download-ie"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("метод загрузки закончился");


    }

}

