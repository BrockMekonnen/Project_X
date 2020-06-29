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
    private JFXButton CardRoomIdentificationBTN;

    @FXML
    private AnchorPane FourInOnePane;

    @FXML
    private JFXButton AdminIdentificationBTN;

    @FXML
    private JFXButton DoctorIdentificationBTN;

    @FXML
    private JFXButton LaboratoryIdentificaitonBTN;


    @FXML
    void toCardRoom(ActionEvent event) throws IOException {
        ChangeToLoginWindow(event,"../View/login.fxml");
    }

    @FXML
    public void toDoctor(ActionEvent event) throws IOException {
        ChangeToLoginWindow(event,"../View/login.fxml");
    }

    @FXML
    void toLaboratory(ActionEvent event) throws IOException {
        ChangeToLoginWindow(event,"../View/login.fxml");
    }

    @FXML
    void toManager(ActionEvent event) throws IOException {
        ChangeToLoginWindow(event,"../View/login.fxml");
    }


    public void ChangeToLoginWindow(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent pane = loader.load();
        Scene loginScene =  new Scene(pane);
            Stage loginwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginwindow.setScene(loginScene);
            loginwindow.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        FourInOnePane.setVisible(false);
//        TransitionAnimation();
//       Animation1();
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
