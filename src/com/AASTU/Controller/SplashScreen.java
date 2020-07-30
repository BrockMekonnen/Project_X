package com.AASTU.Controller;

import com.AASTU.Main;
import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashScreen implements Initializable{
    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Splash().start();

    }

    class Splash extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(3000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        AnchorPane root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("../View/IdentificationPane.fxml"));

                        } catch (IOException e) {
                            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, e);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        rootPane.getScene().getWindow().hide();
                    }
                });

            } catch (InterruptedException e){
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

}
