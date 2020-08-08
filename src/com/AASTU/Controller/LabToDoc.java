package com.AASTU.Controller;

import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LabToDoc implements Initializable {


    @FXML
    private JFXComboBox<?> cbo_vdrl;

    @FXML
    private JFXComboBox<?> cbo_h;

    @FXML
    private JFXComboBox<?> cbo_o;

    @FXML
    private JFXComboBox<?> cbo_felix;

    @FXML
    private JFXComboBox<?> cbo_hbs;

    @FXML
    private JFXComboBox<?> cbo_crp;

    @FXML
    private JFXComboBox<?> cbo_aso;

    @FXML
    private JFXComboBox<?> cbo_rhe;

    @FXML
    private JFXComboBox<?> cbo_serum;

    @FXML
    private JFXComboBox<?> cbo_aids;

    @FXML
    private JFXTextField DateTF;

    @FXML
    private JFXTextField SexTF;

    @FXML
    private JFXTextField AgeTF;

    @FXML
    private JFXTextField NameTF;

    @FXML
    private JFXButton maxBtn;

    @FXML
    private JFXButton exitBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DateTF.setEditable(false);
        SexTF.setEditable(false);
        AgeTF.setEditable(false);
        NameTF.setEditable(false);

    }

    public void setObject(Patient patient){
        DateTF.setText(patient.getDate().toString());
        AgeTF.setText(String.valueOf(patient.getAge()));
        NameTF.setText(patient.getFirstName()+" "+patient.getLastName());
        SexTF.setText(String.valueOf(patient.getSex()));

    }

    @FXML
    void handleCloseButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
}