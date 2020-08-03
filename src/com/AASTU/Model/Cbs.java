package com.AASTU.Model;

import javax.persistence.*;

@Entity
public class Cbs {
    @Id
    @GeneratedValue
    private int labformid;
    @OneToOne
    private TestProperty wbc;
    @OneToOne
    private TestProperty lym;
    @OneToOne
    private TestProperty mid;
    @OneToOne
    private TestProperty gra;
    @OneToOne
    private TestProperty rbc;
    @OneToOne
    private TestProperty hgb;
    @OneToOne
    private TestProperty mchc;
    @OneToOne
    private TestProperty mch;
    @OneToOne
    private TestProperty mcv;
    @OneToOne
    private TestProperty rdw_cv;
    @OneToOne
    private TestProperty hct;
    @OneToOne
    private TestProperty plt;
    @OneToOne
    private TestProperty pct;
    @OneToOne
    private TestProperty p_lcr;
    @OneToOne
    private TestProperty esr;
    @OneToOne
    private TestProperty bloodGroupRh;
    @OneToOne
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
