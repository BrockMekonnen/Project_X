package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorRegistrationWindow implements Initializable {

    @FXML
    void handleDiscardBtn(ActionEvent event) {
        WindowChangeController.popupStage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
