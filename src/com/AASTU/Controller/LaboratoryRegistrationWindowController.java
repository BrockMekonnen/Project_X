package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
    private AnchorPane rootPane;

    @FXML
    private AnchorPane pnlInner;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXTextField LabTechSecondName;

    @FXML
    private JFXTextField LabTechFirstName;

    @FXML
    private JFXDatePicker LabTechDate;

    @FXML
    private JFXTextField LabTechstartWorkingHour;

    @FXML
    private JFXComboBox<String> GenderCombo;

    @FXML
    private JFXComboBox<String> cboTime;

    @FXML
    private JFXTextField LabTechEndWorkingHour;

    @FXML
    private JFXComboBox<?> cboTime1;

    @FXML
    private JFXTextField LaboTechPhoneNumber;

    @FXML
    private JFXTextField LabTchCityAddress;

    @FXML
    private JFXTextField LabTechSucCityAddress;

    @FXML
    private JFXTextField LabTechKebeleAddress;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private JFXButton btnDiscard;

    @FXML
    private JFXTextField LabTechId;

    @Override
    public void initialize(URL location, ResourceBundle resources){


    }

}
