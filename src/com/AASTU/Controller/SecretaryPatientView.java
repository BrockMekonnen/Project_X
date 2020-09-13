package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class SecretaryPatientView implements Initializable {

    private  Patient patientObj;
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label lblTitle;

    @FXML
    private JFXButton exitBtn;


    @FXML
    private JFXButton activateBtn;

    @FXML
    private JFXButton cancelBtn;


    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXTextField addedDateTf;

    @FXML
    private JFXTextField patientIdTf;

    @FXML
    private JFXTextField ageTf;

    @FXML
    private JFXTextField phoneTf;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField subcityTf;

    @FXML
    private JFXTextField kebeleTf;

    @FXML
    private JFXTextField houseNoTf;

    @FXML
    private JFXTextField sexTf;
    @FXML
    private JFXTextField birthDayTf;

    @FXML
    private JFXTextField birthMonthTf;

    @FXML
    private JFXTextField birthYearTf;

    @FXML
    private JFXComboBox<Patient> calanderCb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private JFXButton editBtn;

    private void textFieldStatus(boolean status) {
        firstNameTf.setEditable(status);
        lastNameTf.setEditable(status);
        ageTf.setEditable(false);
        sexTf.setEditable(status);
        cityTf.setEditable(status);
        subcityTf.setEditable(status);
        kebeleTf.setEditable(status);
        phoneTf.setEditable(status);
        houseNoTf.setEditable(status);
        addedDateTf.setEditable(status);
        patientIdTf.setEditable(false);
        birthDayTf.setEditable(false);
        birthMonthTf.setEditable(false);
        birthYearTf.setEditable(false);
    }
    private boolean validatUserInput() throws IOException {
        if(firstNameTf.getText().isEmpty() || firstNameTf.getText().trim().isEmpty() || lastNameTf.getText().isEmpty() ||
                lastNameTf.getText().trim().isEmpty() || sexTf.getText().isEmpty()|| sexTf.getText().trim().isEmpty() ||
                ageTf.getText().isEmpty()|| ageTf.getText().trim().isEmpty() || phoneTf.getText().isEmpty() ||
                phoneTf.getText().trim().isEmpty() || cityTf.getText().isEmpty() || cityTf.getText().trim().isEmpty() ||
                subcityTf.getText().isEmpty() || subcityTf.getText().trim().isEmpty() || kebeleTf.getText().isEmpty() ||
                kebeleTf.getText().trim().isEmpty()|| houseNoTf.getText().isEmpty() || houseNoTf.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
    private boolean comparePatientObjs(Patient obj1, Patient obj2){
        if(Objects.equals(obj1.getFirstName().toLowerCase(), obj2.getFirstName().toLowerCase()) && Objects.equals(obj1.getLastName().toLowerCase(), obj2.getLastName().toLowerCase()) &&
                Objects.equals(obj1.getSex(), obj2.getSex()) &&  Objects.equals(obj1.getAge(), obj2.getAge()) && Objects.equals(obj1.getPhoneNumber(), obj2.getPhoneNumber()) &&
                Objects.equals(obj1.getCity().toLowerCase(), obj2.getCity().toLowerCase()) &&  Objects.equals(obj1.getSubcity().toLowerCase(), obj2.getSubcity().toLowerCase()) &&
                Objects.equals(obj1.getKebele().toLowerCase(), obj2.getKebele().toLowerCase()) &&  Objects.equals(obj1.getHouseNumber().toLowerCase(), obj2.getHouseNumber().toLowerCase())){
            return true;
        }
        return false;
    }
    // to update patient info
    public void updatePatientInfo(Patient obj) throws IOException {
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
        try{
            session.beginTransaction();

            Patient patient = session.get(Patient.class, obj.getPatientId());
            patient.setFirstName(firstNameTf.getText());
            patient.setLastName(lastNameTf.getText());
            if(ExceptionHandler.validateNum(ageTf.getText(),ageTf)){
                patient.setAge(Double.parseDouble(ageTf.getText()));
                patient.setSex(sexTf.getText().toLowerCase().charAt(0));
                patient.setPhoneNumber(phoneTf.getText());
                patient.setCity(cityTf.getText());
                patient.setSubcity(subcityTf.getText());
                patient.setKebele(kebeleTf.getText());
                patient.setHouseNumber(houseNoTf.getText());
                if(comparePatientObjs(patient,obj)){
                    new WindowChangeController().warningPopup("Checking", "You Didn't Make any change?", "warn_confirm.png");
                }else {
                    if(validatUserInput()){
                        if( ExceptionHandler.isLetter(firstNameTf.getText(),firstNameTf) && ExceptionHandler.isLetter(lastNameTf.getText(), lastNameTf) &&
                                ExceptionHandler.isLetter(sexTf.getText(), sexTf)&& ExceptionHandler.isLetter(cityTf.getText(),cityTf) &&
                                ExceptionHandler.validateNum(kebeleTf.getText(),kebeleTf) && ExceptionHandler.ValidatePhone(phoneTf.getText(),phoneTf)) {
                            new WindowChangeController().warningPopup("Checking", "Are you sure to save your Edit?", "warn_confirm.png");
                            if (Warning.isOk) {
                                session.getTransaction().commit();
                                NotificationController.savedNotification("Profile Edited", firstNameTf.getText() + " Info Updated successfully!", "warn_confirm.png");
//                                    WindowChangeController.closeWindow();
                            }
                        }else {
                            new WindowChangeController().warningPopup("Saving Error", "Invalid Inputs! Please Check. ","warn_confirm.png");
                        }
                    }else {
                        new WindowChangeController().warningPopup("Validate Fields", "Please Fill the fields! ","warn_confirm.png");
                    }
                }
            } else {
                new WindowChangeController().warningPopup("Saving Error", "The Age is Not correct","warn_confirm.png");
            }

        } finally {
            factory.close();
            session.close();
        }
    }
    private String convertMonth(Patient patient){
        String month = null;
        switch (patient.getBirthMonth()){
            case 1:
                month = "January";
                break;
            case 2:
                month ="February";
                break;
            case 3:
                month ="March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month ="May";
                break;
            case 6:
                month ="Jun";
                break;
            case 7:
                month ="July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month ="October";
                break;
            case 11:
                month ="November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month;

    }

    String convertage(double age){
        if(age < 1){
         return  Math.round(age * 10) + " Month";
        }else {
            return String.valueOf(Math.round(age));
        }
    }
    /* this function accepts Patient Object and assign
    * some values to the textField */
    public void setObject(Patient object, boolean hasActive){
        patientObj = object;
        String sex = null;
        if(!hasActive){
            activateBtn.setVisible(false);
            editBtn.setTranslateX(100);
        }
        if(object.getSex() == 'm') {
            sex = "Male";
        }else if(object.getSex() == 'f'){
            sex = "Female";
        }
        textFieldStatus(false);
        firstNameTf.setText(object.getFirstName());
        lastNameTf.setText(object.getLastName());
        ageTf.setText( convertage(object.getAge()));
        sexTf.setText(sex);
        cityTf.setText(object.getCity());
        subcityTf.setText(object.getSubcity());
        kebeleTf.setText(object.getKebele());
        phoneTf.setText(object.getPhoneNumber());
        houseNoTf.setText(object.getHouseNumber());
        birthDayTf.setText(Integer.toString(object.getBirthDay()));
        birthMonthTf.setText(convertMonth(object));
        birthYearTf.setText(Integer.toString(object.getBirthYear()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        addedDateTf.setText(object.getDate().format(formatter));
        patientIdTf.setText(String.valueOf(object.getPatientId()));

    }
    /**
     * button handlers
     * */
    void activatePatient(){
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
        try{
            session.beginTransaction();

            Patient activePatient = session.get(Patient.class, patientObj.getPatientId());
            activePatient.setDocActives(true);
            activePatient.setFromSec(true);
            session.getTransaction().commit();
            NotificationController.savedNotification("Activated","Patient Activated successfully!","warn_confirm.png");
        } finally {
            factory.close();
            session.close();
        }
    }
    @FXML
    void activateBtnHandler(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Checking", "Are you sure to Activate?", "warn_confirm.png");
        if(Warning.isOk){
            activatePatient();
            WindowChangeController.closeWindow();
        }
    }

    @FXML
    void cancelBtnHandler(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void exitBtnHandler(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
    @FXML
    void editAndSaveHandler(ActionEvent event) throws IOException {
        textFieldStatus(true);
        if(editBtn.getText().equals("Save")){
            updatePatientInfo(this.patientObj);
        }
        editBtn.setText("Save");
    }
}
