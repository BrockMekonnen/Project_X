package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sun.plugin.javascript.navig.AnchorArray;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class LabToDocViewController implements Initializable {

    @FXML
    private JFXTextField DateTF;

    @FXML
    private JFXTextField SexTF;

    @FXML
    private JFXTextField AgeTF;

    @FXML
    private JFXTextField NameTF;

    @FXML
    private JFXButton maxBtn;

    @FXML
    private JFXButton exitBtn;


    @FXML
    private JFXButton Next;

    @FXML
    private JFXButton Previous;

    @FXML
    private VBox VboxForChildren;

    @FXML
    public AnchorPane rootAnchor;

    private Patient patient=new Patient();

    public ObservableList<LabRequest> Labresults;

    private LabRequest labRequest;

    //to change the inserted data of the scene in the LabToDocControllerView

    private static int changer;

    private List<LabRequest> list;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Editiablity();
        exitBtn.setOnMouseClicked(event -> {
            handleCloseButton();
        });
    }

    public void Editiablity(){
        NameTF.setEditable(false);
        AgeTF.setEditable(false);
        SexTF.setEditable(false);
        DateTF.setEditable(false);
    }

    public void setWindow(Patient patient, String fxml){
        try{
            Next.setVisible(false);
            Previous.setVisible(false);
            this.patient=patient;
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxml));
            AnchorPane root=loader.load();
            LabToDoc contol=loader.getController();
            contol.VisibilityOfCheckBoxes(this.patient);
            rootAnchor.getChildren().add(root);
            setObjectComponents(patient);



            patient.setOnWaiting(true);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setWindowRecord(Patient patient, String fxml){

            list= new DataLoader().LabRequest("from LabRequest where patient_id = " + patient.getPatientId()+" and viewable = 0");
            this.patient=patient;
            if(list.size()>0){
                try{
                FXMLLoader loader=new FXMLLoader(getClass().getResource(fxml));
                AnchorPane root=loader.load();
                RecordPatientView controller=loader.getController();
                controller.SetObjectValue(list.get(changer));
                VboxForChildren.getChildren().add(root);}
                catch (Exception e){
                    e.printStackTrace();
            }
             }
            else {
                    try{
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../View/NoResultIsHere.fxml"));
                AnchorPane root=loader.load();
                VboxForChildren.getChildren().add(root);
                    Next.setVisible(false);
                    }catch (Exception e){
                    e.printStackTrace();}
            }
                setObjectComponents(patient);

            if(changer==list.size()-1){
                Next.setVisible(false);
            }
            if(changer==0){
                Previous.setVisible(false);
            }
            if(changer>0){
                Previous.setVisible(true);
            }
            if(changer<list.size()-1){
                Next.setVisible(true);
            }

    }

    @FXML
    public void NextResult(ActionEvent event){
        changer++;
        VboxForChildren.getChildren().remove(0);
        setWindowRecord(this.patient,"../View/RecordPatientView.fxml");

    }

    @FXML
    public void PreviousResult(ActionEvent event){
        changer--;
        VboxForChildren.getChildren().remove(0);
        setWindowRecord(this.patient,"../View/RecordPatientView.fxml");

    }

    public void setObjectComponents(Patient patient){
        NameTF.setText(patient.getFirstName()+" "+patient.getLastName());
        SexTF.setText(String.valueOf(patient.getSex()));
        AgeTF.setText(String.valueOf(patient.getAge()));
        DateTF.setText(String.valueOf(patient.getDate()));
    }

    @FXML
    public void handleCloseButton(){
        changer=0;
        WindowChangeController.closeWindow();}

}
