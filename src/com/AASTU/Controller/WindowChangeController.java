package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.AASTU.Model.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.Doc;
import java.io.IOException;

public class WindowChangeController {

    private Stage stage;
    private static Stage popupStage[]= new Stage[5];
    private static int windowCount=0;
    private static Patient tempObject;

    private double width,height;


    public void signOut(ActionEvent event, String fxml) throws IOException {
        changeWindow(event,fxml);
    }

    public void changeWindow(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(width);
        stage.setHeight(height);
        Scene loginScene =  new Scene(pane,width,height);
        stage.setScene(loginScene);
        stage.show();
        double x =  stage.widthProperty().doubleValue();
        double y = stage.widthProperty().doubleValue();
        width = x;
        height = y;
    }

    public void popupWindow(ActionEvent event, String fxml) throws IOException {

        Parent root = FXMLLoader.load((getClass().getResource(fxml)));
        Scene scene = new Scene(root);
        Stage temp = new Stage();
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.centerOnScreen();
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();
    }

    /* this function accepts mouse event, string text and patient object
     * and create a window that pops up with information inside of patient object */
    public void popupWindow(MouseEvent event, String fxml, Patient obj) throws IOException {
        tempObject = obj;
        FXMLLoader loader = new FXMLLoader((getClass().getResource(fxml)));
        Parent root = loader.load();
        DoctorPatientView view = loader.getController(); // get the controller of DoctorPatientView
        view.setObject(obj); // assign some information from the object to the Scene
        Stage temp = new Stage();
        Scene scene = new Scene(root);
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();

    }
    public void popupWindow1(MouseEvent event,String fxml,Patient obj) throws IOException{


        FXMLLoader loader = new FXMLLoader((getClass().getResource(fxml)));
        Parent root = loader.load();
        LabToDocViewController view = loader.getController(); // get the controller of DoctorPatientView
        view.setWindow(obj,"../View/LabToDoc.fxml"); // assign some information from the object to the Scene
        Stage temp = new Stage();
        Scene scene = new Scene(root);
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();

    }


    /** this function accepts mouse event, string text and patient object
     * and create a window that pops up with information inside of patient object */
    public void secretaryPatientView(MouseEvent event,String fxml,Patient obj) throws IOException {
        tempObject = obj;
        FXMLLoader loader = new FXMLLoader((getClass().getResource(fxml)));
        Parent root = loader.load();
        SecretaryPatientView view1 = loader.getController(); // get the controller of SecretaryPatientView
        view1.setObject(obj);  // sign some information from the object to the Scene
        Stage temp = new Stage();
        Scene scene = new Scene(root);
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();


    }
    public void docLabResultView(ActionEvent event, String fxml) throws IOException {
        LabRequest labObject = new DataLoader().loadLabRequest(tempObject);
        if(labObject == null){
            new WindowChangeController().warningPopup("Not Found","Laboratory Result Not Found!","warn_exclamation.png");
            return;
        }
        FXMLLoader loader = new FXMLLoader((getClass().getResource(fxml)));
        Parent root = loader.load();
        DocLabResultView view = loader.getController();
        view.setLabResult(labObject);
        Stage temp = new Stage();
        Scene scene = new Scene(root);
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();
    }
    public void docLabRequestView(ActionEvent event, String fxml) throws IOException {
        LabRequest labObject = new DataLoader().loadLabRequest(tempObject);
        FXMLLoader loader = new FXMLLoader((getClass().getResource(fxml)));
        Parent root = loader.load();
        DoctorLaboratoryRequestForm view = loader.getController();
        view.setData(tempObject);
        Stage temp = new Stage();
        Scene scene = new Scene(root);
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();
    }

    public void warningPopup(String warnHeader, String warnBody, String imageUrl ) throws IOException {

        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/WarningPopup.fxml")));
        Parent root = loader.load();
        Warning warn = loader.getController();
        warn.setWarnHeaderFld(warnHeader);
        warn.setWarnBodyFld(warnBody);
        warn.setWarnImg(imageUrl);
        Stage temp = new Stage();
        Scene scene = new Scene(root);
        temp.setScene(scene);
        temp.initStyle(StageStyle.UNDECORATED);
        temp.centerOnScreen();
        temp.initModality(Modality.APPLICATION_MODAL);
        popupStage[windowCount] = temp;
        windowCount++;
        temp.showAndWait();
    }

    public static void closeWindow(){
        Stage stage = popupStage[windowCount-1];
        windowCount--;
        stage.close();

    }

}
