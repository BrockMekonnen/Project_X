package com.AASTU.Controller;

import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewOutPatient implements Initializable {

    public static boolean isAdd;
    @FXML
    private JFXDatePicker startDate;

    @FXML
    private JFXDatePicker endDate;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXTextField idFld;

    private Patient patient;
    public boolean validateUserInputForOut() {
        if(startDate.getValue() == null || endDate.getValue() == null){
            return false;
        }
        return true;
    }
    @FXML
    void cancelWindow(ActionEvent event) {
        WindowChangeController.closeWindow();
        isAdd = false;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
        idFld.setText(String.valueOf(patient.getPatientId()));
    }

    @FXML
    void handleAddButton(ActionEvent event) throws IOException {
        LocalDate startDate = this.startDate.getValue();
        LocalDate endDate = this.endDate.getValue();
        if(validateUserInputForOut()){
            new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it?", "warn_confirm.png");
            PatientRegistration patientRegistration= new PatientRegistration();
            patientRegistration.startDate = startDate;
            patientRegistration.endDate = endDate;
            if(patient != null){
            new DataSaver().saveOutPatient(patient, startDate, endDate);
            }
            isAdd = true;
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idFld.setDisable(true);
    }
}
