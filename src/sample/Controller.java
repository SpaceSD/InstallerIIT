package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    private Button buttonEgais;



    @FXML
    private void onClickMethod(javafx.event.ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("egais.fxml"));
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("Установщик ЕГАИС");
            primaryStage.setScene(new Scene(root, 450, 500));
            primaryStage.setResizable(false);
            primaryStage.show();

        }
    }


