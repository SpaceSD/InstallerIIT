package sample;

import action.BrowserIE.browserDownload;
import action.FsrarCrypto.fsrarCryptoDownload;
import action.FsrarCrypto.testExistInstallFsrarCrypto;
import action.JaCartaD.jaCartaDownload;
import action.JaCartaD.testExistInstallJaCarta;
import action.RutokenD.rutokenDownload;
import action.RutokenD.testExistInstallRutoken;
import action.UTM.testExistInstallUTM;
import action.UTM.utmDownload;
import action.lengthFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
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

    @FXML // fx:id="stackPaneFsrarCrypto"
    private StackPane stackPaneFsrarCrypto;

    @FXML // fx:id="readyToken"
    private ImageView readyToken;

    @FXML // fx:id="readyToken1"
    private ImageView readyToken1;

    @FXML // fx:id="readyBrowser"
    private ImageView readyBrowser;

    @FXML // fx:id="readyFsrarCrypto"
    private ImageView readyFsrarCrypto;

    @FXML // fx:id="readyUTM"
    private ImageView readyUTM;

    @FXML // fx:id="hyperlinkToken"
    private Hyperlink hyperlinkToken;

    @FXML // fx:id="hyperlinkToken1"
    private Hyperlink hyperlinkToken1;

    @FXML // fx:id="hyperlinkFsrarCrypto"
    private Hyperlink hyperlinkFsrarCrypto;

    @FXML // fx:id="hyperlinkUTM"
    private Hyperlink hyperlinkUTM;

    @FXML // fx:id="hyperlinkUpdateBrowser"
    private Hyperlink hyperlinkUpdateBrowser;

    @FXML // fx:id="percentDownloadRutoken"
    private Text percentDownloadRutoken;

    @FXML // fx:id="percentDownloadJaCarta"
    private Text percentDownloadJaCarta;

    @FXML // fx:id="percentDownloadFsrarCrypto"
    private Text percentDownloadFsrarCrypto;

    @FXML // fx:id="percentDownloadUTM"
    private Text percentDownloadUTM;

    @FXML // fx:id="updateBrowser"
    private Text updateBrowser;

    @FXML // fx:id="progressBarToken"
    private ProgressIndicator progressBarToken;

    @FXML // fx:id="progressBarFsrar"
    private ProgressIndicator progressBarFsrar;

    @FXML // fx:id="progressBarUTM"
    private ProgressIndicator progressBarUTM;

    @FXML // fx:id="BOXprogress"
    private VBox BOXprogress;



    public static rutokenDownload rutokenDownloads;
    private redyTokenAfterInstallRutoken redyTokenAfterInstallRutoken;
    public static jaCartaDownload jaCartaDownloads;
    private redyTokenAfterInstallJaCarta redyTokenAfterInstallJaCarta;
    public static fsrarCryptoDownload fsrarCryptoDownloads;
    private redyFsrarCryptoAfterInstall redyFsrarCryptoAfterInstall;
    private static browserDownload browserDownload;
    private redyBrowserInstall redyBrowserInstall;
    public static utmDownload utmDownloads;
    private redyAfterInstallUTM redyAfterInstallUTM;


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

// Поток для проставления готовности установки FsrarCrypto
    class redyFsrarCryptoAfterInstall implements Runnable {

        @Override
        public void run() {

            percentDownloadJaCarta.setVisible(false);
            readyToken1.setVisible(true);
        }
    }

// Поток для проставления готовности установки Browser
    class redyBrowserInstall implements Runnable {

        @Override
        public void run() {

            updateBrowser.setVisible(false);
            readyBrowser.setVisible(true);
        }
    }

// Поток для проставления готовности установки Рутокен
    class redyAfterInstallUTM implements Runnable {

        @Override
        public void run() {

            percentDownloadUTM.setVisible(false);
            readyUTM.setVisible(true);
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
        BOXprogress.setVisible(true);
        redyTokenAfterInstallRutoken = new redyTokenAfterInstallRutoken();
        Thread redyTokenAfterInstallRutokenThredy = new Thread(redyTokenAfterInstallRutoken);
        new Thread(() -> {
            while (rutokenDownloadThready.isAlive() == true) {
                if (rutokenDownloadThready.isAlive() == false) {
                    if (testExistInstallRutoken.testExistInstallRutoken() == true){
                        System.out.println("redyTokenAfterInstallRutokenThredy.start");
                        redyTokenAfterInstallRutokenThredy.start();
                        BOXprogress.setVisible(false);
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
        BOXprogress.setVisible(true);
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
                        BOXprogress.setVisible(false);
                    }else {
                        percentDownloadJaCarta.setText("Ошибка загрузки");
                        System.out.println("БЛЯ");
                    }
                }
            }
        }).start();

    }

//Запускаем поток по нажатию на кнопку скачать: скачивание установка и проставление зеленой галки FsrarCrypto
    @FXML
    private void onClickMethodDownloadFsrarCrypto(javafx.event.ActionEvent event) throws IOException {
        BOXprogress.setVisible(true);
        hyperlinkFsrarCrypto.setVisible(false);
        percentDownloadFsrarCrypto.setVisible(true);
        fsrarCryptoDownloads = new fsrarCryptoDownload();
        Thread fsrarCryptoDownloadThready = new Thread(fsrarCryptoDownloads);    //Создание потока "fsrarCryptoDownloadThready"
        fsrarCryptoDownloadThready.start();//Запуск потока
        redyFsrarCryptoAfterInstall = new redyFsrarCryptoAfterInstall();
        Thread redyFsrarCryptoAfterInstallThredy = new Thread(redyFsrarCryptoAfterInstall);
        new Thread(() -> {
            while (fsrarCryptoDownloadThready.isAlive() == true) {
                if (fsrarCryptoDownloadThready.isAlive() == false) {
                    if (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == true){
                        System.out.println("redyFsrarCryptoAfterInstallThredy.start");
                        redyFsrarCryptoAfterInstallThredy.start();
                        BOXprogress.setVisible(false);
                    }else {
                        percentDownloadFsrarCrypto.setText("Ошибка загрузки");
                        System.out.println("БЛЯ");
                    }
                }
            }
        }).start();

    }

//Запускаем поток по нажатию на кнопку скачать: скачивание установка и проставление зеленой галки UTM
    @FXML
    private void onClickMethodDownloadUTM(javafx.event.ActionEvent event) throws IOException {
        BOXprogress.setVisible(true);
        hyperlinkUTM.setVisible(false);
        percentDownloadUTM.setVisible(true);
        utmDownloads = new utmDownload();
        Thread utmDownloadThready = new Thread(utmDownloads);    //Создание потока "fsrarCryptoDownloadThready"
        utmDownloadThready.start();//Запуск потока
        redyAfterInstallUTM = new redyAfterInstallUTM();
        Thread redyAfterInstallUTMThredy = new Thread(redyAfterInstallUTM);
        new Thread(() -> {
            while (utmDownloadThready.isAlive() == true) {
                if (utmDownloadThready.isAlive() == false) {
                    if (testExistInstallUTM.testExistInstallUTM() == true){
                        System.out.println("redyAfterInstallUTMThredy.start");
                        redyAfterInstallUTMThredy.start();
                        BOXprogress.setVisible(false);
                    }else {
                        percentDownloadUTM.setText("Ошибка загрузки");
                        System.out.println("БЛЯ");
                    }
                }
            }
        }).start();

    }

//Запускаем поток по нажатию на кнопку скачать: скачивание установка и проставление зеленой галки IE
    @FXML
    private void onClickMethodDownloadUpdateBrowser(javafx.event.ActionEvent event) throws IOException {

        hyperlinkUpdateBrowser.setVisible(false);
        updateBrowser.setVisible(true);
        browserDownload = new browserDownload();

        Thread browserDownloadsThready = new Thread(browserDownload);    //Создание потока "fsrarCryptoDownloadThready"
        browserDownloadsThready.start();//Запуск потока
        redyBrowserInstall = new redyBrowserInstall();
        Thread redyBrowserInstallThredy = new Thread(redyBrowserInstall);
        new Thread(() -> {
            while (browserDownloadsThready.isAlive() == true) {
                if (browserDownloadsThready.isAlive() == false) {
                    if (testExistInstallJaCarta.testExistInstallJaCarta() == true){
                        System.out.println("redyFsrarCryptoAfterInstallThredy.start");
                        redyBrowserInstallThredy.start();
                    }else {
                        updateBrowser.setText("Установите обновление");
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
                readyToken.setVisible(false);
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
                    BOXprogress.setVisible(false);
                }
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == true) &
                    (testExistInstallRutoken.testExistInstallRutoken() == true)) ||
                    (((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == false) &
                            (testExistInstallRutoken.testExistInstallRutoken() == true))) {
                percentDownloadRutoken.setVisible(false);
                readyToken.setVisible(true);
                BOXprogress.setVisible(false);
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
                readyToken1.setVisible(false);
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
                    BOXprogress.setVisible(false);
                }
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == true) &
                    (testExistInstallJaCarta.testExistInstallJaCarta() == true)) ||
                    (((action.testExistsFile.testExistsFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe")) == false) &
                            (testExistInstallJaCarta.testExistInstallJaCarta() == true))) {
                percentDownloadJaCarta.setVisible(false);
                readyToken1.setVisible(true);
                BOXprogress.setVisible(false);
            }
        }
    }

//Запускаем поток проверки установки и скачивания FsrarCrypto
    class fsrarCryptoR implements Runnable {
        @Override
        public void run() {
            stackPaneFsrarCrypto.setVisible(true);
            if (((action.testExistsFile.testExistsFile("C:\\ProgramData\\setup-ie.exe")) == false) &
                    (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == false)) {
                readyFsrarCrypto.setVisible(false);
                hyperlinkFsrarCrypto.setVisible(true);
                System.out.println("проверили 1 условие установки фсрар");
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\setup-ie.exe")) == true) &
                    (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == false))) {
                Process p = null;//Запустить ЕХЕ
                try {
                    p = Runtime.getRuntime().exec("cmd /c \"C:\\ProgramData\\setup-ie.exe\"");
                    System.out.println("запустили 2 условие проверки и установку фсрар");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    p.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\setup-ie.exe")) == true) &
                        (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == true)) ||
                        (((action.testExistsFile.testExistsFile("C:\\ProgramData\\setup-ie.exe")) == false) &
                                (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == true))) {
                    System.out.println("запустили 3 условие проверки и реди");
                    percentDownloadFsrarCrypto.setVisible(false);
                    readyFsrarCrypto.setVisible(true);
                    BOXprogress.setVisible(false);
                }
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\setup-ie.exe")) == true) &
                    (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == true)) ||
                    (((action.testExistsFile.testExistsFile("C:\\ProgramData\\setup-ie.exe")) == false) &
                            (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == true))) {
                System.out.println("запустили 4 условие проверки и реди");
                percentDownloadFsrarCrypto.setVisible(false);
                readyFsrarCrypto.setVisible(true);
                BOXprogress.setVisible(false);
            }
        }
    }

    //Запускаем поток проверки установки и скачивания UTM
    class UTMR implements Runnable {
        @Override
        public void run() {

            if (((action.testExistsFile.testExistsFile("C:\\ProgramData\\realegaissetup-3_0_8.exe")) == false) &
                    (testExistInstallUTM.testExistInstallUTM() == false)) {
                readyUTM.setVisible(false);
                hyperlinkUTM.setVisible(true);

            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\realegaissetup-3_0_8.exe")) == true) &
                    (testExistInstallUTM.testExistInstallUTM() == false))) {
                Process p = null;//Запустить ЕХЕ
                try {
                    p = Runtime.getRuntime().exec("cmd /c \"C:\\ProgramData\\realegaissetup-3_0_8.exe\"");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    p.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\realegaissetup-3_0_8.exe")) == true) &
                        (testExistInstallUTM.testExistInstallUTM() == true)) ||
                        (((action.testExistsFile.testExistsFile("C:\\ProgramData\\realegaissetup-3_0_8.exe")) == false) &
                                (testExistInstallFsrarCrypto.testExistInstallFsrarCrypto() == true))) {
                    percentDownloadUTM.setVisible(false);
                    readyUTM.setVisible(true);
                    BOXprogress.setVisible(false);
                }
            }

            if ((((action.testExistsFile.testExistsFile("C:\\ProgramData\\realegaissetup-3_0_8.exe")) == true) &
                    (testExistInstallUTM.testExistInstallUTM() == true)) ||
                    (((action.testExistsFile.testExistsFile("C:\\ProgramData\\realegaissetup-3_0_8.exe")) == false) &
                            (testExistInstallUTM.testExistInstallUTM() == true))) {
                percentDownloadUTM.setVisible(false);
                readyUTM.setVisible(true);
                BOXprogress.setVisible(false);

            }
        }
    }

    static rutokensR rutokensRs;
    static jaCartaR jaCartaRs;
    static fsrarCryptoR fsrarCryptoRs;
    static UTMR UTMRs;
//Обработчик выбора в окне выбора Токена
    @FXML
    private void onClickTokenChoise(javafx.event.ActionEvent event) throws IOException {

        String token = tokenChoise.getValue();

        if (token.equals("Рутокен")) {
            hyperlinkUpdateBrowser.setVisible(false);
            stackPaneRutoken.setVisible(true);
            stackPaneJaCarta.setVisible(false);
            rutokensRs = new rutokensR();
            Thread rutoken = new Thread(rutokensRs);
            rutoken.start();
            File RUTOKENFile = new File("C:\\ProgramData\\rtDrivers_4.3.2.0.exe");
            if (RUTOKENFile.exists()){
            new Thread(()->{
                while ( lengthFile.lengthFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe") < 14992){
                    double progR = ((lengthFile.lengthFile("C:\\ProgramData\\rtDrivers_4.3.2.0.exe"))*1)/14992;
                    progressBarToken.setProgress(progR);
                }
            }).start();
            }
            readyToken.setVisible(false);

        } else if (token.equals("JaCarta")) {
            hyperlinkUpdateBrowser.setVisible(false);
            stackPaneRutoken.setVisible(false);
            stackPaneJaCarta.setVisible(true);
            jaCartaRs = new jaCartaR();
            Thread jaCarta = new Thread(jaCartaRs);
            jaCarta.start();
            File JaCartaFile6 = new File("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi");
            File JaCartaFile8 = new File("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi");
            if (JaCartaFile6.exists() || JaCartaFile8.exists()){
            new Thread(()->{
                while ( (lengthFile.lengthFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi") < 64647) ||
                        (lengthFile.lengthFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi") < 44471)){
                    File file6 = new File("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi");
                    File file8 = new File("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi");
                    if (file6.exists()){
                        double progJ = ((lengthFile.lengthFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x64_ru-Ru.msi"))*1)/64647;
                        progressBarToken.setProgress(progJ);
                    } else if (file8.exists()){
                        double progJ = ((lengthFile.lengthFile("C:\\ProgramData\\JaCartaUnifiedClient_2.11.0.1754_win-x86_ru-Ru.msi"))*1)/44471;
                        progressBarToken.setProgress(progJ);

                    }
                }
            }).start();
            }
            readyToken1.setVisible(false);

        }
        System.out.println(token);

        if (action.BrowserIE.BrowserIE.BrowserIE() == true){
            hyperlinkUpdateBrowser.setVisible(false);
            readyBrowser.setVisible(true);
            updateBrowser.setVisible(false);
        }else {
            updateBrowser.setVisible(false);
            readyBrowser.setVisible(false);
            hyperlinkUpdateBrowser.setVisible(true);
        }

        stackPaneFsrarCrypto.setVisible(true);
        fsrarCryptoRs = new fsrarCryptoR();
        Thread fsrarCrypto = new Thread(fsrarCryptoRs);
        fsrarCrypto.start();
        System.out.println("fsrarCrypto.start()");
        //hyperlinkUTM.setVisible(true);
        File EFSRARFile = new File("C:\\ProgramData\\setup-ie.exe");
        if (EFSRARFile.exists()){
        new Thread(()->{
            while ( lengthFile.lengthFile("C:\\ProgramData\\setup-ie.exe") < 3934){
                double progF = ((lengthFile.lengthFile("C:\\ProgramData\\setup-ie.exe"))*1)/3934;
                progressBarFsrar.setProgress(progF);
            }
        }).start();
        }
        UTMRs = new UTMR();
        Thread UTM = new Thread(UTMRs);
        UTM.start();

        File EUTMFile = new File("C:\\ProgramData\\realegaissetup-3_0_8.exe");
        if (EUTMFile.exists()){
        new Thread(()->{
            while ( lengthFile.lengthFile("C:\\ProgramData\\realegaissetup-3_0_8.exe") < 96433){
                double progU = ((lengthFile.lengthFile("C:\\ProgramData\\realegaissetup-3_0_8.exe"))*1)/96433;
                progressBarUTM.setProgress(progU);
            }
        }).start();}
    }



}

