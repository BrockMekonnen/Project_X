package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorWindowController implements Initializable {

    @FXML
    public AnchorPane profilePane;

    @FXML
    public AnchorPane profileOpacityPane;

    @FXML
    private AnchorPane slidePane;

    @FXML
    private AnchorPane opacityPane;

    @FXML
    private JFXButton OptionBTN;

    @FXML
    private AnchorPane outPnl;

    @FXML
    private AnchorPane pendingPnl;

    @FXML
    private AnchorPane diseasePnl;


    @FXML
    void goToOut(ActionEvent event) {
        pendingPnl.setVisible(false);
        diseasePnl.setVisible(false);
        outPnl.setVisible(true);

    }

    @FXML
    void goToPending(ActionEvent event) {
        diseasePnl.setVisible(false);
        outPnl.setVisible(false);
        pendingPnl.setVisible(true);
    }

    @FXML
    void goToDisease(ActionEvent event) {
        outPnl.setVisible(false);
        pendingPnl.setVisible(false);
        diseasePnl.setVisible(true);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        opacityPane.setVisible(false);
        translation(0.1);
        opacityPane.setOnMouseClicked(event -> {
            translation(1);
        });

        profileOpacityPane.setOnMouseClicked(event -> {
            profilePane.setVisible(false);
            profileOpacityPane.setVisible(false);

        });

    }

    public void translation1(){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),slidePane);
        translateTransition.setByX(600);
        translateTransition.play();

    }
    public void OptionAction(){
        opacityPane.setVisible(true);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.1),slidePane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        translation1();

    }

    @FXML
    void profileHandler(ActionEvent event) {
        translation(1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }


    public void translation(double second){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(second),slidePane);
        translateTransition.setByX(-600);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane.setVisible(false);
        });
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event,"../view/Login.fxml");
    }
}
