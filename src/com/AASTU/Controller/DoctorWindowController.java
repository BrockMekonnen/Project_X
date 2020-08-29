package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DoctorWindowController implements Initializable {

    private static Doctor currentDoctor;
    // profile
    @FXML
    private ImageView exitBtn;

    @FXML
    private JFXTextField firstNameTf;

    @FXML
    private JFXTextField phonTf;

    @FXML
    private JFXTextField lastNameTf;

    @FXML
    private JFXTextField genderTf;

    @FXML
    private JFXTextField startHrTf;

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
    public AnchorPane profilePane;

    @FXML
    public AnchorPane profileOpacityPane;

    @FXML
    private AnchorPane slidePane;

    @FXML
    private AnchorPane opacityPane;

    @FXML
    private AnchorPane pendingPnl;

    @FXML
    private AnchorPane recordPnl;

    @FXML
    private JFXComboBox<?> comboTime;

    @FXML
    private JFXComboBox<?> comboTimeEnd;

    @FXML
    private TableView<Patient> pendingTable;

    @FXML
    private TableColumn<Patient, Integer> columnId;

    @FXML
    private TableColumn<Patient, String> columnFirst;

    @FXML
    private TableColumn<Patient, String> columnLast;

    @FXML
    private TableColumn<Patient, Character> columnSex;

    @FXML
    private TableColumn<Patient, Integer> columnAge;

    @FXML
    private TableColumn<DiseaseRecord, LocalDate> columnDate;

    @FXML
    private TableColumn<DiseaseRecord, String> columnDisease;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnless1;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column1to4;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column5to14;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column14to29;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column28to64;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnGreater63;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnFless1;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF1to4;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF5to14;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF14to29;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF28to64;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnFgreater63;

    @FXML
    private TableView<DiseaseRecord> diseaseTable;

    @FXML
    private TableView<Patient> recordTable;

    @FXML
    private TableColumn<Patient, Integer> columnRecordId;

    @FXML
    private TableColumn<Patient, String> columnRecordFirst;

    @FXML
    private TableColumn<Patient, String> columnRecordLast;

    @FXML
    private TableColumn<Patient, Character> columnRecordSex;

    @FXML
    private TableColumn<Patient, Integer> columnRecordAge;

    @FXML
    private TableColumn<Patient, LocalDate> columnRecordDate;

    @FXML
    private JFXButton allDiseaseBtn;

    @FXML
    private BorderPane diseasePane;


    public static Doctor getCurrentDoctor() {
        return currentDoctor;
    }

    public static void setCurrentDoctor(Doctor currentDoctor) {
        DoctorWindowController.currentDoctor = currentDoctor;
    }

    public int DoctorId=22;


    private void populateRecordTable(){
        columnRecordId.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        columnRecordDate.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("date"));
        columnRecordFirst.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        columnRecordLast.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        columnRecordSex.setCellValueFactory(new PropertyValueFactory<Patient, Character>("sex"));
        columnRecordAge.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        ObservableList<Patient> observableList = FXCollections.observableArrayList();
        List<Patient> patientList = new DataLoader().loadSpecificPatientData("from Patient where patientStatus = 0");
        for(Patient temp: patientList){
            observableList.add(temp);
        }
        recordTable.setItems(observableList);
    }


//    private void populateDiseaseTable(List<DiseaseRecord> diseaseRecordList){
//        ObservableList<DiseaseRecord> observableList = FXCollections.observableArrayList();
//
//        columnDate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, LocalDate>, ObservableValue<LocalDate>>() {
//            @Override
//            public ObservableValue<LocalDate> call(TableColumn.CellDataFeatures<DiseaseRecord, LocalDate> param) {
//                return param.getValue().getDate();
//            }
//        });
//
//        columnDisease.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<DiseaseRecord, String> param) {
//                return param.getValue().getDiseaseName();
//            }
//        });
//
//        columnless1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().mLess1ForTable();
//            }
//        });
//
//        column1to4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().M1to4ForTable();
//            }
//        });
//
//        column5to14.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().M5to14ForTable();
//            }
//        });
//
//        column14to29.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().M15to29ForTable();
//            }
//        });
//
//        column28to64.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().M30to64ForTable();
//            }
//        });
//
//        columnGreater63.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().mGreater65ForTable();
//            }
//        });
//
//        columnFless1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().fLess1ForTable();
//            }
//        });
//
//        columnF1to4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().F1to4ForTable();
//            }
//        });
//
//        columnF5to14.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().F5to14ForTable();
//            }
//        });
//
//        columnF14to29.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().F15to29ForTable();
//            }
//        });
//
//        columnF28to64.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().F30to64ForTable();
//            }
//        });
//
//        columnFgreater63.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
//            @Override
//            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
//                return param.getValue().fGreater65ForTable();
//            }
//        });
//
//        for(DiseaseRecord temp: diseaseRecordList){
//            observableList.add(temp);
//        }
//
//        diseaseTable.setItems(observableList);
//    }

    /* this function inserts data from the database to the pendingTable */
    private void populatePendingTable(String command){

        pendingTable.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = row.getItem(); //get the object in the row and assign it to patient object
                    try {
                        new WindowChangeController().popupWindow(event, "../View/DoctorPatientView.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

        columnId.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        columnFirst.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        columnLast.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        columnSex.setCellValueFactory(new PropertyValueFactory<Patient, Character>("sex"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        ObservableList<Patient> observableList = FXCollections.observableArrayList();
        List<Patient> patientList = new DataLoader().loadSpecificPatientData(command); // get list of data from the database
        for(Patient temp: patientList){
            observableList.add(temp); // change each object from list to observableList
        }
        pendingTable.setItems(observableList);
    }
    // profile handler
    private void textFieldStatus(boolean status) {
        firstNameTf.setEditable(false);
        lastNameTf.setEditable(false);
        passwordTf.setEditable(status);
        genderTf.setEditable(false);
        cityTf.setEditable(false);
        proUserNameTf.setEditable(status);
        phonTf.setEditable(false);
        startHrTf.setEditable(false);
        endHrTf.setEditable(false);
    }

    public void displayProfile(){
        textFieldStatus(false);
        String startTime = new DataLoader().formatTime(currentDoctor.getWorkingStartTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        String endTime = new DataLoader().formatTime(currentDoctor.getWorkingEndTime().format(DateTimeFormatter.ofPattern("HH:mm"))) ;
        String sex = null;
        if(currentDoctor.getSex() == 'm') {
            sex = "Male";
        }else if(currentDoctor.getSex() == 'f'){
            sex = "Female";
        }
        firstNameTf.setText(currentDoctor.getFirstName());
        lastNameTf.setText(currentDoctor.getLastName());
        passwordTf.setText(currentDoctor.getPassword());
        genderTf.setText(sex);
        startHrTf.setText(startTime);
        endHrTf.setText(endTime);
        phonTf.setText(currentDoctor.getPhoneNumber());
        cityTf.setText(currentDoctor.getCity());
        proUserNameTf.setText(currentDoctor.getUserName());
    }

    @FXML
    void cancelProHandler(ActionEvent event) {

    }

    private boolean compareDoctorsObjs(Doctor obj1, Doctor obj2){
        if(Objects.equals(obj1.getFirstName().toLowerCase(), obj2.getFirstName().toLowerCase()) && Objects.equals(obj1.getLastName().toLowerCase(), obj2.getLastName().toLowerCase()) &&
           Objects.equals(obj1.getUserName().toLowerCase(), obj2.getUserName().toLowerCase()) &&  Objects.equals(obj1.getPassword().toLowerCase(), obj2.getPassword().toLowerCase()) &&
           Objects.equals(obj1.getPhoneNumber(), obj2.getPhoneNumber()) && Objects.equals(obj1.getSex(), obj2.getSex()) &&  Objects.equals(obj1.getCity().toLowerCase(), obj2.getCity().toLowerCase())){
            return true;
        }
        return false;
    }
    @FXML
    void editProHandler(ActionEvent event) throws IOException {
        textFieldStatus(true);
        if(editBtn.getText().equals("Save")){
            editProfile();
        }
        editBtn.setText("Save");
    }
    public void editProfile() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            Doctor doctor = session.get(Doctor.class, currentDoctor.getDoctorID());
            doctor.setFirstName(firstNameTf.getText());
            doctor.setLastName(lastNameTf.getText());
            doctor.setPassword(passwordTf.getText());
            doctor.setSex(genderTf.getText().toLowerCase().charAt(0));
            doctor.setPhoneNumber(phonTf.getText());
            doctor.setCity(cityTf.getText());
            doctor.setUserName(proUserNameTf.getText());
            if(compareDoctorsObjs(doctor,currentDoctor)){
                new WindowChangeController().warningPopup("Checking", "You Didn't Make any change?", "warn_confirm.png");
            }else {
                if(ExceptionHandler.validatUserInput(firstNameTf.getText(),lastNameTf.getText(),passwordTf.getText(),genderTf.getText(),cityTf.getText(),phonTf.getText(),proUserNameTf.getText())){
                    new WindowChangeController().warningPopup("Checking", "Are you sure to save your Edit?", "warn_confirm.png");
                    if(Warning.isOk) {
                        session.getTransaction().commit();
                        NotificationController.savedNotification("Profile Edited", "Profile Updated successfully!", "warn_confirm.png");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transition();
        populatePendingTable("from Patient where docActives = 1");
        goToPending();
        displayProfile();

    }

    @FXML
    void handleCardButton(ActionEvent event) {
        populatePendingTable("from Patient where docActives = 1 and fromSec = 1");
        goToPending();
    }

    @FXML
    void handleLabButton(ActionEvent event) {
        populatePendingTable("from Patient where docActives = 1 and fromLab = 1");
        goToPending();
    }

    private void goToView(boolean disease, boolean pending, boolean record){
        diseasePane.setVisible(disease);
        pendingPnl.setVisible(pending);
        recordPnl.setVisible(record);
    }

    @FXML
    void goToPending(ActionEvent event) {
        populatePendingTable("from Patient where docActives = 0");
        goToView(false,true,false);
    }
    void goToPending(){
        goToView(false,true,false);
    }

    @FXML
    void goToDisease(ActionEvent event) throws IOException {
        goToView(true, false, false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/DiseaseRecord.fxml"));
        AnchorPane root = loader.load();
        diseasePane.setCenter(root);
    }

//    @FXML
//    void handleTodayDiseaseButton(ActionEvent event) {
//        String command;
//        LocalDate date = LocalDate.now();
//        command = "from DiseaseRecord where date = " + DateTimeFormatter.BASIC_ISO_DATE.format(date);
//        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData(command);
//        populateDiseaseTable(diseaseRecordList);
//        goToView(true,false,false);
//    }

//    @FXML
//    void handleYestardayDiseaseButton(ActionEvent event) {
//        String command;
//        LocalDate date = LocalDate.now().minusDays(1);
//        command = "from DiseaseRecord where date = " + DateTimeFormatter.BASIC_ISO_DATE.format(date);
//        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData(command);
//        populateDiseaseTable(diseaseRecordList);
//        goToView(true,false,false);
//    }

//    @FXML
//    void handleAllDiseaseButton(ActionEvent event) {
//        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData("from DiseaseRecord");
//        populateDiseaseTable(diseaseRecordList);
//        goToView(true,false,false);
//    }

    @FXML
    void goToRecord(ActionEvent event) {
        populateRecordTable();
        goToView(false,false,true);
    }

    public void translateTransitionBack(AnchorPane pane, double move, double sec){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(sec),pane);
        translateTransition.setByX(move);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane.setVisible(false);
        });
    }

    public void OptionAction(){
        editBtn.setText("Edit");
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
        if(Warning.isOk){
          new WindowChangeController().signOut(event,"../view/Login.fxml");
        }
    }

    private void transition(){
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
    }

}
