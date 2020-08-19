package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

public class ClinicalNoteAdd implements Initializable{
    @FXML
    private JFXTextField dateFld;

    @FXML
    private JFXButton addBtn;

    @FXML
    private TextField diseaseFld;

    @FXML
    private JFXTextArea textArea;


    private List<ClinicalNotes> clinicalNotesList;
    private Patient patient;

    @FXML
    void handleCancelButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    void setPatient(Patient patient){
        this.patient = patient;
        clinicalNotesList = new DataLoader().loadClincalNotes(patient);
        boolean check = false;
        int position=0;
        for(int i=0; i<clinicalNotesList.size(); i++){ // Search for editable Clinical Note and if found get its position
            if(clinicalNotesList.get(i).isEditable()){
                check = true;
                position = i; // get its position
            }
        }
        if(check){
            dateFld.setText(String.valueOf(clinicalNotesList.get(position).getDate()));
            textArea.setText(clinicalNotesList.get(position).getNotes());
            addBtn.setText("Save");

        }
        else
        dateFld.setText(String.valueOf(LocalDate.now()));

    }

    @FXML
    void handleSaveButton(ActionEvent event) {
        boolean check = false;
        int position=0;
        for(int i=0; i<clinicalNotesList.size(); i++){ // Search for editable Clinical Note and if found get its position
            if(clinicalNotesList.get(i).isEditable()){
                check = true;
                position = i; // get its position
            }
        }

        if(check){
            String note = textArea.getText();
            int id = clinicalNotesList.get(position).getNoteId(); // using the position get its id
            new DataSaver().saveEditedClinicalNote(id, note); // save the note
            new DataSaver().updateActivity(patient.getPatientId()," Doctor: "+new DoctorWindowController().DoctorId+" Edit the Clinical Note of Patient for  "+ DateTimeFormatter.BASIC_ISO_DATE.format(clinicalNotesList.get(position).getDate())+" \n",1,LocalDate.now(),new DoctorWindowController().DoctorId);
        }
        else {
            ClinicalNotes note = new ClinicalNotes();
            note.setDate(LocalDate.now());
            note.setNotes(textArea.getText());

            new DataSaver().saveClinicalNote(this.patient, note);
        }
        new DataSaver().updateActivity(patient.getPatientId()," Doctor: "+new DoctorWindowController().DoctorId+" Treat The Patient \n",1,LocalDate.now(),new DoctorWindowController().DoctorId);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> diseaseNames = new DataLoader().loadDiseaseType();
        TextFields.bindAutoCompletion(diseaseFld, diseaseNames);
    }
}
