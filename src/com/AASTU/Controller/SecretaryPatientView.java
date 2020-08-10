package com.AASTU.Controller;


import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SecretaryPatientView implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXButton exitBtn;


    @FXML
    private JFXButton activateBtn;

    @FXML
    private JFXButton cancelBtn;


    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXTextField addedDateTf;

    @FXML
    private JFXTextField patientIdTf;

    @FXML
    private JFXTextField ageTf;

    @FXML
    private JFXTextField phoneTf;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField subcityTf;

    @FXML
    private JFXTextField kebeleTf;

    @FXML
    private JFXTextField houseNoTf;

    @FXML
    private JFXTextField sexTf;
    @FXML
    private JFXTextField birthDayTf;

    @FXML
    private JFXTextField birthMonthTf;

    @FXML
    private JFXTextField birthYearTf;

    @FXML
    private JFXComboBox<Patient> calanderCb;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    /* this function accepts Patient Object and assign
    * some values to the textField */
    public void setObject(Patient object){
        String sex = null;
        if(object.getSex() == 'm') {
            sex = "Male";
        }else if(object.getSex() == 'f'){
            sex = "Female";
        }
        firstNameTf.setText(object.getFirstName());
        lastNameTf.setText(object.getLastName());
        ageTf.setText(( String.valueOf(object.getAge())));
        sexTf.setText(sex);
        cityTf.setText(object.getCity());
        subcityTf.setText(object.getSubcity());
        kebeleTf.setText(object.getKebele());
        phoneTf.setText(object.getPhoneNumber());
        houseNoTf.setText(object.getHouseNumber());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        addedDateTf.setText(object.getDate().format(formatter));
        patientIdTf.setText(String.valueOf(object.getPatientId()));

    }
    /**
     * button handlers
     * */
    @FXML
    void activateBtnHandler(ActionEvent event) {

    }

    @FXML
    void cancelBtnHandler(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void exitBtnHandler(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

}
