package com.AASTU.Model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Serology {
    @Id
    @GeneratedValue
    private int labFormId;
    @OneToOne
    private TestProperty vdrl;
    @OneToOne
    private TestProperty widal_II_h;
    @OneToOne
    private TestProperty widal_II_o;
    @OneToOne
    private TestProperty wellFelix;
    @OneToOne
    private TestProperty hbsag;
    @OneToOne
    private TestProperty crp;
    @OneToOne
    private TestProperty aso;
    @OneToOne
    private TestProperty rheumatoidFactor;
    @OneToOne
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
