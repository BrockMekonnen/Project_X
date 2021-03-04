package com.AASTU.Controller;

import com.AASTU.Model.DiseaseRecord;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DiseaseRecordController implements Initializable {

    @FXML
    private AnchorPane diseaseRecordPane;

    @FXML
    private PieChart pieChartDay;

    @FXML
    private PieChart pieChartMonth;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXButton ageBtn;

    @FXML
    private JFXDatePicker ageDatePicker;

    @FXML
    private JFXComboBox<String> diseaseCombo;

    @FXML
    private JFXButton diseaseBtn;

    @FXML
    private HBox allDiseaseHBox;

    @FXML
    private HBox ageHBox;

    @FXML
    private AnchorPane pieChartPane;

    @FXML
    private AnchorPane barChartPane;

    @FXML
    private AnchorPane tableViewPane;

    @FXML
    private BarChart<String, Number> barChartMonth;

    @FXML
    private BarChart<String, Number> barChartDay;

    @FXML
    private JFXDatePicker barDiseaseDatePicker;

    @FXML
    private HBox barAgeHBox;

    @FXML
    private HBox barDiseaseHBox;

    @FXML
    private JFXDatePicker barDatePicker;

    @FXML
    private JFXComboBox<String> barDiseaseCombo;

    @FXML
    private TableColumn<DiseaseRecord, LocalDate> columnDate;

    @FXML
    private TableColumn<DiseaseRecord, String> columnDisease;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnLess1;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column1to4;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column5to14;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column15to29;

    @FXML
    private TableColumn<DiseaseRecord, Integer> column30to64;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnGreater63;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnFless1;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF1to4;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF5to14;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF15to29;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnF30to64;

    @FXML
    private TableColumn<DiseaseRecord, Integer> columnFGreater63;

    @FXML
    private TableView<DiseaseRecord> diseaseTable;

    private List<DiseaseRecord> listMonth = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + LocalDate.now().getYear() + " and extract(MONTH FROM date) = " + LocalDate.now().getMonthValue());
    private List<DiseaseRecord> listDay = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + LocalDate.now().getYear() + " and extract(MONTH FROM date) = " + LocalDate.now().getMonthValue() + " and extract(DAY FROM date) = " + LocalDate.now().getDayOfMonth() );
    private List<String> distinctDisease = new DataLoader().loadMonthDiseaseNameData(LocalDate.now().getYear(),LocalDate.now().getMonthValue());

    private void populateDiseaseTable(List<DiseaseRecord> diseaseRecordList){
        ObservableList<DiseaseRecord> observableList = FXCollections.observableArrayList();

        columnDate.setCellValueFactory(param -> param.getValue().getDate());

        columnDisease.setCellValueFactory(param -> param.getValue().getDiseaseName());

        columnLess1.setCellValueFactory(param -> param.getValue().mLess1ForTable());

        column1to4.setCellValueFactory(param -> param.getValue().M1to4ForTable());

        column5to14.setCellValueFactory(param -> param.getValue().M5to14ForTable());

        column15to29.setCellValueFactory(param -> param.getValue().M15to29ForTable());

        column30to64.setCellValueFactory(param -> param.getValue().M30to64ForTable());

        columnGreater63.setCellValueFactory(param -> param.getValue().mGreater65ForTable());

        columnFless1.setCellValueFactory(param -> param.getValue().fLess1ForTable());

        columnF1to4.setCellValueFactory(param -> param.getValue().F1to4ForTable());

        columnF5to14.setCellValueFactory(param -> param.getValue().F5to14ForTable());

        columnF15to29.setCellValueFactory(param -> param.getValue().F15to29ForTable());

        columnF30to64.setCellValueFactory(param -> param.getValue().F30to64ForTable());

        columnFGreater63.setCellValueFactory(param -> param.getValue().fGreater65ForTable());

        for(DiseaseRecord temp: diseaseRecordList){
            observableList.add(temp);
        }
        diseaseTable.setItems(observableList);
    }

    @FXML
    void handleDatePicker(ActionEvent event) {
        pieChartMonth.getData().clear();
        pieChartDay.getData().clear();
        LocalDate tempDate = datePicker.getValue();
        listMonth = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue());
        listDay = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue() + " and extract(DAY FROM date) = " + tempDate.getDayOfMonth() );

        populatePieChart();
    }

    private int getSumValue(String diseaseName, List<DiseaseRecord> list){
        int count=0;
        for(DiseaseRecord temp: list){
            if (temp.getDiseaseNameForPie().equals(diseaseName)) {
                count += temp.getAge().getfLess1();
                count += temp.getAge().getF1to4();
                count += temp.getAge().getF5to14();
                count += temp.getAge().getF15to29();
                count += temp.getAge().getF30to64();
                count += temp.getAge().getfGreater65();

                count += temp.getAge().getmLess1();
                count += temp.getAge().getM1to4();
                count += temp.getAge().getM5to14();
                count += temp.getAge().getM15to29();
                count += temp.getAge().getM30to64();
                count += temp.getAge().getmGreater65();
            }
        }
        return count;
    }

    private void populatePieChart(){
        ObservableList<PieChart.Data> pieChartMonthData = FXCollections.observableArrayList();
        ObservableList<PieChart.Data> pieChartDayData = FXCollections.observableArrayList();
        for(int i=0;i<distinctDisease.size();i++){
            int monthValue = getSumValue(distinctDisease.get(i), listMonth);
            int dayValue = getSumValue(distinctDisease.get(i), listDay);
            pieChartMonthData.add(new PieChart.Data(distinctDisease.get(i), monthValue));
            pieChartDayData.add(new PieChart.Data(distinctDisease.get(i), dayValue));
        }
        pieChartMonth.setData(pieChartMonthData);
        pieChartDay.setData(pieChartDayData);
    }
    private void populateBarChart(){
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        for(int i=0; i<distinctDisease.size() ; i++){
            Integer monthValue = getSumValue(distinctDisease.get(i), listMonth);
            int dayValue = getSumValue(distinctDisease.get(i), listDay);
            series.getData().add(new XYChart.Data(distinctDisease.get(i) , monthValue));
            series2.getData().add(new XYChart.Data(distinctDisease.get(i) , dayValue));
        }
        barChartMonth.getData().add(series);
        barChartDay.getData().add(series2);
    }

    @FXML
    void handleBarDatePicker(ActionEvent event) {
        barChartMonth.getData().clear();
        barChartDay.getData().clear();
        handleBarDiseaseCombo(event);
    }

    @FXML
    void handleBarDiseaseDatePicker(ActionEvent event) {
        barChartMonth.getData().clear();
        barChartDay.getData().clear();
        LocalDate tempDate = barDiseaseDatePicker.getValue();
        listMonth = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue());
        listDay = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue() + " and extract(DAY FROM date) = " + tempDate.getDayOfMonth() );

        populateBarChart();
    }

    @FXML
    void handleAgeDatePicker(ActionEvent event) {
        pieChartMonth.getData().clear();
        pieChartDay.getData().clear();
        handleDiseaseCombo(event);
    }


    @FXML
    void handleBarAgeButton(ActionEvent event) {
        barDiseaseHBox.setVisible(false);
        barAgeHBox.setVisible(true);
    }

    @FXML
    void handleBarDiseaseBtn(ActionEvent event) {
        barAgeHBox.setVisible(false);
        barDiseaseHBox.setVisible(true);
    }

    @FXML
    void handleBarDiseaseCombo(ActionEvent event) {
        barChartMonth.getData().clear();
        barChartDay.getData().clear();

        XYChart.Series seriesMonth = new XYChart.Series();
        XYChart.Series seriesDay = new XYChart.Series();

        LocalDate tempDate = barDatePicker.getValue();
        listMonth = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue());
        listDay = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue() + " and extract(DAY FROM date) = " + tempDate.getDayOfMonth() );

        int fLess1 = 0, f1to4 = 0, f5to14 = 0, f15to29 = 0, f30to64 = 0, fGreater65 = 0, mLess1 = 0, m1to4 = 0, m5to14 = 0, m15to29 = 0, m30to64 = 0, mGreater65 = 0;

        for(int i=0; i<listMonth.size(); i++){
            if(barDiseaseCombo.getValue().equals(listMonth.get(i).getDiseaseNameForPie())){
                fLess1 += listMonth.get(i).getAge().getfLess1();
                f1to4 += listMonth.get(i).getAge().getF1to4();
                f5to14 += listMonth.get(i).getAge().getF5to14();
                f15to29 += listMonth.get(i).getAge().getF15to29();
                f30to64 += listMonth.get(i).getAge().getF30to64();
                fGreater65 += listMonth.get(i).getAge().getfGreater65();
                mLess1 += listMonth.get(i).getAge().getmLess1();
                m1to4 += listMonth.get(i).getAge().getM1to4();
                m5to14 += listMonth.get(i).getAge().getM5to14();
                m15to29 += listMonth.get(i).getAge().getM15to29();
                m30to64 += listMonth.get(i).getAge().getM30to64();
                mGreater65 += listMonth.get(i).getAge().getmGreater65();
            }
        }

        seriesMonth.getData().add(new XYChart.Data("F < 1" , fLess1));
        seriesMonth.getData().add(new XYChart.Data("F 1 to 4" , f1to4));
        seriesMonth.getData().add(new XYChart.Data("F 5 to 14" , f5to14));
        seriesMonth.getData().add(new XYChart.Data("F 15 to 29" , f15to29));
        seriesMonth.getData().add(new XYChart.Data("F 30 to 64" , f30to64));
        seriesMonth.getData().add(new XYChart.Data("F > 64" , fGreater65));
        seriesMonth.getData().add(new XYChart.Data("M < 1" , mLess1));
        seriesMonth.getData().add(new XYChart.Data("M 1 to 4" , m1to4));
        seriesMonth.getData().add(new XYChart.Data("M 5 to 14" , m5to14));
        seriesMonth.getData().add(new XYChart.Data("M 15 to 29" , m15to29));
        seriesMonth.getData().add(new XYChart.Data("M 30 to 64" , m30to64));
        seriesMonth.getData().add(new XYChart.Data("M > 64" , mGreater65));

        for(int i=0;i<listDay.size(); i++){
            if(barDiseaseCombo.getValue().equals(listDay.get(i).getDiseaseNameForPie())){
                seriesDay.getData().add(new XYChart.Data("F < 1" , listDay.get(i).getAge().getfLess1()));
                seriesDay.getData().add(new XYChart.Data("F 1 to 4" , listDay.get(i).getAge().getF1to4()));
                seriesDay.getData().add(new XYChart.Data("F 5 to 14" , listDay.get(i).getAge().getF5to14()));
                seriesDay.getData().add(new XYChart.Data("F 15 to 29" , listDay.get(i).getAge().getF15to29()));
                seriesDay.getData().add(new XYChart.Data("F 30 to 64" , listDay.get(i).getAge().getF30to64()));
                seriesDay.getData().add(new XYChart.Data("F > 64" , listDay.get(i).getAge().getfGreater65()));
                seriesDay.getData().add(new XYChart.Data("M < 1" , listDay.get(i).getAge().getmLess1()));
                seriesDay.getData().add(new XYChart.Data("M 1 to 4" , listDay.get(i).getAge().getM1to4()));
                seriesDay.getData().add(new XYChart.Data("M 5 to 14" , listDay.get(i).getAge().getM5to14()));
                seriesDay.getData().add(new XYChart.Data("M 15 to 29" , listDay.get(i).getAge().getM15to29()));
                seriesDay.getData().add(new XYChart.Data("M 30 to 64" , listDay.get(i).getAge().getM30to64()));
                seriesDay.getData().add(new XYChart.Data("M > 64" , listDay.get(i).getAge().getmGreater65()));
            }
        }
        barChartMonth.getData().add(seriesMonth);
        barChartDay.getData().add(seriesDay);

    }

    @FXML
    void handleDiseaseCombo(ActionEvent event) {
        pieChartMonth.getData().clear();
        pieChartDay.getData().clear();

        ObservableList<PieChart.Data> pieChartMonthData = FXCollections.observableArrayList();
        ObservableList<PieChart.Data> pieChartDayData = FXCollections.observableArrayList();

        LocalDate tempDate = ageDatePicker.getValue();
        listMonth = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue());
        listDay = new DataLoader().loadDiseaseData("from DiseaseRecord where extract(YEAR FROM date) = " + tempDate.getYear() + " and extract(MONTH FROM date) = " + tempDate.getMonthValue() + " and extract(DAY FROM date) = " + tempDate.getDayOfMonth() );

        int fLess1 = 0, f1to4 = 0, f5to14 = 0, f15to29 = 0, f30to64 = 0, fGreater65 = 0, mLess1 = 0, m1to4 = 0, m5to14 = 0, m15to29 = 0, m30to64 = 0, mGreater65 = 0;

        for(int i=0;i<listMonth.size(); i++){
            if(diseaseCombo.getValue().equals(listMonth.get(i).getDiseaseNameForPie())){
                fLess1 += listMonth.get(i).getAge().getfLess1();
                f1to4 += listMonth.get(i).getAge().getF1to4();
                f5to14 += listMonth.get(i).getAge().getF5to14();
                f15to29 += listMonth.get(i).getAge().getF15to29();
                f30to64 += listMonth.get(i).getAge().getF30to64();
                fGreater65 += listMonth.get(i).getAge().getfGreater65();
                mLess1 += listMonth.get(i).getAge().getmLess1();
                m1to4 += listMonth.get(i).getAge().getM1to4();
                m5to14 += listMonth.get(i).getAge().getM5to14();
                m15to29 += listMonth.get(i).getAge().getM15to29();
                m30to64 += listMonth.get(i).getAge().getM30to64();
                mGreater65 += listMonth.get(i).getAge().getmGreater65();
            }
        }

        pieChartMonthData.add(new PieChart.Data("Female Age Less Than 1", fLess1));
        pieChartMonthData.add(new PieChart.Data("Female Age 1 to 4", f1to4));
        pieChartMonthData.add(new PieChart.Data("Female Age 5 to 14", f5to14));
        pieChartMonthData.add(new PieChart.Data("Female Age 15 to 29", f15to29));
        pieChartMonthData.add(new PieChart.Data("Female Age 30 to 64", f30to64));
        pieChartMonthData.add(new PieChart.Data("Female Age Greater than 64", fGreater65));
        pieChartMonthData.add(new PieChart.Data("Male Age Less Than 1", mLess1));
        pieChartMonthData.add(new PieChart.Data("Male Age 1 to 4", m1to4));
        pieChartMonthData.add(new PieChart.Data("Male Age 5 to 14", m5to14));
        pieChartMonthData.add(new PieChart.Data("Male Age 15 to 29", m15to29));
        pieChartMonthData.add(new PieChart.Data("Male Age 30 to 64", m30to64));
        pieChartMonthData.add(new PieChart.Data("Male Age Greater than 64", mGreater65));

        for(int i=0; i<listDay.size(); i++){
            if(diseaseCombo.getValue().equals(listDay.get(i).getDiseaseNameForPie())){
                pieChartDayData.add(new PieChart.Data("Female Age Less Than 1", listDay.get(i).getAge().getfLess1()));
                pieChartDayData.add(new PieChart.Data("Female Age 1 to 4 ", listDay.get(i).getAge().getF1to4()));
                pieChartDayData.add(new PieChart.Data("Female Age 5 to 14", listDay.get(i).getAge().getF5to14()));
                pieChartDayData.add(new PieChart.Data("Female Age 15 to 29", listDay.get(i).getAge().getF15to29()));
                pieChartDayData.add(new PieChart.Data("Female Age 30 to 64", listDay.get(i).getAge().getF30to64()));
                pieChartDayData.add(new PieChart.Data("Female Age Greater than 64", listDay.get(i).getAge().getfGreater65()));

                pieChartDayData.add(new PieChart.Data("Male Age Less Than 1", listDay.get(i).getAge().getmLess1()));
                pieChartDayData.add(new PieChart.Data("Male Age 1 to 4", listDay.get(i).getAge().getM1to4()));
                pieChartDayData.add(new PieChart.Data("Male Age 5 to 14", listDay.get(i).getAge().getM5to14()));
                pieChartDayData.add(new PieChart.Data("Male Age 15 to 29", listDay.get(i).getAge().getM15to29()));
                pieChartDayData.add(new PieChart.Data("Male Age 30 to 64", listDay.get(i).getAge().getM30to64()));
                pieChartDayData.add(new PieChart.Data("Male Age Greater than 64", listDay.get(i).getAge().getmGreater65()));
            }
        }

        pieChartMonth.setData(pieChartMonthData);
        pieChartDay.setData(pieChartDayData);

    }

    @FXML
    void handleAgeButton(ActionEvent event) {
        allDiseaseHBox.setVisible(false);
        ageHBox.setVisible(true);
    }

    @FXML
    void handleDiseaseButton(ActionEvent event) {
        ageHBox.setVisible(false);
        allDiseaseHBox.setVisible(true);
    }

    private void goTo(boolean barChart, boolean pieChart, boolean tableView){
        tableViewPane.setVisible(tableView);
        barChartPane.setVisible(barChart);
        pieChartPane.setVisible(pieChart);
    }

    @FXML
    void goToBarChart(ActionEvent event) {
        goTo(true,false,false);
    }

    @FXML
    void goToPieChart(ActionEvent event) {
        goTo(false,true,false);
    }

    @FXML
    void goToTableView(ActionEvent event) {
        goTo(false,false,true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i=0 ;i<distinctDisease.size(); i++){
            diseaseCombo.getItems().add(distinctDisease.get(i));
            barDiseaseCombo.getItems().add(distinctDisease.get(i));
        }
        datePicker.setValue(LocalDate.now());
        ageDatePicker.setValue(LocalDate.now());
        barDiseaseDatePicker.setValue(LocalDate.now());
        barDatePicker.setValue(LocalDate.now());



        populatePieChart();
        populateBarChart();
        List<DiseaseRecord> diseaseRecordList = new DataLoader().loadDiseaseData("from DiseaseRecord");
        System.out.println("List Month: " + listMonth.size());
        System.out.println("List Day: " + listDay.size());
        System.out.println("Disease Record: " + diseaseRecordList.size());
        populateDiseaseTable(diseaseRecordList);
    }
}
