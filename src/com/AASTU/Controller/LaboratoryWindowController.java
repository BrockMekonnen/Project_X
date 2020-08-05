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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LaboratoryWindowController implements Initializable {

    @FXML
    public AnchorPane profilePane;

    @FXML
    public AnchorPane profileOpacityPane;

    @FXML
    private JFXButton navBtn;

    @FXML
    private AnchorPane coverPane;

    @FXML
    private AnchorPane AccountSettingPane;

    @FXML
    private ImageView exitBtn;

    @FXML
    private JFXButton pendingBtn;

    @FXML
    private JFXButton waitingBtn;

    @FXML
    private JFXButton activeBtn;

    @FXML
    private JFXButton recordBtn;

    @FXML
    private AnchorPane pendingPnl;

    @FXML
    private AnchorPane waitingPnl;

    @FXML
    private AnchorPane activePnl;

    @FXML
    private AnchorPane recordPnl;

    void goToView(boolean active, boolean pending, boolean record, boolean waiting){
        pendingPnl.setVisible(pending);
        waitingPnl.setVisible(waiting);
        activePnl.setVisible(active);
        recordPnl.setVisible(record);
    }

    @FXML
    void handleActiveButton(ActionEvent event) {
        goToView(true,false,false,false);
        activePnl.toFront();
    }

    @FXML
    void handlePendingButton(ActionEvent event) {
        goToView(false,true,false,false);
        pendingPnl.toFront();
    }

    @FXML
    void handleRecordButton(ActionEvent event) {
        goToView(false,false,true,false);
        recordPnl.toFront();
    }

    @FXML
    void handleWaitingButton(ActionEvent event) {
        goToView(false,false, false,true);
        waitingPnl.toFront();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        coverPane.setVisible(false);
//        translation(0.1);
        TransitionController.translateTransition(AccountSettingPane, -600, 0.5);
        TransitionController.translation(AccountSettingPane,1,0,0.1);
        coverPane.setOnMouseClicked(event -> {
            translateTransitionBack(AccountSettingPane, -600, 1);
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
            coverPane.setVisible(false);
        });
    }

    public void OptionAction(){
        coverPane.setVisible(true);
        AccountSettingPane.setVisible(true);
        TransitionController.translation(AccountSettingPane,0,1,0.1);
        TransitionController.translateTransition(AccountSettingPane, 600, 1);
    }

    @FXML
    void profileHandler(ActionEvent event) {
        translateTransitionBack(AccountSettingPane,-600,1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }


    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event, "../view/Login.fxml");
    }

}
