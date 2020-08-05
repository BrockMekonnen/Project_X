package com.AASTU.Model;

import com.AASTU.Model.LaboratoryRequest.*;

import javax.persistence.*;

@Entity
@Table(name = "labRequest")
public class LabRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Parasitology parasitology;
    private Bacteriology bacterology;
    private Microscopy microscopy;
    private Chemistry chemistry;
    private Dipstick dipistic;
    private Others others;
    private Cbs cbs;
    private Serology serology;

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





}

