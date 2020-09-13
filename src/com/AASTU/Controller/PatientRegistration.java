package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.chrono.GregorianChronology;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.Set;


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
    private JFXComboBox<String> cboGender;

    @FXML
    private ComboBox<Integer> yearCombo;

    @FXML
    private ComboBox<String> monthCombo;

    @FXML
    private ComboBox<Integer> dayCombo;

    @FXML
    private JFXTextField phoneNumberTf;

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
    private int day;
    private int month;
    private int year;

    ObservableList<String> months = FXCollections.observableArrayList("January","February","March","April","May","Jun","July","August","September","October","November","December");
    ObservableList<Integer> years = FXCollections.observableArrayList();
    ObservableList<Integer> days = FXCollections.observableArrayList();

    void arrange(){
        for(int i =LocalDate.now().getYear(); i>= 1920; i--){
            years.add(i);
        }
        for(int i=1;i<= 31;i++){
            days.add(i);
        }
        yearCombo.setItems(years);
        monthCombo.setItems(months);
        dayCombo.setItems(days);
    }
    void checkBirth() {
        if(cboCalender.getValue().equals("E.C")){
            DateTime ethioDate = new DateTime(yearCombo.getValue(), getIntMonth(monthCombo.getValue()), dayCombo.getValue(),12,0, 0,EthiopicChronology.getInstance());
            DateTime gcDate = ethioDate.withChronology(GregorianChronology.getInstance());
            System.out.println(gcDate.getYear());
            year = gcDate.getYear();
            System.out.println(gcDate.getMonthOfYear());
            month = gcDate.getMonthOfYear();
            System.out.println(gcDate.getDayOfMonth());
            day = gcDate.getDayOfMonth();
        }else if(cboCalender.getValue().equals("G.C")){
            year = yearCombo.getValue();
            month = getIntMonth(monthCombo.getValue());
            day = dayCombo.getValue();
        }

    }
    double getAge(){
        double age;
        // the given year and the current year the same but the month is differ
        if(LocalDate.now().getYear() == year){
            if(LocalDate.now().getMonthValue() - month < 10){
                age = (Double.valueOf(LocalDate.now().getMonthValue()) - month) / 10;
            }else {
                age = (Double.valueOf(LocalDate.now().getMonthValue()) - month) / 100;
            }
        }else {
            // the given year and the current year is differ
            age = LocalDate.now().getYear() - year;
        }

        return age;
    }
    private int getIntMonth(String stringMonth){
        if(cboCalender.getValue().equals("E.C")){
            switch (stringMonth){
                case "January":
                    month = 5;
                    break;
                case "February":
                    month =6;
                    break;
                case "March":
                    month = 7;
                    break;
                case "April":
                    month = 8;
                    break;
                case "May":
                    month =9;
                    break;
                case "Jun":
                    month =10;
                    break;
                case "July":
                    month =11;
                    break;
                case "August":
                    month = 12;
                    break;
                case "September":
                    month = 1;
                    break;
                case "October":
                    month =2;
                    break;
                case "November":
                    month =3;
                    break;
                case "December":
                    month = 4;
                    break;
            }
        }else if(cboCalender.getValue().equals("G.C")){
            switch (stringMonth){
                case "January":
                    month = 1;
                    break;
                case "February":
                    month =2;
                    break;
                case "March":
                    month = 3;
                    break;
                case "April":
                    month = 4;
                    break;
                case "May":
                    month =5;
                    break;
                case "Jun":
                    month =6;
                    break;
                case "July":
                    month =7;
                    break;
                case "August":
                    month = 8;
                    break;
                case "September":
                    month = 9;
                    break;
                case "October":
                    month =10;
                    break;
                case "November":
                    month =11;
                    break;
                case "December":
                    month = 12;
                    break;
            }
        }
        return month;

    }
    private char getSex(String genderType){
        char sex = 0;
        if (genderType.equals("Male")) {
            sex = 'm';
        } else if (genderType.equals("Female")) {
            sex = 'f';
        }
        return sex;
    }
    // to check all text fields are get data
    public boolean validatUserInput() throws IOException {
        if(firstNameTf.getText().isEmpty() || firstNameTf.getText().trim().isEmpty() || lastNameTf.getText().isEmpty() ||
                lastNameTf.getText().trim().isEmpty() || cboGender.getSelectionModel().isEmpty() || dayCombo.getSelectionModel().isEmpty()||
                monthCombo.getSelectionModel().isEmpty()|| yearCombo.getSelectionModel().isEmpty() || cboCalender.getValue().isEmpty()||
                phoneNumberTf.getText().isEmpty() || phoneNumberTf.getText().trim().isEmpty() || cityTf.getText().isEmpty() ||
                cityTf.getText().trim().isEmpty() || subcityTf.getText().isEmpty() || subcityTf.getText().trim().isEmpty() ||
                kebeleTf.getText().isEmpty() || kebeleTf.getText().trim().isEmpty()|| houseNuberTf.getText().isEmpty() ||
                houseNuberTf.getText().trim().isEmpty()) {
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
            checkBirth();
            System.out.println(LocalDate.now().getMonthValue());
            //this if condition is temporary and it is not finished
            if (NewOutPatient.isAdd && Warning.isOk) {
                Patient outPatient = new Patient(firstNameTf.getText(), lastNameTf.getText(),getAge(),day,month,year, getSex(cboGender.getValue()), LocalDate.now(), phoneNumberTf.getText(), cityTf.getText(), subcityTf.getText(), kebeleTf.getText(), houseNuberTf.getText());
                outPatient.setStartDate(startDate);
                outPatient.setEndDate(endDate);
                outPatient.setPatientStatus(true);
                outPatient.setPatientStatus(false);
                outPatient.setOutPatinet(true);
                outPatient.setFromSec(true);
                outPatient.setDocActives(true);
                session.save(outPatient);
                NewOutPatient.isAdd = false;
            } else {

                Patient patient = new Patient(firstNameTf.getText(), lastNameTf.getText(),getAge(),day,month,year, getSex(cboGender.getValue()), LocalDate.now(), phoneNumberTf.getText(), cityTf.getText(), subcityTf.getText(), kebeleTf.getText(), houseNuberTf.getText());
                patient.setOutPatinet(false);

                patient.setPatientStatus(true);
                patient.setFromSec(true);
                patient.setDocActives(true);

                patient.setPatientStatus(true);
                session.save(patient);
                new DataSaver().Activity("Registration",new SecretaryWindowController().SecretaryId,patient.getPatientId());
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
        arrange();
    }

    public void ConfirmationAction() throws IOException {
        if(validatUserInput()) {
            if( ExceptionHandler.isLetter(firstNameTf.getText(),firstNameTf) && ExceptionHandler.isLetter(lastNameTf.getText(), lastNameTf) &&
                    ExceptionHandler.isLetter(cityTf.getText(),cityTf) && ExceptionHandler.validateNum(kebeleTf.getText(),kebeleTf) &&
                    ExceptionHandler.ValidatePhone(phoneNumberTf.getText(),phoneNumberTf)){
                if(ExceptionHandler.isValidDate(cboCalender, yearCombo)){
                    new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
                    if(Warning.isOk) {
                        saveNewPatient();
                        WindowChangeController.closeWindow();
                        NotificationController.savedNotification("Patient Added","Registered Successfully ","warn_confirm.png");
                        //                     new SecretaryWindowController().displayPatients();
                    }
                }else {
                    new WindowChangeController().warningPopup("Saving Error", "Invalid Year! Please Check the year. ","warn_confirm.png");
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


