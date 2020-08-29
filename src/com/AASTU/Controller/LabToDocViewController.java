package com.AASTU.Controller;

import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.AnchorArray;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class LabToDocViewController implements Initializable {

    @FXML
    private JFXTextField DateTF;

    @FXML
    private JFXTextField SexTF;

    @FXML
    private JFXTextField AgeTF;

    @FXML
    private JFXTextField NameTF;

    @FXML
    private JFXButton maxBtn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    private AnchorPane rootAnchor;

    private Patient patient=new Patient();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Editiablity();
        exitBtn.setOnMouseClicked(event -> {
            handleCloseButton();
        });
    }

    public void Editiablity(){
        NameTF.setEditable(false);
        AgeTF.setEditable(false);
        SexTF.setEditable(false);
        DateTF.setEditable(false);
    }

    public void setWindow(Patient patient, String fxml){
        try{
            this.patient=patient;
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxml));
            AnchorPane root=loader.load();
            LabToDoc contol=loader.getController();
            contol.VisibilityOfCheckBoxes(this.patient);
            rootAnchor.getChildren().add(root);
            setObjectComponents(patient);
            patient.setOnWaiting(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setObjectComponents(Patient patient){
        NameTF.setText(patient.getFirstName()+patient.getLastName());
        SexTF.setText(String.valueOf(patient.getSex()));
        AgeTF.setText(String.valueOf(patient.getAge()));
        DateTF.setText(String.valueOf(patient.getDate()));
    }

    @FXML
    public void handleCloseButton(){WindowChangeController.closeWindow();}

}
