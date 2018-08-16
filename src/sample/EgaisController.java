package sample;

import action.JaCartaD.jaCartaDownload;
import action.RutokenD.rutokenDownload;
import action.RutokenD.testExistInstallRutoken;
import action.JaCartaD.testExistInstallJaCarta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EgaisController {


    @FXML
    private Button backButtonEgais;

    @FXML
    private Button testButtonEgais;

    @FXML // fx:id="tokenChoise"
    private ComboBox<String> tokenChoise;


    @FXML // fx:id="stackPaneRutoken"
    private StackPane stackPaneRutoken;

    @FXML // fx:id="stackPaneJaCarta"
    private StackPane stackPaneJaCarta;

    @FXML // fx:id="readyToken"
    private ImageView readyToken;

    @FXML // fx:id="readyToken1"
    private ImageView readyToken1;

    @FXML // fx:id="hyperlinkToken"
    private Hyperlink hyperlinkToken;

    @FXML // fx:id="hyperlinkToken1"
    private Hyperlink hyperlinkToken1;

    @FXML // fx:id="percentDownloadRutoken"
    private Text percentDownloadRutoken;

    @FXML // fx:id="percentDownloadJaCarta"
    private Text percentDownloadJaCarta;

    @FXML // fx:id="readyBrowser"
    private ImageView readyBrowser;

    @FXML // fx:id="readyFsrarCrypto"
    private ImageView readyFsrarCrypto;

    @FXML // fx:id="readyUtm"

    private ImageView readyUtm;
    public static rutokenDownload rutokenDownloads;
    private redyTokenAfterInstallRutoken redyTokenAfterInstallRutoken;
    public static jaCartaDownload jaCartaDownloads;
    private redyTokenAfterInstallJaCarta redyTokenAfterInstallJaCarta;

// This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert tokenChoise != null : "fx:id=\"tokenChoise\" was not injected: check your FXML file 'egais.fxml'.";
        assert readyToken != null : "fx:id=\"readyToken\" was not injected: check your FXML file 'egais.fxml'.";
        assert hyperlinkToken != null : "fx:id=\"hyperlinkToken\" was not injected: check your FXML file 'egais.fxml'.";
    }

//Загрузка сцены на кнопку назад
    @FXML
    private void onClickMethodBack(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("Установщик ИИТ");
        primaryStage.setScene(new Scene(root, 450, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

// Поток для проставления готовности установки Рутокен
    class redyTokenAfterInstallRutoken implements Runnable {

        @Override
        public void run() {

            percentDownloadRutoken.setVisible(false);
            readyToken.setVisible(true);
        }
    }

// Поток для проставления готовности установки JaCarta
    class redyTokenAfterInstallJaCarta implements Runnable {

        @Override
        public void run() {

            percentDownloadJaCarta.setVisible(false);
            readyToken1.setVisible(true);
        }
    }

    //Запускаем поток по нажатию на кнопку скачать: скачивание установка и проставление зеленой галки Рутокен
    @FXML
    private void onClickMethodDownloadRutoken(javafx.event.ActionEvent event) throws IOException {

        hyperlinkToken.setVisible(false);
        percentDownloadRutoken.setVisible(true);
        rutokenDownloads = new rutokenDownload();
        Thread rutokenDownloadThready = new Thread(rutokenDownloads);    //Создание потока "rutokenDownloadThready"
        rutokenDownloadThready.start();//Запуск потока
        redyTokenAfterInstallRutoken = new redyTokenAfterInstallRutoken();
        Thread redyTokenAfterInstallRutokenThredy = new Thread(redyTokenAfterInstallRutoken);
        new Thread(() -> {
            while (rutokenDownloadThready.isAlive() == true) {
                if (rutokenDownloadThready.isAlive() == false) {
                    if (testExistInstallRutoken.testExistInstallRutoken() == true){
                        System.out.println("redyTokenAfterInstallRutokenThredy.start");
                        redyTokenAfterInstallRutokenThredy.start();
                    }else {
                        percentDownloadRutoken.setText("Ошибка загрузки");
                        System.out.println("БЛЯ");
                    }
                }
            }
        }).start();

    }

//Запускаем поток по нажатию на кнопку скачать: скачивание установка и проставление зеленой галки JaCarta
    @FXML
    private void onClickMethodDownloadJaCarta(javafx.event.ActionEvent event) throws IOException {

        hyperlinkToken1.setVisible(false);
        percentDownloadJaCarta.setVisible(true);
        jaCartaDownloads = new jaCartaDownload();
        Thread jaCartaDownloadThready = new Thread(jaCartaDownloads);    //Создание потока "jaCartaDownloadThready"
        jaCartaDownloadThready.start();//Запуск потока
        redyTokenAfterInstallJaCarta = new redyTokenAfterInstallJaCarta();
        Thread redyTokenAfterInstallJaCartaThredy = new Thread(redyTokenAfterInstallJaCarta);
        new Thread(() -> {
            while (jaCartaDownloadThready.isAlive() == true) {
                if (jaCartaDownloadThready.isAlive() == false) {
                    if (testExistInstallJaCarta.testExistInstallJaCarta() == true){
                        System.out.println("redyTokenAfterInstallJaCartaThredy.start");
                        redyTokenAfterInstallJaCartaThredy.start();
                    }else {
                        percentDownloadJaCarta.setText("Ошибка загрузки");
                        System.out.println("БЛЯ");
                    }
                }
            }
        }).start();

    }

//Запускаем поток проверки установки и скачивания Рутокен
    class rutokensR implements Runnable {
        @Override
        public void run() {
            stackPaneJaCarta.setVisible(false);
            stackPaneRutoken.setVisible(true);
            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == false) &
                    (testExistInstallRutoken.testExistInstallRutoken() == false))) {
                hyperlinkToken.setVisible(true);

            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == true) &
                    (testExistInstallRutoken.testExistInstallRutoken() == false))) {
                Process p = null;//Запустить ЕХЕ
                try {
                    p = Runtime.getRuntime().exec("C:\\ProgramData\\rtDrivers_4.3.2.0.exe");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    p.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == true) &
                        (testExistInstallRutoken.testExistInstallRutoken() == true)) ||
                        (((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == false) &
                                (testExistInstallRutoken.testExistInstallRutoken() == true))) {
                    percentDownloadRutoken.setVisible(false);
                    readyToken.setVisible(true);
                }
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == true) &
                    (testExistInstallRutoken.testExistInstallRutoken() == true)) ||
                    (((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == false) &
                            (testExistInstallRutoken.testExistInstallRutoken() == true))) {
                percentDownloadRutoken.setVisible(false);
                readyToken.setVisible(true);
            }
        }
    }

    //Запускаем поток проверки установки и скачивания JaCarta
    class jaCartaR implements Runnable {
        @Override
        public void run() {
            stackPaneJaCarta.setVisible(true);
            stackPaneRutoken.setVisible(false);
            if (((((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi")) == false) || ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi")) == false))&
                    (testExistInstallJaCarta.testExistInstallJaCarta() == false))) {
                hyperlinkToken1.setVisible(true);

            }

            if (((((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi")) == true) || ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi")) == true)) &
                    (testExistInstallJaCarta.testExistInstallJaCarta() == false))) {
                Process p = null;//Запустить ЕХЕ
                try {
                    if ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi")) == true){
                        p = Runtime.getRuntime().exec("cmd /C C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi");
                    } else if ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi")) == true){
                        p = Runtime.getRuntime().exec("cmd /C C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    p.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (((((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi")) == true) ||
                        ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi")) == true)) &
                        (testExistInstallJaCarta.testExistInstallJaCarta() == true)) ||
                        ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi")) == false) || ((action.testExistsFile.testExistsFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi")) == false)) &
                                (testExistInstallJaCarta.testExistInstallJaCarta() == true))) {
                    percentDownloadJaCarta.setVisible(false);
                    readyToken1.setVisible(true);
                }
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == true) &
                    (testExistInstallJaCarta.testExistInstallJaCarta() == true)) ||
                    (((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == false) &
                            (testExistInstallJaCarta.testExistInstallJaCarta() == true))) {
                percentDownloadJaCarta.setVisible(false);
                readyToken1.setVisible(true);
            }
        }
    }

    static rutokensR rutokensRs;
    static jaCartaR jaCartaRs;
//Обработчик выбора в окне выбора Токена
    @FXML
    private void onClickTokenChoise(javafx.event.ActionEvent event) throws IOException {

        String token = tokenChoise.getValue();

        if (token.equals("Рутокен")) {
            stackPaneRutoken.setVisible(true);
            stackPaneJaCarta.setVisible(false);
            rutokensRs = new rutokensR();
            Thread rutokenR = new Thread(rutokensRs);
            rutokenR.start();
            readyToken.setVisible(false);

        } else if (token.equals("JaCarta")) {
            stackPaneRutoken.setVisible(false);
            stackPaneJaCarta.setVisible(true);
            jaCartaRs = new jaCartaR();
            Thread jaCarta = new Thread(jaCartaRs);
            jaCarta.start();
            readyToken1.setVisible(false);

        }
        System.out.println(token);


    }
}

