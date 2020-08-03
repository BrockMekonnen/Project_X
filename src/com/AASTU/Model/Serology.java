package com.AASTU.Model;

import javax.persistence.*;
@Entity
public class Serology {
    @Id
    @GeneratedValue
    private int labFormId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "VDRL_value")),
            @AttributeOverride( name = "price", column = @Column(name = "VDRL_price")),
            @AttributeOverride( name = "test", column = @Column(name = "VDRL_test"))
    })
    private TestProperty vdrl;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Widal_II_H_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Widal_II_H_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Widal_II_H_test"))
    })
    private TestProperty widal_II_h;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Widal_II_O_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Widal_II_O_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Widal_II_O_test"))
    })
    private TestProperty widal_II_o;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "WellFelix_value")),
            @AttributeOverride( name = "price", column = @Column(name = "WellFelix_price")),
            @AttributeOverride( name = "test", column = @Column(name = "WellFelix_test"))
    })
    private TestProperty wellFelix;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "HBSAG_value")),
            @AttributeOverride( name = "price", column = @Column(name = "HBSAG_price")),
            @AttributeOverride( name = "test", column = @Column(name = "HBSAG_test"))
    })
    private TestProperty hbsag;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "CRP_value")),
            @AttributeOverride( name = "price", column = @Column(name = "CRP_price")),
            @AttributeOverride( name = "test", column = @Column(name = "CRP_test"))
    })
    private TestProperty crp;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ASO_value")),
            @AttributeOverride( name = "price", column = @Column(name = "ASO_price")),
            @AttributeOverride( name = "test", column = @Column(name = "ASO_test"))
    })
    private TestProperty aso;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "RheumatoidFactor_value")),
            @AttributeOverride( name = "price", column = @Column(name = "RheumatoidFactor_price")),
            @AttributeOverride( name = "test", column = @Column(name = "RheumatoidFactor_test"))
    })
    private TestProperty rheumatoidFactor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "HpyloriSerum_value")),
            @AttributeOverride( name = "price", column = @Column(name = "HpyloriSerum_price")),
            @AttributeOverride( name = "test", column = @Column(name = "hpyloriSerum_test"))
    })
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
