package com.AASTU.Controller;

import com.AASTU.Main;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
    private ImageView exitBtn;

    @FXML
    private JFXButton paymentBtn;

    @FXML
    private JFXButton outPatientBtn;

    @FXML
    private JFXButton recordBtn;

    @FXML
    private JFXButton activePatientBtn;

    @FXML
    private AnchorPane ActivePatientPnl;

    @FXML
    private AnchorPane paymentPnl;

    @FXML
    private AnchorPane outPatientPnl;

    @FXML
    private AnchorPane recordPnl;

    void goToView(boolean active, boolean pay, boolean out, boolean record){
        ActivePatientPnl.setVisible(active);
        paymentPnl.setVisible(pay);
        outPatientPnl.setVisible(out);
        recordPnl.setVisible(record);


    }


    @FXML
    void handleActivePatientButton(ActionEvent event) {
        goToView(true,false,false,false);
        ActivePatientPnl.toFront();
    }

    @FXML
    void handleOutPatientButton(ActionEvent event) {
        goToView(false,false,true,false);
        outPatientPnl.toFront();
    }

    @FXML
    void handlePaymentButton(ActionEvent event) {
        goToView(false,true,false,false);
        paymentPnl.toFront();
    }

    @FXML
    void handleRecordButton(ActionEvent event) {
        goToView(false,false,false,true);
        recordPnl.toFront();
    }

    @FXML
    public void navAction(ActionEvent event) {
        opacityPane1.setVisible(true);
        slidePane1.setVisible(true);
        TransitionController.translation(slidePane1,0,1,0.1);
        TransitionController.translateTransition(slidePane1, 600, 1);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        opacityPane1.setVisible(false);
        TransitionController.translateTransition(slidePane1, -600, 0.5);
        TransitionController.translation(slidePane1,1,0,0.1);
        opacityPane1.setOnMouseClicked(event -> {
            translateTransitionBack(slidePane1,-600,1);
        });

        profileOpacityPane.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });

        exitBtn.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });
    }

    public void translateTransitionBack(AnchorPane pane, double move, double sec){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(sec),pane);
        translateTransition.setByX(move);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane1.setVisible(false);
        });
    }
    @FXML
    void profileHandler(ActionEvent event) {
        translateTransitionBack(slidePane1,-600,1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }

    public void AddPatientAction(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/PatientRegistration.fxml");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event, "../view/Login.fxml");
    }

    @FXML
    void CloseBTN(ActionEvent event){
        int i=JOptionPane.showConfirmDialog(null,"Do you want to Exit the system","Attention",JOptionPane.YES_NO_OPTION);
        if(i== JOptionPane.YES_OPTION){
        System.exit(0);
        Platform.exit();}
    }





}
