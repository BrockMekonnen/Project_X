package com.AASTU.Controller;

import com.AASTU.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    void ToIdentificationWindow(ActionEvent event) throws IOException {
        Main m=new Main();
        m.action(event,"View/IdentificationPane.fxml",rootPane);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/IdentificationPane.fxml"));
//        Parent pane = loader.load();
//        Scene identificationScene =  new Scene(pane);
//        Stage identification = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        identification.setScene(identificationScene);
//        identification.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
