package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerWindow implements Initializable {

    @FXML
    private AnchorPane opacityPane;

    @FXML
    private AnchorPane slidePane;

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

    @FXML
    private JFXButton pricingBtn;

    @FXML
    private AnchorPane pnl_price;


    /**
     * Secretory
     * */
    @FXML
    public void deleteLaboratoryBtn(ActionEvent event) {

    }

    @FXML
    public void addLaboratoryBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/LaboratoryRegistration.fxml");
    }

    @FXML
    public void editLaboratoryBtn(ActionEvent event) {

    }

    /**
     * Doctor
     * */

    @FXML
    public void addDoctorBtn(ActionEvent event) throws IOException {
        new WindowChangeController().popupWindow(event, "../View/DoctorRegistrationWindow.fxml");
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
        new WindowChangeController().popupWindow(event, "../View/SecretaryRegistration.fxml");
    }

    @FXML
    public void deleteSecretaryBtn(ActionEvent event) throws IOException {

    }

    @FXML
    public void editSecretaryBtn(ActionEvent event) throws IOException {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        opacityPane.setVisible(false);
        translation(0.1);
        opacityPane.setOnMouseClicked(event -> {
            translation(1);
        });
    }

    public void translation(double second){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(second),slidePane);
        translateTransition.setByX(-600);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            opacityPane.setVisible(false);
        });
    }
    @FXML
    void OptionAction(ActionEvent event) {
        opacityPane.setVisible(true);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.1),slidePane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        translation1();
    }

    public void translation1(){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),slidePane);
        translateTransition.setByX(600);
        translateTransition.play();

    }

    @FXML
    void signOutHandler(ActionEvent event) throws IOException {
            new WindowChangeController().signOut(event,"../view/Login.fxml");
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

        } else if(event.getSource() == pricingBtn){
            pnl_price.setVisible(true);
            pnl_price.toFront();
        }
    }

    @FXML
    void gotoTableView(){
        pnl_table.setVisible(true);
        pnl_table.toFront();
    }
    @FXML
    void goToTableView(ActionEvent event){
        goToView(false,false, false, true);
        pnl_table.toFront();

    }
    @FXML
    void goToBarChartView(ActionEvent event){
        goToView(false, false, true, false);
        pnl_bar.toFront();

    }
    @FXML
    void goToPieChartView(ActionEvent event){
        goToView(false, true, false, false);
        pnl_pie.toFront();

    }
    @FXML
    void goToLineChartView(ActionEvent event){
        goToView(true, false , false , false);
        pnl_line.toFront();
    }

    private void goToView(boolean line, boolean pie, boolean bar, boolean table){
        pnl_table.setVisible(table);
        pnl_pie.setVisible(pie);
        pnl_line.setVisible(line);
        pnl_bar.setVisible(bar);
    }


    @FXML
    void gotoTableViewIncome(){
        pnl_table_income.setVisible(true);
        pnl_table_income.toFront();
    }
    @FXML
    void goToTableViewIncome(ActionEvent event){
        goToIncome(true, false, false, false);
        pnl_table_income.toFront();

    }
    @FXML
    void goToBarChartViewIncome(ActionEvent event){
        goToIncome(false, false, true, false);
        pnl_bar_income.toFront();

    }
    @FXML
    void goToPieChartViewIncome(ActionEvent event){
        goToIncome(false, true, false, false);
        pnl_pie_income.toFront();

    }
    @FXML
    void goToLineChartViewIncome(ActionEvent event){
        goToIncome(false, false, false, true);
        pnl_line_income.toFront();
    }

    private void goToIncome(boolean table, boolean pie, boolean bar, boolean line){
        pnl_table_income.setVisible(table);
        pnl_pie_income.setVisible(pie);
        pnl_bar_income.setVisible(bar);
        pnl_line_income.setVisible(line);
    }


    @FXML
    void gotoTableViewDisease(){
        pnl_table_disease.setVisible(true);
        pnl_table_disease.toFront();
    }
    @FXML
    void goToTableViewDisease(ActionEvent event){
        goToDisease(true, false, false , false);
        pnl_table_disease.toFront();

    }
    @FXML
    void goToBarChartViewDisease(ActionEvent event){
        goToDisease(false, false, true, false);
        pnl_bar_disease.toFront();

    }
    @FXML
    void goToPieChartViewDisease(ActionEvent event){
        goToDisease(false, true, false, false);
        pnl_pie_disease.toFront();

    }
    @FXML
    void goToLineChartViewDisease(ActionEvent event){
        goToDisease(false, false, false, true);
        pnl_line_disease.toFront();
    }

    private void goToDisease(boolean table, boolean pie, boolean bar, boolean line){
        pnl_table_disease.setVisible(table);
        pnl_pie_disease.setVisible(pie);
        pnl_bar_disease.setVisible(bar);
        pnl_line_disease.setVisible(line);
    }

    @FXML
    void gotoTableViewWork(){
        pnl_table_work.setVisible(true);
        pnl_table_work.toFront();
    }
    @FXML
    void goToTableViewWork(ActionEvent event){
        goToWork(true, false, false, false);
        pnl_table_work.toFront();

    }
    @FXML
    void goToBarChartViewWork(ActionEvent event){
        goToWork(false, false, true, false);
        pnl_bar_work.toFront();

    }
    @FXML
    void goToPieChartViewWork(ActionEvent event){
        goToWork(false,true,false,false);
        pnl_pie_work.toFront();

    }
    @FXML
    void goToLineChartViewWork(ActionEvent event){
        goToWork(false, false, false, true);
        pnl_line_work.toFront();
    }

    private void goToWork(boolean table, boolean pie, boolean bar, boolean line){
        pnl_table_work.setVisible(table);
        pnl_pie_work.setVisible(pie);
        pnl_bar_work.setVisible(bar);
        pnl_line_work.setVisible(line);
    }

    @FXML
    void CloseBTN(ActionEvent event){
        int i= JOptionPane.showConfirmDialog(null,"Do you want to Exit the system","Attention",JOptionPane.YES_NO_OPTION);
        if(i== JOptionPane.YES_OPTION){
            System.exit(0);
            Platform.exit();}
    }


}





