package com.AASTU.Model;

public class Chemistry {
    private TestProperty fbs;
    private TestProperty rbs;
    private TestProperty sgot;
    private TestProperty sgpt;
    private TestProperty alkalinePhospate;
    private TestProperty bilirubinTotal;
    private TestProperty bilirubinDirect;
    private TestProperty bun;
    private TestProperty creatinine;
    private TestProperty uricAcid;
    private TestProperty totalProtein;
    private TestProperty cholesterol;

    public Chemistry(TestProperty fbs, TestProperty rbs, TestProperty sgot, TestProperty sgpt, TestProperty alkalinePhospate, TestProperty bilirubinTotal, TestProperty bilirubinDirect, TestProperty bun, TestProperty creatinine, TestProperty uricAcid, TestProperty totalProtin, TestProperty cholestrol) {
        this.fbs = fbs;
        this.rbs = rbs;
        this.sgot = sgot;
        this.sgpt = sgpt;
        this.alkalinePhospate = alkalinePhospate;
        this.bilirubinTotal = bilirubinTotal;
        this.bilirubinDirect = bilirubinDirect;
        this.bun = bun;
        this.creatinine = creatinine;
        this.uricAcid = uricAcid;
        this.totalProtein = totalProtin;
        this.cholesterol = cholestrol;
    }

    public TestProperty getFbs() {
        return fbs;
    }

    public void setFbs(TestProperty fbs) {
        this.fbs = fbs;
    }

    public TestProperty getRbs() {
        return rbs;
    }

    public void setRbs(TestProperty rbs) {
        this.rbs = rbs;
    }

    public TestProperty getSgot() {
        return sgot;
    }

    public void setSgot(TestProperty sgot) {
        this.sgot = sgot;
    }

    public TestProperty getSgpt() {
        return sgpt;
    }

    public void setSgpt(TestProperty sgpt) {
        this.sgpt = sgpt;
    }

    public TestProperty getAlkalinePhospate() {
        return alkalinePhospate;
    }

    public void setAlkalinePhospate(TestProperty alkalinePhospate) {
        this.alkalinePhospate = alkalinePhospate;
    }

    public TestProperty getBilirubinTotal() {
        return bilirubinTotal;
    }

    public void setBilirubinTotal(TestProperty bilirubinTotal) {
        this.bilirubinTotal = bilirubinTotal;
    }

    public TestProperty getBilirubinDirect() {
        return bilirubinDirect;
    }

    public void setBilirubinDirect(TestProperty bilirubinDirect) {
        this.bilirubinDirect = bilirubinDirect;
    }

    public TestProperty getBun() {
        return bun;
    }

    public void setBun(TestProperty bun) {
        this.bun = bun;
    }

    public TestProperty getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(TestProperty creatinine) {
        this.creatinine = creatinine;
    }

    public TestProperty getUricAcid() {
        return uricAcid;
    }

    public void setUricAcid(TestProperty uricAcid) {
        this.uricAcid = uricAcid;
    }

    public TestProperty getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(TestProperty totalProtein) {
        this.totalProtein = totalProtein;
    }

    public TestProperty getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(TestProperty cholesterol) {
        this.cholesterol = cholesterol;
    }
}
