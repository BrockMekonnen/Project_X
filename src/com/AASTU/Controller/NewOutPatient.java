package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewOutPatient implements Initializable {

    @FXML
    private JFXButton btnCancel;

    @FXML
    void cancelWindow(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
    @FXML
    void handleAddButton(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it?", "warn_confirm.png");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
