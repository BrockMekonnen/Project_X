package com.AASTU.Model;

import com.AASTU.Model.LaboratoryRequest.*;

import javax.persistence.*;

@Entity
@Table(name = "labRequest")
public class LabRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String LabratoryTechnicianId;
    private Parasitology parasitology;
    private Bacteriology bacterology;
    private Microscopy microscopy;
    private Chemistry chemistry;
    private Dipstick dipistic;
    private Others others;
    private Cbs cbs;
    private Serology serology;

    public LabRequest(){

    }

    public LabRequest(Parasitology parasitology, Bacteriology bacterology, Microscopy microscopy, Chemistry chemistry, Dipstick dipistic, Others others, Cbs cbs, Serology serology) {
        this.parasitology = parasitology;
        this.bacterology = bacterology;
        this.microscopy = microscopy;
        this.chemistry = chemistry;
        this.dipistic = dipistic;
        this.others = others;
        this.cbs = cbs;
        this.serology = serology;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabratoryTechnicianId() {
        return LabratoryTechnicianId;
    }

    public void setLabratoryTechnicianId(String labratoryTechnicianId) {
        LabratoryTechnicianId = labratoryTechnicianId;
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
}

