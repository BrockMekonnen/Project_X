package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import javax.swing.*;
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
    private AnchorPane pendingPnl;

    @FXML
    private AnchorPane diseasePnl;

    @FXML
    private JFXComboBox<?> comboTime;

    @FXML
    private JFXComboBox<?> comboTimeEnd;

    @FXML
    private ImageView exitBtn;

    @FXML
    void goToPending(ActionEvent event) {
        diseasePnl.setVisible(false);
        pendingPnl.setVisible(true);
    }

    @FXML
    void goToDisease(ActionEvent event) {
        pendingPnl.setVisible(false);
        diseasePnl.setVisible(true);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        opacityPane.setVisible(false);
        TransitionController.translateTransition(slidePane, -600, 0.5);
        TransitionController.translation(slidePane,1,0,0.1);
        opacityPane.setOnMouseClicked(event -> {
            translateTransitionBack(slidePane, -600, 1);
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
            opacityPane.setVisible(false);
        });
    }

    public void OptionAction(){
        opacityPane.setVisible(true);
        slidePane.setVisible(true);
        TransitionController.translation(slidePane,0,1,0.1);
        TransitionController.translateTransition(slidePane, 600, 1);

    }

    @FXML
    void profileHandler(ActionEvent event) {
        translateTransitionBack(slidePane,-600,1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }



    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event,"../view/Login.fxml");
    }

    @FXML
    void CloseBTN(ActionEvent event){
        int i=JOptionPane.showConfirmDialog(null,"Do You Want To Exit The System?","Attention",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            //to exit the systems
            System.exit(0);
            Platform.exit();
        }
    }

}
