package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LaboratoryRegistrationWindow implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
    @FXML
    void handleDiscardButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleConfirmButton(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
    }




}
