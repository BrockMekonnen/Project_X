package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Microscopy {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "EpitCells_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "EpitCells_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "EpitCells_test", length = 20))
    })
    private TestProperty epitCells;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "wbc_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "wbc_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "wbc_test", length = 20))
    })
    private TestProperty wbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "rbc_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "rbc_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "rbc_test", length = 20))
    })
    private TestProperty rbc;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Casts_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "Casts_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "Casts_test", length = 20))
    })
    private TestProperty casts;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Bacteria_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "Bacteria_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "Bacteria_test", length = 20))
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
