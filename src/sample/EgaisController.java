package sample;

import action.lengthFile;
import javafx.collections.ObservableList;
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

    @FXML // fx:id="tokenChoise"
    private ComboBox<String> tokenChoise;


    @FXML // fx:id="stackPaneRutoken"
    private StackPane stackPaneRutoken;

    @FXML // fx:id="readyToken"
    private ImageView readyToken;

    @FXML // fx:id="hyperlinkToken"
    private Hyperlink hyperlinkToken;

    @FXML // fx:id="percentDownloadRutoken"
    private Text percentDownloadRutoken;

    @FXML // fx:id="readyBrowser"
    private ImageView readyBrowser;

    @FXML // fx:id="readyFsrarCrypto"
    private ImageView readyFsrarCrypto;

    @FXML // fx:id="readyUtm"
    private ImageView readyUtm;

    // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert tokenChoise != null : "fx:id=\"tokenChoise\" was not injected: check your FXML file 'egais.fxml'.";
        assert readyToken != null : "fx:id=\"readyToken\" was not injected: check your FXML file 'egais.fxml'.";
        assert hyperlinkToken != null : "fx:id=\"hyperlinkToken\" was not injected: check your FXML file 'egais.fxml'.";
    }
    @FXML
    private void onClickMethodBack(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("Установщик ИИТ");
        primaryStage.setScene(new Scene(root, 450, 500));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    static action.rutokenDownload rutokenDownloads;

    @FXML
    private void onClickMethodDownloadRutoken(javafx.event.ActionEvent event) throws IOException {

        hyperlinkToken.setVisible(false);
        percentDownloadRutoken.setVisible(true);
        rutokenDownloads = new action.rutokenDownload();
        Thread rutokenDownloadThready = new Thread(rutokenDownloads);	//Создание потока "rutokenDownloadThready"
        rutokenDownloadThready.start();//Запуск потока
        percentDownloadRutoken.setText(lengthFile.lengthFile("C:\\Users\\Public\\vipnet_csp_4.2_cert.zip"));


    }

    @FXML

    private void onClickTokenChoise(javafx.event.ActionEvent event) throws IOException {

        String token = tokenChoise.getValue();

        if (token.equals("Рутокен")) {
            stackPaneRutoken.setVisible(true);
            System.out.println("Видно Рутокен");
        }else if (token.equals("JaCarta")){
            System.out.println("Видно JaCarta");
        }
        System.out.println(token);


}


    /*tokenChoise.

             {
        @Override public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
            if (oldFruit != null) {
                switch(oldFruit) {
                    case "Apple":  appleImage.setVisible(false);  break;
                    case "Orange": orangeImage.setVisible(false); break;
                    case "Pear":   pearImage.setVisible(false);   break;
                }
            }
            if (newFruit != null) {
                switch(newFruit) {
                    case "Apple":  appleImage.setVisible(true);   break;
                    case "Orange": orangeImage.setVisible(true);  break;
                    case "Pear":   pearImage.setVisible(true);    break;
                }
            }
        }
    });*/



}
