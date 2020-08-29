package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.corba.se.spi.monitoring.LongMonitoredAttributeBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import javax.xml.crypto.Data;
import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LabToDoc implements Initializable {

    @FXML
    private JFXTextField Hema_HBC_TF,Wet_Film_TF;

    @FXML
    private JFXTextField LYMTF,AFB_TF;

    @FXML
    private JFXTextField GRA_TF;

    @FXML
    private JFXTextField MID_TF;

    @FXML
    private JFXTextField Hema_RBC_TF,RBC_TF;

    @FXML
    private JFXTextField HGB_TF;

    @FXML
    private JFXTextField MCHC_TF;

    @FXML
    private JFXTextField MCH_TF;

    @FXML
    private JFXTextField MCB_TF;

    @FXML
    private JFXTextField RDW_CY_TF;

    @FXML
    private JFXTextField HCT_TF;

    @FXML
    private JFXTextField PLT_TF;

    @FXML
    private JFXTextField PCT_TF;

    @FXML
    private JFXTextField P_LCT_TF;

    @FXML
    private JFXTextField ESR_TF;

    @FXML
    private JFXTextField Blood_Group_TF;

    @FXML
    private JFXTextField Blood_Film_TF;

    @FXML
    private JFXTextField STOOL_TEST_TF;

    @FXML
    private JFXTextField OCCULT_BLOOD_TF;

    @FXML
    private JFXTextField CONSISTENCY_TF1;

    @FXML
    private JFXTextField CONSISTENCY_TF2;

    @FXML
    private JFXTextField OVAL_PARASITE_TF1;

    @FXML
    private JFXTextField OVAL_PARASITE_TF2;

    @FXML
    private JFXTextField OVAL_PARASITE_TF3;

    @FXML
    private JFXTextField DIPISTIC_COLOR_TF;

    @FXML
    private JFXTextField APPERANCE_TF;

    @FXML
    private JFXTextField PH_TF;

    @FXML
    private JFXTextField PSG_TF;

    @FXML
    private JFXTextField PROTEIN_TF;

    @FXML
    private JFXTextField GLUCOSE_TF;

    @FXML
    private JFXTextField KETONE_TF;

    @FXML
    private JFXTextField BILIRUBIN_TF;

    @FXML
    private JFXTextField UROBILINOGEN_TF;

    @FXML
    private JFXTextField BLOOD_TF;

    @FXML
    private JFXTextField EPIT_CELLS_TF;

    @FXML
    private JFXTextField WBC_TF;

    @FXML
    private JFXTextField CASTS_TF;

    @FXML
    private JFXTextField BACTERIA_TF;

    @FXML
    private JFXTextField FSB_TF;

    @FXML
    private JFXTextField RBS_TF;

    @FXML
    private JFXTextField SGOP_TF;

    @FXML
    private JFXTextField SGPT_TF;

    @FXML
    private JFXTextField ALKALINE_PHOSPHATE_TF;

    @FXML
    private JFXTextField BILIRUBIN_TOTAL_TF;

    @FXML
    private JFXTextField BILIRUBIN_DIRECT_TF;

    @FXML
    private JFXTextField BUN_TF;

    @FXML
    private JFXTextField CREATININE_TF;

    @FXML
    private JFXTextField URIC_ACID_TF;

    @FXML
    private JFXTextField TOTAL_PROTEIN_TF;

    @FXML
    private JFXTextField CHOLESTEROEL_TF;

    @FXML
    private JFXTextField H_PYLORI_STOOL_TF;

    @FXML
    private JFXTextField KOH_TF;

    @FXML
    private JFXComboBox<String> cbo_vdrl;

    @FXML
    private JFXComboBox<String> cbo_h;

    @FXML
    private JFXComboBox<String> cbo_o;

    @FXML
    private JFXComboBox<String> cbo_felix;

    @FXML
    private JFXComboBox<String> cbo_hbs;

    @FXML
    private JFXComboBox<String> cbo_crp;

    @FXML
    private JFXComboBox<String> cbo_aso;

    @FXML
    private JFXComboBox<String> cbo_rhe;

    @FXML
    private JFXComboBox<String> cbo_serum;

    @FXML
    private JFXTextField Gram_Stain_TF;

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
    private JFXComboBox<String> cbo_aids;

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
    private CheckBox RBS_CheckBox,Bun_CheckBox;

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

    private LabRequest labRequest;

    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void VisibilityOfCheckBoxes(Patient patient){
        this.patient=patient;
        labRequest=new DataLoader().loadLabRequest(patient);
        WBCcheckBox.setVisible(labRequest.getCbs().getWbc().isTest());
        WBCcheckBox.setSelected(true);
        LYMCheckBox.setVisible(labRequest.getCbs().getLym().isTest());
        LYMCheckBox.setSelected(true);
        GRACheckBox.setVisible(labRequest.getCbs().getGra().isTest());
        GRACheckBox.setSelected(true);
        MIDCheckBox.setVisible(labRequest.getCbs().getMid().isTest());
        MIDCheckBox.setSelected(true);
        RBCCheckBox.setVisible(labRequest.getCbs().getRbc().isTest());
        RBCCheckBox.setSelected(true);
        HGBCheckBox.setVisible(labRequest.getCbs().getHgb().isTest());
        HGBCheckBox.setSelected(true);
        MCHCCheckBox.setVisible(labRequest.getCbs().getMchc().isTest());
        MCHCCheckBox.setSelected(true);
        MCVCheckBox.setVisible(labRequest.getCbs().getMcv().isTest());
        MCVCheckBox.setSelected(true);
        RDW_CVCheckBox.setVisible(labRequest.getCbs().getRdw_cv().isTest());
        RDW_CVCheckBox.setSelected(true);
        HCTCheckBox.setVisible(labRequest.getCbs().getHct().isTest());
        HCTCheckBox.setSelected(true);
        PLTCheckBox.setVisible(labRequest.getCbs().getPlt().isTest());
        PLTCheckBox.setSelected(true);
        PCTCheckBox.setVisible(labRequest.getCbs().getPct().isTest());
        PCTCheckBox.setSelected(true);
        P_LCRCheckBox.setVisible(labRequest.getCbs().getP_lcr().isTest());
        P_LCRCheckBox.setSelected(true);
        ESRCheckBox.setVisible(labRequest.getCbs().getEsr().isTest());
        ESRCheckBox.setSelected(true);
        Blood_GroupCheckBox.setVisible(labRequest.getCbs().getBloodGroupRh().isTest());
        Blood_GroupCheckBox.setSelected(true);
        Blood_FilmCheckBox.setVisible(labRequest.getCbs().getBloodFilm().isTest());
        Blood_FilmCheckBox.setSelected(true);
        VDRLCheckBox.setVisible(labRequest.getSerology().getVdrl().isTest());
        VDRLCheckBox.setSelected(true);
        Widal_II_H_CheckBox.setVisible(labRequest.getSerology().getWidal_II_h().isTest());
        Widal_II_H_CheckBox.setSelected(true);
        O_CheckBox.setVisible(labRequest.getSerology().getWidal_II_o().isTest());
        O_CheckBox.setSelected(true);
        Well_Felix_CheckBox.setVisible(labRequest.getSerology().getWellFelix().isTest());
        Well_Felix_CheckBox.setSelected(true);
        HBSag_CheckBox.setVisible(labRequest.getSerology().getHbsag().isTest());
        HBSag_CheckBox.setSelected(true);
        CRP_CheckBox.setVisible(labRequest.getSerology().getCrp().isTest());
        CRP_CheckBox.setSelected(true);
        ASO_CheckBox.setVisible(labRequest.getSerology().getAso().isTest());
        ASO_CheckBox.setSelected(true);
        Rheumatoid_Factor_CheckBox.setVisible(labRequest.getSerology().getRheumatoidFactor().isTest());
        Rheumatoid_Factor_CheckBox.setSelected(true);
        H_Pylori_Serum_CheckBox.setVisible(labRequest.getSerology().getHpyloriSerum().isTest());
        H_Pylori_Serum_CheckBox.setSelected(true);
        Bacteria_CheckBox.setVisible(labRequest.getMicroscopy().getBacteria().isTest());
        Bacteria_CheckBox.setSelected(true);
        Casts_CheckBox.setVisible(labRequest.getMicroscopy().getCasts().isTest());
        Casts_CheckBox.setSelected(true);
        H_Pylori_Stool_CheckBox.setVisible(labRequest.getBacterology().getHpyloriStool().isTest());
        H_Pylori_Stool_CheckBox.setSelected(true);
        KOH_CheckBox.setVisible(labRequest.getBacterology().getKoh().isTest());
        KOH_CheckBox.setSelected(true);
        UricAcid_CheckBox.setVisible(labRequest.getChemistry().getUricAcid().isTest());
        UricAcid_CheckBox.setSelected(true);
        Color_CheckBox.setVisible(labRequest.getDipistic().getTestColor().isTest());
        Color_CheckBox.setSelected(true);
        Apperance_CheckBox.setVisible(labRequest.getDipistic().getAppearance().isTest());
        Apperance_CheckBox.setSelected(true);
        PH_CheckBox.setVisible(labRequest.getDipistic().getPh().isTest());
        PH_CheckBox.setSelected(true);
        PSGCheckBox.setVisible(labRequest.getDipistic().getPsg().isTest());
        PSGCheckBox.setSelected(true);
        Protein_CheckBox.setVisible(labRequest.getDipistic().getProtein().isTest());
        Protein_CheckBox.setSelected(true);
        Glucose_CheckBox.setVisible(labRequest.getDipistic().getGlucose().isTest());
        Glucose_CheckBox.setSelected(true);
        Ketone_CheckBox.setVisible(labRequest.getDipistic().getKetone().isTest());
        Ketone_CheckBox.setSelected(true);
        Bilirubin_CheckBox.setVisible(labRequest.getDipistic().getBilrubin().isTest());
        Bilirubin_CheckBox.setSelected(true);
        Urology_CheckBox.setVisible(labRequest.getDipistic().getUrobilinogen().isTest());
        Urology_CheckBox.setSelected(true);
        MicroRBC_CheckBox.setVisible(labRequest.getMicroscopy().getRbc().isTest());
        MicroRBC_CheckBox.setSelected(true);
        EpitCell_CheckBox.setVisible(labRequest.getMicroscopy().getEpitCells().isTest());
        EpitCell_CheckBox.setSelected(true);
        MicroWBC_CheckBox.setVisible(labRequest.getMicroscopy().getWbc().isTest());
        MicroWBC_CheckBox.setSelected(true);
        CholestrolCheckBox.setVisible(labRequest.getChemistry().getCholesterol().isTest());
        CholestrolCheckBox.setSelected(true);
        TotalProtein_CheckBox.setVisible(labRequest.getChemistry().getTotalProtein().isTest());
        TotalProtein_CheckBox.setSelected(true);
        Blood_CheckBox.setVisible(labRequest.getDipistic().getBlood().isTest());
        Blood_CheckBox.setSelected(true);
        StoolTest_CheckBox.setVisible(labRequest.getParasitology().getStoolTest().isTest());
        StoolTest_CheckBox.setSelected(true);
        OccultBlood_CheckBox.setVisible(labRequest.getParasitology().getOccultBlood().isTest());
        OccultBlood_CheckBox.setSelected(true);
        Consistency_CheckBox.setVisible(labRequest.getParasitology().getConsistency1().isTest());
        Consistency_CheckBox.setSelected(true);
        Oval_Paraiste_CheckBox.setVisible(labRequest.getParasitology().getOvalParasite1().isTest());
        Oval_Paraiste_CheckBox.setSelected(true);
        FBS_CheckBox.setVisible(labRequest.getChemistry().getFbs().isTest());
        FBS_CheckBox.setSelected(true);
        RBS_CheckBox.setVisible(labRequest.getChemistry().getRbs().isTest());
        RBS_CheckBox.setSelected(true);
        SGOT_CheckBox.setVisible(labRequest.getChemistry().getSgot().isTest());
        SGOT_CheckBox.setSelected(true);
        SGPT_CheckBox.setVisible(labRequest.getChemistry().getSgpt().isTest());
        SGPT_CheckBox.setSelected(true);
        Alkaline_Phosphate_CheckBox.setVisible(labRequest.getChemistry().getAlkalinePhosphate().isTest());
        Alkaline_Phosphate_CheckBox.setSelected(true);
        Bilirubin_Total_CheckBox.setVisible(labRequest.getChemistry().getBilirubinTotal().isTest());
        Bilirubin_Total_CheckBox.setSelected(true);
        Bilirubin_Direct_CheckBox.setVisible(labRequest.getChemistry().getBilirubinDirect().isTest());
        Bilirubin_CheckBox.setSelected(true);
        Creatinine_CheckBox.setVisible(labRequest.getChemistry().getCreatinine().isTest());
        Creatinine_CheckBox.setSelected(true);
        Gram_Stain_CheckBox.setVisible(labRequest.getOthers().getGramStain().isTest());
        Gram_Stain_CheckBox.setSelected(true);
        Wet_Film_CheckBox.setVisible(labRequest.getOthers().getWetFilm().isTest());
        Wet_Film_CheckBox.setSelected(true);
        AFB_CheckBox.setVisible(labRequest.getOthers().getAfb().isTest());
        AFB_CheckBox.setSelected(true);
        HIV_AIDS_CheckBox.setVisible(labRequest.getOthers().getHivAids().isTest());
        HIV_AIDS_CheckBox.setSelected(true);
        MCHCheckBox.setVisible(labRequest.getCbs().getMchc().isTest());
        MCHCCheckBox.setSelected(true);
        Bun_CheckBox.setVisible(labRequest.getChemistry().getBun().isTest());
        Bun_CheckBox.setSelected(true);
        MCHCheckBox.setSelected(true);
        if(patient.isOnWaiting()) {
            exceptionForWaiting(labRequest);
        }
    }

    @FXML
    public void send(ActionEvent e){
        setObjectLabTestValue(patient,false,true,false,true,true);

    }

    @FXML
    public void wait(ActionEvent e){
        setObjectLabTestValue(patient,true,false,true,true,false);
    }

    @FXML
    public void cancel(ActionEvent e){
        WindowChangeController.closeWindow();
    }

    public void setObjectLabTestValue( Patient patient, boolean waiting, boolean docActive, boolean labActive,boolean fromLab,boolean secActive){

        boolean check=true;

        if(labRequest.getCbs().getWbc().isTest() && (Hema_HBC_TF.getText().isEmpty() || Hema_HBC_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getCbs().getLym().isTest() && (LYMTF.getText().isEmpty() || LYMTF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getWbc().setValue(Hema_HBC_TF.getText());
        labRequest.getCbs().getLym().setValue(LYMTF.getText());
        if(labRequest.getCbs().getGra().isTest() && (GRA_TF.getText().isEmpty() || GRA_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getGra().setValue(GRA_TF.getText());

        if(labRequest.getCbs().getMid().isTest() && (MID_TF.getText().isEmpty() || MID_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getMid().setValue(MID_TF.getText());

        if(labRequest.getCbs().getRbc().isTest() && (Hema_RBC_TF.getText().isEmpty() || Hema_RBC_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getRbc().setValue(Hema_RBC_TF.getText());

        if(labRequest.getCbs().getHgb().isTest() && (HGB_TF.getText().isEmpty() || HGB_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getHgb().setValue(HGB_TF.getText());


        if(labRequest.getCbs().getMchc().isTest() && (MCHC_TF.getText().isEmpty() || MCHC_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getMchc().setValue(MCHC_TF.getText());

        if(labRequest.getCbs().getMch().isTest() && (MCH_TF.getText().isEmpty() || MCH_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getMch().setValue(MCH_TF.getText());

        if(labRequest.getCbs().getMcv().isTest() && (MCB_TF.getText().isEmpty() || MCB_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getMcv().setValue(MCB_TF.getText());

        if(labRequest.getCbs().getRdw_cv().isTest() && (RDW_CY_TF.getText().isEmpty() || RDW_CY_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getRdw_cv().setValue(RDW_CY_TF.getText());

        if(labRequest.getCbs().getHct().isTest() && (HCT_TF.getText().isEmpty() || HCT_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getHct().setValue(HCT_TF.getText());

        if(labRequest.getCbs().getPlt().isTest() && (PLT_TF.getText().isEmpty() || PLT_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getPlt().setValue(PLT_TF.getText());

        if(labRequest.getCbs().getPct().isTest() && (PCT_TF.getText().isEmpty() || PCT_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getPct().setValue(PCT_TF.getText());

        if(labRequest.getCbs().getP_lcr().isTest() && (P_LCT_TF.getText().isEmpty() || P_LCT_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getP_lcr().setValue(P_LCT_TF.getText());

        if(labRequest.getCbs().getEsr().isTest() && (ESR_TF.getText().isEmpty() || ESR_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getEsr().setValue(ESR_TF.getText());

        if(labRequest.getCbs().getBloodGroupRh().isTest() && (Blood_Group_TF.getText().isEmpty() || Blood_Group_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getBloodGroupRh().setValue(Blood_Group_TF.getText());
        if(labRequest.getCbs().getBloodFilm().isTest() && (Blood_Film_TF.getText().isEmpty() || Blood_Film_TF.getText().equals(" ")))
            check=false;
        labRequest.getCbs().getBloodFilm().setValue(Blood_Film_TF.getText());

        if(labRequest.getParasitology().getStoolTest().isTest() && (STOOL_TEST_TF.getText().isEmpty() || STOOL_TEST_TF.getText().equals(" ")))
            check=false;
        labRequest.getParasitology().getStoolTest().setValue(STOOL_TEST_TF.getText());

        if(labRequest.getParasitology().getOccultBlood().isTest() && (OCCULT_BLOOD_TF.getText().isEmpty() || OCCULT_BLOOD_TF.getText().equals(" ")))
            check=false;
        labRequest.getParasitology().getOccultBlood().setValue(OCCULT_BLOOD_TF.getText());
        if(labRequest.getParasitology().getConsistency1().isTest() && (CONSISTENCY_TF1.getText().isEmpty() || CONSISTENCY_TF1.getText().equals(" ")))
            check=false;
        labRequest.getParasitology().getConsistency1().setValue(CONSISTENCY_TF1.getText());
        if(labRequest.getParasitology().getConsistency2().isTest() && (CONSISTENCY_TF2.getText().isEmpty() || CONSISTENCY_TF2.getText().equals(" ")))
            check=false;
        labRequest.getParasitology().getConsistency2().setValue(CONSISTENCY_TF2.getText());
        if(labRequest.getParasitology().getOvalParasite1().isTest() && (CONSISTENCY_TF2.getText().isEmpty() || CONSISTENCY_TF2.getText().equals(" ")))
            check=false;
        if(labRequest.getParasitology().getOvalParasite1().isTest() && (OVAL_PARASITE_TF1.getText().isEmpty() || OVAL_PARASITE_TF1.getText().equals(" ")))
            check=false;
        if(labRequest.getParasitology().getOvalParasite2().isTest() && (OVAL_PARASITE_TF2.getText().isEmpty() || OVAL_PARASITE_TF2.getText().equals(" ")))
            check=false;
        if(labRequest.getParasitology().getOvalParasite3().isTest() && (OVAL_PARASITE_TF3.getText().isEmpty() || OVAL_PARASITE_TF3.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getTestColor().isTest() && (DIPISTIC_COLOR_TF.getText().isEmpty() || DIPISTIC_COLOR_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getAppearance().isTest() && (APPERANCE_TF.getText().isEmpty() || APPERANCE_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getPh().isTest() && (PH_TF.getText().isEmpty() || PH_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getPsg().isTest() && (PSG_TF.getText().isEmpty() || PSG_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getProtein().isTest() && (PROTEIN_TF.getText().isEmpty() || PROTEIN_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getKetone().isTest() && (KETONE_TF.getText().isEmpty() || KETONE_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getBilrubin().isTest() && (BILIRUBIN_TF.getText().isEmpty() || BILIRUBIN_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getUrobilinogen().isTest() && (UROBILINOGEN_TF.getText().isEmpty() || UROBILINOGEN_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getGlucose().isTest() && (GLUCOSE_TF.getText().isEmpty() || GLUCOSE_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getDipistic().getBlood().isTest() && (BLOOD_TF.getText().isEmpty() || BLOOD_TF.getText().equals(" ")))
            check=false;
        labRequest.getParasitology().getOvalParasite1().setValue(OVAL_PARASITE_TF1.getText());
        labRequest.getParasitology().getOvalParasite2().setValue(OVAL_PARASITE_TF2.getText());
        labRequest.getParasitology().getOvalParasite3().setValue(OVAL_PARASITE_TF3.getText());
        labRequest.getDipistic().getTestColor().setValue(DIPISTIC_COLOR_TF.getText());
        labRequest.getDipistic().getAppearance().setValue(APPERANCE_TF.getText());
        labRequest.getDipistic().getPh().setValue(PH_TF.getText());
        labRequest.getDipistic().getGlucose().setValue(GLUCOSE_TF.getText());
        labRequest.getDipistic().getPsg().setValue(PSG_TF.getText());
        labRequest.getDipistic().getProtein().setValue(PROTEIN_TF.getText());
        labRequest.getDipistic().getKetone().setValue(KETONE_TF.getText());
        labRequest.getDipistic().getBilrubin().setValue(BILIRUBIN_TF.getText());
        labRequest.getDipistic().getUrobilinogen().setValue(UROBILINOGEN_TF.getText());
        labRequest.getDipistic().getBlood().setValue(BLOOD_TF.getText());


        if(labRequest.getMicroscopy().getEpitCells().isTest() && (EPIT_CELLS_TF.getText().isEmpty() || EPIT_CELLS_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getMicroscopy().getWbc().isTest() && (WBC_TF.getText().isEmpty() || WBC_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getMicroscopy().getRbc().isTest() && (RBC_TF.getText().isEmpty() || RBC_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getMicroscopy().getCasts().isTest() && (CASTS_TF.getText().isEmpty() || CASTS_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getMicroscopy().getBacteria().isTest() && (BACTERIA_TF.getText().isEmpty() || BACTERIA_TF.getText().equals(" ")))
            check=false;
        labRequest.getMicroscopy().getEpitCells().setValue(EPIT_CELLS_TF.getText());
        labRequest.getMicroscopy().getWbc().setValue(WBC_TF.getText());
        labRequest.getMicroscopy().getRbc().setValue(RBC_TF.getText());
        labRequest.getMicroscopy().getCasts().setValue(CASTS_TF.getText());
        labRequest.getMicroscopy().getBacteria().setValue(BACTERIA_TF.getText());
        if(labRequest.getChemistry().getFbs().isTest() && (FSB_TF.getText().isEmpty() || FSB_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getRbs().isTest() && (RBS_TF.getText().isEmpty() || RBS_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getSgot().isTest() && (SGOP_TF.getText().isEmpty() || SGOP_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getSgpt().isTest() && (SGPT_TF.getText().isEmpty() || SGPT_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getAlkalinePhosphate().isTest() && (ALKALINE_PHOSPHATE_TF.getText().isEmpty() || ALKALINE_PHOSPHATE_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getBilirubinTotal().isTest() && (BILIRUBIN_TOTAL_TF.getText().isEmpty() || BILIRUBIN_TOTAL_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getBilirubinDirect().isTest() && (BILIRUBIN_DIRECT_TF.getText().isEmpty() || BILIRUBIN_DIRECT_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getBun().isTest() && (BUN_TF.getText().isEmpty() || BUN_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getCreatinine().isTest() && (CREATININE_TF.getText().isEmpty() || CREATININE_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getUricAcid().isTest() && (URIC_ACID_TF.getText().isEmpty() || URIC_ACID_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getTotalProtein().isTest() && (TOTAL_PROTEIN_TF.getText().isEmpty() || TOTAL_PROTEIN_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getChemistry().getCholesterol().isTest() && (CHOLESTEROEL_TF.getText().isEmpty() || CHOLESTEROEL_TF.getText().equals(" ")))
            check=false;
        labRequest.getChemistry().getFbs().setValue(FSB_TF.getText());
        labRequest.getChemistry().getRbs().setValue(RBS_TF.getText());
        labRequest.getChemistry().getSgot().setValue(SGOP_TF.getText());
        labRequest.getChemistry().getSgpt().setValue(SGPT_TF.getText());
        labRequest.getChemistry().getAlkalinePhosphate().setValue(ALKALINE_PHOSPHATE_TF.getText());
        labRequest.getChemistry().getBilirubinTotal().setValue(BILIRUBIN_TOTAL_TF.getText());
        labRequest.getChemistry().getBilirubinDirect().setValue(BILIRUBIN_DIRECT_TF.getText());
        labRequest.getChemistry().getBun().setValue(BUN_TF.getText());
        labRequest.getChemistry().getCreatinine().setValue(CREATININE_TF.getText());
        labRequest.getChemistry().getUricAcid().setValue(URIC_ACID_TF.getText());
        labRequest.getChemistry().getTotalProtein().setValue(TOTAL_PROTEIN_TF.getText());
        labRequest.getChemistry().getCholesterol().setValue(CHOLESTEROEL_TF.getText());
        if(labRequest.getSerology().getVdrl().isTest() && cbo_vdrl.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getWidal_II_h().isTest() && cbo_h.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getWidal_II_o().isTest() && cbo_o.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getWellFelix().isTest() && cbo_felix.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getHbsag().isTest() && cbo_hbs.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getCrp().isTest() && cbo_crp.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getAso().isTest() && cbo_aso.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getRheumatoidFactor().isTest() && cbo_rhe.getSelectionModel().isEmpty())
            check=false;
        if(labRequest.getSerology().getHpyloriSerum().isTest() && cbo_serum.getSelectionModel().isEmpty())
            check=false;
        labRequest.getSerology().getVdrl().setValue(cbo_vdrl.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getWidal_II_h().setValue(cbo_h.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getWidal_II_o().setValue(cbo_o.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getWellFelix().setValue(cbo_felix.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getHbsag().setValue(cbo_hbs.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getCrp().setValue(cbo_crp.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getAso().setValue(cbo_aso.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getRheumatoidFactor().setValue(cbo_rhe.getSelectionModel().getSelectedItem());
        labRequest.getSerology().getHpyloriSerum().setValue(cbo_serum.getSelectionModel().getSelectedItem());
        if(labRequest.getBacterology().getHpyloriStool().isTest() && (H_PYLORI_STOOL_TF.getText().isEmpty() || H_PYLORI_STOOL_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getBacterology().getKoh().isTest() && (KOH_TF.getText().isEmpty() || KOH_TF.getText().equals(" ")))
            check=false;
        labRequest.getBacterology().getHpyloriStool().setValue(H_PYLORI_STOOL_TF.getText());
        labRequest.getBacterology().getKoh().setValue(KOH_TF.getText());
        if(labRequest.getOthers().getAfb().isTest() && (AFB_TF.getText().isEmpty() || AFB_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getOthers().getWetFilm().isTest() && (Wet_Film_TF.getText().isEmpty() || Wet_Film_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getOthers().getGramStain().isTest() && (Gram_Stain_TF.getText().isEmpty() || Gram_Stain_TF.getText().equals(" ")))
            check=false;
        if(labRequest.getOthers().getHivAids().isTest() && cbo_aids.getSelectionModel().isEmpty())
            check=false;
        labRequest.getOthers().getAfb().setValue(AFB_TF.getText());
        labRequest.getOthers().getWetFilm().setValue(Wet_Film_TF.getText());
        labRequest.getOthers().getGramStain().setValue(Gram_Stain_TF.getText());
        labRequest.getOthers().getHivAids().setValue(cbo_aids.getSelectionModel().getSelectedItem());

        if(waiting)
            check=true;

        if(check){

        new DataSaver().updateLabresult(patient,labRequest,labRequest.getId());
        patient.setOnWaiting(waiting);
        patient.setDocActives(docActive);
        patient.setLabActives(labActive);
        patient.setFromLab(fromLab);
        patient.setSecActives(secActive);
        new DataSaver().saveEditedPatient(patient);
            WindowChangeController.closeWindow();
    }
    else {
            try {
                new WindowChangeController().warningPopup("Attention", "Please fill Doctors Check Point", "warn_exclamation.png");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void exceptionForWaiting(LabRequest labRequest){

        if(!labRequest.getCbs().getWbc().getValue().isEmpty())
            Hema_HBC_TF.setText(String.valueOf(labRequest.getCbs().getWbc().getValue()));
        if(!labRequest.getCbs().getLym().getValue().isEmpty())
            LYMTF.setText(String.valueOf(labRequest.getCbs().getLym().getValue()));
        if(!labRequest.getCbs().getGra().getValue().isEmpty())
            GRA_TF.setText(String.valueOf(labRequest.getCbs().getGra().getValue()));
        if(!labRequest.getCbs().getMid().getValue().isEmpty())
            MID_TF.setText(String.valueOf(labRequest.getCbs().getMid().getValue()));
        if(!labRequest.getCbs().getRbc().getValue().isEmpty())
            Hema_RBC_TF.setText(String.valueOf(labRequest.getCbs().getRbc().getValue()));
        if(!labRequest.getCbs().getHgb().getValue().isEmpty())
            HGB_TF.setText(String.valueOf(labRequest.getCbs().getHgb().getValue()));
        if(!labRequest.getCbs().getMchc().getValue().isEmpty())
           MCHC_TF.setText(labRequest.getCbs().getMchc().getValue());
        if(!labRequest.getCbs().getMch().getValue().isEmpty())
            MCH_TF.setText(labRequest.getCbs().getMch().getValue());

        if(!labRequest.getCbs().getMcv().getValue().isEmpty())
            MCB_TF.setText(String.valueOf(labRequest.getCbs().getMcv().getValue()));
        if(!labRequest.getCbs().getRdw_cv().getValue().isEmpty())
            RDW_CY_TF.setText(String.valueOf(labRequest.getCbs().getRdw_cv().getValue()));

        if(!labRequest.getCbs().getHct().getValue().isEmpty())
            HCT_TF.setText(String.valueOf(labRequest.getCbs().getHct().getValue()));

        if(!labRequest.getCbs().getPlt().getValue().isEmpty())
            PLT_TF.setText(String.valueOf(labRequest.getCbs().getPct().getValue()));
        if(!labRequest.getCbs().getPct().getValue().isEmpty())
            PCT_TF.setText(String.valueOf(labRequest.getCbs().getPct().getValue()));
        if(!labRequest.getCbs().getP_lcr().getValue().isEmpty())
            P_LCT_TF.setText(String.valueOf(labRequest.getCbs().getP_lcr().getValue()));

        if(!labRequest.getCbs().getEsr().getValue().isEmpty())
            ESR_TF.setText(String.valueOf(labRequest.getCbs().getEsr().getValue()));
        if(!labRequest.getCbs().getBloodGroupRh().getValue().isEmpty())
            Blood_Group_TF.setText(String.valueOf(labRequest.getCbs().getBloodGroupRh().getValue()));

        if(!labRequest.getCbs().getBloodFilm().getValue().isEmpty())
            Blood_Film_TF.setText(String.valueOf(labRequest.getCbs().getBloodFilm().getValue()));
        if(!labRequest.getParasitology().getOccultBlood().getValue().isEmpty())
            OCCULT_BLOOD_TF.setText(String.valueOf(labRequest.getParasitology().getOccultBlood().getValue()));

        if(!labRequest.getParasitology().getStoolTest().getValue().isEmpty())
            STOOL_TEST_TF.setText(String.valueOf(labRequest.getParasitology().getConsistency1().getValue()));

        if(!labRequest.getParasitology().getConsistency1().getValue().isEmpty())
            CONSISTENCY_TF1.setText(String.valueOf(labRequest.getParasitology().getConsistency1().getValue()));
        if(!labRequest.getParasitology().getConsistency2().getValue().isEmpty())
            CONSISTENCY_TF2.setText(String.valueOf(labRequest.getParasitology().getConsistency2().getValue()));
        if(!labRequest.getParasitology().getOvalParasite1().getValue().isEmpty())
            OVAL_PARASITE_TF1.setText(String.valueOf(labRequest.getParasitology().getOvalParasite1().getValue()));

        if(!labRequest.getParasitology().getOvalParasite2().getValue().isEmpty())
            OVAL_PARASITE_TF2.setText(String.valueOf(labRequest.getParasitology().getOvalParasite2().getValue()));

        if(!labRequest.getParasitology().getOvalParasite3().getValue().isEmpty())
            OVAL_PARASITE_TF3.setText(String.valueOf(labRequest.getParasitology().getOvalParasite3().getValue()));


        if(!labRequest.getDipistic().getTestColor().getValue().isEmpty())
           DIPISTIC_COLOR_TF.setText(String.valueOf(labRequest.getDipistic().getTestColor().getValue()));
        if(!labRequest.getDipistic().getAppearance().getValue().isEmpty())
            APPERANCE_TF.setText(String.valueOf(labRequest.getDipistic().getAppearance().getValue()));
        if(!labRequest.getDipistic().getPh().getValue().isEmpty())
            PH_TF.setText(String.valueOf(labRequest.getDipistic().getPh().getValue()));
        if(!labRequest.getDipistic().getPsg().getValue().isEmpty())
            PSG_TF.setText(String.valueOf(labRequest.getDipistic().getPsg().getValue()));
        if(!labRequest.getDipistic().getGlucose().getValue().isEmpty())
            GLUCOSE_TF.setText(String.valueOf(labRequest.getDipistic().getGlucose().getValue()));
        if(!labRequest.getDipistic().getProtein().getValue().isEmpty())
            PROTEIN_TF.setText(String.valueOf(labRequest.getDipistic().getProtein().getValue()));
        if(!labRequest.getDipistic().getKetone().getValue().isEmpty())
            KETONE_TF.setText(String.valueOf(labRequest.getDipistic().getKetone().getValue()));
        if(!labRequest.getDipistic().getUrobilinogen().getValue().isEmpty())
           UROBILINOGEN_TF.setText(String.valueOf(labRequest.getDipistic().getUrobilinogen().getValue()));

        if(!labRequest.getMicroscopy().getEpitCells().getValue().isEmpty())
            EPIT_CELLS_TF.setText(String.valueOf(labRequest.getMicroscopy().getEpitCells().getValue()));
        if(!labRequest.getDipistic().getBlood().getValue().isEmpty())
            BLOOD_TF.setText(String.valueOf(labRequest.getDipistic().getBlood().getValue()));
        if(!labRequest.getMicroscopy().getWbc().getValue().isEmpty())
            WBC_TF.setText(String.valueOf(labRequest.getMicroscopy().getWbc().getValue()));
        if(!labRequest.getMicroscopy().getRbc().getValue().isEmpty())
            RBC_TF.setText(String.valueOf(labRequest.getMicroscopy().getRbc().getValue()));
        if(!labRequest.getMicroscopy().getCasts().getValue().isEmpty())
            CASTS_TF.setText(String.valueOf(labRequest.getMicroscopy().getCasts().getValue()));
        if(!labRequest.getMicroscopy().getBacteria().getValue().isEmpty())
            BACTERIA_TF.setText(String.valueOf(labRequest.getMicroscopy().getBacteria().getValue()));

        if(!labRequest.getChemistry().getFbs().getValue().isEmpty())
           FSB_TF.setText(String.valueOf(labRequest.getChemistry().getFbs().getValue()));
        if(!labRequest.getChemistry().getRbs().getValue().isEmpty())
           RBS_TF.setText(String.valueOf(labRequest.getChemistry().getRbs().getValue()));
        if(!labRequest.getChemistry().getSgot().getValue().isEmpty())
           SGOP_TF.setText(String.valueOf(labRequest.getChemistry().getSgot().getValue()));
        if(!labRequest.getChemistry().getSgpt().getValue().isEmpty())
           SGPT_TF.setText(String.valueOf(labRequest.getChemistry().getSgpt().getValue()));
        if(!labRequest.getChemistry().getAlkalinePhosphate().getValue().isEmpty())
            ALKALINE_PHOSPHATE_TF.setText(String.valueOf(labRequest.getChemistry().getAlkalinePhosphate().getValue()));
        if(!labRequest.getChemistry().getBilirubinTotal().getValue().isEmpty())
            BILIRUBIN_TOTAL_TF.setText(String.valueOf(labRequest.getChemistry().getBilirubinTotal().getValue()));
        if(!labRequest.getChemistry().getBilirubinDirect().getValue().isEmpty())
            BILIRUBIN_DIRECT_TF.setText(String.valueOf(labRequest.getChemistry().getBilirubinDirect().getValue()));
        if(!labRequest.getChemistry().getBun().getValue().isEmpty())
            BUN_TF.setText(String.valueOf(labRequest.getChemistry().getBun().getValue()));
        if(!labRequest.getChemistry().getCreatinine().getValue().isEmpty())
            CREATININE_TF.setText(String.valueOf(labRequest.getChemistry().getCreatinine().getValue()));
        if(!labRequest.getChemistry().getUricAcid().getValue().isEmpty())
            URIC_ACID_TF.setText(String.valueOf(labRequest.getChemistry().getUricAcid().getValue()));


        if(!labRequest.getChemistry().getTotalProtein().getValue().isEmpty())
            TOTAL_PROTEIN_TF.setText(String.valueOf(labRequest.getChemistry().getTotalProtein().getValue()));
        if(!labRequest.getChemistry().getCholesterol().getValue().isEmpty())
            CHOLESTEROEL_TF.setText(String.valueOf(labRequest.getChemistry().getCholesterol().getValue()));

        if(!labRequest.getBacterology().getHpyloriStool().getValue().isEmpty())
            H_PYLORI_STOOL_TF.setText(String.valueOf(labRequest.getBacterology().getHpyloriStool().getValue()));
        if(!labRequest.getBacterology().getKoh().getValue().isEmpty())
            KOH_TF.setText(String.valueOf(labRequest.getBacterology().getKoh().getValue()));
        if(!labRequest.getOthers().getAfb().getValue().isEmpty())
            AFB_TF.setText(String.valueOf(labRequest.getOthers().getAfb().getValue()));


        if(!labRequest.getOthers().getWetFilm().getValue().isEmpty())
            Wet_Film_TF.setText(String.valueOf(labRequest.getOthers().getWetFilm().getValue()));
        if(!labRequest.getOthers().getGramStain().getValue().isEmpty())
            Gram_Stain_TF.setText(String.valueOf(labRequest.getOthers().getGramStain().getValue()));
        if(labRequest.getSerology().getVdrl().getValue()!=null){
            cbo_vdrl.getSelectionModel().select(String.valueOf(labRequest.getSerology().getVdrl().getValue()));
        }



        if(labRequest.getSerology().getWidal_II_h().getValue()!=null)
            cbo_h.getSelectionModel().select(String.valueOf(labRequest.getSerology().getWidal_II_h().getValue()));
        if(labRequest.getSerology().getWidal_II_o().getValue()!=null)
            cbo_o.getSelectionModel().select(String.valueOf(labRequest.getSerology().getWidal_II_o().getValue()));
        if(labRequest.getSerology().getWellFelix().getValue()!=null)
            cbo_felix.getSelectionModel().select(String.valueOf(labRequest.getSerology().getWellFelix().getValue()));
        if(labRequest.getSerology().getHbsag().getValue()!=null)
            cbo_hbs.getSelectionModel().select(String.valueOf(labRequest.getSerology().getHbsag().getValue()));
        if(labRequest.getSerology().getCrp().getValue()!=null)
            cbo_crp.getSelectionModel().select(String.valueOf(labRequest.getSerology().getCrp().getValue()));

        if(labRequest.getSerology().getAso().getValue()!=null)
            cbo_aso.getSelectionModel().select(String.valueOf(labRequest.getSerology().getAso().getValue()));
        if(labRequest.getSerology().getRheumatoidFactor().getValue()!=null)
            cbo_rhe.getSelectionModel().select(String.valueOf(labRequest.getSerology().getRheumatoidFactor().getValue()));
        if(labRequest.getSerology().getHpyloriSerum().getValue()!=null)
            cbo_serum.getSelectionModel().select(String.valueOf(labRequest.getSerology().getHpyloriSerum().getValue()));
        if(labRequest.getOthers().getHivAids().getValue()!=null)
            cbo_aids.getSelectionModel().select(String.valueOf(labRequest.getOthers().getHivAids().getValue()));
    }


    }