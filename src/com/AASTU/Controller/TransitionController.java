package com.AASTU.Controller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class TransitionController {
    public TransitionController(){

    }

    public static void translateTransition(AnchorPane pane, double move, double sec){
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(sec),pane);
        translateTransition1.setByX(move);
        translateTransition1.play();
    }

    public static void translation(AnchorPane pane, double from, double to, double sec) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(sec),pane);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.play();
    }
}
