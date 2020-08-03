package com.AASTU.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Lab_Request")
public class LabRequest {
    @Column(name="Patient_Id")
    private int patientId;
    @Column(name="Lab_Form_Id")
    private int labFormId;
    @Column(name="Parasitology")
    private Parasitology parasitology;
    @Column(name="Bacteriology")
    private Bacteriology bacterology;
    @Column(name="Microscopy")
    private Microscopy microscopy;
    @Column(name="Chemistry")
    private Chemistry chemistry;
    @Column(name="Dipistic")
    private Dipstick dipistic;
    @Column(name="Others")
    private Others others;
    @Column(name="CBS")
    private Cbs cbs;
    @Column(name="Serology")
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

    public Bacteriology getBacterology() {
        return bacterology;
    }

    public void setBacterology(Bacteriology bacterology) {
        this.bacterology = bacterology;
    }

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
        this.bacterology = bacterology;
        this.microscopy = microscopy;
        this.chemistry = chemistry;
        this.dipistic = dipistic;

        this.others = others;
        this.cbs = cbs;
        this.serology = serology;
    }
}
