package com.AASTU.Controller;


import com.jfoenix.controls.JFXTextField;

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

    public static String source;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXTextField password;


    @FXML
    void signIn(ActionEvent event) throws IOException {
//        if(userName.getText().contains("doctor")) {
//            changeWindow(event,"../view/DoctorWindow.fxml");
//        }else if(userName.getText().contains("lab")){
//            changeWindow(event,"../view/LaboratoryWindow.fxml");
//        }else if(userName.getText().contains("sec")){
//            changeWindow(event,"../view/SecretaryWindow.fxml");
//        }else if(userName.getText().contains("manager")){
//            changeWindow(event,"../view/ManagerWindow.fxml");
//        }

        if(source.equals("sec")){
            changeWindow(event,"../view/SecretaryWindow.fxml");
        } else if(source.equals("doc")){
            changeWindow(event,"../view/DoctorWindow.fxml");
        }else if(source.equals("mana")) {
            changeWindow(event,"../view/ManagerWindow.fxml");
        }else if(source.equals("lab")){
            changeWindow(event,"../view/LaboratoryWindow.fxml");
        }
    }


    public void changeWindow(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent pane = loader.load();
        Scene loginScene =  new Scene(pane);
        Stage loginwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginwindow.setScene(loginScene);
        loginwindow.show();
    }
    @FXML
    private AnchorPane rootPane;

    @FXML
    void ToIdentificationWindow(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/IdentificationPane.fxml"));
        Parent pane = loader.load();
        Scene identificationScene =  new Scene(pane);
        Stage identification = (Stage) ((Node) event.getSource()).getScene().getWindow();
        identification.setScene(identificationScene);
        identification.show();

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
