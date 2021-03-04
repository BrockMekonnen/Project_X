package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ClinicalNoteView implements Initializable{

    @FXML
    private JFXTextArea noteArea;

    @FXML
    private JFXTextField dateFld;

    @FXML
    private JFXButton editButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void isEditVisible(boolean value){
        editButton.setVisible(value);
    }

    public void setDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        dateFld.setText(date.format(formatter));
    }

    public void setText(String text){
        noteArea.setText(text);
    }

    @FXML
    void handleEditButton(ActionEvent event) throws IOException {
        new WindowChangeController().clinicalNotesView(event,"../View/ClinicalNoteAdd.fxml");
    }

}
