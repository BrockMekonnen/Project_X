package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import com.AASTU.Model.Pricing;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PaymentController implements Initializable{
    private  Patient patientObj;
    @FXML
    private TableView<Pricing> paymentDetailTable;

    @FXML
    private TableColumn<Pricing, Number> testNoCol;

    @FXML
    private TableColumn<Pricing, String> testTypeCol;

    @FXML
    private TableColumn<Pricing, Double> pricecol;


    @FXML
    private JFXTextField totalPriceTf;

    @FXML
    private JFXButton payedBtn;

    @FXML
    private JFXButton cancelBtn;

    public static ObservableList<Pricing> pricings = FXCollections.observableArrayList();

    public void setObject(Patient obj){
        patientObj = obj;
        testTypeCol.setCellValueFactory(new PropertyValueFactory<Pricing, String>("testName"));
        pricecol.setCellValueFactory(new PropertyValueFactory<Pricing, Double>("price"));
        // generate the row number
        testNoCol.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(paymentDetailTable.getItems().indexOf(column.getValue())));
        double totalPrice = new SecretaryWindowController().calcTotalPayment(obj);
        String total = Double.toString(totalPrice);
        totalPriceTf.setText(total + " ETB.");
        ObservableList<Pricing> pricingObservableList = FXCollections.observableArrayList();
        for(Pricing tempPatent: pricings){
            pricingObservableList.add(tempPatent);
        }
        paymentDetailTable.setItems(pricingObservableList);
    }
    @FXML
    void cancelHandler(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void payedHandler(ActionEvent event) {
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
            activePatient.setLabActives(true);
            activePatient.setFromSec(true);
            activePatient.setPayed(true);
            activePatient.setSecActives(false);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
