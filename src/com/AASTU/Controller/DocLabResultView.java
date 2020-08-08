package com.AASTU.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DocLabResultView implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void handleCloseButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleExitButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleMaxButton(ActionEvent event) {

    }
}
