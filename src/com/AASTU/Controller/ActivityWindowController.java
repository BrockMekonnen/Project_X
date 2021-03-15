package com.AASTU.Controller;

import com.AASTU.Model.Doctor;
import com.AASTU.Model.Laboratory;
import com.AASTU.Model.Patient;
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
    private Label Data;

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

        Data.setText(work.getActivity_day().toString());
        DetailTA.setText(work.getActivity());
        DetailTA.setEditable(false);
        if(work.getPatientId()==0)
            PatientName.setText("No Patient Data");
        else{
            Patient p=new DataLoader().loadSinglePatinetObject(work);
            PatientName.setText(p.getFirstName()+" "+p.getLastName());}

        if(work.getDoctorId()==0)
            DoctorName.setText("No Doctor Activity");
        else{
            Doctor d=new DataLoader().loadsingleDoctor(work);
            DoctorName.setText(d.getFirstName()+" "+d.getLastName());}

        if(work.getLabTechnicianId()==0)
            LabratoryTechName.setText("No Laboratory Data");
        else{
            Laboratory l=new DataLoader().loadSingleLaboratory(work);
            LabratoryTechName.setText(l.getFirstName()+" "+l.getLastName()); }
    }


}
