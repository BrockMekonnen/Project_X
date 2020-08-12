package com.AASTU.Controller;

import com.AASTU.Main;
import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
    private JFXDatePicker addedDateTf;

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

    public void addNewPatient(){
    }

    private char sex;
    // save new patient to database
    public void saveNewPatient(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(OutPatient.class)
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
            TestProperty test = new TestProperty("postive", 2154,true);
//
            Parasitology obj1 = new Parasitology(test,test,test,test,test,test,test);
            Bacteriology obj2 = new Bacteriology(test, test);
            Microscopy obj3 = new Microscopy(test,test,test,test,test);
            Chemistry obj4 = new Chemistry(test,test,test,test,test,test,test,test,test,test,test,test);
            Dipstick obj5 = new Dipstick(test,test,test,test,test,test,test,test,test,test);
            Others obj6 = new Others(test, test, test, test);
            Cbs obj7 = new Cbs(test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test);
            Serology obj8 = new Serology(test,test,test,test,test,test,test,test,test);

            LabRequest lab = new LabRequest("labId","docId",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);

            ClinicalNotes clinicalNote = new ClinicalNotes(LocalDate.now(),"ggggg","docId");


            if(cboGender.getValue().toString().equals("Male")){
                sex = 'm';
            }else if(cboGender.getValue().toString().equals("Female")) {
                sex = 'f';
            }
            //this if condition is temporary and it is not finished
            if(NewOutPatient.isAdd && Warning.isOk){
                OutPatient outPatient = new OutPatient(firstNameTf.getText(),lastNameTf.getText(),Integer.parseInt(ageTf.getText()),sex, LocalDate.now(),phoneNumberTf.getText(),
                        cityTf.getText(),subcityTf.getText(),kebeleTf.getText(),houseNuberTf.getText(),startDate,endDate);
                outPatient.addClincalNote(clinicalNote);
                outPatient.addLabRequest(lab);

                outPatient.setDocActives(true);
                outPatient.setLabActives(true);
                outPatient.setSecActives(true);
                outPatient.setSecActives(true);
                outPatient.setLabActives(true);

                session.save(outPatient);
                NewOutPatient.isAdd = false;
            } else  {
                Patient patient = new Patient(firstNameTf.getText(),lastNameTf.getText(),Integer.parseInt(ageTf.getText()),sex, LocalDate.now(),phoneNumberTf.getText(),cityTf.getText(),subcityTf.getText(),kebeleTf.getText(),houseNuberTf.getText());
                patient.addClincalNote(clinicalNote);
                patient.addLabRequest(lab);

                patient.setDocActives(true);
                patient.setLabActives(true);
                patient.setSecActives(true);
                patient.setSecActives(true);
                patient.setLabActives(true);

                session.save(patient);
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
    }


    public void ConfirmationAction() throws IOException {
        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it? ","warn_confirm.png");
        if(Warning.isOk) {
            saveNewPatient();
            WindowChangeController.closeWindow();
            WindowChangeController.closeWindow();
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


