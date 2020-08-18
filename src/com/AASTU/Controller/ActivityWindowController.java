package com.AASTU.Controller;

import com.AASTU.Model.WorkActivity;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ActivityWindowController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label DoctorName;

    @FXML
    private Label PatientName;

    @FXML
    private Label LabratoryTechName;

    @FXML
    private TextArea DetailTA;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    public void cancelAction(ActionEvent event){
        WindowChangeController.closeWindow();

    }
    public void setComponents(WorkActivity work){
        // to access the name we have to register doctor,secretary and lab technician in the database first
        DetailTA.setText(work.getActivity());
        PatientName.setText(new DataLoader().loadSinglePatinetObject(work).getFirstName()+" "+new DataLoader().loadSinglePatinetObject(work).getLastName());
        DoctorName.setText(new DataLoader().loadsingleDoctor(work).getFirstName()+" "+new DataLoader().loadsingleDoctor(work).getLastName());
        LabratoryTechName.setText(new DataLoader().loadSingleLaboratory(work).getFirstName()+" "+new DataLoader().loadSingleLaboratory(work).getLastName());
    }


}
