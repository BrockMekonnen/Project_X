package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class PatientRegistration implements Initializable{

    @FXML
    private AnchorPane subPane1;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane pnlInner;

    @FXML
    private Label lblTitle;

    @FXML
    private StackPane subpane2;

    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXComboBox<?> cboGender;

    @FXML
    private JFXTextField birthDayTf;

    @FXML
    private JFXTextField birthMonthTf;

    @FXML
    private JFXTextField birthYearTf;

    @FXML
    private JFXTextField phoneNumberTf;

    @FXML
    private JFXTextField ageTf;

    @FXML
    private JFXComboBox<String> cboCalender;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField subcityTf;

    @FXML
    private JFXTextField kebeleTf;

    @FXML
    private JFXTextField patientAddedDateTF;

    @FXML
    private JFXTextField patientIdTf;

    @FXML
    private JFXButton btnConfirm;

    @FXML
    private JFXButton btnDiscard;

    @FXML
    private JFXTextField houseNuberTf;

    @FXML
    private JFXButton btnOutPatient;

    @FXML
    private JFXCheckBox isOutCb;

    @FXML
    private JFXCheckBox hasLabCb;

    public static LocalDate startDate;

    public static LocalDate endDate;

    private String firstName;
    private int age;
    private String phoneNo;
    private char sex;

    // to check all text fields are get data
    public boolean validatUserInput() throws IOException {
        if(firstNameTf.getText().isEmpty() || firstNameTf.getText().trim().isEmpty() || lastNameTf.getText().isEmpty() ||
                lastNameTf.getText().trim().isEmpty() || cboGender.getSelectionModel().isEmpty() ||
                ageTf.getText().isEmpty()|| ageTf.getText().trim().isEmpty() || phoneNumberTf.getText().isEmpty() ||
                phoneNumberTf.getText().trim().isEmpty() || cityTf.getText().isEmpty() || cityTf.getText().trim().isEmpty() ||
                subcityTf.getText().isEmpty() || subcityTf.getText().trim().isEmpty() || kebeleTf.getText().isEmpty() ||
                kebeleTf.getText().trim().isEmpty()|| houseNuberTf.getText().isEmpty() || houseNuberTf.getText().trim().isEmpty()) {
             return false;
        }
        return true;
    }

    public void saveNewPatient() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)
                .addAnnotatedClass(TestProperty.class)
                .addAnnotatedClass(Parasitology.class)
                .addAnnotatedClass(Bacteriology.class)
                .addAnnotatedClass(Microscopy.class)
                .addAnnotatedClass(Chemistry.class)
                .addAnnotatedClass(Dipstick.class)
                .addAnnotatedClass(Others.class)
                .addAnnotatedClass(Cbs.class)
                .addAnnotatedClass(Serology.class)
                .addAnnotatedClass(LabRequest.class)
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
            if (NewOutPatient.isAdd && Warning.isOk) {
                Patient outPatient = new Patient(firstNameTf.getText(), lastNameTf.getText(),Integer.parseInt(ageTf.getText()), sex, LocalDate.now(), phoneNumberTf.getText(), cityTf.getText(), subcityTf.getText(), kebeleTf.getText(), houseNuberTf.getText());
                outPatient.setStartDate(startDate);

                outPatient.setPatientStatus(true);

                outPatient.setEndDate(endDate);
                outPatient.setPatientStatus(true);
                outPatient.setOutPatinet(true);
                outPatient.setFromSec(true);
                outPatient.setDocActives(true);
                session.save(outPatient);
                NewOutPatient.isAdd = false;
            } else {

               Patient patient = new Patient(firstNameTf.getText(), lastNameTf.getText(), Integer.parseInt(ageTf.getText()), sex, LocalDate.now(), phoneNumberTf.getText(), cityTf.getText(), subcityTf.getText(), kebeleTf.getText(), houseNuberTf.getText());
                patient.setOutPatinet(false);

                patient.setPatientStatus(true);
                patient.setFromSec(true);
                patient.setDocActives(true);

                patient.setPatientStatus(true);
                session.save(patient);
                new DataSaver().Activity("Registration",SecretaryWindowController.currentSecretary.getSecretaryId(),patient.getPatientId());
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cboCalender.getSelectionModel().select("E.C");
        patientAddedDateTF.setDisable(true);
        patientAddedDateTF.setText(LocalDate.now().format( DateTimeFormatter.ofPattern("dd/LLLL/yyyy")));
    }

    public void ConfirmationAction() throws IOException {
        if(validatUserInput()) {
          if( ExceptionHandler.isLetter(firstNameTf.getText(),firstNameTf) && ExceptionHandler.isLetter(lastNameTf.getText(), lastNameTf) &&
              ExceptionHandler.isLetter(cityTf.getText(),cityTf) && ExceptionHandler.validateNum(kebeleTf.getText(),kebeleTf) &&
              ExceptionHandler.validateNum(ageTf.getText(),ageTf) && ExceptionHandler.ValidatePhone(phoneNumberTf.getText(),phoneNumberTf)){
               new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
                if(Warning.isOk) {
                     WindowChangeController.closeWindow();
                     saveNewPatient();
                     NotificationController.savedNotification("Patient Added","Registered Successfully ","warn_confirm.png");
              }
          }else {
            new WindowChangeController().warningPopup("Saving Error", "Invalid Inputs! Please Check. ","warn_confirm.png");

          }
        }else {
            new WindowChangeController().warningPopup("Validate Fields", "Please Fill the fields! ","warn_confirm.png");
        }
    }


    @FXML
    void DiscardAction(ActionEvent event) throws IOException {
        WindowChangeController.closeWindow();
    }

    @FXML
    void addOutPatient(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event,"../View/NewOutPatient.fxml");
    }
}


