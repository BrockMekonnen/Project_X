package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.omg.CORBA.TRANSIENT;

import java.io.IOException;

public class WindowChangeController {

    private Stage stage;
    private AnchorPane pane;
    static Stage popupStage;


    public WindowChangeController(){
        stage = new Stage();
    }

    private void changer(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        pane = loader.load();
        Scene loginScene =  new Scene(pane);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(loginScene);
        stage.show();
    }

    public void signOut(ActionEvent event, String fxml) throws IOException {
        changer(event,fxml);
    }

    public void changeWindow(ActionEvent event, String fxml) throws IOException {
       changer(event, fxml);
    }

    public void popupWindow(ActionEvent event, String fxml) throws IOException {

        Parent root = FXMLLoader.load((getClass().getResource(fxml)));
        Scene scene = new Scene(root);
        popupStage = new Stage();
        popupStage.setScene(scene);
        popupStage.initStyle(StageStyle.UNDECORATED);
        popupStage.centerOnScreen();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.showAndWait();

    }



}
