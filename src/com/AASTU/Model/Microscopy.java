package com.AASTU.Model;

import javax.persistence.*;
@Entity
public class Microscopy {
    @Id
    @GeneratedValue
    private int labFormId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "EpitCells_value")),
            @AttributeOverride( name = "price", column = @Column(name = "EpitCells_price")),
            @AttributeOverride( name = "test", column = @Column(name = "EpitCells_test"))
    })
    private TestProperty epitCells;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "WBC_value")),
            @AttributeOverride( name = "price", column = @Column(name = "WBC_price")),
            @AttributeOverride( name = "test", column = @Column(name = "WBC_test"))
    })
    private TestProperty wbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "RBC_value")),
            @AttributeOverride( name = "price", column = @Column(name = "RBC_price")),
            @AttributeOverride( name = "test", column = @Column(name = "RBC_test"))
    })
    private TestProperty rbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Casts_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Casts_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Casts_test"))
    })
    private TestProperty casts;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Bacteria_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Bacteria_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Bacteria_test"))
    })
    private TestProperty bacteria;

    public Microscopy( TestProperty epitCells, TestProperty wbc, TestProperty rbc, TestProperty casts, TestProperty bacteria) {
        this.epitCells = epitCells;
        this.wbc = wbc;
        this.rbc = rbc;
        this.casts = casts;
        this.bacteria = bacteria;
    }

    public Microscopy(){

    }

    public TestProperty getEpitCells() {
        return epitCells;
    }

    public void setEpitCells(TestProperty epitCells) {
        this.epitCells = epitCells;
    }

    public TestProperty getWbc() {
        return wbc;
    }

    public void setWbc(TestProperty wbc) {
        this.wbc = wbc;
    }

    public TestProperty getRbc() {
        return rbc;
    }

    public void setRbc(TestProperty rbc) {
        this.rbc = rbc;
    }

    public TestProperty getCasts() {
        return casts;
    }

    public void setCasts(TestProperty casts) {
        this.casts = casts;
    }

    public TestProperty getBacteria() {
        return bacteria;
    }

    public void setBacteria(TestProperty bacteria) {
        this.bacteria = bacteria;
    }
}
