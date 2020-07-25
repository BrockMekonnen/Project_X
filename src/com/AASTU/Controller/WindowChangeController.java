package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowChangeController {

    public WindowChangeController(){
    }

    private void changer(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent pane = loader.load();
        Scene loginScene =  new Scene(pane);
        Stage loginwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginwindow.setScene(loginScene);
        loginwindow.show();
    }

    public void signOut(ActionEvent event, String fxml) throws IOException {
        changer(event,fxml);
    }

    public void changeWindow(ActionEvent event, String fxml) throws IOException {
       changer(event, fxml);
    }


}
