package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class IdentificationController implements Initializable{
    @FXML
    private JFXButton CardRoomIdentificationBTN;

    @FXML
    private AnchorPane FourInOnePane;

    @FXML
    private JFXButton AdminIdentificationBTN;

    @FXML
    private JFXButton DoctorIdentificationBTN;

    @FXML
    private JFXButton LaboratoryIdentificaitonBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FourInOnePane.setVisible(false);
        TransitionAnimation();
       Animation1();
    }
    public void TransitionAnimation(){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.1),DoctorIdentificationBTN);
        translateTransition.setByY(-800);
        translateTransition.play();
        TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.1),CardRoomIdentificationBTN);
        translateTransition1.setByX(-800);
        translateTransition1.play();
        TranslateTransition translateTransition2=new TranslateTransition(Duration.seconds(0.1),LaboratoryIdentificaitonBTN);
        translateTransition2.setByX(800);
        translateTransition2.play();
        TranslateTransition translateTransition3=new TranslateTransition(Duration.seconds(0.1),AdminIdentificationBTN);
        translateTransition3.setByY(800);
        translateTransition3.play();

    }
    public void Animation1(){
        FourInOnePane.setVisible(true);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1.5),FourInOnePane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        fadeTransition.setOnFinished(event->{
            TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.4),DoctorIdentificationBTN);
            translateTransition.setByY(800);
            translateTransition.play();
            translateTransition.setOnFinished(event1 -> {
                TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.4),CardRoomIdentificationBTN);
                translateTransition1.setByX(800);
                translateTransition1.play();
                translateTransition1.setOnFinished(event2 -> {
                    TranslateTransition translateTransition2=new TranslateTransition(Duration.seconds(0.4),LaboratoryIdentificaitonBTN);
                    translateTransition2.setByX(-800);
                    translateTransition2.play();
                    translateTransition2.setOnFinished(event3 -> {
                        TranslateTransition translateTransition3=new TranslateTransition(Duration.seconds(0.4),AdminIdentificationBTN);
                        translateTransition3.setByY(-800);
                        translateTransition3.play();
                    });
                });
            });
        });
    }
}
