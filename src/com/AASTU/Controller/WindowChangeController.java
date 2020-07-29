package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.omg.CORBA.TRANSIENT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class WindowChangeController {

    private Stage stage;
    private AnchorPane pane;
    private static Stage popupStage[]= new Stage[5];
    private static int windowCount=0;

    public static int x=0;

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
        Stage temp = new Stage();
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.centerOnScreen();
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();


    }
    public void warningPopup(String warnHeader, String warnBody, String imageUrl ) throws IOException {

        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/WarningPopup.fxml")));
        Parent root = loader.load();
        Warning warn = loader.getController();
        warn.setWarnHeaderFld(warnHeader);
        warn.setWarnBodyFld(warnBody);
        warn.setWarnImg(imageUrl);
        Scene scene = new Scene(root);
        Stage temp = new Stage();
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.centerOnScreen();
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();


    }



    public static void closeWindow(){
        Stage stage = popupStage[windowCount-1];
        windowCount--;
        stage.close();

    }



    public void WellcomScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/SplashScreen.fxml"));
            AnchorPane pane=loader.load();
            Scene scene = new Scene(pane);
            if(x==0)

                stage.initStyle(StageStyle.UNDECORATED);

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void action(ActionEvent event, String fxml, AnchorPane rootPane){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            AnchorPane root=loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            rootPane.getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }

    }







}
