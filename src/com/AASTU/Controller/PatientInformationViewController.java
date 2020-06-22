package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientInformationViewController implements Initializable {


    @FXML
    private Label PatientInfoViewSubCityLB;

    @FXML
    private Label PatientInfoViewDOBLB;

    @FXML
    private JFXButton PatientInfoViewDoneBTN;

    @FXML
    private Label PatientInfoViewGenderLB;

    @FXML
    private Label PatientInfoViewPhoneNumberLB;

    @FXML
    private Label patientId;

    @FXML
    private Label PatientInfoViewNameLB;

    @FXML
    private Label PatientInfoViewCityLB;

    @FXML
    private Label PatientInfoViewAddDateLB;

    @FXML
    private Label PatientInfoViewKebeleLB;

    @FXML
    private JFXButton PatientInfoViewCancelBTN;

    @FXML
    private Label PatientInfoViewIdLB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
