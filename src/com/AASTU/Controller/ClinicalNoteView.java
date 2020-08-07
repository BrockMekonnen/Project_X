package com.AASTU.Controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ClinicalNoteView implements Initializable{

    @FXML
    private JFXTextArea noteArea;

    @FXML
    private JFXTextField dateFld;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        dateFld.setText(date.format(formatter));
    }

    public void setText(String text){
        noteArea.setText(text);
    }


}
