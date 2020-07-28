package com.AASTU.Controller;

import com.AASTU.Main;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecretaryWindowController implements Initializable {

    @FXML
    public AnchorPane profilePane;

    @FXML
    public AnchorPane profileOpacityPane;

    @FXML
    private JFXButton navBtn;

    @FXML
    private AnchorPane slidePane1;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane opacityPane1;

    @FXML
    public void navAction(ActionEvent event) {
        opacityPane1.setVisible(true);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.1),slidePane1);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        translation1();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        opacityPane1.setVisible(false);
        translation(0.1);
        opacityPane1.setOnMouseClicked(event -> {
            translation(1);
        });

        profileOpacityPane.setOnMouseClicked(event -> {
            profilePane.setVisible(false);
            profileOpacityPane.setVisible(false);

        });
    }

    @FXML
    void profileHandler(ActionEvent event) {
        translation(1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }
    public void translation(double second){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(second),slidePane1);
        translateTransition.setByX(-600);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane1.setVisible(false);
        });
    }

    public void translation1(){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),slidePane1);
        translateTransition.setByX(600);
        translateTransition.play();

    }

    public void AddPatientAction(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/PatientRegistration.fxml");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event, "../view/Login.fxml");
    }


}
