package com.AASTU.Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class NewPatientRegistrationController implements Initializable {

    @FXML
    private JFXCheckBox PeriodicPatientCheckBox;

    @FXML
    private DatePicker PatinetDateOfBirth;

    @FXML
    private AnchorPane PatientFormPane;

    @FXML
    private JFXTextField PatientLastNameTF;

    @FXML
    private JFXTextField PatientAddressKebeleTF;

    @FXML
    private JFXComboBox<?> GenderCombo;

    @FXML
    private JFXCheckBox EmergencyCheckBox;

    @FXML
    private DatePicker PatientAddDate;

    @FXML
    private Label PatientIdLB;

    @FXML
    private JFXTextField PatientAddressSubCityTF;

    @FXML
    private JFXTextField PatientAddressCityTF;

    @FXML
    private AnchorPane PatientFormWindow;

    @FXML
    private JFXTextField PatientFirstNameTF;

    @FXML
    private JFXTextField PatientPhoneNumberTF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(0.01),PatientFormPane);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        scaleTransition.play();
        scaleTransition.setOnFinished(event -> {
            ScaleTransition scaleTransition1=new ScaleTransition(Duration.seconds(1),PatientFormPane);
            scaleTransition1.setByY(1);
            scaleTransition1.setByX(1);
            scaleTransition1.play();
        });

    }
}
