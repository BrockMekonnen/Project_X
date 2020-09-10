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
import java.util.Objects;
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
        String name = userName.getText();
        String pass = password.getText();
            if(source.equals("sec")){
                secretary = new DataLoader().secretaryObj(pass, name);
                if(secretary != null){
                    if (Objects.equals(secretary.getUserName(), name) && Objects.equals(secretary.getPassword(),pass) ){
                        SecretaryWindowController.setCurrentSecretary(secretary);
                        new WindowChangeController().changeWindow(event,"../view/SecretaryWindow.fxml");
                    }else {
                        errorLabel.setAlignment(Pos.CENTER);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Check Your Spellings!");
                    }
                }else {
                    errorLabel.setAlignment(Pos.CENTER);
                    errorLabel.setVisible(true);
                }
            } else if(source.equals("doc")){
                doctor = new DataLoader().doctorObj(pass, name);
                if(doctor != null){
                    if (Objects.equals(doctor.getUserName(), name) && Objects.equals(doctor.getPassword(),pass) ) {
                        DoctorWindowController.setCurrentDoctor(doctor);
                        new WindowChangeController().changeWindow(event, "../view/DoctorWindow.fxml");
                    }else {
                        errorLabel.setAlignment(Pos.CENTER);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Check Your Spellings!");
                    }
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
                    if (Objects.equals(laboratory.getUserName(), name) && Objects.equals(laboratory.getPassword(),pass) ) {
                        LaboratoryWindowController.setCurrentLaboratory(laboratory);
                        System.out.println(laboratory);
                        new WindowChangeController().changeWindow(event, "../view/LaboratoryWindow.fxml");
                    }else {
                        errorLabel.setAlignment(Pos.CENTER);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Check Your Spellings!");
                    }
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
        String name = userName.getText();
        String pass = password.getText();
        if(event.getCode() == KeyCode.ENTER){
                if(source.equals("sec")){
                    secretary = new DataLoader().secretaryObj(pass, name);
                    if(secretary != null){
                        if (Objects.equals(secretary.getUserName(), name) && Objects.equals(secretary.getPassword(),pass) ){
                            SecretaryWindowController.setCurrentSecretary(secretary);
                            new WindowChangeController().changeWindow1(event,"../view/SecretaryWindow.fxml");
                        }else {
                            errorLabel.setAlignment(Pos.CENTER);
                            errorLabel.setVisible(true);
                            errorLabel.setText("Check Your Spellings!");
                        }
                }else {
                    errorLabel.setAlignment(Pos.CENTER);
                    errorLabel.setVisible(true);
                }
                } else if(source.equals("doc")){
                    doctor = new DataLoader().doctorObj(pass, name);
                    if(doctor != null){
                        if (Objects.equals(doctor.getUserName(), name) && Objects.equals(doctor.getPassword(),pass) ) {
                            DoctorWindowController.setCurrentDoctor(doctor);
                            new WindowChangeController().changeWindow1(event, "../view/DoctorWindow.fxml");
                        }else {
                            errorLabel.setAlignment(Pos.CENTER);
                            errorLabel.setVisible(true);
                            errorLabel.setText("Check Your Spellings!");
                        }
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
                        if (Objects.equals(laboratory.getUserName(), name) && Objects.equals(laboratory.getPassword(),pass) ) {
                            LaboratoryWindowController.setCurrentLaboratory(laboratory);
                            System.out.println(laboratory);
                            new WindowChangeController().changeWindow1(event, "../view/LaboratoryWindow.fxml");
                        }else {
                            errorLabel.setAlignment(Pos.CENTER);
                            errorLabel.setVisible(true);
                            errorLabel.setText("Check Your Spellings!");
                        }
                    }else {
                        errorLabel.setAlignment(Pos.CENTER);
                        errorLabel.setVisible(true);
                    }
                }

        }

        if(event.getCode() == KeyCode.BACK_SPACE){
            new WindowChangeController().changeWindow1(event,"../View/IdentificationPane.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
