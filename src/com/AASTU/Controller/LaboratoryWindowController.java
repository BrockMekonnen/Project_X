package com.AASTU.Controller;

import com.AASTU.Main;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class LaboratoryWindowController implements Initializable {

    @FXML
    private TableView<Patient> PendingPatientTableView,WaitingPatientTableView,ActivePatientTableView,RecordedPatientTableView;

    @FXML
    private TableColumn<Patient, Integer> PendingOrderNoCol,WaitingNoOrderCol,ActiveOrderNoCol,RecordOrderNoCol;

    @FXML
    private TableColumn<Patient, String> PendingFirstNameCol,WaitingFirstNameCol,ActiveFirstNameCol,RecordFirstNameCol;

    @FXML
    private TableColumn<Patient, String> PendingLastNameCol,WaitingLastNameCol,ActiveLastNameCol,RecordLastNameCol;

    @FXML
    private TableColumn<Patient, Character> PendingSexCol,WaitingSexCol,ActiveSexCol,RecordSexCol;

    @FXML
    private TableColumn<Patient, Integer> PendingAgecol,WaitingAgeCol,ActiveAgeCol,RecordAgeCol;

    @FXML
    private TableColumn<Patient, Date> PendingAddDateCol,WaitingAddedDateCol,ActiveAddDateCol,RecordAddDateCol;

    @FXML
    private TableColumn<Patient, String> PendingPhoneNumbelCol,WaitingPhoneNumberCol,ActivePhoneNumberCol,RecordPhoneNumberCol;

    @FXML
    private TableColumn<Patient, String> PendingCitycol,WaitingCityCol,ActiveCityCol,RecordCityCol;

    @FXML
    private TableColumn<Patient, String> PendingSubCityCol,WaitingSubCityCol,ActiveSubCityCol,RecordSubCityCol;

    @FXML
    private TableColumn<Patient, String> PendingKebeleCol,WaitingKebeleCol,ActiveKebeleCol,RecordKebeleCol;

    @FXML
    private JFXComboBox<?> comboTime;

    @FXML
    private JFXComboBox<?> comboTimeEnd;


    @FXML
    public AnchorPane profilePane;

    @FXML
    public AnchorPane profileOpacityPane;

    @FXML
    private JFXButton navBtn;

    @FXML
    private AnchorPane coverPane;

    @FXML
    private AnchorPane AccountSettingPane;

    @FXML
    private ImageView exitBtn;

    @FXML
    private JFXButton pendingBtn;

    @FXML
    private JFXButton waitingBtn;

    @FXML
    private JFXButton activeBtn;

    @FXML
    private JFXButton recordBtn;

    @FXML
    private AnchorPane pendingPnl;

    @FXML
    private AnchorPane waitingPnl;

    @FXML
    private AnchorPane activePnl;

    @FXML
    private AnchorPane recordPnl;

     ObservableList<Patient> PendingPatientList=FXCollections.observableArrayList(Main.controller1.loadPatientData());
     ObservableList<Patient> ActivePatientList=FXCollections.observableArrayList(Main.controller1.loadPatientData());
     ObservableList<Patient> RecordedDataPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificData("from Patient where id=12"));
     ObservableList<Patient> WaitingPatientList=FXCollections.observableArrayList(Main.controller1.loadPatientData());
    void goToView(boolean active, boolean pending, boolean record, boolean waiting){
        pendingPnl.setVisible(pending);
        waitingPnl.setVisible(waiting);
        activePnl.setVisible(active);
        recordPnl.setVisible(record);
    }

    @FXML
    void handleActiveButton(ActionEvent event) {
        //some specification will be done here to access Active Patients only
        ActivePatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificData("from Patient where id=13"));
        goToView(true,false,false,false);
        activePnl.toFront();
    }

    @FXML
    void handlePendingButton(ActionEvent event) {
        //some Specification will be done here to access only Pending Patients
        PendingPatientList= FXCollections.observableArrayList(Main.controller1.loadPatientData());
        goToView(false,true,false,false);
        pendingPnl.toFront();
    }

    @FXML
    void handleRecordButton(ActionEvent event) {
        //Some specification will be done here To Access Patients that are treated by Specific Laboratory Technician
        RecordedDataPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificData("from Patient where id=12"));
        goToView(false,false,true,false);
        recordPnl.toFront();
    }

    @FXML
    void handleWaitingButton(ActionEvent event) {
        //some specification wil be done here to access only waiting Patients from the whole lists
        WaitingPatientList=FXCollections.observableArrayList(Main.controller1.loadPatientData());
        goToView(false,false, false,true);
        waitingPnl.toFront();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        VisibilityTest();
        TableOperation();
        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        coverPane.setVisible(false);
//        translation(0.1);
        TransitionController.translateTransition(AccountSettingPane, -600, 0.5);
        TransitionController.translation(AccountSettingPane,1,0,0.1);
        coverPane.setOnMouseClicked(event -> {
            translateTransitionBack(AccountSettingPane, -600, 1);
        });

        profileOpacityPane.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });

        exitBtn.setOnMouseClicked(event -> {
            TransitionController.exitHandler(profilePane, profileOpacityPane);
        });
    }

    public void VisibilityTest(){
        pendingPnl.setVisible(true);
        waitingPnl.setVisible(false);
        activePnl.setVisible(false);
        recordPnl.setVisible(false);
    }

    public void TableOperation(){
        /** Pending Patient Table List Operation **/
        PendingKebeleCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("kebele"));
        PendingSubCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("subcity"));
        PendingAddDateCol.setCellValueFactory(new PropertyValueFactory<Patient,Date>("date"));
        PendingAgecol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        PendingFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        PendingLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        PendingOrderNoCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        PendingSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        PendingPhoneNumbelCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        PendingCitycol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        PendingPatientTableView.setItems(PendingPatientList);
        /**Active Patient Table List Operation**/
        ActiveKebeleCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("kebele"));
        ActiveSubCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("subcity"));
        ActiveAddDateCol.setCellValueFactory(new PropertyValueFactory<Patient,Date>("date"));
        ActiveAgeCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        ActiveFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        ActiveLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        ActiveOrderNoCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        ActiveSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        ActivePhoneNumberCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        ActiveCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        ActivePatientTableView.setItems(ActivePatientList);
        /**Recorded Patient on the laboratory Technician Id **/
        RecordKebeleCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("kebele"));
        RecordSubCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("subcity"));
        RecordAddDateCol.setCellValueFactory(new PropertyValueFactory<Patient,Date>("date"));
        RecordAgeCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        RecordFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        RecordLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        RecordOrderNoCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        RecordSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        RecordPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        RecordCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        RecordedPatientTableView.setItems(RecordedDataPatientList);
        /**Waiting Patient Table View List**/
        WaitingKebeleCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("kebele"));
        WaitingSubCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("subcity"));
        WaitingAddedDateCol.setCellValueFactory(new PropertyValueFactory<Patient,Date>("date"));
        WaitingAgeCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        WaitingFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        WaitingLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        WaitingNoOrderCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        WaitingSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        WaitingPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        WaitingCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        WaitingPatientTableView.setItems(WaitingPatientList);
    }

    public void translateTransitionBack(AnchorPane pane, double move, double sec){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(sec),pane);
        translateTransition.setByX(move);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            coverPane.setVisible(false);
        });
    }

    public void OptionAction(){
        coverPane.setVisible(true);
        AccountSettingPane.setVisible(true);
        TransitionController.translation(AccountSettingPane,0,1,0.1);
        TransitionController.translateTransition(AccountSettingPane, 600, 1);
    }

    @FXML
    void profileHandler(ActionEvent event) {
        translateTransitionBack(AccountSettingPane,-600,1);
        profileOpacityPane.setVisible(true);
        profilePane.setVisible(true);
    }


    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().signOut(event, "../view/Login.fxml");
    }

}
