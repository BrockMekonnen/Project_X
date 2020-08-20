package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.Doctor;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DoctorRegistrationWindow implements Initializable {

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
    private char sex;

    private void saveNewDoctor(){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
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
            Doctor doctor = new Doctor(firstNameTf.getText(),lastNameTf.getText(),sex,LocalDate.now(),"password", startTimePk.getValue(),endTimePk.getValue(),phoneTf.getText(),cityTf.getText(),subCityTf.getText(),kebeleTf.getText());
            session.save(doctor);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
    @FXML
    void handleDiscardBtn(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleConfirmButton(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
        saveNewDoctor();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addedTf.setDisable(true);
        addedTf.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/LLLL/yyyy")));
    }
}
