package com.AASTU.Controller;

import com.AASTU.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private AnchorPane rootPane;

    Main main=new Main();

    @FXML
    void ToIdentificationWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/IdentificationPane.fxml"));
        Parent pane = loader.load();
        Scene identificationScene =  new Scene(pane);
        Stage identification = (Stage) ((Node) event.getSource()).getScene().getWindow();
        identification.setScene(identificationScene);
        identification.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void gotoDoctor (ActionEvent event,String fxml){
        // Doctor Identification will be checked here
        main.action(event,fxml,rootPane);
    }
    public void gotoLab(ActionEvent event,String fxml){
        // Laboratory Technician Identification will be checked here
        main.action(event,fxml,rootPane);
    }
    public void gotoSec(ActionEvent event,String fxml){
        // Laboratory Technician Identification will be checked here
        main.action(event,fxml,rootPane);
    }
    public void gotoManager(ActionEvent event,String fxml){
        // Laboratory Technician Identification will be checked here
        main.action(event,fxml,rootPane);
    }

    @FXML
   void SignInBTN(ActionEvent event){
        Main main=new Main();

        if(IdentificationController.Identifier==1){
            gotoSec(event,"View/SecretaryWindow.fxml");
        }
        else if(IdentificationController.Identifier==2){
            gotoDoctor(event,"View/DoctorWindow.fxml");
        }
        else if(IdentificationController.Identifier==3){
            gotoLab(event,"View/LaboratoryWindow.fxml");
        }
        else if(IdentificationController.Identifier==4){
            gotoManager(event,"View/ManagerWindow.fxml");
        }
    }
}
