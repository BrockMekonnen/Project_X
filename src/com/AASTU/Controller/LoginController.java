package com.AASTU.Controller;


import com.AASTU.Model.Doctor;
import com.AASTU.Model.Laboratory;
import com.AASTU.Model.Secretary;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    public static String source;

    @FXML
    private JFXTextField userName;

    @FXML
    private Label errorLabel;

    @FXML
    private JFXPasswordField password;

    Secretary secretary;
    Doctor doctor;
    Laboratory laboratory;
    @FXML
    void signIn(ActionEvent event) throws IOException {
        String name = userName.getText().toLowerCase();
        String pass = password.getText().toLowerCase();
        if(source.equals("sec")){
            secretary = new DataLoader().secretaryObj(pass, name);
            if(secretary != null){
                SecretaryWindowController.currentSecretary = secretary;
                new WindowChangeController().changeWindow(event,"../view/SecretaryWindow.fxml");
            }else {
                errorLabel.setAlignment(Pos.CENTER);
                errorLabel.setVisible(true);
            }
        } else if(source.equals("doc")){
            doctor = new DataLoader().doctorObj(pass, name);
            if(doctor != null){
                DoctorWindowController.currentDoctor = doctor;
                new WindowChangeController().changeWindow(event,"../view/DoctorWindow.fxml");
            }else {
                errorLabel.setAlignment(Pos.CENTER);
                errorLabel.setVisible(true);
            }
        }else if(source.equals("mana")) {
            if(name.equals("admin")  && pass.equals("admin") ) {
                new WindowChangeController().changeWindow(event,"../view/ManagerWindow.fxml");
            }else {
                errorLabel.setAlignment(Pos.CENTER);
                errorLabel.setVisible(true);
            }
        }else if(source.equals("lab")){
            laboratory = new DataLoader().laboratoryObj(pass, name);
            if(laboratory != null){
                LaboratoryWindowController.currentLaboratory = laboratory;
                System.out.println(laboratory);
                new WindowChangeController().changeWindow(event,"../view/LaboratoryWindow.fxml");
            }else {
                errorLabel.setAlignment(Pos.CENTER);
                errorLabel.setVisible(true);
            }
        }
    }

    @FXML
    void ToIdentificationWindow(ActionEvent event) throws IOException {
        new WindowChangeController().changeWindow(event,"../View/IdentificationPane.fxml");
    }

    // event handler when user press ENTER key from keyboard
    @FXML
    void EnterKeyHandler(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.ENTER){
            String name = userName.getText().toLowerCase();
            String pass = password.getText().toLowerCase();
            if(source.equals("sec")){
                secretary = new DataLoader().secretaryObj(pass, name);
                if(secretary != null){
                    SecretaryWindowController.currentSecretary = secretary;
                    System.out.println(secretary);
                    new WindowChangeController().changeWindow1(event,"../view/SecretaryWindow.fxml");
                }else {
                    errorLabel.setAlignment(Pos.CENTER);
                    errorLabel.setVisible(true);
                }
            } else if(source.equals("doc")){
                doctor = new DataLoader().doctorObj(pass, name);
                if(doctor != null){
                    DoctorWindowController.currentDoctor = doctor;
                    System.out.println(doctor);
                    new WindowChangeController().changeWindow1(event,"../view/DoctorWindow.fxml");
                }else {
                    errorLabel.setAlignment(Pos.CENTER);
                    errorLabel.setVisible(true);
                }
            }else if(source.equals("mana")) {
                if(name.equals("admin")  && pass.equals("admin") ) {
                    new WindowChangeController().changeWindow1(event,"../view/ManagerWindow.fxml");
                }else {
                    errorLabel.setAlignment(Pos.CENTER);
                    errorLabel.setVisible(true);
                }
            }else if(source.equals("lab")){
                laboratory = new DataLoader().laboratoryObj(pass, name);
                if(laboratory != null){
                    LaboratoryWindowController.currentLaboratory = laboratory;
                    System.out.println(laboratory);
                    new WindowChangeController().changeWindow1(event,"../view/LaboratoryWindow.fxml");
                }else {
                    errorLabel.setAlignment(Pos.CENTER);
                    errorLabel.setVisible(true);
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
