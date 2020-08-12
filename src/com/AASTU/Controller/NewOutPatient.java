package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
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
    public boolean validateUserInputForOut() {
        if(startDate.getValue() == null || startDate.getValue() == null){
            return false;
        }
        return true;
    }
    @FXML
    void cancelWindow(ActionEvent event) {
        WindowChangeController.closeWindow();
        isAdd = false;
    }

    @FXML
    void handleAddButton(ActionEvent event) throws IOException {
        if(validateUserInputForOut()){
        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it?", "warn_confirm.png");
            PatientRegistration patientRegistration= new PatientRegistration();
            patientRegistration.startDate = startDate.getValue();
            patientRegistration.endDate = endDate.getValue();
            isAdd = true;
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
