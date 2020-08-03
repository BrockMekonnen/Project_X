package com.AASTU.Model;

public class LabRequest {
    private int patientId;
    private int labFormId;
    private Parasitology parasitology;
    private Bacteriology bacterology;
    private Microscopy microscopy;
    private Chemistry chemistry;
    private Dipstick dipistic;
    private Others others;
    private Cbs cbs;
    private Serology serology;

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
