package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Serology {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "vdrl_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "vdrl_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "vdrl_test", length = 20))
    })
    private TestProperty vdrl;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "widal_II_h_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "widal_II_h_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "widal_II_h_test", length = 20))
    })
    private TestProperty widal_II_h;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "widal_II_o_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "widal_II_o_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "widal_II_o_test", length = 20))
    })
    private TestProperty widal_II_o;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "wellFelix_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "wellFelix_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "wellFelix_test", length = 20))
    })
    private TestProperty wellFelix;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "hbsag_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "hbsag_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "hbsag_test", length = 20))
    })
    private TestProperty hbsag;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "crp_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "crp_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "crp_test", length = 20))
    })
    private TestProperty crp;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "aso_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "aso_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "aso_test", length = 20))
    })
    private TestProperty aso;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "rheumatoidFactor_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "rheumatoidFactor_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "rheumatoidFactor_test", length = 20))
    })
    private TestProperty rheumatoidFactor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "hpyloriSerum_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "hpyloriSerum_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "hpyloriSerum_test", length = 20))
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

    public Serology() {
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
