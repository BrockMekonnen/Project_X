package com.AASTU.Controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorLaboratoryRequestForm implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXCheckBox cbcSelectAll;

    @FXML
    private JFXCheckBox parastologySelectAll;

    @FXML
    private JFXCheckBox lstSelectAll;

    @FXML
    private JFXCheckBox rstSelectAll;

    @FXML
    private JFXCheckBox otherSelectAll;

    @FXML
    private JFXCheckBox dipisticSelectAll;

    @FXML
    private JFXCheckBox microscopySelectAll;

    @FXML
    private JFXCheckBox serologySelectAll;

    @FXML
    private JFXCheckBox bacterologySelectAll;

    @FXML
    void bacterologySelectAll(ActionEvent event) {

    }

    @FXML
    void cbcSelectAll(ActionEvent event) {

    }

    @FXML
    void dipisticSelectAll(ActionEvent event) {

    }

    @FXML
    void lstSelectAll(ActionEvent event) {

    }

    @FXML
    void microscopySelectAll(ActionEvent event) {

    }

    @FXML
    void otherSelectAll(ActionEvent event) {

    }

    @FXML
    void parastologySelectAll(ActionEvent event) {

    }

    @FXML
    void rstSelectAll(ActionEvent event) {

    }

    @FXML
    void serologySelectAll(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    void handleBackButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
}
