package com.AASTU.Controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindow implements Initializable {

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        pane4.setStyle("-fx-background-image: url(\"/sample/3.jpg\")");

        backgroundAnimation();
    }

    private void backgroundAnimation() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3),pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3),pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {

                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3),pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {

                    FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(3),pane2);
                    fadeTransition3.setFromValue(1);
                    fadeTransition3.setToValue(0);
                    fadeTransition3.play();

                    fadeTransition3.setOnFinished(event3 -> {
                        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(3),pane3);
                        fadeTransition4.setFromValue(1);
                        fadeTransition4.setToValue(0);
                        fadeTransition4.play();

                        fadeTransition4.setOnFinished(event4 -> {
                            FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(3),pane4);
                            fadeTransition5.setFromValue(1);
                            fadeTransition5.setToValue(0);
                            fadeTransition5.play();

                            fadeTransition5.setOnFinished(event5 -> {
                                backgroundAnimation();

                            });
                        });
                    });
                });
            });
        });
    }
}
