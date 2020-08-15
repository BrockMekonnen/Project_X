package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorPatientView implements Initializable{

    @FXML
    private VBox pnl_Scroll;

    @FXML
    private JFXTextField nameFld;

    @FXML
    private JFXTextField ageFld;

    @FXML
    private JFXTextField sexFld;

    @FXML
    private JFXTextField cityFld;

    @FXML
    private JFXTextField subcityFld;

    @FXML
    private JFXTextField kebeleFld;

    @FXML
    private JFXTextField phoneFld;

    @FXML
    private JFXTextField houseFld;

    @FXML
    private JFXTextField dateFld;

    @FXML
    private JFXTextField idFld;

    private Patient patient;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private void refreshNodes(List<ClinicalNotes> list){

        pnl_Scroll.getChildren().clear();

        for(int i=0;i<list.size();i++){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ClinicalNoteView.fxml"));
                AnchorPane root = loader.load();
                ClinicalNoteView loadData = loader.getController();
                loadData.isEditVisible(list.get(i).isEditable());
                loadData.setText(list.get(i).getNotes());
                loadData.setDate(list.get(i).getDate());
                pnl_Scroll.getChildren().add(root);
            } catch (IOException e){
                Logger.getLogger(DoctorPatientView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    void handleAddNoteButton(ActionEvent event) throws IOException {
        new WindowChangeController().clinicalNotesView(event,"../View/ClinicalNoteAdd.fxml");
    }

    /* this function accepts Patient Object and assign
     * some values to the textField */
    public void setObject(Patient object){
        this.patient = object;
        nameFld.setText(object.getFirstName() + " " + object.getLastName());
        ageFld.setText(( String.valueOf(object.getAge())));
        sexFld.setText(String.valueOf(object.getSex()));
        cityFld.setText(object.getCity());
        subcityFld.setText(object.getSubcity());
        kebeleFld.setText(object.getKebele());
        phoneFld.setText(object.getPhoneNumber());
        houseFld.setText(object.getHouseNumber());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        dateFld.setText(object.getDate().format(formatter));
        idFld.setText(String.valueOf(object.getPatientId()));
        refreshNodes(new DataLoader().loadClincalNotes(object));

    }

    @FXML
    void handleBackButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleRequestAction(ActionEvent event) throws IOException {
        new WindowChangeController().docLabRequestView(event, "../View/DoctorLaboratoryRequestForm.fxml");
    }

    @FXML
    void handleOutPatientButton(ActionEvent event) throws IOException {
        new WindowChangeController().outPatientView(event, "../View/NewOutPatient.fxml");
    }

    @FXML
    void handleResultButton(ActionEvent event) throws IOException {
        new WindowChangeController().docLabResultView(event, "../View/DocLabResultView.fxml");
    }

    @FXML
    void handleExitButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleMaxButton(ActionEvent event) {

    }

    @FXML
    void handleCloseCaseButton(ActionEvent event) {
        DataSaver saver = new DataSaver();

        patient.setDocActives(false);
        patient.setPatientStatus(false);
        patient.setFromSec(false);
        patient.setFromLab(false);

        LabRequest request = new DataLoader().loadLabRequest(patient);
        if(request != null){
            request.setViewable(false);
            saver.saveEditedLabResult(request, false);
        }

        ClinicalNotes note = new DataLoader().loadClinicalNote(patient);
        if(note != null){
            saver.saveEditedClinicalNote(note.getNoteId(), false);
        }

        saver.saveEditedPatient(patient);

        System.out.println(patient.isDocActives());
        System.out.println(patient.isPatientStatus());

    }
}
