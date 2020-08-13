package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ClinicalNoteAdd implements Initializable{
    @FXML
    private JFXTextField dateFld;

    @FXML
    private JFXTextArea textArea;

    private Patient patient;

    @FXML
    void handleCancelButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    void setPatient(Patient patient){
        this.patient = patient;
    }

    @FXML
    void handleSaveButton(ActionEvent event) {
        ClinicalNotes note = new ClinicalNotes();
        note.setDate(LocalDate.now());
        note.setNotes(textArea.getText());

        new DataSaver().saveClinicalNote(this.patient, note);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateFld.setText(String.valueOf(LocalDate.now()));
    }
}
