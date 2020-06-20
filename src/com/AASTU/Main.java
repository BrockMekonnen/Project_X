package com.AASTU;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

//    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        this.stage=primaryStage;
//        mainWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/login.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        scene.getStylesheets().addAll(Main.class.getResource("View/LoginStyle.css").toExternalForm());
        primaryStage.setTitle("login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
