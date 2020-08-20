package com.AASTU.Controller;


import com.AASTU.Model.DiseaseRecord;
import com.AASTU.Model.PatientAnalysis;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PatientAnalysisController implements Initializable {

    @FXML
    private AnchorPane patientAnalysisPnl;

    @FXML
    private AnchorPane barPane;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis barX;

    @FXML
    private NumberAxis barY;

    @FXML
    private JFXButton lineChartBtn;

    @FXML
    private JFXButton tableViewBtn;

    @FXML
    private AnchorPane LinePane;

    @FXML
    private LineChart<String, Number> lineChart;


    @FXML
    private CategoryAxis chartX;

    @FXML
    private NumberAxis chartY;

    @FXML
    private JFXButton barChartBtn;

    @FXML
    private JFXComboBox<Integer> comboBox;

    @FXML
    private JFXCheckBox checkJanuary;

    @FXML
    private JFXCheckBox checkFebruary;

    @FXML
    private JFXCheckBox checkMarch;

    @FXML
    private JFXCheckBox checkApril;

    @FXML
    private JFXCheckBox checkMay;

    @FXML
    private JFXCheckBox checkJune;

    @FXML
    private JFXCheckBox checkJuly;

    @FXML
    private JFXCheckBox checkAugust;

    @FXML
    private JFXCheckBox checkSeptember;

    @FXML
    private JFXCheckBox checkOctober;

    @FXML
    private JFXCheckBox checkNovember;

    @FXML
    private JFXCheckBox checkDecember;

    @FXML
    private AnchorPane tablePane;

    @FXML
    private JFXComboBox<String> comboBoxMonth;

    @FXML
    private JFXComboBox<Integer> barChartCombo;

    @FXML
    private TableView<PatientAnalysis> tableView;

    @FXML
    private TableColumn<PatientAnalysis, LocalDate> dateCol;

    @FXML
    private TableColumn<PatientAnalysis, Integer> patientNumberCol;

    private int selectedYear = LocalDate.now().getYear();

    private List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue());

    private int barSelectedYear = LocalDate.now().getYear();

    private void populateTableView(){
        List<PatientAnalysis> list = new DataLoader().loadAllPatientAnalysisData();
        dateCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PatientAnalysis, LocalDate>, ObservableValue<LocalDate>>() {
            @Override
            public ObservableValue<LocalDate> call(TableColumn.CellDataFeatures<PatientAnalysis, LocalDate> param) {
                return param.getValue().tableDateGetter();
            }
        });
        patientNumberCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PatientAnalysis, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<PatientAnalysis, Integer> param) {
                return param.getValue().tableTotalPatinetGetter();
            }
        });
        ObservableList<PatientAnalysis> observableList = FXCollections.observableArrayList();
        for (PatientAnalysis temp: list){
            observableList.add(temp);
        }
        tableView.setItems(observableList);

    }

    @FXML
    void handleYearCombo(ActionEvent event) {
        barChart.getData().clear();
        barSelectedYear = barChartCombo.getValue();
        comboBoxMonth.getSelectionModel().clearSelection();
    }

    private void populateBarChart( ){
        barChart.getData().clear();

        XYChart.Series series = new XYChart.Series();

        for(PatientAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalPatient()));
        }
        barChart.getData().add(series);
    }

    private void populateBarChart( int month, int year){
        barChart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(year, month);
        for(PatientAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalPatient()));
        }
        barChart.getData().add(series);
    }

    @FXML
    void handleMonthCombo(ActionEvent event) {
        if("January".equals(comboBoxMonth.getValue())){
            populateBarChart(1, barSelectedYear);
        }
        else if("February".equals(comboBoxMonth.getValue())){
            populateBarChart(2, barSelectedYear);
        }
        else if("March".equals(comboBoxMonth.getValue()) ){
            populateBarChart(3, barSelectedYear);
        }
        else if("April".equals(comboBoxMonth.getValue()) ){
            populateBarChart(4, barSelectedYear);
        }
        else if("May".equals(comboBoxMonth.getValue()) ){
            populateBarChart(5, barSelectedYear);
        }
        else if("June".equals(comboBoxMonth.getValue()) ){
            populateBarChart(6, barSelectedYear);
        }
        else if("July".equals(comboBoxMonth.getValue()) ){
            populateBarChart(7, barSelectedYear);
        }
        else if("August".equals(comboBoxMonth.getValue()) ){
            populateBarChart(8, barSelectedYear);
        }
        else if("September".equals(comboBoxMonth.getValue()) ){
            populateBarChart(9, barSelectedYear);
        }
        else if("October".equals(comboBoxMonth.getValue()) ){
            populateBarChart(10, barSelectedYear);
        }
        else if("November".equals(comboBoxMonth.getValue()) ){
            populateBarChart(11, barSelectedYear);
        }
        else if("December".equals(comboBoxMonth.getValue()) ){
            populateBarChart(12, barSelectedYear);
        }
    }

    private void selectedMonthYear(int month, XYChart.Series series){
        if(month == 1){
            checkJanuary.setSelected(true);
            series.setName("January");
        }
        else if(month == 2){
            checkFebruary.setSelected(true);
            series.setName("February");
        }
        else if(month == 3){
            checkMarch.setSelected(true);
            series.setName("March");
        }
        else if(month == 4){
            checkApril.setSelected(true);
            series.setName("April");
        }
        else if(month == 5){
            checkMay.setSelected(true);
            series.setName("May");
        }
        else if(month == 6){
            checkJune.setSelected(true);
            series.setName("June");
        }
        else if(month == 7){
            checkJuly.setSelected(true);
            series.setName("July");
        }
        else if(month == 8){
            checkAugust.setSelected(true);
            series.setName("August");
        }
        else if(month == 9){
            checkSeptember.setSelected(true);
            series.setName("September");
        }
        else if(month == 10){
            checkOctober.setSelected(true);
            series.setName("October");
        }
        else if(month == 11){
            checkNovember.setSelected(true);
            series.setName("November");
        }
        else if(month == 12){
            checkDecember.setSelected(true);
            series.setName("December");
        }
    }

    @FXML
    void handleComboBox(ActionEvent event) {
        lineChart.getData().clear();
        selectedYear = comboBox.getValue();
        unChackAll();
    }

    private void unChackAll(){
        checkJanuary.setSelected(false);
        checkFebruary.setSelected(false);
        checkMarch.setSelected(false);
        checkApril.setSelected(false);
        checkMay.setSelected(false);
        checkJune.setSelected(false);
        checkJuly.setSelected(false);
        checkAugust.setSelected(false);
        checkSeptember.setSelected(false);
        checkOctober.setSelected(false);
        checkNovember.setSelected(false);
        checkDecember.setSelected(false);
    }

    private void populateLineChart(){
        lineChart.getData().clear();
        unChackAll();
        LocalDate date = list.get(0).getDate();

        XYChart.Series series = new XYChart.Series();
        selectedMonthYear(date.getMonthValue(), series);
        for(PatientAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalPatient()));
        }
        lineChart.getData().add(series);
    }

    // add passed list to the LineChart
    private void addSeries(XYChart.Series series, List<PatientAnalysis> list){
        for(PatientAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalPatient()));
        }
        lineChart.getData().add(series);
    }

    // Remove passed Series from line chart
    private void removeSeries(XYChart.Series series){
        for(int i=0;i<lineChart.getData().size(); i++){
            if(lineChart.getData().get(i).getName().equals(series.getName())){
                lineChart.getData().remove(i);
            }
        }
    }

    @FXML
    void handleApril(ActionEvent event) {

        XYChart.Series series = new XYChart.Series();
        series.setName("April");
        if(checkApril.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 4);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleAugust(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("August");
        if(checkAugust.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 8);
            addSeries(series,list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleDecember(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("December");
        if(checkDecember.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 12);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleFebruary(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("February");
        if(checkFebruary.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 2);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleJanuary(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("January");
        if(checkJanuary.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 1);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleJuly(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("July");
        if(checkJuly.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 7);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleJune(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("June");
        if(checkJune.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 6);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleMay(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("May");
        if(checkMay.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 5);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleNovember(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("November");
        if(checkNovember.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 11);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleOctober(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("October");
        if(checkOctober.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 10);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleSeptember(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("September");
        if(checkSeptember.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 9);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    @FXML
    void handleMarch(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("March");
        if(checkMarch.isSelected()){
            List<PatientAnalysis> list = new DataLoader().loadPatientAnalysisDate(selectedYear, 3);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    private void goToView(boolean line, boolean bar, boolean table){
        barPane.setVisible(bar);
        LinePane.setVisible(line);
        tablePane.setVisible(table);
    }

    @FXML
    void goToBarChart(ActionEvent event) {
        populateBarChart();
        goToView(false,true,false);
    }

    @FXML
    void goToLineChart(ActionEvent event) {
        populateLineChart();
        goToView(true, false, false);
    }

    @FXML
    void goToTableView(ActionEvent event) {
        populateTableView();
        goToView(false,false,true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBoxMonth.getItems().add("January");
        comboBoxMonth.getItems().add("February");
        comboBoxMonth.getItems().add("March");
        comboBoxMonth.getItems().add("April");
        comboBoxMonth.getItems().add("May");
        comboBoxMonth.getItems().add("June");
        comboBoxMonth.getItems().add("July");
        comboBoxMonth.getItems().add("August");
        comboBoxMonth.getItems().add("September");
        comboBoxMonth.getItems().add("October");
        comboBoxMonth.getItems().add("November");
        comboBoxMonth.getItems().add("December");

        ArrayList<Integer> years = new DataLoader().loadPatientAnalysisYearOnly();
        for(Integer temp: years){
            comboBox.getItems().add(temp);
            barChartCombo.getItems().add(temp);
        }
        comboBox.getSelectionModel().select((Integer)(LocalDate.now().getYear()));
        barChartCombo.getSelectionModel().select((Integer)(LocalDate.now().getYear()));
        comboBoxMonth.getSelectionModel().select((Integer) LocalDate.now().getMonthValue() - 1);
        populateBarChart();
        populateLineChart();
        populateTableView();

    }
}
