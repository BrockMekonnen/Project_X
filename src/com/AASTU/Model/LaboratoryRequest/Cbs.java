package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Cbs {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_wbc_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_wbc_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_wbc_test", length = 20))
    })
    private TestProperty wbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_lym_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_lym_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_lym_test", length = 20))
    })
    private TestProperty lym;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_mid_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_mid_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_mid_test", length = 20))
    })
    private TestProperty mid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_gra_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_gra_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_gra_test", length = 20))
    })
    private TestProperty gra;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_rbc_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_rbc_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_rbc_test", length = 20))
    })
    private TestProperty rbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_hgb_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_hgb_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_hgb_test", length = 20))
    })
    private TestProperty hgb;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_mchc_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_mchc_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_mchc_test", length = 20))
    })
    private TestProperty mchc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_mch_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_mch_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_mch_test", length = 20))
    })
    private TestProperty mch;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_mcv_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_mcv_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_mcv_test", length = 20))
    })
    private TestProperty mcv;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_rdw_cv_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_rdw_cv_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_rdw_cv_test", length = 20))
    })
    private TestProperty rdw_cv;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_hct_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_hct_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_hct_test", length = 20))
    })
    private TestProperty hct;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_plt_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_plt_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_plt_test", length = 20))
    })
    private TestProperty plt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_pct_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_pct_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_pct_test", length = 20))
    })
    private TestProperty pct;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_p_lcr_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_p_lcr_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_p_lcr_test", length = 20))
    })
    private TestProperty p_lcr;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_esr_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_esr_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_esr_test", length = 20))
    })
    private TestProperty esr;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_bloodGroupRh_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_bloodGroupRh_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_bloodGroupRh_test", length = 20))
    })
    private TestProperty bloodGroupRh;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cbs_bloodFilm_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cbs_bloodFilm_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cbs_bloodFilm_test", length = 20))
    })
    private TestProperty bloodFilm;

    public Cbs(){
        this.wbc = new TestProperty("",81,false);
        this.lym = new TestProperty("",82,false);
        this.mid = new TestProperty("",83,false);
        this.gra = new TestProperty("",84,false);
        this.rbc = new TestProperty("",85,false);
        this.hgb = new TestProperty("",86,false);
        this.mchc = new TestProperty("",87,false);
        this.mch = new TestProperty("",88,false);
        this.mcv = new TestProperty("",89,false);
        this.rdw_cv = new TestProperty("",90,false);
        this.hct = new TestProperty("",91,false);
        this.plt = new TestProperty("",92,false);
        this.pct = new TestProperty("",92,false);
        this.p_lcr = new TestProperty("",94,false);
        this.esr = new TestProperty("",95,false);
        this.bloodGroupRh = new TestProperty("",96,false);
        this.bloodFilm = new TestProperty("",97,false);
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
