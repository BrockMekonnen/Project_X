package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LaboratoryWindowController implements Initializable {

    @FXML
    private JFXButton ChangePassword;

    @FXML
    private TableView<?> LaboratoryTableView;

    @FXML
    private TableColumn<?, ?> PatientSexCol;

    @FXML
    private JFXButton SignOut;

    @FXML
    private TableColumn<?, ?> PatientSubCityCol;

    @FXML
    private JFXButton Help;

    @FXML
    private TableColumn<?, ?> PatientCityCol;

    @FXML
    private TableColumn<?, ?> PatientPaymentCol;

    @FXML
    private JFXButton TestBTN;

    @FXML
    private TableColumn<?, ?> PatientIdCol;

    @FXML
    private JFXButton ListBTN;

    @FXML
    private AnchorPane CoverPane,AccountSettingPane;

    @FXML
    private TableColumn<?, ?> PatientNameCol;

    @FXML
    private AnchorPane BarPane;

    @FXML
    private JFXButton pendingBTN;

    @FXML
    private Label WellcomeLB;

    @FXML
    private TableColumn<?, ?> PatientAgeCol;

    @FXML
    private TableColumn<?, ?> PatientKebeleCol;

    @FXML
    private JFXButton ViewAllLaboratoryBTN;

    @FXML
    private JFXButton Exit,Option;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CoverPane.setVisible(false);
        translation(0.1);
        CoverPane.setOnMouseClicked(event -> {
            translation(1);
        });
    }

    public void translation(double second){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(second),AccountSettingPane);
        translateTransition.setByX(-600);
        translateTransition.play();
        translateTransition.setOnFinished(event -> {
            CoverPane.setVisible(false);
        });
    }
    public void translation1(){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),AccountSettingPane);
        translateTransition.setByX(600);
        translateTransition.play();

    }
    public void OptionAction(){
        CoverPane.setVisible(true);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.1),CoverPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        translation1();
    }
    public void ExitAction(){
        int i= JOptionPane.showConfirmDialog(null,"Are You Sure You Want to Exit The System","Confirmation",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            Platform.exit();
            System.exit(0);
        }
        else {
            translation(1);
            CoverPane.setVisible(false);
        }
    }
}
