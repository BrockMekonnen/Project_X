package com.AASTU.Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LabToDoc implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void handleCloseButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
}