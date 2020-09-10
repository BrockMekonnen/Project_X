package com.AASTU.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Warning implements Initializable{

    public static boolean isOk;
    @FXML
    private JFXTextField warnHeaderFld = new JFXTextField();

    @FXML
    private ImageView warnImg = new ImageView();

    @FXML
    private JFXTextField warnBodyFld = new JFXTextField();

    public static boolean isIsOk() {
        return isOk;
    }

    public static void setIsOk(boolean isOk) {
        Warning.isOk = isOk;
    }

    void setWarnHeaderFld(String warnHeader) {
        warnHeaderFld.setText(warnHeader);
    }

    void setWarnImg(String imageView) {
        this.warnImg.setImage(new Image(imageView));
    }

    void setWarnBodyFld(String warnBody) {
        this.warnBodyFld.setText(warnBody);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void handleCancelButton(ActionEvent event) {
        WindowChangeController.closeWindow();
        isOk = false;
    }

    @FXML
    void handleOkButton(ActionEvent event) {
        isOk = true;

//        WindowChangeController.closeWindow();
//        WindowChangeController.closeWindow();
        WindowChangeController.closeWindow();
//         return true;

    }

    @FXML
    void close(MouseEvent event) {
        WindowChangeController.closeWindow();
    }


}


