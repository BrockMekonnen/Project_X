package com.AASTU.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ClinicalNoteAdd {
    @FXML
    private JFXButton closeBtn;


    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == closeBtn){
            DoctorPatientView.stage.close();
        }
    }

}
