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
    private AnchorPane IdentificationPane3;

    @FXML
    private AnchorPane IdentificationPane1;

    @FXML
    private JFXButton CardRoomIdentificationBTN;

    @FXML
    private AnchorPane IdentificationPane2;

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
        SlideThePane();
        TransitionAnimation();
       Animation1();
    }
    public void SlideThePane(){
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(9),IdentificationPane3);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished(event -> {
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(4),IdentificationPane2);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();
            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2=new FadeTransition(Duration.seconds(4),IdentificationPane1);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();
                fadeTransition2.setOnFinished(event2 -> {
                    FadeTransition fadeTransition3=new FadeTransition(Duration.seconds(4),IdentificationPane1);
                    fadeTransition3.setFromValue(0);
                    fadeTransition3.setToValue(1);
                    fadeTransition3.play();
                    fadeTransition3.setOnFinished(event3 -> {
                        FadeTransition fadeTransition4=new FadeTransition(Duration.seconds(4),IdentificationPane2);
                        fadeTransition4.setFromValue(0);
                        fadeTransition4.setToValue(1);
                        fadeTransition4.play();
                        fadeTransition4.setOnFinished(event4 -> {
                            FadeTransition fadeTransition5=new FadeTransition(Duration.seconds(4),IdentificationPane3);
                            fadeTransition5.setFromValue(0);
                            fadeTransition5.setToValue(1);
                            fadeTransition5.play();
                            fadeTransition5.setOnFinished(event5 -> {
                                SlideThePane();
                            });
                        });
                    });
                });
            });
        });
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
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),FourInOnePane);
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
