package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LaboratoryWindowController implements Initializable {

    @FXML
    private JFXButton navBtn;

    @FXML
    private AnchorPane coverPane;

    @FXML
    private AnchorPane AccountSettingPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coverPane.setVisible(false);
        translation(0.1);
        coverPane.setOnMouseClicked(event -> {
            translation(1);
        });
    }

    public void translation(double second){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(second),AccountSettingPane);
        translateTransition.setByX(-600);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            coverPane.setVisible(false);
        });
    }
    public void translation1(){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),AccountSettingPane);
        translateTransition.setByX(600);
        translateTransition.play();

    }
    public void OptionAction(){
        coverPane.setVisible(true);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.1),coverPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        translation1();
    }

    public void ExitAction(){
        int i= JOptionPane.showConfirmDialog(null,"Are You Sure You Want to Exit The System","Confirmation",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            Platform.exit();
            System.exit(0);
        }
        else {
            translation(1);
            coverPane.setVisible(false);
        }
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event, "../view/Login.fxml");
    }
}
