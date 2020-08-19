package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class DoctorWindowController implements Initializable {

    public static Doctor currentDoctor;
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
    private JFXTextField kebeleTf;

    @FXML
    private JFXTextField cityTf;

    @FXML
    private JFXTextField subCityTf;

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
    private AnchorPane diseasePnl;

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


    private void populateDiseaseTable(List<DiseaseRecord> diseaseRecordList){
        ObservableList<DiseaseRecord> observableList = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, LocalDate>, ObservableValue<LocalDate>>() {
            @Override
            public ObservableValue<LocalDate> call(TableColumn.CellDataFeatures<DiseaseRecord, LocalDate> param) {
                return param.getValue().getDate();
            }
        });

        columnDisease.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DiseaseRecord, String> param) {
                return param.getValue().getDiseaseName();
            }
        });

        columnless1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().mLess1ForTable();
            }
        });

        column1to4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().M1to4ForTable();
            }
        });

        column5to14.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().M5to14ForTable();
            }
        });

        column14to29.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().M15to29ForTable();
            }
        });

        column28to64.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().M30to64ForTable();
            }
        });

        columnGreater63.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().mGreater65ForTable();
            }
        });

        columnFless1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().fLess1ForTable();
            }
        });

        columnF1to4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().F1to4ForTable();
            }
        });

        columnF5to14.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().F5to14ForTable();
            }
        });

        columnF14to29.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().F15to29ForTable();
            }
        });

        columnF28to64.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().F30to64ForTable();
            }
        });

        columnFgreater63.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DiseaseRecord, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<DiseaseRecord, Integer> param) {
                return param.getValue().fGreater65ForTable();
            }
        });

        for(DiseaseRecord temp: diseaseRecordList){
            observableList.add(temp);
        }

        diseaseTable.setItems(observableList);
    }

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
        firstNameTf.setEditable(status);
        lastNameTf.setEditable(status);
        passwordTf.setEditable(status);
        genderTf.setEditable(status);
        cityTf.setEditable(status);
        subCityTf.setEditable(status);
        kebeleTf.setEditable(status);
        phonTf.setEditable(status);
        startHrTf.setEditable(false);
        endHrTf.setEditable(false);
    }

    public void displayProfile(){
        textFieldStatus(false);
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
        startHrTf.setText(currentDoctor.getWorkingStartTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        endHrTf.setText(currentDoctor.getWorkingEndTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        phonTf.setText(currentDoctor.getPhoneNumber());
        cityTf.setText(currentDoctor.getCity());
        subCityTf.setText(currentDoctor.getSubcity());
        kebeleTf.setText(currentDoctor.getKebele());
    }

    @FXML
    void cancelProHandler(ActionEvent event) {

    }
    @FXML
    void editProHandler(ActionEvent event) {
        textFieldStatus(true);
        if(editBtn.getText().equals("save")){
            editProfile();
        }
        editBtn.setText("Save");

    }
    public void editProfile(){
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
//            secretary.setSex(sexTf.getText().toLowerCase().charAt(0));
            doctor.setPhoneNumber(phonTf.getText());
            doctor.setCity(cityTf.getText());
            doctor.setSubcity(subCityTf.getText());
            doctor.setKebele(kebeleTf.getText());

            session.getTransaction().commit();
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
        diseasePnl.setVisible(disease);
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
    void goToDisease(ActionEvent event) {
        handleTodayDiseaseButton(event);
    }

    @FXML
    void handleTodayDiseaseButton(ActionEvent event) {
        String command;
        LocalDate date = LocalDate.now();
        command = "from DiseaseRecord where date = " + DateTimeFormatter.BASIC_ISO_DATE.format(date);
        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData(command);
        populateDiseaseTable(diseaseRecordList);
        goToView(true,false,false);
    }

    @FXML
    void handleYestardayDiseaseButton(ActionEvent event) {
        String command;
        LocalDate date = LocalDate.now().minusDays(1);
        command = "from DiseaseRecord where date = " + DateTimeFormatter.BASIC_ISO_DATE.format(date);
        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData(command);
        populateDiseaseTable(diseaseRecordList);
        goToView(true,false,false);
    }

    @FXML
    void handleAllDiseaseButton(ActionEvent event) {
        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData("from DiseaseRecord");
        populateDiseaseTable(diseaseRecordList);
        goToView(true,false,false);
    }

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
