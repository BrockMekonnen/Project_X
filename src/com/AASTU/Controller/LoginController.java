package com.AASTU.Controller;


import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    public static String source;


    @FXML
    void signIn(ActionEvent event) throws IOException {
        if(source.equals("sec")){
           new WindowChangeController().changeWindow(event,"../view/SecretaryWindow.fxml");
        } else if(source.equals("doc")){
            new WindowChangeController().changeWindow(event,"../view/DoctorWindow.fxml");
        }else if(source.equals("mana")) {
            new WindowChangeController().changeWindow(event,"../view/ManagerWindow.fxml");
        }else if(source.equals("lab")){
            new WindowChangeController().changeWindow(event,"../view/LaboratoryWindow.fxml");
        }
    }

    @FXML
    void ToIdentificationWindow(ActionEvent event) throws IOException {
        new WindowChangeController().changeWindow(event,"../View/IdentificationPane.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
