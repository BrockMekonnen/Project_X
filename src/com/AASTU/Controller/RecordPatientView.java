package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RecordPatientView implements Initializable {

    @FXML
    public Label dateLabel;

    @FXML
    private JFXTextField Hema_HBC_TF=new JFXTextField();

    @FXML
    private JFXTextField Wet_Film_TF=new JFXTextField();

    @FXML
    private JFXTextField LYMTF=new JFXTextField(),AFB_TF=new JFXTextField();

    @FXML
    private JFXTextField GRA_TF=new JFXTextField();

    @FXML
    private JFXTextField MID_TF=new JFXTextField();

    @FXML
    private JFXTextField Hema_RBC_TF=new JFXTextField(),RBC_TF=new JFXTextField();

    @FXML
    private JFXTextField HGB_TF=new JFXTextField();

    @FXML
    private JFXTextField MCHC_TF=new JFXTextField();

    @FXML
    private JFXTextField MCH_TF=new JFXTextField();

    @FXML
    private JFXTextField MCB_TF=new JFXTextField();

    @FXML
    private JFXTextField RDW_CY_TF=new JFXTextField();

    @FXML
    private JFXTextField HCT_TF=new JFXTextField();

    @FXML
    private JFXTextField PLT_TF=new JFXTextField();

    @FXML
    private JFXTextField PCT_TF=new JFXTextField();

    @FXML
    private JFXTextField P_LCT_TF=new JFXTextField();

    @FXML
    private JFXTextField ESR_TF=new JFXTextField();

    @FXML
    public JFXTextField Blood_Group_TF=new JFXTextField();

    @FXML
    private JFXTextField Blood_Film_TF=new JFXTextField();

    @FXML
    private JFXTextField STOOL_TEST_TF=new JFXTextField();

    @FXML
    private JFXTextField OCCULT_BLOOD_TF=new JFXTextField();

    @FXML
    private JFXTextField CONSISTENCY_TF1=new JFXTextField();

    @FXML
    private JFXTextField CONSISTENCY_TF2=new JFXTextField();

    @FXML
    private JFXTextField OVAL_PARASITE_TF1=new JFXTextField();

    @FXML
    private JFXTextField OVAL_PARASITE_TF2=new JFXTextField();

    @FXML
    private JFXTextField OVAL_PARASITE_TF3=new JFXTextField();

    @FXML
    private JFXTextField DIPISTIC_COLOR_TF=new JFXTextField();

    @FXML
    private JFXTextField APPERANCE_TF=new JFXTextField();

    @FXML
    private JFXTextField PH_TF=new JFXTextField();

    @FXML
    private JFXTextField PSG_TF=new JFXTextField();

    @FXML
    private JFXTextField PROTEIN_TF=new JFXTextField();

    @FXML
    private JFXTextField GLUCOSE_TF=new JFXTextField();

    @FXML
    private JFXTextField KETONE_TF=new JFXTextField();

    @FXML
    private JFXTextField BILIRUBIN_TF=new JFXTextField();

    @FXML
    private JFXTextField UROBILINOGEN_TF=new JFXTextField();

    @FXML
    private JFXTextField BLOOD_TF=new JFXTextField();

    @FXML
    private JFXTextField EPIT_CELLS_TF=new JFXTextField();


    @FXML
    private JFXTextField WBC_TF=new JFXTextField();

    @FXML
    private JFXTextField CASTS_TF=new JFXTextField();

    @FXML
    private JFXTextField BACTERIA_TF=new JFXTextField();

    @FXML
    private JFXTextField FSB_TF=new JFXTextField();

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
    private JFXComboBox<String> cbo_serum,cbo_aids;

    @FXML
    private JFXTextField Gram_Stain_TF;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void SetObjectValue(LabRequest labRequest){
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

        if(!labRequest.getMicroscopy().getEpitCells().getValue().trim().isEmpty())
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

        if(labRequest.getSerology().getVdrl().getValue()!=null && !labRequest.getSerology().getVdrl().getValue().isEmpty())
            cbo_vdrl.getSelectionModel().select(String.valueOf(labRequest.getSerology().getVdrl().getValue()));

        if(labRequest.getSerology().getWidal_II_h().getValue()!=null && !labRequest.getSerology().getWidal_II_h().getValue().isEmpty())
            cbo_h.getSelectionModel().select(String.valueOf(labRequest.getSerology().getWidal_II_h().getValue()));
        if(labRequest.getSerology().getWidal_II_o().getValue()!=null && !labRequest.getSerology().getWidal_II_o().getValue().isEmpty())
            cbo_o.getSelectionModel().select(String.valueOf(labRequest.getSerology().getWidal_II_o().getValue()));
        if(labRequest.getSerology().getWellFelix().getValue()!=null && !labRequest.getSerology().getWellFelix().getValue().isEmpty())
            cbo_felix.getSelectionModel().select(String.valueOf(labRequest.getSerology().getWellFelix().getValue()));
        if(labRequest.getSerology().getHbsag().getValue()!=null && !labRequest.getSerology().getHbsag().getValue().isEmpty())
            cbo_hbs.getSelectionModel().select(String.valueOf(labRequest.getSerology().getHbsag().getValue()));
        if(labRequest.getSerology().getCrp().getValue()!=null && !labRequest.getSerology().getCrp().getValue().isEmpty())
            cbo_crp.getSelectionModel().select(String.valueOf(labRequest.getSerology().getCrp().getValue()));

        if(labRequest.getSerology().getAso().getValue()!=null && !labRequest.getSerology().getAso().getValue().isEmpty())
            cbo_aso.getSelectionModel().select(String.valueOf(labRequest.getSerology().getAso().getValue()));
        if(labRequest.getSerology().getRheumatoidFactor().getValue()!=null && !labRequest.getSerology().getRheumatoidFactor().getValue().isEmpty())
            cbo_rhe.getSelectionModel().select(String.valueOf(labRequest.getSerology().getRheumatoidFactor().getValue()));
        if(labRequest.getSerology().getHpyloriSerum().getValue()!=null && !labRequest.getSerology().getHpyloriSerum().getValue().isEmpty())
            cbo_serum.getSelectionModel().select(String.valueOf(labRequest.getSerology().getHpyloriSerum().getValue()));
        if(labRequest.getOthers().getHivAids().getValue()!=null && !labRequest.getOthers().getHivAids().getValue().isEmpty())
            cbo_aids.getSelectionModel().select(String.valueOf(labRequest.getOthers().getHivAids().getValue()));
        dateLabel.setText(labRequest.getRequestDate().toString());

    }
}
