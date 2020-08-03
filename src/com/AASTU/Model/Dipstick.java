package com.AASTU.Model;

public class Dipstick {
    private TestProperty testColor;
    private TestProperty appearance;
    private TestProperty ph;
    private TestProperty psg;
    private TestProperty protein;
    private TestProperty glucose;
    private TestProperty ketone;
    private TestProperty bilrubin;
    private TestProperty urobilinogen;
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
