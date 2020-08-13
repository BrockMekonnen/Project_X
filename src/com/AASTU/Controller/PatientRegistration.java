package com.AASTU.Controller;

import com.AASTU.Main;
import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class PatientRegistration implements Initializable{

    @FXML
    private AnchorPane subPane1;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane pnlInner;

    @FXML
    private Label lblTitle;

    @FXML
    private StackPane subpane2;

    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXComboBox<?> cboGender;

    @FXML
    private JFXTextField birthDayTf;

    @FXML
    private JFXTextField birthMonthTf;

    @FXML
    private JFXTextField birthYearTf;

    @FXML
    private JFXTextField phoneNumberTf;

    @FXML
    private JFXTextField ageTf;

    @FXML
    private JFXComboBox<String> cboCalender;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField subcityTf;

    @FXML
    private JFXTextField kebeleTf;

    @FXML
    private JFXTextField patientAddedDateTF;

    @FXML
    private JFXTextField patientIdTf;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private JFXButton btnDiscard;

    @FXML
    private JFXTextField houseNuberTf;

    @FXML
    private JFXButton btnOutPatient;

    @FXML
    private JFXCheckBox isOutCb;

    @FXML
    private JFXCheckBox hasLabCb;

    public static LocalDate startDate;

    public static LocalDate endDate;

    public void addNewPatient(){
    }

    private char sex;

    // to check all text fields are get data
    public boolean validatUserInput() throws IOException {
        if(firstNameTf.getText().isEmpty() || lastNameTf.getText().isEmpty() || cboGender.getSelectionModel().isEmpty() ||
                ageTf.getText().isEmpty()|| phoneNumberTf.getText().isEmpty() || cityTf.getText().isEmpty() ||
                subcityTf.getText().isEmpty() || kebeleTf.getText().isEmpty() || houseNuberTf.getText().isEmpty()) {
//              new WindowChangeController().warningPopup("Validate Fields", "Please Enter Into the fields ","warn_confirm.png");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cboCalender.getSelectionModel().select("E.C");
    }


    public void ConfirmationAction() throws IOException {
        if(validatUserInput()) {
            new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
            if(Warning.isOk) {
                WindowChangeController.closeWindow();
                WindowChangeController.closeWindow();
            }
        }


    }

    @FXML
    void DiscardAction(ActionEvent event) throws IOException {
        WindowChangeController.closeWindow();

    }

    @FXML
    void addOutPatient(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event,"../View/NewOutPatient.fxml");

    }


}


