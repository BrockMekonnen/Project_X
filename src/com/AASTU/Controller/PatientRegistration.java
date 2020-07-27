package com.AASTU.Controller;

import com.AASTU.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientRegistration implements Initializable{

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane subPane1;

    @FXML
    private Label lblTitle;

    @FXML
    private StackPane subpane2;

    @FXML
    private JFXComboBox<?> cboGender;

    @FXML
    private JFXComboBox<String> cboCalender;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private JFXButton btnDiscard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cboCalender.getSelectionModel().select("E.C");
    }

//    public void DiscardAction(ActionEvent event){
//        int i= JOptionPane.showConfirmDialog(null,"Are You sure You want to Discard The file","Message",JOptionPane.YES_NO_OPTION);
//        if(i==JOptionPane.YES_OPTION) {
//            Main main = new Main();
//            main.action(event, "View/SecretaryWindow.fxml", rootPane);
//        }
//    }

    public void ConfirmationAction(){
        JOptionPane.showMessageDialog(null,"You Successfully Register Patient","Message",JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void DiscardAction(ActionEvent event) {
        WindowChangeController.popupStage.close();
    }
}

