package com.AASTU.Controller;

import com.AASTU.Main;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorWindowController implements Initializable {

    @FXML
    private AnchorPane slidePane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane opacityPane;

    @FXML
    private JFXButton OptionBTN;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        opacityPane.setVisible(false);
        translation(0.1);
        opacityPane.setOnMouseClicked(event -> {
            translation(1);
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
        Main.object.action(event,"../View/login.fxml",rootPane);
    }
}
