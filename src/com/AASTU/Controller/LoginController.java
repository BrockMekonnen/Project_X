package com.AASTU.Controller;


import com.AASTU.Main;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{


    @FXML
    private AnchorPane rootPane;

    public static String source;

    @FXML
    private JFXTextField userName;




    @FXML
    void signIn(ActionEvent event) throws IOException {
        if(source.equals("sec")){
            Main.object.action(event,"../View/SecretaryWindow.fxml",rootPane);
        } else if(source.equals("doc")){
            Main.object.action(event,"../View/DoctorWindow.fxml",rootPane);
        }else if(source.equals("mana")) {
            Main.object.action(event,"../View/ManagerWindow.fxml",rootPane);
        }else if(source.equals("lab"))
            Main.object.action(event,"../View/LaboratoryWindow.fxml",rootPane);
        }


    @FXML
    void ToIdentificationWindow(ActionEvent event) throws IOException {
        Main.object.action(event,"../View/IdentificationPane.fxml",rootPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
