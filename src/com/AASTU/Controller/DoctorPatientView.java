package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.Patient;
import com.AASTU.utils.DatabaseThread;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
        DatabaseThread.startClinicalNoteThread();
    }

    private void refreshNodeList() {
        Task<Void> task = new Task<Void>() {

            int listSize =new DataLoader().loadClincalNotes(patient).size();

            @Override
            protected Void call() throws Exception {
                String clinicalNote = "";
                if(listSize > 0){
                    clinicalNote = new DataLoader().loadClincalNotes(patient).get(listSize - 1).getNotes();
                }
                while(DatabaseThread.CLINICALNOTERUNNING) {
                    Thread.sleep(1000);
                    List<ClinicalNotes> list =new DataLoader().loadClincalNotes(patient);
                    if(listSize != list.size()){
                        Platform.runLater(() -> {
                            refreshNodes(list);
                        });
                        listSize = list.size();
                    }
                    if(listSize > 0){
                        if(!clinicalNote.equals(new DataLoader().loadClincalNotes(patient).get(listSize - 1).getNotes())){
                            Platform.runLater(() -> {
                                refreshNodes(list);
                            });
                            clinicalNote = new DataLoader().loadClincalNotes(patient).get(listSize - 1).getNotes();
                        }
                    }
                }
                return null;
            }
        };
        Thread dbThread = new Thread(task);
        dbThread.setDaemon(true);
        dbThread.start();
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
        WindowChangeController change = new WindowChangeController();
        if(!(new DataLoader().loadClinicalNote(this.patient) == null)){
            change.warningPopup("Unfinished Note", "There is note which has not been finished yet", "warn_exclamation.png");
            return;
        }
        change.clinicalNotesView(event,"../View/ClinicalNoteAdd.fxml");
    }

    /** this function accepts Patient Object and assign
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
        refreshNodeList();
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleRequestAction(ActionEvent event) throws IOException {
        WindowChangeController obj = new WindowChangeController();
        if(!(new DataLoader().loadLabRequest(patient) == null)){
            obj.warningPopup("Request Already Exists","Please finish the first request first.", "warn_exclamation.png");
            return;
        }
        obj.docLabRequestView(event, "../View/DoctorLaboratoryRequestForm.fxml");
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
        DatabaseThread.terminateClinicalNoteThread();
    }

    @FXML
    void handleMaxButton(ActionEvent event) {

    }

    @FXML
    void handleCloseCaseButton(ActionEvent event) throws IOException {
        DataSaver saver = new DataSaver();

        patient.setDocActives(false);
        patient.setFromSec(false);
        patient.setFromLab(false);
        patient.setLabActives(false);
        patient.setOnWaiting(false);
        patient.setSecActives(true);
        patient.setPatientStatus(false);

        if( patient.isOutPatinet()){// check if patient is out Patient
            if(patient.getEndDate().compareTo(LocalDate.now()) < 0 )// check if the patient has finished
                patient.setOutPatinet(false);
        }

        new WindowChangeController().warningPopup("Confirm Saving", "Are you sure you went to save it", "warn_confirm.png");
        if(!Warning.isIsOk()){
            return;
        }

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
        WindowChangeController.closeWindow();
    }
}
