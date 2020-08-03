package com.AASTU.Model;

import javax.persistence.*;

@Entity
public class Cbs {
    @Id
    @GeneratedValue
    private String labformId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "WBC_value")),
            @AttributeOverride( name = "price", column = @Column(name = "WBC_price")),
            @AttributeOverride( name = "test", column = @Column(name = "WBC_test"))
    })
    private TestProperty wbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "LYM_value")),
            @AttributeOverride( name = "price", column = @Column(name = "LYM_price")),
            @AttributeOverride( name = "test", column = @Column(name = "LYM_test"))
    })
    private TestProperty lym;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "mid_value")),
            @AttributeOverride( name = "price", column = @Column(name = "mid_price")),
            @AttributeOverride( name = "test", column = @Column(name = "mid_test"))
    })
    private TestProperty mid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "gra_value")),
            @AttributeOverride( name = "price", column = @Column(name = "gra_price")),
            @AttributeOverride( name = "test", column = @Column(name = "gra_test"))
    })
    private TestProperty gra;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "RBC_value")),
            @AttributeOverride( name = "price", column = @Column(name = "RBC_price")),
            @AttributeOverride( name = "test", column = @Column(name = "RBC_test"))
    })
    private TestProperty rbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "HGB_value")),
            @AttributeOverride( name = "price", column = @Column(name = "HGB_price")),
            @AttributeOverride( name = "test", column = @Column(name = "HGB_test"))
    })
    private TestProperty hgb;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "MCHC_value")),
            @AttributeOverride( name = "price", column = @Column(name = "MCHC_price")),
            @AttributeOverride( name = "test", column = @Column(name = "MCHC_test"))
    })
    private TestProperty mchc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "MCH_value")),
            @AttributeOverride( name = "price", column = @Column(name = "MCH_price")),
            @AttributeOverride( name = "test", column = @Column(name = "MCH_test"))
    })
    private TestProperty mch;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "MCV_value")),
            @AttributeOverride( name = "price", column = @Column(name = "MCV_price")),
            @AttributeOverride( name = "test", column = @Column(name = "MCV_test"))
    })
    private TestProperty mcv;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "RDW_CV_value")),
            @AttributeOverride( name = "price", column = @Column(name = "RDW_CV_price")),
            @AttributeOverride( name = "test", column = @Column(name = "RDW_CV_test"))
    })
    private TestProperty rdw_cv;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "HCT_value")),
            @AttributeOverride( name = "price", column = @Column(name = "HCT_price")),
            @AttributeOverride( name = "test", column = @Column(name = "HCT_test"))
    })
    private TestProperty hct;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "PLT_value")),
            @AttributeOverride( name = "price", column = @Column(name = "PLT_price")),
            @AttributeOverride( name = "test", column = @Column(name = "PLT_test"))
    })
    private TestProperty plt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "PCT_value")),
            @AttributeOverride( name = "price", column = @Column(name = "PCT_price")),
            @AttributeOverride( name = "test", column = @Column(name = "PCT_test"))
    })
    private TestProperty pct;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "p_LCR_value")),
            @AttributeOverride( name = "price", column = @Column(name = "P_LCR_price")),
            @AttributeOverride( name = "test", column = @Column(name = "P_LCR_test"))
    })
    private TestProperty p_lcr;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ESR_value")),
            @AttributeOverride( name = "price", column = @Column(name = "ESR_price")),
            @AttributeOverride( name = "test", column = @Column(name = "ESR_test"))
    })
    private TestProperty esr;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "BloodGroupRh_value")),
            @AttributeOverride( name = "price", column = @Column(name = "BloodGroupRh_price")),
            @AttributeOverride( name = "test", column = @Column(name = "BloodGroupRh_test"))
    })
    private TestProperty bloodGroupRh;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "BloodFilm_value")),
            @AttributeOverride( name = "price", column = @Column(name = "BloodFilm_price")),
            @AttributeOverride( name = "test", column = @Column(name = "BloodFilm_test"))
    })
    private TestProperty bloodFilm;

    public Cbs(){

    }

    public Cbs(TestProperty wbc, TestProperty lym, TestProperty mid, TestProperty gra, TestProperty rbc, TestProperty hgb, TestProperty mchc, TestProperty mch, TestProperty mcv, TestProperty rdw_cv, TestProperty hct, TestProperty plt, TestProperty pct, TestProperty p_lcr, TestProperty esr, TestProperty bloodGroupRh, TestProperty bloodFilm) {
        this.wbc = wbc;
        this.lym = lym;
        this.mid = mid;
        this.gra = gra;
        this.rbc = rbc;
        this.hgb = hgb;
        this.mchc = mchc;
        this.mch = mch;
        this.mcv = mcv;
        this.rdw_cv = rdw_cv;
        this.hct = hct;
        this.plt = plt;
        this.pct = pct;
        this.p_lcr = p_lcr;
        this.esr = esr;
        this.bloodGroupRh = bloodGroupRh;
        this.bloodFilm = bloodFilm;
    }

    public TestProperty getWbc() {
        return wbc;
    }

    public void setWbc(TestProperty wbc) {
        this.wbc = wbc;
    }

    public TestProperty getLym() {
        return lym;
    }

    public void setLym(TestProperty lym) {
        this.lym = lym;
    }

    public TestProperty getMid() {
        return mid;
    }

    public void setMid(TestProperty mid) {
        this.mid = mid;
    }

    public TestProperty getGra() {
        return gra;
    }

    public void setGra(TestProperty gra) {
        this.gra = gra;
    }

    public TestProperty getRbc() {
        return rbc;
    }

    public void setRbc(TestProperty rbc) {
        this.rbc = rbc;
    }

    public TestProperty getHgb() {
        return hgb;
    }

    public void setHgb(TestProperty hgb) {
        this.hgb = hgb;
    }

    public TestProperty getMchc() {
        return mchc;
    }

    public void setMchc(TestProperty mchc) {
        this.mchc = mchc;
    }

    public TestProperty getMch() {
        return mch;
    }

    public void setMch(TestProperty mch) {
        this.mch = mch;
    }

    public TestProperty getMcv() {
        return mcv;
    }

    public void setMcv(TestProperty mcv) {
        this.mcv = mcv;
    }

    public TestProperty getRdw_cv() {
        return rdw_cv;
    }

    public void setRdw_cv(TestProperty rdw_cv) {
        this.rdw_cv = rdw_cv;
    }

    public TestProperty getHct() {
        return hct;
    }

    public void setHct(TestProperty hct) {
        this.hct = hct;
    }

    public TestProperty getPlt() {
        return plt;
    }

    public void setPlt(TestProperty plt) {
        this.plt = plt;
    }

    public TestProperty getPct() {
        return pct;
    }

    public void setPct(TestProperty pct) {
        this.pct = pct;
    }

    public TestProperty getP_lcr() {
        return p_lcr;
    }

    public void setP_lcr(TestProperty p_lcr) {
        this.p_lcr = p_lcr;
    }

    public TestProperty getEsr() {
        return esr;
    }

    public void setEsr(TestProperty esr) {
        this.esr = esr;
    }

    public TestProperty getBloodGroupRh() {
        return bloodGroupRh;
    }

    public void setBloodGroupRh(TestProperty bloodGroupRh) {
        this.bloodGroupRh = bloodGroupRh;
    }

    public TestProperty getBloodFilm() {
        return bloodFilm;
    }

    public void setBloodFilm(TestProperty bloodFilm) {
        this.bloodFilm = bloodFilm;
    }
}
