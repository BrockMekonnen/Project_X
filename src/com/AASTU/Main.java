package com.AASTU;

import com.AASTU.Controller.DataLoader;
import com.AASTU.Controller.LaboratoryWindowController;
import com.AASTU.Controller.WindowChangeController;
import com.AASTU.Model.Laboratory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    public static DataLoader controller1=new DataLoader();
    public static Thread thread;
    Stage stage;

    @Override
    public void start(Stage primaryStage)throws Exception {
        this.stage=primaryStage;
        WellcomScreen();
    }
    public void WellcomScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/SplashScreen.fxml"));
            AnchorPane pane=loader.load();
            Scene scene = new Scene(pane);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
