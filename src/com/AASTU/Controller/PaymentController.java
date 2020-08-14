package com.AASTU.Controller;

import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable{
    @FXML
    private TableView<?> paymentDetailTable;

    @FXML
    private JFXTextField totalPriceTf;

    @FXML
    private JFXButton payedBtn;

    @FXML
    private JFXButton cancelBtn;

    public void setObject(Patient obj){
        double totalPrice = new SecretaryWindowController().calcTotalPayment(obj);
        String total = Double.toString(totalPrice);
        totalPriceTf.setText(total + " ETB.");
    }
    @FXML
    void cancelHandler(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void payedHandler(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
