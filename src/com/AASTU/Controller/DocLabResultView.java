package com.AASTU.Controller;

import com.AASTU.Model.LabRequest;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DocLabResultView implements Initializable {

    @FXML
    private JFXTextField cbcWbcFld;

    @FXML
    private JFXTextField cbcLymFld;

    @FXML
    private JFXTextField cbcGraFld;

    @FXML
    private JFXTextField cbcMidFld;

    @FXML
    private JFXTextField cbcRbcFld;

    @FXML
    private JFXTextField cbcHgbFld;

    @FXML
    private JFXTextField cbcMchcFld;

    @FXML
    private JFXTextField cbcMchFld;

    @FXML
    private JFXTextField cbcMcvFld;

    @FXML
    private JFXTextField cbcRdwcvFld;

    @FXML
    private JFXTextField cbcHctFld;

    @FXML
    private JFXTextField cbcPlt;

    @FXML
    private JFXTextField cbcPctFld;

    @FXML
    private JFXTextField cbcPlcrFld;

    @FXML
    private JFXTextField cbcEsrFld;

    @FXML
    private JFXTextField bloodGroupFld;

    @FXML
    private JFXTextField BloodFilmFld;

    @FXML
    private JFXTextField stoolTestFld;

    @FXML
    private JFXTextField occultBloodFld;

    @FXML
    private JFXTextField consistencyFld1;

    @FXML
    private JFXTextField consistencyFld2;

    @FXML
    private JFXTextField ovalParasiteFld1;

    @FXML
    private JFXTextField ovalParasiteFld2;

    @FXML
    private JFXTextField ovalParasiteFld3;

    @FXML
    private JFXTextField chemFbsFld;

    @FXML
    private JFXTextField chemRbsFld;

    @FXML
    private JFXTextField chemSgotFld;

    @FXML
    private JFXTextField chemSgptFld;

    @FXML
    private JFXTextField chemAPFld;

    @FXML
    private JFXTextField chmeBTFld;

    @FXML
    private JFXTextField chemBDFld;

    @FXML
    private JFXTextField chemBunFld;

    @FXML
    private JFXTextField chemCreastinineFld;

    @FXML
    private JFXTextField chemUricAcidFld;

    @FXML
    private JFXTextField chemTotalProtienFld;

    @FXML
    private JFXTextField chemCholestrolFld;

    @FXML
    private JFXTextField uColorFld;

    @FXML
    private JFXTextField appearanceFld;

    @FXML
    private JFXTextField uPhFld;

    @FXML
    private JFXTextField uPsgFld;

    @FXML
    private JFXTextField uProteinFld;

    @FXML
    private JFXTextField uGlucoseFld;

    @FXML
    private JFXTextField uKetoneFld;

    @FXML
    private JFXTextField uBilirubinFld;

    @FXML
    private JFXTextField uUrobilinogenFld;

    @FXML
    private JFXTextField uBloodFld;

    @FXML
    private JFXTextField uepitCellsFld;

    @FXML
    private JFXTextField uWbcFld;

    @FXML
    private JFXTextField uRbcFld;

    @FXML
    private JFXTextField uCastsFld;

    @FXML
    private JFXTextField uBacteriaFld;

    @FXML
    private JFXTextField hPyloriStoolFld;

    @FXML
    private JFXTextField kohFld;

    @FXML
    private JFXTextField gramStainFld;

    @FXML
    private JFXTextField wetFilmFld;

    @FXML
    private JFXTextField afbFld;

    @FXML
    private JFXTextField vdrlFld;

    @FXML
    private JFXTextField widalHFld;

    @FXML
    private JFXTextField widalOFld;

    @FXML
    private JFXTextField wellFelixFld;

    @FXML
    private JFXTextField hbsagFld;

    @FXML
    private JFXTextField crpFld;

    @FXML
    private JFXTextField asoFld;

    @FXML
    private JFXTextField rheumatoidFactorFld;

    @FXML
    private JFXTextField hPyloriSerumFld;

    @FXML
    private JFXTextField hivAidsFld;

    public void setLabResult(LabRequest obj){
        cbcWbcFld.setText(String.valueOf(obj.getCbs().getWbc().getValue()));
        cbcLymFld.setText(String.valueOf(obj.getCbs().getLym().getValue()));
        cbcGraFld.setText(String.valueOf(obj.getCbs().getGra().getValue()));
        cbcMidFld.setText(String.valueOf(obj.getCbs().getMid().getValue()));
        cbcRbcFld.setText(String.valueOf(obj.getCbs().getRbc().getValue()));
        cbcHgbFld.setText(String.valueOf(obj.getCbs().getHgb().getValue()));
        cbcMchcFld.setText(String.valueOf(obj.getCbs().getMchc().getValue()));
        cbcMchFld.setText(String.valueOf(obj.getCbs().getMch().getValue()));
        cbcMcvFld.setText(String.valueOf(obj.getCbs().getMcv().getValue()));
        cbcRdwcvFld.setText(String.valueOf(obj.getCbs().getRdw_cv().getValue()));
        cbcHctFld.setText(String.valueOf(obj.getCbs().getHct().getValue()));
        cbcPlt.setText(String.valueOf(obj.getCbs().getPlt().getValue()));
        cbcPctFld.setText(String.valueOf(obj.getCbs().getPct().getValue()));
        cbcPlcrFld.setText(String.valueOf(obj.getCbs().getP_lcr().getValue()));
        cbcEsrFld.setText(String.valueOf(obj.getCbs().getEsr().getValue()));
        bloodGroupFld.setText(String.valueOf(obj.getCbs().getBloodGroupRh().getValue()));
        BloodFilmFld.setText(String.valueOf(obj.getCbs().getBloodFilm().getValue()));

        stoolTestFld.setText(String.valueOf(obj.getParasitology().getStoolTest().getValue()));
        occultBloodFld.setText(String.valueOf(obj.getParasitology().getOccultBlood().getValue()));
        consistencyFld1.setText(String.valueOf(obj.getParasitology().getConsistency1().getValue()));
        consistencyFld2.setText(String.valueOf(obj.getParasitology().getConsistency2().getValue()));
        ovalParasiteFld1.setText(String.valueOf(obj.getParasitology().getOvalParasite1().getValue()));
        ovalParasiteFld2.setText(String.valueOf(obj.getParasitology().getOvalParasite2().getValue()));
        ovalParasiteFld3.setText(String.valueOf(obj.getParasitology().getOvalParasite3().getValue()));

        chemFbsFld.setText(String.valueOf(obj.getChemistry().getFbs().getValue()));
        chemRbsFld.setText(String.valueOf(obj.getChemistry().getRbs().getValue()));
        chemSgotFld.setText(String.valueOf(obj.getChemistry().getSgot().getValue()));
        chemSgptFld.setText(String.valueOf(obj.getChemistry().getSgpt().getValue()));
        chemAPFld.setText(String.valueOf(obj.getChemistry().getAlkalinePhosphate().getValue()));
        chmeBTFld.setText(String.valueOf(obj.getChemistry().getBilirubinTotal().getValue()));
        chemBDFld.setText(String.valueOf(obj.getChemistry().getBilirubinDirect().getValue()));
        chemBunFld.setText(String.valueOf(obj.getChemistry().getBun().getValue()));
        chemCreastinineFld.setText(String.valueOf(obj.getChemistry().getCreatinine().getValue()));
        chemUricAcidFld.setText(String.valueOf(obj.getChemistry().getUricAcid().getValue()));
        chemTotalProtienFld.setText(String.valueOf(obj.getChemistry().getTotalProtein().getValue()));
        chemCholestrolFld.setText(String.valueOf(obj.getChemistry().getCholesterol().getValue()));

        uColorFld.setText(String.valueOf(obj.getDipistic().getTestColor().getValue()));
        appearanceFld.setText(String.valueOf(obj.getDipistic().getAppearance().getValue()));
        uPhFld.setText(String.valueOf(obj.getDipistic().getPh().getValue()));
        uPsgFld.setText(String.valueOf(obj.getDipistic().getPsg().getValue()));
        uProteinFld.setText(String.valueOf(obj.getDipistic().getProtein().getValue()));
        uGlucoseFld.setText(String.valueOf(obj.getDipistic().getGlucose().getValue()));
        uKetoneFld.setText(String.valueOf(obj.getDipistic().getKetone().getValue()));
        uBilirubinFld.setText(String.valueOf(obj.getDipistic().getBilrubin().getValue()));
        uUrobilinogenFld.setText(String.valueOf(obj.getDipistic().getUrobilinogen().getValue()));
        uBloodFld.setText(String.valueOf(obj.getDipistic().getBlood().getValue()));

        uepitCellsFld.setText(String.valueOf(obj.getMicroscopy().getEpitCells().getValue()));
        uWbcFld.setText(String.valueOf(obj.getMicroscopy().getWbc().getValue()));
        uRbcFld.setText(String.valueOf(obj.getMicroscopy().getRbc().getValue()));
        uCastsFld.setText(String.valueOf(obj.getMicroscopy().getCasts().getValue()));
        uBacteriaFld.setText(String.valueOf(obj.getMicroscopy().getBacteria().getValue()));

        vdrlFld.setText(String.valueOf(obj.getSerology().getVdrl().getValue()));
        widalHFld.setText(String.valueOf(obj.getSerology().getWidal_II_h().getValue()));
        widalOFld.setText(String.valueOf(obj.getSerology().getWidal_II_o().getValue()));
        wellFelixFld.setText(String.valueOf(obj.getSerology().getWellFelix().getValue()));
        hbsagFld.setText(String.valueOf(obj.getSerology().getHbsag().getValue()));
        crpFld.setText(String.valueOf(obj.getSerology().getCrp().getValue()));
        asoFld.setText(String.valueOf(obj.getSerology().getAso().getValue()));
        rheumatoidFactorFld.setText(String.valueOf(obj.getSerology().getRheumatoidFactor().getValue()));
        hPyloriSerumFld.setText(String.valueOf(obj.getSerology().getHpyloriSerum().getValue()));

        hPyloriStoolFld.setText(String.valueOf(obj.getBacterology().getHpyloriStool().getValue()));
        kohFld.setText(String.valueOf(obj.getBacterology().getKoh().getValue()));

        gramStainFld.setText(String.valueOf(obj.getOthers().getGramStain().getValue()));
        wetFilmFld.setText(String.valueOf(obj.getOthers().getWetFilm().getValue()));
        afbFld.setText(String.valueOf(obj.getOthers().getAfb().getValue()));
        hivAidsFld.setText(String.valueOf(obj.getOthers().getHivAids().getValue()));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void handleCloseButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleExitButton(ActionEvent event) {
        WindowChangeController.closeWindow();
    }

    @FXML
    void handleMaxButton(ActionEvent event) {

    }

}
