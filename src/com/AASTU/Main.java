package com.AASTU;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader= new FXMLLoader(Main.class.getResource("View/DoctorWindow.fxml"));
        Parent pane=loader.load();
        Scene s=new Scene(pane);
        primaryStage.setScene(s);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
