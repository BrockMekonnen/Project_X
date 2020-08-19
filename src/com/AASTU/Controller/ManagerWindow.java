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
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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

    // doctor Lists
    List<Doctor> doctorList = new DataLoader().loadDoctorsData();
    // prices lists
    List<Pricing> pricings = new DataLoader().loadPricing();
    // laboratory lists
    List<Laboratory> laboratoriesList = new DataLoader().loadLaboratoriestData();

    // Secretary List
    List<Secretary> secretaryList = new DataLoader().loadSecretariesData();
    /**
     * Laboratory
     * */
    @FXML
    public void deleteLaboratoryBtn(ActionEvent event) {
        deleteLaboratory();
    }

    @FXML
    public void addLaboratoryBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/LaboratoryRegistration.fxml");
    }

    @FXML
    public void editLaboratoryBtn(ActionEvent event) {

    }

    public void displayLaboratory(){
        labNoCol1.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(laboratoryTable.getItems().indexOf(column.getValue())));
        labIDCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, Integer>("laboratoryId"));
        labFullNameCol1.setCellValueFactory(l -> new SimpleStringProperty(l.getValue().getFirstName()
                + " " + l.getValue().getLastName()));
        labAddedDateCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, LocalDate>("addedDate"));
        labStartHrCol1.setCellValueFactory(new PropertyValueFactory<Laboratory,LocalTime>("workingStartTime"));
        labEndHrCol1.setCellValueFactory(new PropertyValueFactory<Laboratory, LocalTime>("workingEndTime"));

        ObservableList<Laboratory> laboratoryObservableList = FXCollections.observableArrayList();
        for(Laboratory doctor: laboratoriesList){
            laboratoryObservableList.add(doctor);
        }
        laboratoryTable.setItems(laboratoryObservableList);
    }

    private void deleteLaboratory() {
        laboratoryTable.setEditable(true);
        Laboratory laboratory = laboratoryTable.getSelectionModel().getSelectedItem();
        if (laboratory != null) {
            doctorTable.getItems().remove(laboratory);
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
        }
    }


    /**
     * Doctor
     * */
    public void displayDoctors(){
        noCol.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(doctorTable.getItems().indexOf(column.getValue())));
        docIDCol.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("doctorID"));
        fullNameCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getFirstName()
                + " " + d.getValue().getLastName()));
        addedDateCol.setCellValueFactory(new PropertyValueFactory<Doctor, LocalDate>("addedDate"));
        startHrCol.setCellValueFactory(new PropertyValueFactory<Doctor,LocalTime>("workingStartTime"));
        endHrCol.setCellValueFactory(new PropertyValueFactory<Doctor, LocalTime>("workingEndTime"));

        ObservableList<Doctor> patientsList = FXCollections.observableArrayList();
        for(Doctor doctor: doctorList){
            patientsList.add(doctor);
        }
            doctorTable.setItems(patientsList);
    }
    private void deleteDoctor() {
        doctorTable.setEditable(true);
        Doctor doctor = doctorTable.getSelectionModel().getSelectedItem();
        if (doctor != null) {
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
        }
    }

    @FXML
    public void addDoctorBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/DoctorRegistrationWindow.fxml");
    }


    @FXML
    public void editDoctorBtn(ActionEvent event) throws IOException {
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

    @FXML
    public void editSecretaryBtn(ActionEvent event) throws IOException {
    }

    public void displaySecretary(){
        secNoCol11.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(secretaryTable1.getItems().indexOf(column.getValue())));
        secIDCol11.setCellValueFactory(new PropertyValueFactory<Secretary, Integer>("secretaryId"));
        secFullNameCol11.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getFirstName()
                + " " + s.getValue().getLastName()));
        secAddedDateCol11.setCellValueFactory(new PropertyValueFactory<Secretary, LocalDate>("addedDate"));
        secStartHrCol11.setCellValueFactory(new PropertyValueFactory<Secretary,LocalTime>("workingStartTime"));
        secEndHrCol11.setCellValueFactory(new PropertyValueFactory<Secretary, LocalTime>("workingEndTime"));

        ObservableList<Secretary> secretaryObservableList = FXCollections.observableArrayList();
        for(Secretary secretary: secretaryList){
            secretaryObservableList.add(secretary);
        }
        secretaryTable1.setItems(secretaryObservableList);
    }
    private void deleteSecretary() {
        doctorTable.setEditable(true);
        Secretary secretary = secretaryTable1.getSelectionModel().getSelectedItem();
        if (secretary != null) {
            doctorTable.getItems().remove(secretary);
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
    }

    /**
     * Price
     * */
    @FXML
    public void cancelBtn(ActionEvent event) {

    }

    @FXML
    void editPriceBtn(ActionEvent event) {
        editSaveBtn.setText("Save");
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
            new WindowChangeController().signOut(event,"../view/Login.fxml");
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
            changeInnerWindow(true,false,false,false,false,false,false,false);
        }
        else if(event.getSource() == btn_lab){
            changeInnerWindow(false,true,false,false,false,false,false,false);

        }
        else if(event.getSource() == btn_secretaries){
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
    @FXML
    void goToTableViewWork(ActionEvent event){
        goToWork(true, false, false, false);
        pnl_table_work.toFront();

    }
    @FXML
    void goToBarChartViewWork(ActionEvent event){
        goToWork(false, false, true, false);
        pnl_bar_work.toFront();

    }
    @FXML
    void goToPieChartViewWork(ActionEvent event){
        goToWork(false,true,false,false);
        pnl_pie_work.toFront();

    }
    @FXML
    void goToLineChartViewWork(ActionEvent event){
        goToWork(false, false, false, true);
        pnl_line_work.toFront();
    }

    private void goToWork(boolean table, boolean pie, boolean bar, boolean line){
        pnl_table_work.setVisible(table);
        pnl_pie_work.setVisible(pie);
        pnl_bar_work.setVisible(bar);
        pnl_line_work.setVisible(line);
    }


}





