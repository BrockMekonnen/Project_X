package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerWindow {

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
    private AnchorPane pnl_analysis_patient;

    @FXML
    private AnchorPane pnl_analysis_income;

    @FXML
    private AnchorPane pnl_disease_record;

    @FXML
    private AnchorPane pnl_work_record;


    @FXML
    private AnchorPane pnl_pie;

    @FXML
    private AnchorPane pnl_bar;

    @FXML
    private AnchorPane pnl_line;

    @FXML
    private AnchorPane pnl_table;

    @FXML
    private AnchorPane pnl_pie_income;

    @FXML
    private AnchorPane pnl_bar_income;

    @FXML
    private AnchorPane pnl_line_income;

    @FXML
    private AnchorPane pnl_table_income;

    @FXML
    private AnchorPane pnl_pie_disease;

    @FXML
    private AnchorPane pnl_bar_disease;

    @FXML
    private AnchorPane pnl_line_disease;

    @FXML
    private AnchorPane pnl_table_disease;

    @FXML
    private AnchorPane pnl_pie_work;

    @FXML
    private AnchorPane pnl_bar_work;

    @FXML
    private AnchorPane pnl_line_work;

    @FXML
    private AnchorPane pnl_table_work;


    /**
     * Secretory
     * */
    @FXML
    public void deleteLaboratoryBtn(ActionEvent event) {

    }

    @FXML
    public void addLaboratoryBtn(ActionEvent event) throws IOException {
        toRegWindow(event, "../View/LaboratoryRegistration.fxml");
    }

    @FXML
    public void editLaboratoryBtn(ActionEvent event) {

    }

    /**
     * Doctor
     * */

    @FXML
    public void addDoctorBtn(ActionEvent event) throws IOException {
        toRegWindow(event, "../View/DoctorRegistrationWindow.fxml");
    }

    @FXML
    public void editDoctorBtn(ActionEvent event) throws IOException {
    }

    @FXML
    public void deleteDoctorBtn(ActionEvent event) throws IOException {

    }
    /**
     * Secretary
     * */

    @FXML
    public void addSecretaryBtn(ActionEvent event) throws IOException {
        toRegWindow(event, "../View/SecretaryRegistration.fxml");
    }

    @FXML
    public void deleteSecretaryBtn(ActionEvent event) throws IOException {

    }

    @FXML
    public void editSecretaryBtn(ActionEvent event) throws IOException {
    }

    public void toRegWindow(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent pane = loader.load();
        Scene registrationScene =  new Scene(pane);
        Stage registWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        registWindow.setScene(registrationScene);
        registWindow.show();
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btn_doctors){
            pnl_doctors.setVisible(true);
            pnl_doctors.toFront();

        } else if(event.getSource() == btn_lab){
            pnl_lab.setVisible(true);
            pnl_lab.toFront();

        } else if(event.getSource() == btn_secretaries){
            pnl_sec.setVisible(true);
            pnl_sec.toFront();

        } else if(event.getSource() == btn_analysis_patient){
            pnl_analysis_patient.setVisible(true);
            pnl_analysis_patient.toFront();
            gotoTableView();


        } else if(event.getSource() == btn_ana_Income){
            pnl_analysis_income.setVisible(true);
            pnl_analysis_income.toFront();
            gotoTableViewIncome();

        } else if(event.getSource() == btn_disease_record){
            pnl_disease_record.setVisible(true);
            pnl_disease_record.toFront();
            gotoTableViewDisease();

        } else if(event.getSource() == btn_work_record){
            pnl_work_record.setVisible(true);
            pnl_work_record.toFront();
            gotoTableViewWork();

        }
    }

    @FXML
    void gotoTableView(){
        pnl_table.setVisible(true);
        pnl_table.toFront();
    }
    @FXML
    void goToTableView(ActionEvent event){
        pnl_line.setVisible(false);
        pnl_pie.setVisible(false);
        pnl_bar.setVisible(false);

        pnl_table.setVisible(true);
        pnl_table.toFront();

    }
    @FXML
    void goToBarChartView(ActionEvent event){
        pnl_line.setVisible(false);
        pnl_pie.setVisible(false);
        pnl_table.setVisible(false);

        pnl_bar.setVisible(true);
        pnl_bar.toFront();

    }
    @FXML
    void goToPieChartView(ActionEvent event){
        pnl_line.setVisible(false);
        pnl_table.setVisible(false);
        pnl_bar.setVisible(false);

        pnl_pie.setVisible(true);
        pnl_pie.toFront();

    }
    @FXML
    void goToLineChartView(ActionEvent event){
        pnl_table.setVisible(false);
        pnl_pie.setVisible(false);
        pnl_bar.setVisible(false);

        pnl_line.setVisible(true);
        pnl_line.toFront();
    }


    @FXML
    void gotoTableViewIncome(){
        pnl_table_income.setVisible(true);
        pnl_table_income.toFront();
    }
    @FXML
    void goToTableViewIncome(ActionEvent event){
        pnl_line_income.setVisible(false);
        pnl_pie_income.setVisible(false);
        pnl_bar_income.setVisible(false);

        pnl_table_income.setVisible(true);
        pnl_table_income.toFront();

    }
    @FXML
    void goToBarChartViewIncome(ActionEvent event){
        pnl_line_income.setVisible(false);
        pnl_pie_income.setVisible(false);
        pnl_table_income.setVisible(false);

        pnl_bar_income.setVisible(true);
        pnl_bar_income.toFront();

    }
    @FXML
    void goToPieChartViewIncome(ActionEvent event){
        pnl_line_income.setVisible(false);
        pnl_table_income.setVisible(false);
        pnl_bar_income.setVisible(false);

        pnl_pie_income.setVisible(true);
        pnl_pie_income.toFront();

    }
    @FXML
    void goToLineChartViewIncome(ActionEvent event){
        pnl_table_income.setVisible(false);
        pnl_pie_income.setVisible(false);
        pnl_bar_income.setVisible(false);

        pnl_line_income.setVisible(true);
        pnl_line_income.toFront();

    }

    @FXML
    void gotoTableViewDisease(){
        pnl_table_disease.setVisible(true);
        pnl_table_disease.toFront();
    }
    @FXML
    void goToTableViewDisease(ActionEvent event){
        pnl_line_disease.setVisible(false);
        pnl_pie_disease.setVisible(false);
        pnl_bar_disease.setVisible(false);

        pnl_table_disease.setVisible(true);
        pnl_table_disease.toFront();

    }
    @FXML
    void goToBarChartViewDisease(ActionEvent event){
        pnl_line_disease.setVisible(false);
        pnl_pie_disease.setVisible(false);
        pnl_table_disease.setVisible(false);

        pnl_bar_disease.setVisible(true);
        pnl_bar_disease.toFront();

    }
    @FXML
    void goToPieChartViewDisease(ActionEvent event){
        pnl_line_disease.setVisible(false);
        pnl_table_disease.setVisible(false);
        pnl_bar_disease.setVisible(false);

        pnl_pie_disease.setVisible(true);
        pnl_pie_disease.toFront();

    }
    @FXML
    void goToLineChartViewDisease(ActionEvent event){
        pnl_table_disease.setVisible(false);
        pnl_pie_disease.setVisible(false);
        pnl_bar_disease.setVisible(false);

        pnl_line_disease.setVisible(true);
        pnl_line_disease.toFront();
    }

    @FXML
    void gotoTableViewWork(){
        pnl_table_work.setVisible(true);
        pnl_table_work.toFront();
    }
    @FXML
    void goToTableViewWork(ActionEvent event){
        pnl_line_work.setVisible(false);
        pnl_pie_work.setVisible(false);
        pnl_bar_work.setVisible(false);

        pnl_table_work.setVisible(true);
        pnl_table_work.toFront();

    }
    @FXML
    void goToBarChartViewWork(ActionEvent event){
        pnl_line_work.setVisible(false);
        pnl_pie_work.setVisible(false);
        pnl_table_work.setVisible(false);

        pnl_bar_work.setVisible(true);
        pnl_bar_work.toFront();

    }
    @FXML
    void goToPieChartViewWork(ActionEvent event){
        pnl_line_work.setVisible(false);
        pnl_table_work.setVisible(false);
        pnl_bar_work.setVisible(false);

        pnl_pie_work.setVisible(true);
        pnl_pie_work.toFront();

    }
    @FXML
    void goToLineChartViewWork(ActionEvent event){
        pnl_table_work.setVisible(false);
        pnl_pie_work.setVisible(false);
        pnl_bar_work.setVisible(false);

        pnl_line_work.setVisible(true);
        pnl_line_work.toFront();
    }


}





