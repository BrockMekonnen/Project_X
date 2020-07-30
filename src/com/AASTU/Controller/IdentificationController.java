package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class IdentificationController implements Initializable{


    @FXML
    void toCardRoom(ActionEvent event) throws IOException {
        new WindowChangeController().changeWindow(event,"../View/login.fxml");
        LoginController.source = "sec";
    }

    @FXML
    public void toDoctor(ActionEvent event) throws IOException {
        new WindowChangeController().changeWindow(event,"../View/login.fxml");
        LoginController.source = "doc";
    }

    @FXML
    void toLaboratory(ActionEvent event) throws IOException {
        new WindowChangeController().changeWindow(event,"../View/login.fxml");
        LoginController.source = "lab";

    }

    @FXML
    void toManager(ActionEvent event) throws IOException {
        new WindowChangeController().changeWindow(event,"../View/login.fxml");
        LoginController.source = "mana";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
