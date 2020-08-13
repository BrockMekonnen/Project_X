package com.AASTU.Controller;

import com.AASTU.Main;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
    public TableView<Patient> PendingPatientTableView,WaitingPatientTableView,ActivePatientTableView,RecordedPatientTableView;

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
    private JFXTextField PatientSearchTF;

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

    //The Id of Laboratory Technician አሁን የገባው hahaha
    public static String LaboratoryId="12";

     ObservableList<Patient> PendingPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where docActives = 1"));
     ObservableList<Patient> ActivePatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where docActives = 1"));

     //sending sql command for the database concatenating with the laboratoryid to filter out Patients that are treated by this Technician
     ObservableList<Patient> RecordedDataPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where id="+LaboratoryId));
     ObservableList<Patient> WaitingPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where docActives = 1"));
    void goToView(boolean active, boolean pending, boolean record, boolean waiting){
        pendingPnl.setVisible(pending);
        waitingPnl.setVisible(waiting);
        activePnl.setVisible(active);
        recordPnl.setVisible(record);
    }

    @FXML
    void handleActiveButton(ActionEvent event) {
        //some specification will be done here to access Active Patients only
        ActivePatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where labActives=1"));
        SearchField();
        goToView(true,false,false,false);
        activePnl.toFront();
    }

    @FXML
    void handlePendingButton(ActionEvent event) {
        //some Specification will be done here to access only Pending Patients
        PendingPatientList= FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where docActives = 1 and OnWaiting = 0"));
        SearchField();
        goToView(false,true,false,false);
        pendingPnl.toFront();
    }

    @FXML
    void handleRecordButton(ActionEvent event) {
        //Some specification will be done here To Access Patients that are treated by Specific Laboratory Technician
        RecordedDataPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where id="+LaboratoryId));
        SearchField();
        goToView(false,false,true,false);
        recordPnl.toFront();
    }

    @FXML
    void handleWaitingButton(ActionEvent event) {
        //some specification wil be done here to access only waiting Patients from the whole lists
        WaitingPatientList=FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where docActives = 1 and onWaiting = 1"));
        SearchField();
        goToView(false,false, false,true);
        waitingPnl.toFront();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        VisibilityTest();
        //For table operations or assignments
        TableOperation();
        //Used for text field searching
        SearchField();
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

        PendingPatientTableView.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = PendingPatientTableView.getSelectionModel().getSelectedItem(); //get the object in the row and assign it to patient object
                    try {
                        new WindowChangeController().popupWindow1(event, "../View/LabToDocView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

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
//        ActivePatientTableView.setRowFactory(tv -> {
//            TableRow<Patient> row = new TableRow<>(); // get the row
//            row.setOnMouseClicked(event -> {
//                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
//                    Patient rowData = PendingPatientTableView.getSelectionModel().getSelectedItem(); //get the object in the row and assign it to patient object
//                    try {
//
//                        new WindowChangeController().popupWindow1(event, "../View/LabToDocView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
//
////                         new WindowChangeController().popupWindow1(event, "../View/DocLabResultView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            return row ;
//        });
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
        WaitingPatientTableView.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = PendingPatientTableView.getSelectionModel().getSelectedItem(); //get the object in the row and assign it to patient object
                    try {

                        new WindowChangeController().popupWindow1(event, "../View/LabToDocView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
//                         new WindowChangeController().popupWindow1(event, "../View/DocLabResultView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
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

    public void SearchField(){
        FilteredList<Patient> Pending_PatientList=new FilteredList<>(PendingPatientList, p ->true);
        FilteredList<Patient> Waiting_PatientList=new FilteredList<>(WaitingPatientList, p ->true);
        FilteredList<Patient> Active_PatientList=new FilteredList<>(ActivePatientList, p ->true);
        FilteredList<Patient> Record_PatientList=new FilteredList<>(RecordedDataPatientList, p ->true);
        FilteredList<Patient> list;
        TableView<Patient> TableViews;
// conditions that are checked on the visibility of AnchorPanes

        if(pendingPnl.isVisible()==true){

            list=Pending_PatientList;
            TableViews=PendingPatientTableView;

        }else if(waitingPnl.isVisible()==true){

            list=Waiting_PatientList;
            TableViews=WaitingPatientTableView;
        }
        else if(activePnl.isVisible()==true){

            list=Active_PatientList;
            TableViews=ActivePatientTableView;

        }else{

            list=Record_PatientList;
            TableViews=RecordedPatientTableView;

        }

        PatientSearchTF.textProperty().addListener(((observable, oldValue, newValue) -> {
            list.setPredicate(myObject ->{
                if (newValue==null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter=newValue.toLowerCase();
                if(String.valueOf(myObject.getFirstName()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(String.valueOf(myObject.getLastName()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(String.valueOf(myObject.getPhoneNumber()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        }
        ));
        // sorted value of filtered list and add the list value to the table list
        SortedList<Patient> sortedList=new SortedList<>(list);
        sortedList.comparatorProperty().bind(TableViews.comparatorProperty());
        TableViews.setItems(sortedList);
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
