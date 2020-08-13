package com.AASTU.Model;

import com.AASTU.Model.LaboratoryRequest.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "labRequest")
public class LabRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "labTechnicianId")
    private String labTechnicianId;

    @Column(name = "physicianId")
    private String physicianId;

    @Column(name = "requestDate")
    private LocalDate requestDate;

    private Parasitology parasitology;
    private Bacteriology bacterology;
    private Microscopy microscopy;
    private Chemistry chemistry;
    private Dipstick dipistic;
    private Others others;
    private Cbs cbs;
    private Serology serology;

    public LabRequest(){
        this.serology = new Serology();
        this.cbs = new Cbs();
        this.others = new Others();
        this.dipistic = new Dipstick();
        this.chemistry = new Chemistry();
        this.microscopy = new Microscopy();
        this.bacterology = new Bacteriology();
        this.parasitology = new Parasitology();

        this.requestDate = LocalDate.now();
        this.physicianId = "";
        this.labTechnicianId = "";

    }

    public LabRequest(String labTechnicianId, String physicianId, LocalDate requestDate, Parasitology parasitology, Bacteriology bacterology, Microscopy microscopy, Chemistry chemistry, Dipstick dipistic, Others others, Cbs cbs, Serology serology) {
        this.labTechnicianId = labTechnicianId;
        this.physicianId = physicianId;
        this.requestDate = requestDate;
        this.parasitology = parasitology;
        this.bacterology = bacterology;
        this.microscopy = microscopy;
        this.chemistry = chemistry;
        this.dipistic = dipistic;
        this.others = others;
        this.cbs = cbs;
        this.serology = serology;
    }

    public String getLabTechnicianId() {
        return labTechnicianId;
    }

    public void setLabTechnicianId(String labTechnicianId) {
        this.labTechnicianId = labTechnicianId;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

