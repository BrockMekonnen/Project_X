package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Chemistry {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "FSB_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "FSB_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "FSB_test", length = 20))
    })
    private TestProperty fbs;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "RBS_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "RBS_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "RBS_test", length = 20))
    })
    private TestProperty rbs;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "SGOT_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "SGOT_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "SGOT_test", length = 20))
    })
    private TestProperty sgot;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "SGPT_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "SGPT_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "SGPT_test", length = 20))
    })
    private TestProperty sgpt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "AlkalinePhosphate_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "AlkalinePhosphate_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "AlkalinePhosphate_test", length = 20))
    })
    private TestProperty AlkalinePhosphate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "BilrubinTotal_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "BilrubinTotal_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "BilrubinTotal_test", length = 20))
    })
    private TestProperty bilirubinTotal;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "BilrubinDirect_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "BilrubinDirect_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "BilrubinDirect_test", length = 20))
    })
    private TestProperty bilirubinDirect;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Bun_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "Bun_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "Bun_test", length = 20))
    })
    private TestProperty bun;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Creatinine_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "Creatinine_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "Creatinine_test", length = 20))
    })
    private TestProperty creatinine;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "UricAcid_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "UricAcid_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "UricAcid_test", length = 20))
    })
    private TestProperty uricAcid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "TotalProtein_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "TotalProtein_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "TotalProtein_test", length = 20))
    })
    private TestProperty totalProtein;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Cholesterol_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "Cholesterol_price", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "Cholesterol_test", length = 20))
    })
    private TestProperty cholesterol;

    public Chemistry(TestProperty fbs, TestProperty rbs, TestProperty sgot, TestProperty sgpt, TestProperty AlkalinePhosphate, TestProperty bilirubinTotal, TestProperty bilirubinDirect, TestProperty bun, TestProperty creatinine, TestProperty uricAcid, TestProperty totalProtin, TestProperty cholestrol) {
        this.fbs = fbs;
        this.rbs = rbs;
        this.sgot = sgot;
        this.sgpt = sgpt;
        this.AlkalinePhosphate = AlkalinePhosphate;
        this.bilirubinTotal = bilirubinTotal;
        this.bilirubinDirect = bilirubinDirect;
        this.bun = bun;
        this.creatinine = creatinine;
        this.uricAcid = uricAcid;
        this.totalProtein = totalProtin;
        this.cholesterol = cholestrol;
    }

    public Chemistry() {
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

    public TestProperty getAlkalinePhosphate() {
        return AlkalinePhosphate;
    }

    public void setAlkalinePhosphate(TestProperty alkalinePhosphate) {
        this.AlkalinePhosphate = alkalinePhosphate;
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
