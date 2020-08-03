package com.AASTU.Model;

public class Serology {
    private int labFormId;
    private TestProperty vdrl;
    private TestProperty widal_II_h;
    private TestProperty widal_II_o;
    private TestProperty wellFelix;
    private TestProperty hbsag;
    private TestProperty crp;
    private TestProperty aso;
    private TestProperty rheumatoidFactor;
    private TestProperty hpyloriSerum;

    public Serology(TestProperty vdrl, TestProperty widal_II_h, TestProperty widal_II_o, TestProperty wellFelix, TestProperty hbsag, TestProperty crp, TestProperty aso, TestProperty rheumatoidFactor, TestProperty hpyloriSerum) {
        this.vdrl = vdrl;
        this.widal_II_h = widal_II_h;
        this.widal_II_o = widal_II_o;
        this.wellFelix = wellFelix;
        this.hbsag = hbsag;
        this.crp = crp;
        this.aso = aso;
        this.rheumatoidFactor = rheumatoidFactor;
        this.hpyloriSerum = hpyloriSerum;
    }

    public TestProperty getVdrl() {
        return vdrl;
    }

    public void setVdrl(TestProperty vdrl) {
        this.vdrl = vdrl;
    }

    public TestProperty getWidal_II_h() {
        return widal_II_h;
    }

    public void setWidal_II_h(TestProperty widal_II_h) {
        this.widal_II_h = widal_II_h;
    }

    public TestProperty getWidal_II_o() {
        return widal_II_o;
    }

    public void setWidal_II_o(TestProperty widal_II_o) {
        this.widal_II_o = widal_II_o;
    }

    public TestProperty getWellFelix() {
        return wellFelix;
    }

    public void setWellFelix(TestProperty wellFelix) {
        this.wellFelix = wellFelix;
    }

    public TestProperty getHbsag() {
        return hbsag;
    }

    public void setHbsag(TestProperty hbsag) {
        this.hbsag = hbsag;
    }

    public TestProperty getCrp() {
        return crp;
    }

    public void setCrp(TestProperty crp) {
        this.crp = crp;
    }

    public TestProperty getAso() {
        return aso;
    }

    public void setAso(TestProperty aso) {
        this.aso = aso;
    }

    public TestProperty getRheumatoidFactor() {
        return rheumatoidFactor;
    }

    public void setRheumatoidFactor(TestProperty rheumatoidFactor) {
        this.rheumatoidFactor = rheumatoidFactor;
    }

    public TestProperty getHpyloriSerum() {
        return hpyloriSerum;
    }

    public void setHpyloriSerum(TestProperty hpyloriSerum) {
        this.hpyloriSerum = hpyloriSerum;
    }
}
