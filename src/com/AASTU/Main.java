package com.AASTU;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {
    Stage stage;
    public static int x=0;
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
            if(x==0)
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void action(ActionEvent event, String fxml, AnchorPane rootPane){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            AnchorPane root=loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            rootPane.getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
