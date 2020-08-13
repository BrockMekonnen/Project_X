package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

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

    public Bacteriology bacteriology=new Bacteriology();
    Cbs cbs=new Cbs();
    Chemistry chemistry=new Chemistry();
    Dipstick dipstick=new Dipstick();
    Microscopy microscopy=new Microscopy();
    Others others=new Others();
    Parasitology parasitology=new Parasitology();
    Serology serology=new Serology();

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

    public void setObjectLabTestValue(Patient patient){
        if(!Hema_HBC_TF.getText().isEmpty()){
            cbs.setWbc(new TestProperty(Hema_HBC_TF.getText(),30,true));
        }
        else{
            cbs.setWbc(new TestProperty(" ",0,false));
        }
        if(!LYMTF.getText().isEmpty()){
            cbs.setLym(new TestProperty(LYMTF.getText(),30,true));
        }else{
            cbs.setLym(new TestProperty(" ",0,false));
        }
        if(!GRA_TF.getText().isEmpty()){
            cbs.setGra(new TestProperty(GRA_TF.getText(),30,true));
        }else{
            cbs.setGra(new TestProperty(" ",0,false));
        }

        if(!MID_TF.getText().isEmpty()){
            cbs.setMid(new TestProperty(MID_TF.getText(),30,true));
        }else{
            cbs.setMid(new TestProperty(" ",0,false));
        }
        if(!Hema_RBC_TF.getText().isEmpty()){
            cbs.setRbc(new TestProperty(Hema_RBC_TF.getText(),30,true));
        }else{
            cbs.setRbc(new TestProperty(" ",0,false));
        }
        if(!HGB_TF.getText().isEmpty()){
            cbs.setHgb(new TestProperty(HGB_TF.getText(),30,true));
        }else{
            cbs.setHgb(new TestProperty(" ",0,false));
        }
        if(!MCHC_TF.getText().isEmpty()){
            cbs.setMchc(new TestProperty(MCHC_TF.getText(),30,true));
        }else{
            cbs.setMchc(new TestProperty(" ",0,false));
        }
        if(!MCH_TF.getText().isEmpty()){
            cbs.setMch(new TestProperty(MCH_TF.getText(),30,true));
        }else{
            cbs.setMch(new TestProperty(" ",0,false));
        }
        if(!MCB_TF.getText().isEmpty()){
            cbs.setMcv(new TestProperty(MCB_TF.getText(),30,true));
        }else{
            cbs.setMcv(new TestProperty(" ",0,false));
        }
        if(!RDW_CY_TF.getText().isEmpty()){
            cbs.setRdw_cv(new TestProperty(RDW_CY_TF.getText(),30,true));
        }else{
            cbs.setRdw_cv(new TestProperty(" ",0,false));
        }
        if(!HCT_TF.getText().isEmpty()){
            cbs.setHct(new TestProperty(HCT_TF.getText(),30,true));
        }else{
            cbs.setLym(new TestProperty(" ",0,false));
        }
        if(!PLT_TF.getText().isEmpty()){
            cbs.setPlt(new TestProperty(PLT_TF.getText(),30,true));
        }else{
            cbs.setPlt(new TestProperty(" ",0,false));
        }
        if(!PCT_TF.getText().isEmpty()){
            cbs.setPct(new TestProperty(PCT_TF.getText(),30,true));
        }else{
            cbs.setPct(new TestProperty(" ",0,false));
        }
        if(!P_LCT_TF.getText().isEmpty()){
            cbs.setP_lcr(new TestProperty(P_LCT_TF.getText(),30,true));
        }else{
            cbs.setP_lcr(new TestProperty(" ",0,false));
        }
        if(!ESR_TF.getText().isEmpty()){
            cbs.setEsr(new TestProperty(ESR_TF.getText(),30,true));
        }else{
            cbs.setEsr(new TestProperty(" ",0,false));
        }
        if(!Blood_Group_TF.getText().isEmpty()){
            cbs.setBloodGroupRh(new TestProperty(Blood_Group_TF.getText(),30,true));
        }else{
            cbs.setBloodGroupRh(new TestProperty(" ",0,false));
        }
        if(!Blood_Film_TF.getText().isEmpty()){
            cbs.setBloodFilm(new TestProperty(Blood_Film_TF.getText(),30,true));
        }else{
            cbs.setBloodFilm(new TestProperty(" ",0,false));




        }
        if(!STOOL_TEST_TF.getText().isEmpty()){
            parasitology.setStoolTest(new TestProperty(STOOL_TEST_TF.getText(),0,true));
        }
        else{
            parasitology.setStoolTest(new TestProperty(" ",0,false));
        }
        if(!OCCULT_BLOOD_TF.getText().isEmpty()){
            parasitology.setOccultBlood(new TestProperty(OCCULT_BLOOD_TF.getText(),30,true));
        }
        else{
            parasitology.setOccultBlood(new TestProperty(" ",0,false));
        }
        if(!CONSISTENCY_TF1.getText().isEmpty()){
            parasitology.setConsistency1(new TestProperty(CONSISTENCY_TF1.getText(),30,true));
        }
        else{
            parasitology.setConsistency1(new TestProperty(" ",0,false));
        }
        if(!CONSISTENCY_TF2.getText().isEmpty()){
            parasitology.setConsistency2(new TestProperty(CONSISTENCY_TF2.getText(),30,true));
        }
        else{
            parasitology.setConsistency2(new TestProperty(" ",0,false));
        }
        if(!OVAL_PARASITE_TF1.getText().isEmpty()){
            parasitology.setOvalParasite1(new TestProperty(OVAL_PARASITE_TF1.getText(),0,true));
        }
        else{
            parasitology.setOvalParasite1(new TestProperty(" ",0,false));
        }
        if(!OVAL_PARASITE_TF2.getText().isEmpty()){
            parasitology.setOvalParasite2(new TestProperty(OVAL_PARASITE_TF2.getText(),0,true));
        }
        else{
            parasitology.setOvalParasite2(new TestProperty(" ",0,false));
        }
        if(!OVAL_PARASITE_TF3.getText().isEmpty()){
            parasitology.setOvalParasite3(new TestProperty(OVAL_PARASITE_TF3.getText(),0,true));
        }
        else{
            parasitology.setOvalParasite3(new TestProperty(" ",0,false));
        }



        if(!DIPISTIC_COLOR_TF.getText().isEmpty()){
            dipstick.setTestColor(new TestProperty(DIPISTIC_COLOR_TF.getText(),0,true));
        }else {
            dipstick.setTestColor(new TestProperty(" ",0,false));
        }
        if(!APPERANCE_TF.getText().isEmpty()){
            dipstick.setAppearance(new TestProperty(APPERANCE_TF.getText(),0,true));
        }else {
            dipstick.setAppearance(new TestProperty(" ",0,false));
        }
        if(!PH_TF.getText().isEmpty()){
            dipstick.setPh(new TestProperty(PH_TF.getText(),0,true));
        }else {
            dipstick.setPh(new TestProperty(" ",0,false));
        }
        if(!PSG_TF.getText().isEmpty()){
            dipstick.setPsg(new TestProperty(PSG_TF.getText(),0,true));
        }else {
            dipstick.setPsg(new TestProperty(" ",0,false));
        }
        if(!PROTEIN_TF.getText().isEmpty()){
            dipstick.setProtein(new TestProperty(PROTEIN_TF.getText(),0,true));
        }else {
            dipstick.setProtein(new TestProperty(" ",0,false));
        }
        if(!GLUCOSE_TF.getText().isEmpty()){
            dipstick.setGlucose(new TestProperty(GLUCOSE_TF.getText(),0,true));
        }else {
            dipstick.setGlucose(new TestProperty(" ",0,false));
        }
        if(!KETONE_TF.getText().isEmpty()){
            dipstick.setKetone(new TestProperty(KETONE_TF.getText(),0,true));
        }else {
            dipstick.setKetone(new TestProperty(" ",0,false));
        }
        if(!BILIRUBIN_TF.getText().isEmpty()){
            dipstick.setBilrubin(new TestProperty(BILIRUBIN_TF.getText(),0,true));
        }else {
            dipstick.setBilrubin(new TestProperty(" ",0,false));
        }
        if(!UROBILINOGEN_TF.getText().isEmpty()){
            dipstick.setUrobilinogen(new TestProperty(UROBILINOGEN_TF.getText(),0,true));
        }else {
            dipstick.setUrobilinogen(new TestProperty(" ",0,false));
        }
        if(!BLOOD_TF.getText().isEmpty()){
            dipstick.setBlood(new TestProperty(BLOOD_TF.getText(),0,true));
        }else {
            dipstick.setBlood(new TestProperty(" ",0,false));
        }



        if(!EPIT_CELLS_TF.getText().isEmpty()){
            microscopy.setEpitCells(new TestProperty(EPIT_CELLS_TF.getText(),0,true));
        }
        else {
            microscopy.setEpitCells(new TestProperty(" ",0,false));
        }
        if(WBC_TF.getText().isEmpty()){
            microscopy.setWbc(new TestProperty(WBC_TF.getText(),0,true));
        }
        else{
            microscopy.setWbc(new TestProperty(" ",0,false));
        }
        if(!RBC_TF.getText().isEmpty()){
            microscopy.setRbc(new TestProperty(RBC_TF.getText(),0,true));
        }
        else {
            microscopy.setRbc(new TestProperty(" ",0,false));
        }
        if(!CASTS_TF.getText().isEmpty()){
            microscopy.setCasts(new TestProperty(CASTS_TF.getText(),0,true));
        }
        else {
            microscopy.setCasts(new TestProperty(" ",0,false));
        }
        if(!BACTERIA_TF.getText().isEmpty()){
            microscopy.setBacteria(new TestProperty(BACTERIA_TF.getText(),0,true));
        }
        else {
            microscopy.setBacteria(new TestProperty(" ",0,false));
        }



        if(!FSB_TF.getText().isEmpty()){
            chemistry.setFbs(new TestProperty(FSB_TF.getText(),0,true));
        }
        else {
            chemistry.setFbs(new TestProperty(" ",0,false));
        }
        if(!RBS_TF.getText().isEmpty()){
            chemistry.setRbs(new TestProperty(RBS_TF.getText(),0,true));
        }
        else {
            chemistry.setRbs(new TestProperty(" ",0,false));
        }
        if(!SGOP_TF.getText().isEmpty()){
            chemistry.setSgot(new TestProperty(SGOP_TF.getText(),0,true));
        }
        else {
            chemistry.setSgot(new TestProperty(" ",0,false));
        }
        if(!SGPT_TF.getText().isEmpty()){
            chemistry.setSgpt(new TestProperty(SGPT_TF.getText(),0,true));
        }
        else {
            chemistry.setSgpt(new TestProperty(" ",0,false));
        }
        if(!ALKALINE_PHOSPHATE_TF.getText().isEmpty()){
            chemistry.setAlkalinePhosphate(new TestProperty(ALKALINE_PHOSPHATE_TF.getText(),0,true));
        }
        else {
            chemistry.setAlkalinePhosphate(new TestProperty(" ",0,false));
        }
        if(!BILIRUBIN_TOTAL_TF.getText().isEmpty()){
            chemistry.setBilirubinTotal(new TestProperty(BILIRUBIN_TOTAL_TF.getText(),0,true));
        }
        else {
            chemistry.setBilirubinTotal(new TestProperty(" ",0,false));
        }
        if(!BILIRUBIN_DIRECT_TF.getText().isEmpty()){
            chemistry.setBilirubinDirect(new TestProperty(BILIRUBIN_DIRECT_TF.getText(),0,true));
        }
        else {
            chemistry.setBilirubinDirect(new TestProperty(" ",0,false));
        }
        if(!BUN_TF.getText().isEmpty()){
            chemistry.setBun(new TestProperty(BUN_TF.getText(),0,true));
        }
        else {
            chemistry.setBun(new TestProperty(" ",0,false));
        }
        if(!CREATININE_TF.getText().isEmpty()){
            chemistry.setCreatinine(new TestProperty(CREATININE_TF.getText(),0,true));
        }
        else {
            chemistry.setCreatinine(new TestProperty(" ",0,false));
        }
        if(!URIC_ACID_TF.getText().isEmpty()){
            chemistry.setUricAcid(new TestProperty(URIC_ACID_TF.getText(),0,true));
        }
        else {
            chemistry.setUricAcid(new TestProperty(" ",0,false));
        }
        if(!TOTAL_PROTEIN_TF.getText().isEmpty()){
            chemistry.setTotalProtein(new TestProperty(TOTAL_PROTEIN_TF.getText(),0,true));
        }
        else {
            chemistry.setTotalProtein(new TestProperty(" ",0,false));
        }
        if(!CHOLESTEROEL_TF.getText().isEmpty()){
            chemistry.setCholesterol(new TestProperty(CHOLESTEROEL_TF.getText(),0,true));
        }
        else {
            chemistry.setCholesterol(new TestProperty(" ",0,false));
        }




        if(!cbo_vdrl.getSelectionModel().isEmpty()){
            serology.setVdrl(new TestProperty(cbo_vdrl.getSelectionModel().getSelectedItem().toString(),0,true));
        }
        else {
            serology.setVdrl(new TestProperty(" ",0,false));
        }
        if(!cbo_h.getSelectionModel().isEmpty()){
            serology.setWidal_II_h(new TestProperty(cbo_h.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setWidal_II_h(new TestProperty(" ",0,false));
        }
        if(!cbo_o.getSelectionModel().isEmpty()){
            serology.setWidal_II_o(new TestProperty(cbo_o.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setWidal_II_o(new TestProperty(" ",0,false));
        }
        if(!cbo_felix.getSelectionModel().isEmpty()){
            serology.setWellFelix(new TestProperty(cbo_felix.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setWellFelix(new TestProperty(" ",0,false));
        }
        if(!cbo_hbs.getSelectionModel().isEmpty()){
            serology.setHbsag(new TestProperty(cbo_hbs.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setHbsag(new TestProperty(" ",0,false));
        }
        if(!cbo_crp.getSelectionModel().isEmpty()){
            serology.setCrp(new TestProperty(cbo_crp.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setCrp(new TestProperty(" ",0,false));
        }
        if(!cbo_aso.getSelectionModel().isEmpty()){
            serology.setAso(new TestProperty(cbo_aso.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setAso(new TestProperty(" ",0,false));
        }
        if(!cbo_rhe.getSelectionModel().isEmpty()){
            serology.setRheumatoidFactor(new TestProperty(cbo_rhe.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setRheumatoidFactor(new TestProperty(" ",0,false));
        }
        if(!cbo_serum.getSelectionModel().isEmpty()){
            serology.setHpyloriSerum(new TestProperty(cbo_serum.getSelectionModel().getSelectedItem(),0,true));
        }
        else {
            serology.setHpyloriSerum(new TestProperty(" ",0,false));
        }





        if(!H_PYLORI_STOOL_TF.getText().isEmpty()){
            bacteriology.setHpyloriStool(new TestProperty(H_PYLORI_STOOL_TF.getText(),0,true));
        }
        else {
            bacteriology.setHpyloriStool(new TestProperty(" ",0,false));
        }
        if(!KOH_TF.getText().isEmpty()){
            bacteriology.setKoh(new TestProperty(KOH_TF.getText(),0,true));
        }
        else {
            bacteriology.setKoh(new TestProperty(" ",0,false));
        }




        if(!AFB_TF.getText().isEmpty()){
            others.setAfb(new TestProperty(AFB_TF.getText(),0,true));
        }
        else {
            others.setAfb(new TestProperty(" ",0,false));
        }
        if(!Wet_Film_TF.getText().isEmpty()){
            others.setWetFilm(new TestProperty(Wet_Film_TF.getText(),0,true));
        }
        else {
            others.setAfb(new TestProperty(" ",0,false));
        }
        if(!Gram_Stain_TF.getText().isEmpty()){
            others.setGramStain(new TestProperty(Gram_Stain_TF.getText(),0,true));
        }
        else {
            others.setAfb(new TestProperty(" ",0,false));
        }
        if(!cbo_aids.getSelectionModel().isEmpty()) {
            others.setHivAids(new TestProperty(cbo_aids.getSelectionModel().getSelectedItem(), 0, true));
        }
        else{
            others.setHivAids(new TestProperty(" ",0,false));
        }

//        LabRequest labRequest=new LabRequest(LaboratoryWindowController.LaboratoryId,"id", LocalDate.now(),parasitology,bacteriology,microscopy,chemistry,dipstick,others,cbs,serology);
//        patient.addLabRequest(labRequest);
    }

}