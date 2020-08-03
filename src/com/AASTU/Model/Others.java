package com.AASTU.Model;

public class Others {
    private int labFormId;
    private TestProperty gramStain;
    private TestProperty wetFilm;
    private TestProperty afb;
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
