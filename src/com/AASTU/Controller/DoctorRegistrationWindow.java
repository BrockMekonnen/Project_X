package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorRegistrationWindow implements Initializable {

    @FXML
    void handleDiscardBtn(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleConfirmButton(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you want to save it? ","warn_confirm.png");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
