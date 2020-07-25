package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorPatientView implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label lblTitle;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox pnl_Scroll;

    @FXML
    private JFXButton btn_addNote;

    static Stage stage;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        refreshNodes();
    }
    private void refreshNodes(){

        pnl_Scroll.getChildren().clear();

        Node [] nodes = new Node[15];

        for(int i=0;i<1;i++){
            try{

                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("../View/ClinicalNoteView.fxml"));
                pnl_Scroll.getChildren().add(nodes[i]);
            } catch (IOException e){
                Logger.getLogger(DoctorPatientView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btn_addNote) {
            if(stage == null){
            try {
                Parent root = FXMLLoader.load((getClass().getResource("../View/ClinicalNoteAdd.fxml")));
                stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setAlwaysOnTop(true);
                stage.setResizable(true);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
                stage.show();
            }

        }
    }
}
