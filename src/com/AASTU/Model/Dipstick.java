package com.AASTU.Model;

import javax.persistence.*;

@Entity
public class Dipstick {
    @Id
    @GeneratedValue
    private int labformid;
    @OneToOne
    private TestProperty testColor;
    @OneToOne
    private TestProperty appearance;
    @OneToOne
    private TestProperty ph;
    @OneToOne
    private TestProperty psg;
    @OneToOne
    private TestProperty protein;
    @OneToOne
    private TestProperty glucose;
    @OneToOne
    private TestProperty ketone;
    @OneToOne
    private TestProperty bilrubin;
    @OneToOne
    private TestProperty urobilinogen;
    @OneToOne
    private TestProperty blood;

    public Dipstick(TestProperty color, TestProperty appearance, TestProperty ph, TestProperty psg, TestProperty protein, TestProperty glucose, TestProperty ketone, TestProperty bilrubin, TestProperty urobilinogen, TestProperty blood) {
        this.testColor = color;
        this.appearance = appearance;
        this.ph = ph;
        this.psg = psg;
        this.protein = protein;
        this.glucose = glucose;
        this.ketone = ketone;
        this.bilrubin = bilrubin;
        this.urobilinogen = urobilinogen;
        this.blood = blood;
    }

    public Dipstick(){

    }

    public TestProperty getTestColor() {
        return testColor;
    }

    public void setTestColor(TestProperty testColor) {
        this.testColor = testColor;
    }

    public TestProperty getAppearance() {
        return appearance;
    }

    public void setAppearance(TestProperty appearance) {
        this.appearance = appearance;
    }

    public TestProperty getPh() {
        return ph;
    }

    public void setPh(TestProperty ph) {
        this.ph = ph;
    }

    public TestProperty getPsg() {
        return psg;
    }

    public void setPsg(TestProperty psg) {
        this.psg = psg;
    }

    public TestProperty getProtein() {
        return protein;
    }

    public void setProtein(TestProperty protein) {
        this.protein = protein;
    }

    public TestProperty getGlucose() {
        return glucose;
    }

    public void setGlucose(TestProperty glucose) {
        this.glucose = glucose;
    }

    public TestProperty getKetone() {
        return ketone;
    }

    public void setKetone(TestProperty ketone) {
        this.ketone = ketone;
    }

    public TestProperty getBilrubin() {
        return bilrubin;
    }

    public void setBilrubin(TestProperty bilrubin) {
        this.bilrubin = bilrubin;
    }

    public TestProperty getUrobilinogen() {
        return urobilinogen;
    }

    public void setUrobilinogen(TestProperty urobilinogen) {
        this.urobilinogen = urobilinogen;
    }

    public TestProperty getBlood() {
        return blood;
    }

    public void setBlood(TestProperty blood) {
        this.blood = blood;
    }
}
