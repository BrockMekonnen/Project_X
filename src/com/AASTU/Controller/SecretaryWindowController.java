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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
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
List<Patient> allPatientList = new DataLoader().loadSpecificPatientData("from Patient");
List<Patient> normalPatientList =new DataLoader().loadSpecificPatientData("from Patient where outPatient = 0 and patientStates = 1");
List<Patient> outPatientList = new DataLoader().loadSpecificPatientData("from Patient where patientStates = 1 and outPatient = 1");


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

    // method to calculate the total payment
    public double calcTotalPayment(Patient obj){
        double total=0, price;
        List<LabRequest> labObject = new DataLoader().labRequest(obj);
        for(LabRequest labRequest: labObject){
            if(labRequest.getBacterology().getKoh().isTest()){
                price = new DataLoader().prices(labRequest.getBacterology().getKoh().getPriceId());
                total += price;
            }if(labRequest.getBacterology().getHpyloriStool().isTest()){
                price = new DataLoader().prices(labRequest.getBacterology().getHpyloriStool().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getConsistency1().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getConsistency1().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getConsistency2().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getConsistency2().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getOccultBlood().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getOccultBlood().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getOvalParasite1().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getOvalParasite1().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getOvalParasite2().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getOvalParasite2().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getOvalParasite3().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getOvalParasite3().getPriceId());
                total += price;
            }if(labRequest.getParasitology().getStoolTest().isTest()){
                price = new DataLoader().prices(labRequest.getParasitology().getStoolTest().getPriceId());
                total += price;
            }if(labRequest.getCbs().getBloodFilm().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getBloodFilm().getPriceId());
                total += price;
            }if(labRequest.getCbs().getBloodGroupRh().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getBloodGroupRh().getPriceId());
                total += price;
            }if(labRequest.getCbs().getEsr().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getEsr().getPriceId());
                total += price;
            }if(labRequest.getCbs().getGra().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getGra().getPriceId());
                total += price;
            }if(labRequest.getCbs().getHct().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getHct().getPriceId());
                total += price;
            }if(labRequest.getCbs().getHgb().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getHgb().getPriceId());
                total += price;
            }if(labRequest.getCbs().getLym().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getLym().getPriceId());
                total += price;
            }if(labRequest.getCbs().getMch().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getMch().getPriceId());
                total += price;
            }if(labRequest.getCbs().getMchc().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getMchc().getPriceId());
                total += price;
            }if(labRequest.getCbs().getMcv().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getMcv().getPriceId());
                total += price;
            }if(labRequest.getCbs().getMid().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getMid().getPriceId());
                total += price;
            }if(labRequest.getCbs().getP_lcr().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getP_lcr().getPriceId());
                total += price;
            }if(labRequest.getCbs().getPct().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getPct().getPriceId());
                total += price;
            }if(labRequest.getCbs().getPlt().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getPlt().getPriceId());
                total += price;
            }if(labRequest.getCbs().getRbc().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getRbc().getPriceId());
                total += price;
            }if(labRequest.getCbs().getRdw_cv().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getRdw_cv().getPriceId());
                total += price;
            }if(labRequest.getCbs().getWbc().isTest()){
                price = new DataLoader().prices(labRequest.getCbs().getWbc().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getAlkalinePhosphate().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getAlkalinePhosphate().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getBilirubinDirect().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getBilirubinDirect().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getBilirubinTotal().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getBilirubinTotal().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getBun().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getBun().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getCholesterol().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getCholesterol().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getCreatinine().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getCreatinine().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getFbs().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getFbs().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getRbs().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getRbs().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getSgot().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getSgot().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getSgpt().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getSgpt().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getTotalProtein().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getTotalProtein().getPriceId());
                total += price;
            }if(labRequest.getChemistry().getUricAcid().isTest()){
                price = new DataLoader().prices(labRequest.getChemistry().getUricAcid().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getAppearance().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getAppearance().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getBilrubin().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getBilrubin().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getBlood().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getBlood().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getGlucose().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getGlucose().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getKetone().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getKetone().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getPh().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getPh().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getProtein().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getProtein().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getPsg().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getPsg().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getTestColor().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getTestColor().getPriceId());
                total += price;
            }if(labRequest.getDipistic().getUrobilinogen().isTest()){
                price = new DataLoader().prices(labRequest.getDipistic().getUrobilinogen().getPriceId());
                total += price;
            }if(labRequest.getSerology().getAso().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getAso().getPriceId());
                total += price;
            }if(labRequest.getSerology().getCrp().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getCrp().getPriceId());
                total += price;
            }if(labRequest.getSerology().getHbsag().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getHbsag().getPriceId());
                total += price;
            }if(labRequest.getSerology().getHpyloriSerum().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getHpyloriSerum().getPriceId());
                total += price;
            }if(labRequest.getSerology().getRheumatoidFactor().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getRheumatoidFactor().getPriceId());
                total += price;
            }if(labRequest.getSerology().getVdrl().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getVdrl().getPriceId());
                total += price;
            }if(labRequest.getSerology().getWellFelix().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getWellFelix().getPriceId());
                total += price;
            }if(labRequest.getSerology().getWidal_II_h().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getWidal_II_h().getPriceId());
                total += price;
            }if(labRequest.getSerology().getWidal_II_o().isTest()){
                price = new DataLoader().prices(labRequest.getSerology().getWidal_II_o().getPriceId());
                total += price;
            }if(labRequest.getMicroscopy().getBacteria().isTest()){
                price = new DataLoader().prices(labRequest.getMicroscopy().getBacteria().getPriceId());
                total += price;
            }if(labRequest.getMicroscopy().getCasts().isTest()){
                price = new DataLoader().prices(labRequest.getMicroscopy().getCasts().getPriceId());
                total += price;
            }if(labRequest.getMicroscopy().getEpitCells().isTest()){
                price = new DataLoader().prices(labRequest.getMicroscopy().getEpitCells().getPriceId());
                total += price;
            }if(labRequest.getMicroscopy().getRbc().isTest()){
                price = new DataLoader().prices(labRequest.getMicroscopy().getRbc().getPriceId());
                total += price;
            }if(labRequest.getMicroscopy().getWbc().isTest()){
                price = new DataLoader().prices(labRequest.getMicroscopy().getWbc().getPriceId());
                total += price;
            }if(labRequest.getOthers().getAfb().isTest()){
                price = new DataLoader().prices(labRequest.getOthers().getAfb().getPriceId());
                total += price;
            }if(labRequest.getOthers().getGramStain().isTest()){
                price = new DataLoader().prices(labRequest.getOthers().getGramStain().getPriceId());
                total += price;
            }if(labRequest.getOthers().getHivAids().isTest()){
                price = new DataLoader().prices(labRequest.getOthers().getHivAids().getPriceId());
                total += price;
            }if(labRequest.getOthers().getWetFilm().isTest()){
                price = new DataLoader().prices(labRequest.getOthers().getWetFilm().getPriceId());
                total += price;
            }
        }
        return total;
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

    // for payment Table
    public void rowClickHandlerforPayment( TableView<Patient> tableName) {
        tableName.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>(); // get the row
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {// if double click and row is not empty
                    Patient rowData = row.getItem(); //get the object in the row and assign it to patient object
                    try {
                        new WindowChangeController().totalPaymentView(event, "../View/PaymentWindow.fxml", rowData); // created new object of WindowChangeController and called popup ( with Patient object)
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
        rowClickHandlerforPayment(paymentTable);
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
        for(Patient tempPatent: allPatientList){
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
