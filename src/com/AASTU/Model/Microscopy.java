package com.AASTU.Model;

public class Microscopy {
    private int labFormId;
    private TestProperty epitCells;
    private TestProperty wbc;
    private TestProperty rbc;
    private TestProperty casts;
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
