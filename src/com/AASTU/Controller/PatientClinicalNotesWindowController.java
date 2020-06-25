package com.AASTU.Controller;

import com.AASTU.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientClinicalNotesWindowController implements Initializable {


    @FXML
    private AnchorPane ClinicalNotePane;

    @FXML
    private JFXButton CancelBTN;

    @FXML
    private JFXButton DoneBTN,NewBTN;

    @FXML
    private TableView<?> PatientTreatedDateTableView;


    @FXML
    private TableColumn<?, String> PatientTreatedDateCol;

    @FXML
    private JFXTextArea PatientClinicalNoteTA;

    @FXML
    private Label NewPatientIndicationLB;

    String NullStringAssigment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NullStringAssigment=PatientClinicalNoteTA.getText();
        visibility(false);
        editablechanges();
    }

    public void visibility(boolean bool){
        PatientTreatedDateTableView.setVisible(bool);
        NewPatientIndicationLB.setVisible(!bool);
    }

    public void editablechanges(){
        PatientClinicalNoteTA.setEditable(false);
        DoneBTN.setVisible(false);
        NewBTN.setVisible(true);
    }

    @FXML
    public void CancelBTNAction(ActionEvent event){
        int i=JOptionPane.showConfirmDialog(null,"Are You sure you want to cancel ?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            //cancel registration
        }
        else if(i==JOptionPane.NO_OPTION){
            //leave without change of something
        }

    }

    Stage stage;
    @FXML
    public void DoneBTNAction(ActionEvent event)throws Exception{
        int i=JOptionPane.showConfirmDialog(null,"Do The Patient need Laboratory Test?","Laboratory CheckUps",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            //go to the Doctors Laboratory requisition form
        }
        else if(i==JOptionPane.NO_OPTION){
            // ignore the laboratory form and back to the normal window of doctor
        }
    }
    @FXML
    public void NewBTNAction(ActionEvent event){
        DoneBTN.setVisible(true);
        NewBTN.setVisible(false);
        // to assign null value in the text field of the pane
        PatientClinicalNoteTA.setText(NullStringAssigment);
        // to write on the text field of the pane
        PatientClinicalNoteTA.setEditable(true);
    }

}
