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

public class DoctorRegistrationWindowController implements Initializable {

    @FXML
    private JFXTextField DoctorFirsNameTF;

    @FXML
    private JFXTextField DoctorUserName;

    @FXML
    private AnchorPane PatientFormPane;

    @FXML
    private JFXTextField DoctorWorkingHoursTF;

    @FXML
    private DatePicker DoctorAddDate;

    @FXML
    private JFXTextField DoctorAddressSubCityTF;

    @FXML
    private JFXComboBox<?> GenderCombo;

    @FXML
    private JFXButton DoneBTN;

    @FXML
    private JFXTextField DoctorAddressKebeleTF;

    @FXML
    private Label DoctorIdLB;

    @FXML
    private JFXTextField DoctorLastName;

    @FXML
    private JFXTextField DoctorPhoneNumberTF;

    @FXML
    private JFXButton CancelBTN;

    @FXML
    private AnchorPane PatientFormWindow;

    @FXML
    private JFXTextField DoctorAddressCityTF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
