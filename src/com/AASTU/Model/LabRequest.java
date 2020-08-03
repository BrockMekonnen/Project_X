package com.AASTU.Model;

import javax.persistence.*;

@Entity
public class LabRequest {
    @Id
    @GeneratedValue
    private int patientId;
    private int labFormId;
    @OneToOne
    private Parasitology parasitology;
//    @OneToOne
//    private Bacteriology bacterology;
    @OneToOne
    private Microscopy microscopy;
    @OneToOne
    private Chemistry chemistry;
    @OneToOne
    private Dipstick dipistic;
    @OneToOne
    private Others others;
    @OneToOne
    private Cbs cbs;
    @OneToOne
    private Serology serology;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getLabFormId() {
        return labFormId;
    }

    public void setLabFormId(int labFormId) {
        this.labFormId = labFormId;
    }

    public Parasitology getParasitology() {
        return parasitology;
    }

    public void setParasitology(Parasitology parasitology) {
        this.parasitology = parasitology;
    }

//    public Bacteriology getBacterology() {
//        return bacterology;
//    }
//
//    public void setBacterology(Bacteriology bacterology) {
//        this.bacterology = bacterology;
//    }

    public Microscopy getMicroscopy() {
        return microscopy;
    }

    public void setMicroscopy(Microscopy microscopy) {
        this.microscopy = microscopy;
    }

    public Chemistry getChemistry() {
        return chemistry;
    }

    public void setChemistry(Chemistry chemistry) {
        this.chemistry = chemistry;
    }

    public Dipstick getDipistic() {
        return dipistic;
    }

    public void setDipistic(Dipstick dipistic) {
        this.dipistic = dipistic;
    }

    public Others getOthers() {
        return others;
    }

    public void setOthers(Others others) {
        this.others = others;
    }

    public Cbs getCbs() {
        return cbs;
    }

    public void setCbs(Cbs cbs) {
        this.cbs = cbs;
    }

    public Serology getSerology() {
        return serology;
    }

    public void setSerology(Serology serology) {
        this.serology = serology;
    }

    public LabRequest(int patientId, int labFormId, Parasitology parasitology, Bacteriology bacterology, Microscopy microscopy, Chemistry chemistry, Dipstick dipistic, Others others, Cbs cbs, Serology serology) {
        this.patientId = patientId;
        this.labFormId = labFormId;
        this.parasitology = parasitology;
//        this.bacterology = bacterology;
        this.microscopy = microscopy;
        this.chemistry = chemistry;
        this.dipistic = dipistic;

        this.others = others;
        this.cbs = cbs;
        this.serology = serology;
    }
}
