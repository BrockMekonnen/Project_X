package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;

import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ManagerWindow implements Initializable {

    /**
     * Doctor Table
     * */
    @FXML
    private TableView<Doctor> doctorTable;

    @FXML
    private TableColumn<Doctor, Number> noCol;

    @FXML
    private TableColumn<Doctor, Integer> docIDCol;

    @FXML
    private TableColumn<Doctor, String> fullNameCol;

    @FXML
    private TableColumn<Doctor, LocalDate> addedDateCol;

    @FXML
    private TableColumn<Doctor, LocalTime> startHrCol;

    @FXML
    private TableColumn<Doctor, LocalTime> endHrCol;

    @FXML
    private TableColumn<Doctor, String> docUserNameCol;

    @FXML
    private TableColumn<Doctor, String> docPasswordCol;

    @FXML
    private TableColumn<Doctor, String> docPhoneCol;

    @FXML
    private TableColumn<Doctor, String> docCityCol;
    /**
     * price Table
     * */
    @FXML
    private TableView<Pricing> testTable;

    @FXML
    private TableColumn<Pricing, Integer> testIdCol;

    @FXML
    private TableColumn<Pricing, String> testNameCol;

    @FXML
    private TableColumn<Pricing, Double> priceCol;

    @FXML
    private JFXButton editSaveBtn;


    /**
     * Laboratory Table
     * */

    @FXML
    private TableView<Laboratory> laboratoryTable;

    @FXML
    private TableColumn<Laboratory, Number> labNoCol1;

    @FXML
    private TableColumn<Laboratory, Integer> labIDCol1;

    @FXML
    private TableColumn<Laboratory, String> labFullNameCol1;

    @FXML
    private TableColumn<Laboratory, LocalDate> labAddedDateCol1;

    @FXML
    private TableColumn<Laboratory, LocalTime> labStartHrCol1;

    @FXML
    private TableColumn<Laboratory, LocalTime> labEndHrCol1;

    @FXML
    private TableColumn<Laboratory, String> labUserNameCol;

    @FXML
    private TableColumn<Laboratory, String> labPasswordCol;
    @FXML
    private TableColumn<Laboratory, String> labPhoneCol;

    @FXML
    private TableColumn<Laboratory, String> labCityCol1;


    /**
     * Secretary Table
     * */
    @FXML
    private TableView<Secretary> secretaryTable1;

    @FXML
    private TableColumn<Secretary, Number> secNoCol11;

    @FXML
    private TableColumn<Secretary, Integer> secIDCol11;

    @FXML
    private TableColumn<Secretary, String> secFullNameCol11;

    @FXML
    private TableColumn<Secretary, LocalDate> secAddedDateCol11;

    @FXML
    private TableColumn<Secretary, LocalTime> secStartHrCol11;

    @FXML
    private TableColumn<Secretary, LocalTime> secEndHrCol11;

    @FXML
    private TableColumn<Secretary, String> secUserNameCol;

    @FXML
    private TableColumn<Secretary, String> secPasswordCol;

    @FXML
    private TableColumn<Secretary, String> secPhoneCol;

    @FXML
    private TableColumn<Secretary, String> secCityCol;



    /**Work Table*/
    @FXML
    private TableView<WorkActivity> workTableView;

    @FXML
    private TableColumn<WorkActivity,Integer> ActiveCol;

    @FXML
    private TableColumn<WorkActivity, LocalDate> DateCol;

    @FXML
    private TableColumn<WorkActivity, Integer> PatientIdCol;

    @FXML
    private TableColumn<WorkActivity, Integer> SecretaryIdCol;

    @FXML
    private TableColumn<WorkActivity, Integer> DotorIdCol;

    @FXML
    private TableColumn<WorkActivity, Integer> LabIdCol;

    @FXML
    private TableColumn<WorkActivity, String> ActivityCol;

    @FXML
    public AnchorPane profilePane;

    @FXML
    public AnchorPane profileOpacityPane;

    @FXML
    private AnchorPane opacityPane;

    @FXML
    private AnchorPane slidePane;

    @FXML
    private JFXButton btn_doctors;

    @FXML
    private JFXButton btn_lab;

    @FXML
    private JFXButton btn_secretaries;

    @FXML
    private JFXButton btn_analysis_patient;

    @FXML
    private JFXButton btn_ana_Income;

    @FXML
    private JFXButton btn_disease_record;

    @FXML
    private JFXButton btn_work_record;

    @FXML
    private AnchorPane pnl_doctors;

    @FXML
    private AnchorPane pnl_lab;

    @FXML
    private AnchorPane pnl_sec;

    @FXML
    private AnchorPane pnl_work_record;


    @FXML
    private AnchorPane pnl_pie_work;

    @FXML
    private AnchorPane pnl_bar_work;

    @FXML
    private AnchorPane pnl_line_work;

    @FXML
    private AnchorPane pnl_table_work;

    @FXML
    private JFXButton pricingBtn;

    @FXML
    private AnchorPane pnl_price;

    @FXML
    private ImageView exitBtn;

    @FXML
    private BorderPane pnl_analysis_income;

    @FXML
    private BorderPane pnl_analysis_patient;

    @FXML
    private BorderPane pnl_analysis_disease;

    // prices lists
    ObservableList<Pricing> pricings =FXCollections.observableArrayList(new DataLoader().loadPricing());
    // doctor Lists
    ObservableList<Doctor> doctorList;
    // laboratory lists
    ObservableList<Laboratory> laboratoriesList;

    // Secretary List
    ObservableList<Secretary> secretaryList;
    /**
     * Laboratory
     * */

    ObservableList<WorkActivity> list=FXCollections.observableArrayList(new DataLoader().loadActivity());


    @FXML
    public void deleteLaboratoryBtn(ActionEvent event) throws IOException {
        deleteLaboratory();
    }

    @FXML
    public void addLaboratoryBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/LaboratoryRegistration.fxml");
    }

    public void displayLaboratory(){
        laboratoriesList = FXCollections.observableArrayList(new DataLoader().loadLaboratoriestData());
        labNoCol1.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(laboratoryTable.getItems().indexOf(column.getValue())));
        labIDCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, Integer>("laboratoryId"));
        labFullNameCol1.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getFirstName()
                + " " + l.getValue().getLastName()));
        labPhoneCol.setCellValueFactory(new PropertyValueFactory<Laboratory, String>("phoneNumber"));
        labCityCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, String>("city"));
        labAddedDateCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, LocalDate>("addedDate"));
        labStartHrCol1.setCellValueFactory(new PropertyValueFactory<Laboratory,LocalTime>("workingStartTime"));
        labEndHrCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, LocalTime>("workingEndTime"));
        labUserNameCol.setCellValueFactory(new PropertyValueFactory<Laboratory,String>("userName"));
        labPasswordCol.setCellValueFactory(new PropertyValueFactory<Laboratory, String>("password"));
        laboratoryTable.setItems(laboratoriesList);
    }

    private void deleteLaboratory() throws IOException {
        laboratoryTable.setEditable(true);
        Laboratory laboratory = laboratoryTable.getSelectionModel().getSelectedItem();
        if (laboratory != null) {
            new WindowChangeController().warningPopup("Check Deleting", "Are You Sure To delete?","warn_confirm.png");
            if(Warning.isOk) {
                laboratoryTable.getItems().remove(laboratory);
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Laboratory.class)
                        .buildSessionFactory();
                Session session = factory.getCurrentSession();
                try {
                    session.beginTransaction();
                    session.delete(laboratory);
                    session.getTransaction().commit();
                } finally {
                    factory.close();
                    session.close();
                }
                NotificationController.deletedNotification("Laboratories deleted","deleted Successfully","warn_delete.png");
            }
        }else {
            new WindowChangeController().warningPopup("No selection", "There is no Selected Person", "warn_confirm.png");
        }
    }


    /**
     * Doctor
     * */
    public void displayDoctors(){
        doctorList = FXCollections.observableArrayList(new DataLoader().loadDoctorsData());
        noCol.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(doctorTable.getItems().indexOf(column.getValue())));
        docIDCol.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("doctorID"));
        fullNameCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getFirstName()
                + " " + d.getValue().getLastName()));
        docPhoneCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("phoneNumber"));
        docCityCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("city"));
        addedDateCol.setCellValueFactory(new PropertyValueFactory<Doctor, LocalDate>("addedDate"));
        startHrCol.setCellValueFactory(new PropertyValueFactory<Doctor,LocalTime>("workingStartTime"));
        endHrCol.setCellValueFactory(new PropertyValueFactory<Doctor, LocalTime>("workingEndTime"));
        docUserNameCol.setCellValueFactory(new PropertyValueFactory<Doctor,String>("userName"));
        docPasswordCol.setCellValueFactory(new PropertyValueFactory<Doctor, String>("password"));
        doctorTable.setItems(doctorList);
    }

    private void deleteDoctor() throws IOException {
        doctorTable.setEditable(true);
        Doctor doctor = doctorTable.getSelectionModel().getSelectedItem();
        if (doctor != null) {
            new WindowChangeController().warningPopup("Check Deleting", "Are You Sure To delete?","warn_confirm.png");
            if(Warning.isOk){
                doctorTable.getItems().remove(doctor);
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Doctor.class)
                        .buildSessionFactory();

                Session session = factory.getCurrentSession();
                try {

                    session.beginTransaction();
                    session.delete(doctor);
                    session.getTransaction().commit();
                } finally {
                    factory.close();
                    session.close();
                }
                NotificationController.deletedNotification("Doctor deleted","deleted Successfully","warn_delete.png");
            }
        } else {

            new WindowChangeController().warningPopup("No selection", "There is no Selected Person", "warn_confirm.png");
        }
    }

    @FXML
    public void addDoctorBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/DoctorRegistrationWindow.fxml");
    }



    @FXML
    public void deleteDoctorBtn(ActionEvent event) throws IOException {
         deleteDoctor();
    }
    /**
     * Secretary
     * */

    @FXML
    public void addSecretaryBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/SecretaryRegistration.fxml");
    }

    @FXML
    public void deleteSecretaryBtn(ActionEvent event) throws IOException {
        deleteSecretary();
    }

    public void displaySecretary(){
        secretaryList = FXCollections.observableArrayList(new DataLoader().loadSecretariesData());
        secNoCol11.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(secretaryTable1.getItems().indexOf(column.getValue())));
        secIDCol11.setCellValueFactory(new PropertyValueFactory<Secretary, Integer>("secretaryId"));
        secFullNameCol11.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getFirstName()
                + " " + s.getValue().getLastName()));
        secPhoneCol.setCellValueFactory(new PropertyValueFactory<Secretary, String>("phoneNumber"));
        secCityCol.setCellValueFactory(new PropertyValueFactory<Secretary, String>("city"));
        secAddedDateCol11.setCellValueFactory(new PropertyValueFactory<Secretary, LocalDate>("addedDate"));
        secStartHrCol11.setCellValueFactory(new PropertyValueFactory<Secretary,LocalTime>("workingStartTime"));
        secEndHrCol11.setCellValueFactory(new PropertyValueFactory<Secretary, LocalTime>("workingEndTime"));
        secUserNameCol.setCellValueFactory(new PropertyValueFactory<Secretary,String>("userName"));
        secPasswordCol.setCellValueFactory(new PropertyValueFactory<Secretary,String>("password"));
        secretaryTable1.setItems(secretaryList);
    }


    private void deleteSecretary() throws IOException {
        doctorTable.setEditable(true);
        Secretary secretary = secretaryTable1.getSelectionModel().getSelectedItem();
        if (secretary != null) {
            new WindowChangeController().warningPopup("Check Deleting", "Are You Sure To delete?","warn_confirm.png");
            if(Warning.isOk){
                secretaryTable1.getItems().remove(secretary);
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Secretary.class)
                        .buildSessionFactory();

                Session session = factory.getCurrentSession();
                try {

                    session.beginTransaction();
                    session.delete(secretary);
                    session.getTransaction().commit();
                } finally {
                    factory.close();
                    session.close();
                }
            }
            NotificationController.deletedNotification("Secretaries deleted","deleted Successfully","warn_delete.png");

        }else {
            new WindowChangeController().warningPopup("No selection", "There is no Selected Person", "warn_confirm.png");
        }
    }

    /**
     * Price
     * */
    @FXML
    public void cancelBtn(ActionEvent event) {

    }

    @FXML
    void editPriceBtn(ActionEvent event) {
//        editSaveBtn.setText("Save");
        testTable.setEditable(true);
//        editSaveBtn.setVisible(false);
        cellEdit();
    }

    void cellEdit() {
        testNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        testNameCol.setOnEditCommit(event1 -> {
            final String name = event1.getNewValue() != null ? event1.getNewValue() :
                    event1.getOldValue();
            editName(name);
        });
        priceCol.setCellFactory(TextFieldTableCell.<Pricing, Double>forTableColumn(new DoubleStringConverter()));
            priceCol.setOnEditCommit(event1 -> {
                    final Double price = event1.getNewValue() != null ? event1.getNewValue() :
                            event1.getOldValue();
                    editPrice(price);
            });
    }

    void editName(String name){
        Pricing pricing = testTable.getSelectionModel().getSelectedItem();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pricing.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Pricing pricing1 = session.get(Pricing.class, pricing.getPriceId());
            pricing1.setTestName(name);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
    void editPrice(Double price){
        Pricing pricing = testTable.getSelectionModel().getSelectedItem();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pricing.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Pricing pricing1 = session.get(Pricing.class, pricing.getPriceId());
            pricing1.setPrice(price);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
    private void displayPrice(){
        testIdCol.setCellValueFactory(new PropertyValueFactory<Pricing, Integer>("priceId"));
        testNameCol.setCellValueFactory(new PropertyValueFactory<Pricing,String>("testName"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Pricing, Double>("price"));
        testTable.setEditable(true);
        ObservableList<Pricing> pricingList = FXCollections.observableArrayList();
        for(Pricing pricing: pricings){
            pricingList.add(pricing);
        }
        testTable.setItems(pricingList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableOperation();
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        opacityPane.setVisible(false);
        TransitionController.translateTransition(slidePane, -600, 0.5);
        TransitionController.translation(slidePane,1,0,0.1);
        opacityPane.setOnMouseClicked(event -> {
            translateTransitionBack(slidePane, -600, 1);
        });

        profileOpacityPane.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });

        exitBtn.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });
        displayPrice();
        displayDoctors();
        displayLaboratory();
        displaySecretary();
    }

    public void translateTransitionBack(AnchorPane pane, double move, double sec){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(sec),pane);
        translateTransition.setByX(move);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane.setVisible(false);
        });
    }
    @FXML
    void OptionAction(ActionEvent event) {
        opacityPane.setVisible(true);
        slidePane.setVisible(true);
        TransitionController.translation(slidePane,0,1,0.1);
        TransitionController.translateTransition(slidePane, 600, 1);
    }

    @FXML
    void profileHandler(ActionEvent event) {
        translateTransitionBack(slidePane,-600,1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Checking", "Are you sure to Sign Out?", "warn_confirm.png");
        if (Warning.isOk) {
            new WindowChangeController().signOut(event,"../view/Login.fxml");
       }
    }

    private void changeInnerWindow(boolean docWindow, boolean labWindow, boolean secWindow, boolean incomeWindow, boolean patient, boolean disease, boolean work, boolean pricing){
        pnl_doctors.setVisible(docWindow);
        pnl_lab.setVisible(labWindow);
        pnl_sec.setVisible(secWindow);
        pnl_analysis_income.setVisible(incomeWindow);
        pnl_analysis_patient.setVisible(patient);
        pnl_analysis_disease.setVisible(disease);
        pnl_work_record.setVisible(work);
        pnl_price.setVisible(pricing);

    }

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == btn_doctors){
            displayDoctors();
            changeInnerWindow(true,false,false,false,false,false,false,false);
        }
        else if(event.getSource() == btn_lab){
            displayLaboratory();
            changeInnerWindow(false,true,false,false,false,false,false,false);

        }
        else if(event.getSource() == btn_secretaries){
            displaySecretary();
            changeInnerWindow(false,false,true,false,false,false,false, false);

        }
        else if(event.getSource() == btn_ana_Income){
            changeInnerWindow(false,false,false,true,false,false,false,false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/IncomeAnalysis.fxml"));
            AnchorPane root = loader.load();
            pnl_analysis_income.setCenter(root);

        }
        else if(event.getSource() == btn_analysis_patient){
            changeInnerWindow(false,false,false,false,true,false,false,false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/PatientAnalysis.fxml"));
            AnchorPane root = loader.load();
            pnl_analysis_patient.setCenter(root);

        }
        else if(event.getSource() == btn_disease_record){
            changeInnerWindow(false,false,false,false,false,true,false,false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DiseaseRecord.fxml"));
            AnchorPane root = loader.load();
            pnl_analysis_disease.setCenter(root);

        }
        else if(event.getSource() == btn_work_record){
            changeInnerWindow(false,false,false,false,false,false,true,false);
            gotoTableViewWork();

        }
        else if(event.getSource() == pricingBtn){
            changeInnerWindow(false,false,false,false,false,false,false,true);
        }
    }


    @FXML
    void gotoTableViewWork(){
        pnl_table_work.setVisible(true);
        pnl_table_work.toFront();
    }




    public void TableOperation(){
        list=FXCollections.observableArrayList(new DataLoader().loadActivity());
        ActiveCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,Integer>("ActivityId"));
        DateCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,LocalDate>("Activity_day"));
        PatientIdCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,Integer>("PatientId"));
        SecretaryIdCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,Integer>("SecretaryId"));
        DotorIdCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,Integer>("DoctorId"));
        LabIdCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,Integer>("LabTechnicianId"));
        ActivityCol.setCellValueFactory(new PropertyValueFactory<WorkActivity,String>("Activity"));
        workTableView.setItems(list);
        workTableView.setRowFactory(tv -> {
            TableRow<WorkActivity> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    WorkActivity rowData = workTableView.getSelectionModel().getSelectedItem(); //get the object in the row and assign it to patient object
                    try {

                        new WindowChangeController().popupWindow0(event, "../View/ActivityWindow.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
//                         new WindowChangeController().popupWindow1(event, "../View/DocLabResultView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }



}





