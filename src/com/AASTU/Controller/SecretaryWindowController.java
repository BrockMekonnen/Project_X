package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class SecretaryWindowController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton paymentBtn;

    @FXML
    private JFXButton outPatientBtn;

    @FXML
    private JFXButton recordBtn;

    @FXML
    private JFXButton activePatientBtn;

    /** ACTIVE PATIENT*/
    @FXML
    private AnchorPane ActivePatientPnl;

    @FXML
    private TableView<Patient> mainTable;
    @FXML
    private TableColumn<Patient, Integer> patientIdCol;

    @FXML
    private TableColumn<Patient, String> firstNameCol;

    @FXML
    private TableColumn<Patient, String> lastNameCol;

    @FXML
    private TableColumn<Patient, Character> sexCol;

    @FXML
    private TableColumn<Patient, Integer> ageCol;

    @FXML
    private TableColumn<Patient, LocalDate> addedDateCol;

    @FXML
    private TableColumn<Patient, String> phoneNoCol;

    @FXML
    private TableColumn<Patient, String> cityCol;

    @FXML
    private TableColumn<Patient, String> subCityCol;

    @FXML
    private TableColumn<Patient, String> kebeleCol;

    @FXML
    private TableColumn<Patient, String> houseNoCol;

    /** PAYMENT*/
    @FXML
    private AnchorPane paymentPnl;

    @FXML
    private TableView<Patient> paymentTable;

    @FXML
    private TableColumn<Patient, Integer> payPatientIdCol;

    @FXML
    private TableColumn<Patient, String> fullNameCol;

    @FXML
    private TableColumn<Patient, Double> paymentCol;

    /** OUT PATIENT*/
    @FXML
    private AnchorPane outPatientPnl;

    @FXML
    private TableView<Patient> outPatientTable;

    @FXML
    private TableColumn<Patient, Integer> patientOutIdCol;

    @FXML
    private TableColumn<Patient, String> firstNameOutCol;

    @FXML
    private TableColumn<Patient, String> lastNameOutCol;

    @FXML
    private TableColumn<Patient, Character> sexOutCol;

    @FXML
    private TableColumn<Patient, Integer> ageOutCol;

    @FXML
    private TableColumn<Patient, LocalDate> addedDateOutCol;

    @FXML
    private TableColumn<Patient, LocalDate> startDateCol;

    @FXML
    private TableColumn<Patient, LocalDate> endDateCol;

    @FXML
    private TableColumn<Patient, String> phoneNoOutCol;

    @FXML
    private TableColumn<Patient, String> cityOutCol;

    @FXML
    private TableColumn<Patient, String> subCityOutCol;

    @FXML
    private TableColumn<Patient, String> kebeleOutCol;

    @FXML
    private TableColumn<Patient, String> houseNoOutCol;

    /** RECORD*/
    @FXML
    private TableView<Patient> recordTable;

    @FXML
    private TableColumn<Patient, Integer> patientIdColRec;

    @FXML
    private TableColumn<Patient, LocalDate> addedDateColRec;

    @FXML
    private TableColumn<Patient, String> fullNameColRec;

    @FXML
    private TableColumn<Patient, Character> sexColRec;

    @FXML
    private TableColumn<Patient, Integer> ageColRec;

    @FXML
    private TableColumn<Patient, String> cityColRec;
    ///////////////////////////////////////////////////
    @FXML
    private AnchorPane recordPnl;

    @FXML
    private JFXButton navBtn;

    @FXML
    private AnchorPane opacityPane1;

    @FXML
    private AnchorPane slidePane1;

    @FXML
    private AnchorPane profileOpacityPane;

    @FXML
    private AnchorPane profilePane;

    @FXML
    private ImageView exitBtn;
    @FXML
    private JFXTextField searchfield;

// getting patient lists from database
List<Patient> allPatientList = new DataLoader().loadPatientData();
List<Patient> normalPatientList =new DataLoader().loadSpecificData("from Patient p where p.pType = Patient");
List<Patient> outPatientList = new DataLoader().loadSpecificData("from Patient p where p.pType = OutPatient");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        opacityPane1.setVisible(false);
        TransitionController.translateTransition(slidePane1, -600, 0.5);
        TransitionController.translation(slidePane1,1,0,0.1);
        opacityPane1.setOnMouseClicked(event -> {
            translateTransitionBack(slidePane1,-600,1);
        });

        profileOpacityPane.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });

        exitBtn.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });
        displayPatients();
        displayPayment();
        displayRecords();
    }

    void goToView(boolean active, boolean pay, boolean out, boolean record){
        ActivePatientPnl.setVisible(active);
        paymentPnl.setVisible(pay);
        outPatientPnl.setVisible(out);
        recordPnl.setVisible(record);


    }



    /**
     * ROW CLICK HANDLER
     * */
    public void rowClickHandler( TableView<Patient> tableName) {
        tableName.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = row.getItem(); //get the object in the row and assign it to patient object
                    try {
                        new WindowChangeController().secretaryPatientView(event, "../View/SecretaryPatientView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }

    /**
     * METHODS TO DISPLAY AND REFRESH TABLES
     * */

    // method to display the total payment of patient but it is not finished yet!
    public void displayPayment() {
        payPatientIdCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        // display full name
        fullNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Patient, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<Patient, String> p) {
                return new SimpleStringProperty(p.getValue().getFirstName()
                        + " " + p.getValue().getLastName());
            }
        });
        ObservableList<Patient> patientsList = FXCollections.observableArrayList();
        for(Patient tempPatent: normalPatientList){
            patientsList.add(tempPatent);
        }
        paymentTable.setItems(patientsList);
    }

    //  method to display patient records
    public void displayRecords() {
        rowClickHandler(recordTable);
        patientIdColRec.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        fullNameColRec.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Patient, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Patient, String> param) {
                return new SimpleStringProperty(param.getValue().getFirstName() + " " + param.getValue().getLastName());
            }
        });
        addedDateColRec.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("date"));
        sexColRec.setCellValueFactory(new PropertyValueFactory<Patient, Character>("sex"));
        ageColRec.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        cityColRec.setCellValueFactory(new PropertyValueFactory<Patient, String>("city"));
        ObservableList<Patient> recordList = FXCollections.observableArrayList();
        for(Patient patient: allPatientList) {
            recordList.add(patient);
        }
        recordTable.setItems(recordList);
    }

    // method to display the registered patients to the table
    public  void displayPatients() {
        rowClickHandler(mainTable);
        // to display normal patient
        patientIdCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        sexCol.setCellValueFactory(new PropertyValueFactory<Patient, Character>("sex"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        addedDateCol.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("date"));
        phoneNoCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNumber"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("city"));
        subCityCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("subcity"));
        kebeleCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("kebele"));
        houseNoCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("houseNumber"));
        ObservableList<Patient> normalPatientObservableList = FXCollections.observableArrayList();
        for(Patient tempPatent: normalPatientList){
            normalPatientObservableList.add(tempPatent);
        }

        mainTable.setItems(normalPatientObservableList);
        rowClickHandler(outPatientTable);
        // to display out patient
        patientOutIdCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        firstNameOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        lastNameOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        sexOutCol.setCellValueFactory(new PropertyValueFactory<Patient, Character>("sex"));
        ageOutCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        addedDateOutCol.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("date"));
        phoneNoOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNumber"));
        cityOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("city"));
        subCityOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("subcity"));
        kebeleOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("kebele"));
        houseNoOutCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("houseNumber"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("endDate"));
        ObservableList<Patient> outPatientObservableList = FXCollections.observableArrayList();
        for(Patient tempPatent: outPatientList){
            outPatientObservableList.add(tempPatent);
        }

        outPatientTable.setItems(outPatientObservableList);
    }


    /**
     * HANDLE BUTTONS
     * */

    @FXML
    void handleActivePatientButton(ActionEvent event) {
        goToView(true,false,false,false);
        ActivePatientPnl.toFront();
    }

    @FXML
    void handleOutPatientButton(ActionEvent event) {
        goToView(false,false,true,false);
        outPatientPnl.toFront();
    }

    @FXML
    void handlePaymentButton(ActionEvent event) {
        goToView(false,true,false,false);
        paymentPnl.toFront();
    }

    @FXML
    void handleRecordButton(ActionEvent event) {
        goToView(false,false,false,true);
        recordPnl.toFront();
    }

    @FXML
    public void navAction(ActionEvent event) {
        opacityPane1.setVisible(true);
        slidePane1.setVisible(true);
        TransitionController.translation(slidePane1,0,1,0.1);
        TransitionController.translateTransition(slidePane1, 600, 1);

    }

    public void translateTransitionBack(AnchorPane pane, double move, double sec){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(sec),pane);
        translateTransition.setByX(move);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane1.setVisible(false);
        });
    }
    @FXML
    void profileHandler(ActionEvent event) {
        translateTransitionBack(slidePane1,-600,1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }

    public void AddPatientAction(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/PatientRegistration.fxml");
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event, "../view/Login.fxml");
    }

    @FXML
    void CloseBTN(ActionEvent event){
        int i= JOptionPane.showConfirmDialog(null,"Do you want to Exit the system","Attention",JOptionPane.YES_NO_OPTION);
        if(i== JOptionPane.YES_OPTION){
            System.exit(0);
            Platform.exit();}
    }

}
