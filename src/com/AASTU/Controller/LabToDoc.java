package com.AASTU.Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LabToDoc implements Initializable {

    @FXML
    private JFXComboBox<?> cbo_vdrl;

    @FXML
    private JFXComboBox<?> cbo_h;

    @FXML
    private JFXComboBox<?> cbo_o;

    @FXML
    private JFXComboBox<?> cbo_felix;

    @FXML
    private JFXComboBox<?> cbo_hbs;

    @FXML
    private JFXComboBox<?> cbo_crp;

    @FXML
    private JFXComboBox<?> cbo_aso;

    @FXML
    private JFXComboBox<?> cbo_rhe;

    @FXML
    private JFXComboBox<?> cbo_serum;

    @FXML
    private JFXComboBox<?> cbo_aids;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        combo_box.getItems().removeAll(combo_box.getItems());
//        combo_box.getItems().addAll( "Positive", "Negative", "Not Selected");
//        combo_box.getSelectionModel().select("Not Selected");
    }
}