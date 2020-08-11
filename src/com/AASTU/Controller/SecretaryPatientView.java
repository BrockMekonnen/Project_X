package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.OutPatient;
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
import java.util.ResourceBundle;

public class SecretaryPatientView implements Initializable {

    public static Patient patientObj;
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
        ageTf.setEditable(status);
        sexTf.setEditable(status);
        cityTf.setEditable(status);
        subcityTf.setEditable(status);
        kebeleTf.setEditable(status);
        phoneTf.setEditable(status);
        houseNoTf.setEditable(status);
        addedDateTf.setEditable(status);
        patientIdTf.setEditable(false);
        birthDayTf.setEditable(status);
        birthMonthTf.setEditable(status);
        birthYearTf.setEditable(status);
    }

    // to update patient info
    public void updatePatientInfo(Patient obj){
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

            Patient patient = session.get(Patient.class, obj.getPatientId());
            patient.setFirstName(firstNameTf.getText());
            patient.setLastName(lastNameTf.getText());
            patient.setAge(Integer.parseInt(ageTf.getText()));
            patient.setSex(sexTf.getText().toLowerCase().charAt(0));
            patient.setPhoneNumber(phoneTf.getText());
            patient.setCity(cityTf.getText());
            patient.setSubcity(subcityTf.getText());
            patient.setKebele(kebeleTf.getText());
            patient.setHouseNumber(houseNoTf.getText());

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
    /* this function accepts Patient Object and assign
    * some values to the textField */
    public void setObject(Patient object){
        String sex = null;
        if(object.getSex() == 'm') {
            sex = "Male";
        }else if(object.getSex() == 'f'){
            sex = "Female";
        }
        textFieldStatus(false);
        firstNameTf.setText(object.getFirstName());
        lastNameTf.setText(object.getLastName());
        ageTf.setText(( String.valueOf(object.getAge())));
        sexTf.setText(sex);
        cityTf.setText(object.getCity());
        subcityTf.setText(object.getSubcity());
        kebeleTf.setText(object.getKebele());
        phoneTf.setText(object.getPhoneNumber());
        houseNoTf.setText(object.getHouseNumber());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        addedDateTf.setText(object.getDate().format(formatter));
        patientIdTf.setText(String.valueOf(object.getPatientId()));

    }
    /**
     * button handlers
     * */
    @FXML
    void activateBtnHandler(ActionEvent event) {

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
            new WindowChangeController().warningPopup("Confirm Saving", "Are you sure. you went to save it?", "warn_confirm.png");
            updatePatientInfo(patientObj);
        }
        editBtn.setText("Save");
    }
}
