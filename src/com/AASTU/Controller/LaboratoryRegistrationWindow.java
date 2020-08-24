package com.AASTU.Controller;

import com.AASTU.Model.Doctor;
import com.AASTU.Model.Laboratory;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class LaboratoryRegistrationWindow implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane pnlInner;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField addedTf;

    @FXML
    private JFXComboBox<?> cboGender;

    @FXML
    private JFXTextField phoneTf;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField subCityTf;

    @FXML
    private JFXTextField kebeleTf;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private JFXButton btnDiscard;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXTimePicker endTimePk;

    @FXML
    private JFXTimePicker startTimePk;
    @FXML
    private JFXTextField userNameTf;
    private char sex;
    public boolean validatUserInput() throws IOException {
        if(firstNameTf.getText().isEmpty() || firstNameTf.getText().trim().isEmpty() || lastNameTf.getText().isEmpty() ||
                lastNameTf.getText().trim().isEmpty() || userNameTf.getText().isEmpty()|| userNameTf.getText().trim().isEmpty() || cboGender.getSelectionModel().isEmpty() ||
                startTimePk.getValue() == null|| startTimePk.getValue() == null ||endTimePk.getValue() == null ||
                endTimePk.getValue()== null|| cityTf.getText().isEmpty() || cityTf.getText().trim().isEmpty() ||
                subCityTf.getText().isEmpty() || subCityTf.getText().trim().isEmpty() || kebeleTf.getText().isEmpty() ||
                kebeleTf.getText().trim().isEmpty()|| phoneTf.getText().isEmpty() || phoneTf.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        addedTf.setDisable(true);
        addedTf.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/LLLL/yyyy")));
    }

    @FXML
    void handleConfirmButton(ActionEvent event) throws IOException {
        boolean userNameExist = new DataLoader().laboratoriestUserNameExist(userNameTf.getText());
        if(validatUserInput()){
            if(ExceptionHandler.isLetter(firstNameTf.getText(),firstNameTf) && ExceptionHandler.isLetter(lastNameTf.getText(),lastNameTf) && ExceptionHandler.ValidatePhone(phoneTf.getText(),phoneTf) &&
               ExceptionHandler.isLetter(cityTf.getText(),cityTf) && ExceptionHandler.validateNum(kebeleTf.getText(),kebeleTf)){
                 if(!userNameExist){
                 new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
                 if(Warning.isOk){
                     saveNewLaboratory();
                     WindowChangeController.closeWindow();
                     NotificationController.savedNotification("Laboratories Added","Registered Successfully ","warn_confirm.png");
                 }
             }else {
                     new WindowChangeController().warningPopup("Saving Error", "The User Name is Already Used!!","warn_confirm.png");
              }
            } else {
                new WindowChangeController().warningPopup("Saving Error", "Invalid Inputs! Please Check. ","warn_confirm.png");
            }
        }else {
            new WindowChangeController().warningPopup("Validate Fields", "Please Fill the fields! ","warn_confirm.png");

        }
    }

    @FXML
    void handleDiscardBtn(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    public void saveNewLaboratory(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Laboratory.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            if (cboGender.getValue().toString().equals("Male")) {
                sex = 'm';
            } else if (cboGender.getValue().toString().equals("Female")) {
                sex = 'f';
            }
            //this if condition is temporary and it is not finished
            Laboratory laboratory = new Laboratory(firstNameTf.getText(),lastNameTf.getText(),userNameTf.getText(),sex, LocalDate.now(),"password", startTimePk.getValue(),endTimePk.getValue(),phoneTf.getText(),cityTf.getText(),subCityTf.getText(),kebeleTf.getText());
            session.save(laboratory);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

}
