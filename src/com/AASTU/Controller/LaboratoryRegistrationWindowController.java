package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LaboratoryRegistrationWindowController implements Initializable {

    @FXML
    private AnchorPane PatientFormWindow;

    @FXML
    private AnchorPane PatientFormPane;

    @FXML
    private DatePicker LabTechnicianAddDate;

    @FXML
    private Label DoctorIdLB;

    @FXML
    private JFXTextField LabTechnicianFirsNameTF;

    @FXML
    private JFXTextField LabTechnicianLastName;

    @FXML
    private JFXComboBox<?> GenderCombo;

    @FXML
    private JFXTextField LabTechnicianPhoneNumberTF;

    @FXML
    private JFXTextField LabTechnicianAddressKebeleTF;

    @FXML
    private JFXTextField LabTechnicianAddressSubCityTF;

    @FXML
    private JFXTextField LabTechnicianAddressCityTF;

    @FXML
    private JFXButton DoneBTN;

    @FXML
    private JFXButton CancelBTN;

    @FXML
    private JFXTextField LabTechnicianWorkingHoursTF;

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

}
