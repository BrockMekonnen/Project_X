package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.AASTU.Model.Patient;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DoctorLaboratoryRequestForm implements Initializable {

    @FXML
    private JFXCheckBox selectAllCbc;

    @FXML
    private JFXCheckBox cbcWbc;

    @FXML
    private JFXCheckBox cbcLym;

    @FXML
    private JFXCheckBox cbcMid;

    @FXML
    private JFXCheckBox cbcGra;

    @FXML
    private JFXCheckBox cbcRbc;

    @FXML
    private JFXCheckBox cbcHgb;

    @FXML
    private JFXCheckBox cbcMchc;

    @FXML
    private JFXCheckBox cbcMch;

    @FXML
    private JFXCheckBox cbcMcv;

    @FXML
    private JFXCheckBox cbcRdwCv;

    @FXML
    private JFXCheckBox cbcHct;

    @FXML
    private JFXCheckBox cbcPlt;

    @FXML
    private JFXCheckBox cbcPct;

    @FXML
    private JFXCheckBox cbcPlcr;

    @FXML
    private JFXCheckBox cbcEsr;

    @FXML
    private JFXCheckBox BloodGroupRh;

    @FXML
    private JFXCheckBox BloodFilm;

    @FXML
    private JFXCheckBox stoolTest;

    @FXML
    private JFXCheckBox occultBlood;

    @FXML
    private JFXCheckBox consistency;

    @FXML
    private JFXCheckBox ovalParasite;

    @FXML
    private JFXCheckBox selectAllParasitology;

    @FXML
    private JFXCheckBox selectAllLst;

    @FXML
    private JFXCheckBox sgot;

    @FXML
    private JFXCheckBox sgpt;

    @FXML
    private JFXCheckBox alkalinePhosphate;

    @FXML
    private JFXCheckBox bilirubinTotal;

    @FXML
    private JFXCheckBox bilirubinDirect;

    @FXML
    private JFXCheckBox bun;

    @FXML
    private JFXCheckBox creatinine;

    @FXML
    private JFXCheckBox selectAllRst;

    @FXML
    private JFXCheckBox uricAcid;

    @FXML
    private JFXCheckBox totalProtein;

    @FXML
    private JFXCheckBox cholesterol;

    @FXML
    private JFXCheckBox selectAllChemistryOther;

    @FXML
    private JFXCheckBox urinColor;

    @FXML
    private JFXCheckBox urinAppearance;

    @FXML
    private JFXCheckBox urinPh;

    @FXML
    private JFXCheckBox urinPsg;

    @FXML
    private JFXCheckBox urinProtein;

    @FXML
    private JFXCheckBox urinGlucose;

    @FXML
    private JFXCheckBox urinKetone;

    @FXML
    private JFXCheckBox urinBilirubin;

    @FXML
    private JFXCheckBox urinUrobilinogen;

    @FXML
    private JFXCheckBox urinBlood;

    @FXML
    private JFXCheckBox selectAllDipistic;

    @FXML
    private JFXCheckBox urinEpitCells;

    @FXML
    private JFXCheckBox urinWbc;

    @FXML
    private JFXCheckBox urinRbc;

    @FXML
    private JFXCheckBox urinCasts;

    @FXML
    private JFXCheckBox urinBacteria;

    @FXML
    private JFXCheckBox selectAllMicroscopy;

    @FXML
    private JFXCheckBox seroVdrl;

    @FXML
    private JFXCheckBox seroWidall;

    @FXML
    private JFXCheckBox seroWellFelix;

    @FXML
    private JFXCheckBox seroHbsag;

    @FXML
    private JFXCheckBox seroCrp;

    @FXML
    private JFXCheckBox seroAso;

    @FXML
    private JFXCheckBox seroRheumatoidFactor;

    @FXML
    private JFXCheckBox seroHpyloriSerum;

    @FXML
    private JFXCheckBox selectAllSerology;

    @FXML
    private JFXCheckBox bactHpyloriStool;

    @FXML
    private JFXCheckBox bactKoh;

    @FXML
    private JFXCheckBox selectAllBacterology;

    @FXML
    private JFXCheckBox gramStain;

    @FXML
    private JFXCheckBox wetFilm;

    @FXML
    private JFXCheckBox afb;

    @FXML
    private JFXCheckBox hivAids;

    @FXML
    private JFXCheckBox fbs;

    @FXML
    private JFXCheckBox rbs;



    @FXML
    private JFXTextField nameFld;

    @FXML
    private JFXTextField ageFld;

    @FXML
    private JFXTextField sexFld;

    @FXML
    private JFXTextField dateFld;

    private Patient patient;

    public void setData(Patient patient){
        this.patient = patient;
        nameFld.setText(String.valueOf(patient.getFirstName() + " " + patient.getLastName()));
        ageFld.setText(String.valueOf(patient.getAge()));
        sexFld.setText(String .valueOf(patient.getSex()));
        dateFld.setText(String.valueOf(LocalDate.now()));
    }



    @FXML
    void handleAllBacterology(ActionEvent event) {
        bactHpyloriStool.setSelected(selectAllBacterology.isSelected());
        bactKoh.setSelected(selectAllBacterology.isSelected());
    }

    @FXML // select all Categories under Serology
    void handleAllSerology(ActionEvent event) {
        seroVdrl.setSelected(selectAllSerology.isSelected());
        seroWidall.setSelected(selectAllSerology.isSelected());
        seroWellFelix.setSelected(selectAllSerology.isSelected());
        seroHbsag.setSelected(selectAllSerology.isSelected());
        seroCrp.setSelected(selectAllSerology.isSelected());
        seroAso.setSelected(selectAllSerology.isSelected());
        seroRheumatoidFactor.setSelected(selectAllSerology.isSelected());
        seroHpyloriSerum.setSelected(selectAllSerology.isSelected());
    }

    @FXML// Select All Categorise under Microscopy
    void handleAllMicroscopy(ActionEvent event) {
        urinEpitCells.setSelected(selectAllMicroscopy.isSelected());
        urinWbc.setSelected(selectAllMicroscopy.isSelected());
        urinRbc.setSelected(selectAllMicroscopy.isSelected());
        urinCasts.setSelected(selectAllMicroscopy.isSelected());
        urinBacteria.setSelected(selectAllMicroscopy.isSelected());

    }

    @FXML
    void handleAllDipistic(ActionEvent event) {
        urinColor.setSelected(selectAllDipistic.isSelected());
        urinAppearance.setSelected(selectAllDipistic.isSelected());
        urinPh.setSelected(selectAllDipistic.isSelected());
        urinPsg.setSelected(selectAllDipistic.isSelected());
        urinProtein.setSelected(selectAllDipistic.isSelected());
        urinGlucose.setSelected(selectAllDipistic.isSelected());
        urinKetone.setSelected(selectAllDipistic.isSelected());
        urinBilirubin.setSelected(selectAllDipistic.isSelected());
        urinUrobilinogen.setSelected(selectAllDipistic.isSelected());
        urinBlood.setSelected(selectAllDipistic.isSelected());
    }

    @FXML
    void handleAllOtherChemistry(ActionEvent event) {
        uricAcid.setSelected(selectAllChemistryOther.isSelected());
        totalProtein.setSelected(selectAllChemistryOther.isSelected());
        cholesterol.setSelected(selectAllChemistryOther.isSelected());
    }

    @FXML
    void handleAllRst(ActionEvent event) {
        bun.setSelected(selectAllRst.isSelected());
        creatinine.setSelected(selectAllRst.isSelected());
    }

    @FXML
    void handleAllLst(ActionEvent event) {
        sgot.setSelected(selectAllLst.isSelected());
        sgpt.setSelected(selectAllLst.isSelected());
        alkalinePhosphate.setSelected(selectAllLst.isSelected());
        bilirubinTotal.setSelected(selectAllLst.isSelected());
        bilirubinDirect.setSelected(selectAllLst.isSelected());
    }

    @FXML
    void handleAllCbc(ActionEvent event) {
        cbcWbc.setSelected(selectAllCbc.isSelected());
        cbcLym.setSelected(selectAllCbc.isSelected());
        cbcMid.setSelected(selectAllCbc.isSelected());
        cbcGra.setSelected(selectAllCbc.isSelected());
        cbcRbc.setSelected(selectAllCbc.isSelected());
        cbcHgb.setSelected(selectAllCbc.isSelected());
        cbcMchc.setSelected(selectAllCbc.isSelected());
        cbcMch.setSelected(selectAllCbc.isSelected());
        cbcMcv.setSelected(selectAllCbc.isSelected());
        cbcRdwCv.setSelected(selectAllCbc.isSelected());
        cbcHct.setSelected(selectAllCbc.isSelected());
        cbcPlt.setSelected(selectAllCbc.isSelected());
        cbcPct.setSelected(selectAllCbc.isSelected());
        cbcPlcr.setSelected(selectAllCbc.isSelected());
        cbcEsr.setSelected(selectAllCbc.isSelected());
        BloodGroupRh.setSelected(selectAllCbc.isSelected());
        BloodFilm.setSelected(selectAllCbc.isSelected());
    }

    @FXML
    void handleAllParasitology(ActionEvent event) {
        stoolTest.setSelected(selectAllParasitology.isSelected());
        occultBlood.setSelected(selectAllParasitology.isSelected());
        consistency.setSelected(selectAllParasitology.isSelected());
        ovalParasite.setSelected(selectAllParasitology.isSelected());
    }

    @FXML
    void handleSendButton(ActionEvent event) {
        LabRequest labRequest = new LabRequest();

        labRequest.getCbs().getWbc().setTest(cbcWbc.isSelected());
        labRequest.getCbs().getLym().setTest(cbcLym.isSelected());
        labRequest.getCbs().getMid().setTest(cbcMid.isSelected());
        labRequest.getCbs().getGra().setTest(cbcGra.isSelected());
        labRequest.getCbs().getRbc().setTest(cbcRbc.isSelected());
        labRequest.getCbs().getHgb().setTest(cbcHgb.isSelected());
        labRequest.getCbs().getMchc().setTest(cbcMchc.isSelected());
        labRequest.getCbs().getMch().setTest(cbcMch.isSelected());
        labRequest.getCbs().getMcv().setTest(cbcMcv.isSelected());
        labRequest.getCbs().getRdw_cv().setTest(cbcRdwCv.isSelected());
        labRequest.getCbs().getHct().setTest(cbcHct.isSelected());
        labRequest.getCbs().getPlt().setTest(cbcPlt.isSelected());
        labRequest.getCbs().getPct().setTest(cbcPct.isSelected());
        labRequest.getCbs().getP_lcr().setTest(cbcPlcr.isSelected());
        labRequest.getCbs().getEsr().setTest(cbcEsr.isSelected());
        labRequest.getCbs().getBloodGroupRh().setTest(BloodGroupRh.isSelected());
        labRequest.getCbs().getBloodFilm().setTest(BloodFilm.isSelected());

        labRequest.getParasitology().getStoolTest().setTest(stoolTest.isSelected());
        labRequest.getParasitology().getOccultBlood().setTest(occultBlood.isSelected());
        labRequest.getParasitology().getConsistency1().setTest(consistency.isSelected());
        labRequest.getParasitology().getConsistency2().setTest(consistency.isSelected());
        labRequest.getParasitology().getOvalParasite1().setTest(ovalParasite.isSelected());
        labRequest.getParasitology().getOvalParasite2().setTest(ovalParasite.isSelected());
        labRequest.getParasitology().getOvalParasite3().setTest(ovalParasite.isSelected());

        labRequest.getChemistry().getFbs().setTest(fbs.isSelected());
        labRequest.getChemistry().getRbs().setTest(rbs.isSelected());
        labRequest.getChemistry().getSgot().setTest(sgot.isSelected());
        labRequest.getChemistry().getSgpt().setTest(sgpt.isSelected());
        labRequest.getChemistry().getAlkalinePhosphate().setTest(alkalinePhosphate.isSelected());
        labRequest.getChemistry().getBilirubinTotal().setTest(bilirubinTotal.isSelected());
        labRequest.getChemistry().getBilirubinDirect().setTest(bilirubinDirect.isSelected());
        labRequest.getChemistry().getBun().setTest(bun.isSelected());
        labRequest.getChemistry().getCreatinine().setTest(creatinine.isSelected());
        labRequest.getChemistry().getUricAcid().setTest(uricAcid.isSelected());
        labRequest.getChemistry().getTotalProtein().setTest(totalProtein.isSelected());
        labRequest.getChemistry().getCholesterol().setTest(cholesterol.isSelected());

        labRequest.getDipistic().getTestColor().setTest(urinColor.isSelected());
        labRequest.getDipistic().getAppearance().setTest(urinAppearance.isSelected());
        labRequest.getDipistic().getPh().setTest(urinPh.isSelected());
        labRequest.getDipistic().getPsg().setTest(urinPsg.isSelected());
        labRequest.getDipistic().getProtein().setTest(urinProtein.isSelected());
        labRequest.getDipistic().getGlucose().setTest(urinGlucose.isSelected());
        labRequest.getDipistic().getKetone().setTest(urinKetone.isSelected());
        labRequest.getDipistic().getBilrubin().setTest(urinBilirubin.isSelected());
        labRequest.getDipistic().getUrobilinogen().setTest(urinUrobilinogen.isSelected());
        labRequest.getDipistic().getBlood().setTest(urinBlood.isSelected());
        labRequest.getMicroscopy().getEpitCells().setTest(urinEpitCells.isSelected());
        labRequest.getMicroscopy().getWbc().setTest(urinWbc.isSelected());
        labRequest.getMicroscopy().getRbc().setTest(urinRbc.isSelected());
        labRequest.getMicroscopy().getCasts().setTest(urinCasts.isSelected());
        labRequest.getMicroscopy().getBacteria().setTest(urinBacteria.isSelected());

        labRequest.getSerology().getVdrl().setTest(seroVdrl.isSelected());
        labRequest.getSerology().getWidal_II_h().setTest(seroWidall.isSelected());
        labRequest.getSerology().getWidal_II_o().setTest(seroWidall.isSelected());
        labRequest.getSerology().getWellFelix().setTest(seroWellFelix.isSelected());
        labRequest.getSerology().getHbsag().setTest(seroHbsag.isSelected());
        labRequest.getSerology().getCrp().setTest(seroCrp.isSelected());
        labRequest.getSerology().getAso().setTest(seroAso.isSelected());
        labRequest.getSerology().getRheumatoidFactor().setTest(seroRheumatoidFactor.isSelected());
        labRequest.getSerology().getHpyloriSerum().setTest(seroHpyloriSerum.isSelected());

        labRequest.getBacterology().getHpyloriStool().setTest(bactHpyloriStool.isSelected());
        labRequest.getBacterology().getKoh().setTest(bactKoh.isSelected());

        labRequest.getOthers().getGramStain().setTest(gramStain.isSelected());
        labRequest.getOthers().getWetFilm().setTest(wetFilm.isSelected());
        labRequest.getOthers().getAfb().setTest(afb.isSelected());
        labRequest.getOthers().getHivAids().setTest(hivAids.isSelected());

        new DataSaver().saveLabResult(patient, labRequest);

        patient.setSecActives(false);
        patient.setDocActives(false);
        patient.setFromSec(false);
        patient.setPayed(false);

        new DataSaver().saveEditedPatient(patient);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void handleBackButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleExitButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }
}
