package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class WindowChangeController {

    private Stage stage;
    private static Stage popupStage[]= new Stage[5];
    private static int windowCount=0;

    double width,height;


    public void signOut(ActionEvent event, String fxml) throws IOException {
        changeWindow(event,fxml);
    }

    public void changeWindow(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setWidth(width);
        stage.setHeight(height);
        Scene loginScene =  new Scene(pane,width,height);

        stage.setScene(loginScene);
        stage.show();
        double x =  stage.widthProperty().doubleValue();
        double y = stage.widthProperty().doubleValue();
        width = x;
        height = y;

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


}
