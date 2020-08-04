package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Others {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "gramStain_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "gramStain_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "gramStain_test", length = 20))
    })
    private TestProperty gramStain;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "wetFilm_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "wetFilm_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "wetFilm_test", length = 20))
    })
    private TestProperty wetFilm;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "afb_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "afb_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "afb_test", length = 20))
    })
    private TestProperty afb;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "hivAids_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "hivAids_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "hivAids_test", length = 20))
    })
    private TestProperty hivAids;

    public Others(TestProperty gramStain, TestProperty wetFilm, TestProperty afb, TestProperty hivAids) {
        this.gramStain = gramStain;
        this.wetFilm = wetFilm;
        this.afb = afb;
        this.hivAids = hivAids;
    }

    public Others() {
    }

    public TestProperty getGramStain() {
        return gramStain;
    }

    public void setGramStain(TestProperty gramStain) {
        this.gramStain = gramStain;
    }

    public TestProperty getWetFilm() {
        return wetFilm;
    }

    public void setWetFilm(TestProperty wetFilm) {
        this.wetFilm = wetFilm;
    }

    public TestProperty getAfb() {
        return afb;
    }

    public void setAfb(TestProperty afb) {
        this.afb = afb;
    }

    public TestProperty getHivAids() {
        return hivAids;
    }

    public void setHivAids(TestProperty hivAids) {
        this.hivAids = hivAids;
    }
}
