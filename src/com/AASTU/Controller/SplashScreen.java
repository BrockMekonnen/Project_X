package com.AASTU.Controller;

import com.AASTU.Model.IncomeAnalysis;
import com.AASTU.Model.PatientAnalysis;
import javafx.fxml.FXML;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.AnchorPane;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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

        private void checkIncome() {
            DataLoader loadData = new DataLoader();
            DataSaver saveData = new DataSaver();
            IncomeAnalysis analysis = loadData.loadSingleIncomeAnalysisData(LocalDate.now());
            if(analysis == null) {
                System.out.println("IncomeAnalysis: null");
                analysis = new IncomeAnalysis(LocalDate.now(), 0);
                saveData.saveIncomeAnalysis(analysis);
            }
        }

        private void checkTodayPatientAnalysis() {
            DataLoader loadData = new DataLoader();
            DataSaver saveData = new DataSaver();
            PatientAnalysis analysis = loadData.loadSinglePatientAnalysisData(LocalDate.now());
            if(analysis == null) {
                System.out.println("IncomeAnalysis: null");
                analysis = new PatientAnalysis(LocalDate.now(), 0);
                saveData.savePatientAnalysis(analysis);
            }
        }

        @Override
        public void run(){
            try {
                Thread.sleep(100);
                checkIncome();
                checkTodayPatientAnalysis();
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
                        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
                        if(screenBounds.getHeight() > 780 && screenBounds.getWidth() > 1370){
                            stage.setHeight(screenBounds.getHeight() - 100);
                            stage.setWidth(screenBounds.getWidth() - 100);
                        }
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
