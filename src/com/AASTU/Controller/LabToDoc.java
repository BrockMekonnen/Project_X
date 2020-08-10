package com.AASTU.Controller;

import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import org.hibernate.annotations.Check;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LabToDoc implements Initializable {


    @FXML
    private JFXComboBox<?> cbo_vdrl;

    @FXML
    private JFXComboBox<?> cbo_h;

    @FXML
    private JFXComboBox<?> cbo_o;

    @FXML
    private JFXComboBox<?> cbo_felix;

    @FXML
    private JFXComboBox<?> cbo_hbs;

    @FXML
    private JFXComboBox<?> cbo_crp;

    @FXML
    private JFXComboBox<?> cbo_aso;

    @FXML
    private JFXComboBox<?> cbo_rhe;

    @FXML
    private JFXComboBox<?> cbo_serum;

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
    private CheckBox WBCcheckBox;

    @FXML
    private CheckBox LYMCheckBox;

    @FXML
    private CheckBox GRACheckBox;

    @FXML
    private CheckBox MIDCheckBox;

    @FXML
    private CheckBox RBCCheckBox;

    @FXML
    private CheckBox HGBCheckBox;

    @FXML
    private CheckBox MCHCCheckBox;

    @FXML
    private CheckBox MCHCheckBox;

    @FXML
    private CheckBox MCVCheckBox;

    @FXML
    private CheckBox RDW_CVCheckBox;

    @FXML
    private CheckBox HCTCheckBox;

    @FXML
    private CheckBox PLTCheckBox;

    @FXML
    private CheckBox PCTCheckBox;

    @FXML
    private CheckBox P_LCRCheckBox;

    @FXML
    private CheckBox ESRCheckBox;

    @FXML
    private CheckBox Blood_GroupCheckBox;

    @FXML
    private CheckBox Blood_FilmCheckBox;

    @FXML
    private CheckBox VDRLCheckBox;

    @FXML
    private CheckBox Widal_II_H_CheckBox;

    @FXML
    private CheckBox O_CheckBox;

    @FXML
    private CheckBox Well_Felix_CheckBox;

    @FXML
    private CheckBox HBSag_CheckBox;

    @FXML
    private CheckBox CRP_CheckBox;

    @FXML
    private CheckBox ASO_CheckBox;

    @FXML
    private CheckBox Rheumatoid_Factor_CheckBox;

    @FXML
    private CheckBox H_Pylori_Serum_CheckBox;

    @FXML
    private CheckBox Bacteria_CheckBox;

    @FXML
    private CheckBox Casts_CheckBox;

    @FXML
    private CheckBox H_Pylori_Stool_CheckBox;

    @FXML
    private CheckBox KOH_CheckBox;

    @FXML
    private CheckBox UricAcid_CheckBox;

    @FXML
    private CheckBox Color_CheckBox;

    @FXML
    private CheckBox Apperance_CheckBox;

    @FXML
    private CheckBox PH_CheckBox;

    @FXML
    private CheckBox PSGCheckBox;

    @FXML
    private CheckBox Protein_CheckBox;

    @FXML
    private CheckBox Glucose_CheckBox;

    @FXML
    private CheckBox Ketone_CheckBox;

    @FXML
    private CheckBox Bilirubin_CheckBox;

    @FXML
    private CheckBox Urology_CheckBox;

    @FXML
    private CheckBox MicroRBC_CheckBox;

    @FXML
    private CheckBox EpitCell_CheckBox;

    @FXML
    private CheckBox MicroWBC_CheckBox;

    @FXML
    private CheckBox CholestrolCheckBox;

    @FXML
    private CheckBox TotalProtein_CheckBox;

    @FXML
    private CheckBox Blood_CheckBox;

    @FXML
    private JFXComboBox<?> cbo_aids;

    @FXML
    private CheckBox StoolTest_CheckBox;

    @FXML
    private CheckBox OccultBlood_CheckBox;

    @FXML
    private CheckBox Consistency_CheckBox;

    @FXML
    private CheckBox Oval_Paraiste_CheckBox;

    @FXML
    private CheckBox FBS_CheckBox;

    @FXML
    private CheckBox RBS_CheckBox;

    @FXML
    private CheckBox SGOT_CheckBox;

    @FXML
    private CheckBox SGPT_CheckBox;

    @FXML
    private CheckBox Alkaline_Phosphate_CheckBox;

    @FXML
    private CheckBox Bilirubin_Total_CheckBox;

    @FXML
    private CheckBox Bilirubin_Direct_CheckBox;

    @FXML
    private CheckBox Creatinine_CheckBox;

    @FXML
    private CheckBox Gram_Stain_CheckBox;

    @FXML
    private CheckBox Wet_Film_CheckBox;

    @FXML
    private CheckBox AFB_CheckBox;

    @FXML
    private CheckBox HIV_AIDS_CheckBox;

    public static ArrayList<CheckBox> checkBoxes=new ArrayList<CheckBox>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void VisibilityOfCheckBoxes(){
        WBCcheckBox.setVisible(false);
        LYMCheckBox.setVisible(false);
        GRACheckBox.setVisible(false);
        MIDCheckBox.setVisible(false);
        RBCCheckBox.setVisible(false);
        HGBCheckBox.setVisible(false);
        MCHCCheckBox.setVisible(false);
        MCHCCheckBox.setVisible(false);
        MCVCheckBox.setVisible(false);
        RDW_CVCheckBox.setVisible(false);
        HCTCheckBox.setVisible(false);
        PLTCheckBox.setVisible(false);
        PCTCheckBox.setVisible(false);
        P_LCRCheckBox.setVisible(false);
        ESRCheckBox.setVisible(false);
        Blood_GroupCheckBox.setVisible(false);
        Blood_FilmCheckBox.setVisible(false);
        VDRLCheckBox.setVisible(false);
        Widal_II_H_CheckBox.setVisible(false);
        O_CheckBox.setVisible(false);
        Well_Felix_CheckBox.setVisible(false);
        HBSag_CheckBox.setVisible(false);
        CRP_CheckBox.setVisible(false);
        ASO_CheckBox.setVisible(false);
        Rheumatoid_Factor_CheckBox.setVisible(false);
        H_Pylori_Serum_CheckBox.setVisible(false);
        Bacteria_CheckBox.setVisible(false);
        Casts_CheckBox.setVisible(false);
        H_Pylori_Stool_CheckBox.setVisible(false);
        KOH_CheckBox.setVisible(false);
        UricAcid_CheckBox.setVisible(false);
        Color_CheckBox.setVisible(false);
        Apperance_CheckBox.setVisible(false);
        PH_CheckBox.setVisible(false);
        PSGCheckBox.setVisible(false);
        Protein_CheckBox.setVisible(false);
        Glucose_CheckBox.setVisible(false);
        Ketone_CheckBox.setVisible(false);
        Bilirubin_CheckBox.setVisible(false);
        Urology_CheckBox.setVisible(false);
        MicroRBC_CheckBox.setVisible(false);
        EpitCell_CheckBox.setVisible(false);
        MicroWBC_CheckBox.setVisible(false);
        CholestrolCheckBox.setVisible(false);
        TotalProtein_CheckBox.setVisible(false);
        Blood_CheckBox.setVisible(false);
        StoolTest_CheckBox.setVisible(false);
        OccultBlood_CheckBox.setVisible(false);
        Consistency_CheckBox.setVisible(false);
        Oval_Paraiste_CheckBox.setVisible(false);
        FBS_CheckBox.setVisible(false);
        RBS_CheckBox.setVisible(false);
        SGOT_CheckBox.setVisible(false);
        SGPT_CheckBox.setVisible(false);
        Alkaline_Phosphate_CheckBox.setVisible(false);
        Bilirubin_Total_CheckBox.setVisible(false);
        Bilirubin_Direct_CheckBox.setVisible(false);
        Creatinine_CheckBox.setVisible(false);
        Gram_Stain_CheckBox.setVisible(false);
        Wet_Film_CheckBox.setVisible(false);
        AFB_CheckBox.setVisible(false);
        HIV_AIDS_CheckBox.setVisible(false);
        MCHCheckBox.setVisible(false);
    }


    @FXML
    void handleCloseButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
}