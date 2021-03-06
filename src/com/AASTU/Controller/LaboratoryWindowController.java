package com.AASTU.Controller;

import com.AASTU.Main;
import com.AASTU.Model.Laboratory;
import com.AASTU.Model.Patient;
import com.AASTU.utils.DatabaseThread;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.AASTU.Controller.NotificationController.searchFieldHandler;

public class LaboratoryWindowController implements Initializable {

    private static Laboratory currentLaboratory;
    // profile
    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField phonTf;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXTextField genderTf;

    @FXML
    private JFXTextField srartHrTf;

    @FXML
    private JFXTextField endHrTf;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField proUserNameTf;

    @FXML
    private JFXTextField passwordTf;

    @FXML
    private JFXButton editBtn;


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

    private boolean isOnActive = false;
    private boolean isOnPending = true;
    private boolean isOnRecord = false;
    private boolean isOnWaiting = false;

    ObservableList<Patient> pendingPatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where labActives = 1 and onWaiting = 0"));
    ObservableList<Patient> activePatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where labActives = 1"));

    //sending sql command for the database concatenating with the laboratoryid to filter out Patients that are treated by this Technician
    ObservableList<Patient> recordedDataPatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where outPatient = 0"));
    ObservableList<Patient> waitingPatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where labActives = 1 and onWaiting=1"));

    public static Laboratory getCurrentLaboratory() {
        return currentLaboratory;
    }

    public static void setCurrentLaboratory(Laboratory currentLaboratory) {
        LaboratoryWindowController.currentLaboratory = currentLaboratory;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseThread.start();

        VisibilityTest();
        populatePendingTable(pendingPatientList);
        searchFieldHandler(pendingPatientList,PendingPatientTableView,PatientSearchTF);
        displayProfile();

        profilePane.setVisible(false);
        profileOpacityPane.setVisible(false);
        coverPane.setVisible(false);
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
        refreshTable();
    }

    private void refreshTable() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int pendingPatientListSize = pendingPatientList.size();
                int activePatientListSize = activePatientList.size();
                int recordedDataPatientListSize = recordedDataPatientList.size();
                int waitingPatientListSize = waitingPatientList.size();
                while (DatabaseThread.RUNNING) {
                    Thread.sleep(1000);
                    if(isOnPending) {
                        pendingPatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where labActives = 1 and onWaiting = 0"));
                        if(pendingPatientListSize != pendingPatientList.size()) {
                            Platform.runLater(() -> {
                                populatePendingTable(pendingPatientList);
                            });
                            pendingPatientListSize = pendingPatientList.size();
                        }
                    }
                    else if(isOnActive) {
                        activePatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where labActives = 1"));
                        if(activePatientListSize != activePatientList.size()){
                            Platform.runLater(() -> {
                                populateActivePatientTable(activePatientList);
                            });
                            activePatientListSize = activePatientList.size();
                        }
                    }
                    else if(isOnWaiting) {
                        waitingPatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where labActives = 1 and onWaiting=1"));
                        if(waitingPatientListSize != waitingPatientList.size()) {
                            Platform.runLater(()  -> {
                                populateWaitingPatient(waitingPatientList);
                            });
                            waitingPatientListSize = waitingPatientList.size();
                        }
                    }
                    else if(isOnRecord) {
                        recordedDataPatientList = FXCollections.observableArrayList(new DataLoader().loadSpecificPatientData("from Patient where outPatient = 0"));
                        if(recordedDataPatientListSize != recordedDataPatientList.size()){
                            Platform.runLater(() -> {
                               populateRecordTable(recordedDataPatientList);
                            });
                            recordedDataPatientListSize = recordedDataPatientList.size();
                        }
                    }
                }
                return null;
            }
        };
        Thread dbThread = new Thread(task);
        dbThread.setDaemon(true);
        dbThread.start();
    }

    void goToView(boolean active, boolean pending, boolean record, boolean waiting){
        pendingPnl.setVisible(pending);
        isOnPending = pending;
        waitingPnl.setVisible(waiting);
        isOnWaiting = waiting;
        activePnl.setVisible(active);
        isOnActive = active;
        recordPnl.setVisible(record);
        isOnRecord = record;
    }

    @FXML
    void handleActiveButton(ActionEvent event) {
        //some specification will be done here to access Active Patients only
        activePatientList =FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where labActives = 1"));
        populateActivePatientTable(activePatientList);
        goToView(true,false,false,false);
        activePnl.toFront();
        searchFieldHandler(activePatientList,ActivePatientTableView,PatientSearchTF);
        SearchField();

    }

    @FXML
    void handlePendingButton(ActionEvent event) {
        //some Specification will be done here to access only Pending Patients
        pendingPatientList = FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where labActives = 1 and onWaiting = 0"));
        populatePendingTable(pendingPatientList);
        goToView(false,true,false,false);
        SearchField();
        pendingPnl.toFront();
        searchFieldHandler(pendingPatientList,PendingPatientTableView,PatientSearchTF);
    }

    @FXML
    void handleRecordButton(ActionEvent event) {
        //Some specification will be done here To Access Patients that are treated by Specific Laboratory Technician
        recordedDataPatientList =FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient"));
        populateRecordTable(recordedDataPatientList);
        goToView(false,false,true,false);
        SearchField();
        recordPnl.toFront();
        searchFieldHandler(recordedDataPatientList,RecordedPatientTableView,PatientSearchTF);
    }

    @FXML
    void handleWaitingButton(ActionEvent event) {
        //some specification wil be done here to access only waiting Patients from the whole lists
        waitingPatientList =FXCollections.observableArrayList(Main.controller1.loadSpecificPatientData("from Patient where labActives = 1 and onWaiting = 1"));
        populateWaitingPatient(waitingPatientList);
        goToView(false,false, false,true);
        SearchField();
        waitingPnl.toFront();
        searchFieldHandler(waitingPatientList,WaitingPatientTableView,PatientSearchTF);
    }

    public void VisibilityTest(){
        pendingPnl.setVisible(true);
        waitingPnl.setVisible(false);
        activePnl.setVisible(false);
        recordPnl.setVisible(false);
    }

    public void populateWaitingPatient(ObservableList<Patient> WaitingPatientList){

        WaitingPatientTableView.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = WaitingPatientTableView.getSelectionModel().getSelectedItem(); //get the object in the row and assign it to patient object
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

    private void populateRecordTable(ObservableList<Patient> RecordedDataPatientList) {
        RecordedPatientTableView.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = RecordedPatientTableView.getSelectionModel().getSelectedItem(); //get the object in the row and assign it to patient object
                    try {
                        new WindowChangeController().PopUpLabRecord(event, "../View/LabToDocView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
//                         new WindowChangeController().popupWindow1(event, "../View/DocLabResultView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
        /**Recorded Patient on the laboratory Technician Id **/
        RecordKebeleCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("kebele"));
        RecordSubCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("subcity"));
        RecordAddDateCol.setCellValueFactory(new PropertyValueFactory<Patient, Date>("date"));
        RecordAgeCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        RecordFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        RecordLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        RecordOrderNoCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        RecordSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        RecordPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        RecordCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        RecordedPatientTableView.setItems(RecordedDataPatientList);
    }

    private void populateActivePatientTable(ObservableList<Patient> ActivePatientList) {
        /**Active Patient Table List Operation**/
        ActiveKebeleCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("kebele"));
        ActiveSubCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("subcity"));
        ActiveAddDateCol.setCellValueFactory(new PropertyValueFactory<Patient, Date>("date"));
        ActiveAgeCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        ActiveFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        ActiveLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        ActiveOrderNoCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        ActiveSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        ActivePhoneNumberCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        ActiveCityCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        ActivePatientTableView.setItems(ActivePatientList);
    }

    private void populatePendingTable(ObservableList<Patient> PendingPatientList) {
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
        PendingAddDateCol.setCellValueFactory(new PropertyValueFactory<Patient, Date>("date"));
        PendingAgecol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("age"));
        PendingFirstNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        PendingLastNameCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        PendingOrderNoCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("patientId"));
        PendingSexCol.setCellValueFactory(new PropertyValueFactory<Patient,Character>("sex"));
        PendingPhoneNumbelCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
        PendingCitycol.setCellValueFactory(new PropertyValueFactory<Patient,String>("City"));
        PendingPatientTableView.setItems(PendingPatientList);

    }

    public void SearchField(){
        FilteredList<Patient> Pending_PatientList=new FilteredList<>(pendingPatientList, p ->true);
        FilteredList<Patient> Waiting_PatientList=new FilteredList<>(waitingPatientList, p ->true);
        FilteredList<Patient> Active_PatientList=new FilteredList<>(activePatientList, p ->true);
        FilteredList<Patient> Record_PatientList=new FilteredList<>(recordedDataPatientList, p ->true);
        FilteredList<Patient> list;
        TableView<Patient> TableViews;
// conditions that are checked on the visibility of AnchorPanes

        if(pendingPnl.isVisible()){

            list=Pending_PatientList;
            TableViews=PendingPatientTableView;

        }else if(waitingPnl.isVisible()){

            list=Waiting_PatientList;
            TableViews=WaitingPatientTableView;
        }
        else if(activePnl.isVisible()){

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
        editBtn.setText("Edit");
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

    public void editProfile() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Laboratory.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            Laboratory laboratory = session.get(Laboratory .class, currentLaboratory.getLaboratoryId());
            laboratory.setFirstName(firstNameTf.getText());
            laboratory.setLastName(lastNameTf.getText());
            laboratory.setPassword(passwordTf.getText());
            laboratory.setSex(genderTf.getText().toLowerCase().charAt(0));
            laboratory.setPhoneNumber(phonTf.getText());
            laboratory.setCity(cityTf.getText());
            laboratory.setUserName(proUserNameTf.getText());
            if(compareLaboratoryObjs(laboratory,currentLaboratory)){
                new WindowChangeController().warningPopup("Checking", "You Didn't Make any change?", "warn_confirm.png");
            }else {
                if(ExceptionHandler.validatUserInput(firstNameTf.getText(),lastNameTf.getText(),passwordTf.getText(),genderTf.getText(),cityTf.getText(),phonTf.getText(),proUserNameTf.getText())){
                    new WindowChangeController().warningPopup("Checking", "Are you sure to save your Edit?", "warn_confirm.png");
                    if(Warning.isOk){
                        session.getTransaction().commit();
                        NotificationController.savedNotification("Profile Edited","Profile Updated successfully!","warn_confirm.png");
                    }
                }else {
                    new WindowChangeController().warningPopup("Validate Fields", "Please Fill the fields! ","warn_confirm.png");
                }
            }
        } finally {
            factory.close();
            session.close();
        }
    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
        new WindowChangeController().warningPopup("Checking", "Are you sure to Sign Out?", "warn_confirm.png");
        if (Warning.isOk) {
            new WindowChangeController().signOut(event, "../view/Login.fxml");
        }
        DatabaseThread.terminate();
    }

    private boolean compareLaboratoryObjs(Laboratory obj1, Laboratory obj2){
        if(Objects.equals(obj1.getFirstName().toLowerCase(), obj2.getFirstName().toLowerCase()) && Objects.equals(obj1.getLastName().toLowerCase(), obj2.getLastName().toLowerCase()) &&
                Objects.equals(obj1.getUserName().toLowerCase(), obj2.getUserName().toLowerCase()) &&  Objects.equals(obj1.getPassword().toLowerCase(), obj2.getPassword().toLowerCase()) &&
                Objects.equals(obj1.getPhoneNumber(), obj2.getPhoneNumber()) && Objects.equals(obj1.getSex(), obj2.getSex()) &&  Objects.equals(obj1.getCity().toLowerCase(), obj2.getCity().toLowerCase())){
            return true;
        }
        return false;
    }

    @FXML
    void canceProlHandler(ActionEvent event) {

    }

    @FXML
    void editProHandler(ActionEvent event) throws IOException {
        textFieldStatus(true);
        if(editBtn.getText().equals("Save")){
            editProfile();
        }
        editBtn.setText("Save");
    }

    // profile Handler
    private void textFieldStatus(boolean status) {
        firstNameTf.setEditable(false);
        lastNameTf.setEditable(false);
        passwordTf.setEditable(status);
        genderTf.setEditable(false);
        cityTf.setEditable(false);
        proUserNameTf.setEditable(status);
        phonTf.setEditable(false);
        srartHrTf.setEditable(false);
        endHrTf.setEditable(false);

    }

    public void displayProfile(){
        textFieldStatus(false);
        String startTime = new DataLoader().formatTime(currentLaboratory.getWorkingStartTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        String endTime = new DataLoader().formatTime(currentLaboratory.getWorkingEndTime().format(DateTimeFormatter.ofPattern("HH:mm"))) ;
        String sex = null;
        if(currentLaboratory.getSex() == 'm') {
            sex = "Male";
        }else if(currentLaboratory.getSex() == 'f'){
            sex = "Female";
        }
        firstNameTf.setText(currentLaboratory.getFirstName());
        lastNameTf.setText(currentLaboratory.getLastName());
        genderTf.setText(sex);
        passwordTf.setText(currentLaboratory.getPassword());
        srartHrTf.setText(startTime);
        endHrTf.setText(endTime);
        phonTf.setText(currentLaboratory.getPhoneNumber());
        cityTf.setText(currentLaboratory.getCity());
        proUserNameTf.setText(currentLaboratory.getUserName());
    }

}
