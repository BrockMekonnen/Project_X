package com.AASTU.Model;

import javax.persistence.*;

@Entity
@Table(name = "others")
public class Others {
    @Id
    @GeneratedValue
    private int labFormId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "gramStain_value")),
            @AttributeOverride( name = "price", column = @Column(name = "garmStain_price")),
            @AttributeOverride( name = "test", column = @Column(name = "gramStain_test"))
    })
    private TestProperty gramStain;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "wetFilm_value")),
            @AttributeOverride( name = "price", column = @Column(name = "wetFilm_price")),
            @AttributeOverride( name = "test", column = @Column(name = "wetFilm_test"))
    })
    private TestProperty wetFilm;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "afb_value")),
            @AttributeOverride( name = "price", column = @Column(name = "afb_price")),
            @AttributeOverride( name = "test", column = @Column(name = "afb_test"))
    })
    private TestProperty afb;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "hivAids_value")),
            @AttributeOverride( name = "price", column = @Column(name = "hivAids_price")),
            @AttributeOverride( name = "test", column = @Column(name = "hivAids_test"))
    })
    private TestProperty hivAids;

    public Others(TestProperty gramStain, TestProperty wetFilm, TestProperty afb, TestProperty hivAids) {
        this.gramStain = gramStain;
        this.wetFilm = wetFilm;
        this.afb = afb;
        this.hivAids = hivAids;
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
