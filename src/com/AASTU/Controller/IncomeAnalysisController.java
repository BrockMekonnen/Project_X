package com.AASTU.Controller;

import com.AASTU.Model.IncomeAnalysis;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class IncomeAnalysisController implements Initializable {

    @FXML
    private AnchorPane incomeAnalysisPane;

    @FXML
    private JFXButton lineChartBtn;

    @FXML
    private JFXButton tableViewBtn;

    @FXML
    private JFXButton barChartBtn;

    @FXML
    private JFXComboBox<String> barMonthCombo;

    @FXML
    private JFXComboBox<Integer> barYearCombo;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private JFXComboBox<Integer> lineYearCombo;

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
    private TableColumn<IncomeAnalysis, LocalDate> dateCol;

    @FXML
    private TableColumn<IncomeAnalysis, Double> totalIncomeCol;

    @FXML
    private AnchorPane barPane;

    @FXML
    private AnchorPane linePane;

    @FXML
    private AnchorPane tablePane;

    @FXML
    private TableView<IncomeAnalysis> tableView;

    @FXML
    private BarChart<String, Number> barChart;

    private List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(LocalDate.now().getYear(), LocalDate.now().getMonthValue());

    private int selectedYear = LocalDate.now().getYear();

    private int barSelectedYear = LocalDate.now().getYear();

    private void populateTableView(){
        List<IncomeAnalysis> list = new DataLoader().loadAllIncomeAnalysisData();
        System.out.println("IncomeAnalysisController.populateTableView: list size" + list.size());
        dateCol.setCellValueFactory(param -> param.getValue().tableDateGetter());
        totalIncomeCol.setCellValueFactory(param -> param.getValue().tableIncomeGetter());

        ObservableList<IncomeAnalysis> observableList = FXCollections.observableArrayList();
        for (IncomeAnalysis temp: list){
            observableList.add(temp);
        }
        tableView.setItems(observableList);
    }

    @FXML
    void handleLineCombo(ActionEvent event) {
        lineChart.getData().clear();

        selectedYear = lineYearCombo.getValue();
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

    private void populateBarChart( ){
        barChart.getData().clear();

        XYChart.Series series = new XYChart.Series();

        for(IncomeAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalIncome()));
        }
        barChart.getData().add(series);
    }

    private void populateBarChart( int year, int month ){
        barChart.getData().clear();

        XYChart.Series series = new XYChart.Series();
        List<IncomeAnalysis> list = new DataLoader().loadAllIncomeAnalysisData();
        for(IncomeAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalIncome()));
        }
        barChart.getData().add(series);
    }

    @FXML
    void handleMonthCombo(ActionEvent event) {
        if("January".equals(barMonthCombo.getValue())){
            populateBarChart(1, barSelectedYear);
        }
        else if("February".equals(barMonthCombo.getValue())){
            populateBarChart(2, barSelectedYear);
        }
        else if("March".equals(barMonthCombo.getValue()) ){
            populateBarChart(3, barSelectedYear);
        }
        else if("April".equals(barMonthCombo.getValue()) ){
            populateBarChart(4, barSelectedYear);
        }
        else if("May".equals(barMonthCombo.getValue()) ){
            populateBarChart(5, barSelectedYear);
        }
        else if("June".equals(barMonthCombo.getValue()) ){
            populateBarChart(6, barSelectedYear);
        }
        else if("July".equals(barMonthCombo.getValue()) ){
            populateBarChart(7, barSelectedYear);
        }
        else if("August".equals(barMonthCombo.getValue()) ){
            populateBarChart(8, barSelectedYear);
        }
        else if("September".equals(barMonthCombo.getValue()) ){
            populateBarChart(9, barSelectedYear);
        }
        else if("October".equals(barMonthCombo.getValue()) ){
            populateBarChart(10, barSelectedYear);
        }
        else if("November".equals(barMonthCombo.getValue()) ){
            populateBarChart(11, barSelectedYear);
        }
        else if("December".equals(barMonthCombo.getValue()) ){
            populateBarChart(12, barSelectedYear);
        }
    }

    private void populateLineChart(){
        lineChart.getData().clear();
        unChackAll();
        System.out.println("list seze = " + list.size());
        LocalDate date = list.get(0).getDate();

        XYChart.Series series = new XYChart.Series();
        selectedMonthYear(date.getMonthValue(), series);
        for(IncomeAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalIncome()));
        }
        lineChart.getData().add(series);
    }

    @FXML
    void handleBarYear(ActionEvent event) {
        barChart.getData().clear();

        barSelectedYear = barYearCombo.getValue();
        barMonthCombo.getSelectionModel().clearSelection();
    }

    // add passed list to the LineChart
    private void addSeries(XYChart.Series series, List<IncomeAnalysis> list){
        for(IncomeAnalysis temp: list){
            series.getData().add(new XYChart.Data(String.valueOf(temp.getDate().getDayOfMonth()), temp.getTotalIncome()));
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 4);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 8);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 12);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 2);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 1);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 7);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 6);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 5);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 11);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 10);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 9);
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
            List<IncomeAnalysis> list = new DataLoader().loadIncomeAnalaysisData(selectedYear, 3);
            addSeries(series, list);
        }
        else {
            removeSeries(series);
        }
    }

    private void display(boolean line, boolean bar, boolean table){
        barPane.setVisible(bar);
        linePane.setVisible(line);
        tablePane.setVisible(table);
    }

    @FXML
    void goToBarChart(ActionEvent event) {
        display(false,true,false);
    }

    @FXML
    void goToLineChart(ActionEvent event) {
        display(true,false,false);
    }

    @FXML
    void goToTableView(ActionEvent event) {
        display(false,false,true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barMonthCombo.getItems().add("January");
        barMonthCombo.getItems().add("February");
        barMonthCombo.getItems().add("March");
        barMonthCombo.getItems().add("April");
        barMonthCombo.getItems().add("May");
        barMonthCombo.getItems().add("June");
        barMonthCombo.getItems().add("July");
        barMonthCombo.getItems().add("August");
        barMonthCombo.getItems().add("September");
        barMonthCombo.getItems().add("October");
        barMonthCombo.getItems().add("November");
        barMonthCombo.getItems().add("December");

        ArrayList<Integer> years = new DataLoader().loadIncomeAnalysisYearOnly();
        for(Integer temp: years){
            barYearCombo.getItems().add(temp);
            lineYearCombo.getItems().add(temp);
        }
        lineYearCombo.getSelectionModel().select((Integer)(LocalDate.now().getYear()));
        barYearCombo.getSelectionModel().select((Integer)(LocalDate.now().getYear()));
        barMonthCombo.getSelectionModel().select((Integer) LocalDate.now().getMonthValue() - 1);

        populateBarChart();
        populateLineChart();
        populateTableView();
    }
}
