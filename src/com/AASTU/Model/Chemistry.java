package com.AASTU.Model;

import javax.persistence.*;
@Entity
public class Chemistry {
    @Id
    @GeneratedValue
    private String labformid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "FSB_value")),
            @AttributeOverride( name = "price", column = @Column(name = "FSB_price")),
            @AttributeOverride( name = "test", column = @Column(name = "FSB_test"))
    })
    private TestProperty fbs;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "RBS_value")),
            @AttributeOverride( name = "price", column = @Column(name = "RBS_price")),
            @AttributeOverride( name = "test", column = @Column(name = "RBS_test"))
    })
    private TestProperty rbs;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "SGOT_value")),
            @AttributeOverride( name = "price", column = @Column(name = "SGOT_price")),
            @AttributeOverride( name = "test", column = @Column(name = "SGOT_test"))
    })
    private TestProperty sgot;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "SGPT_value")),
            @AttributeOverride( name = "price", column = @Column(name = "SGPT_price")),
            @AttributeOverride( name = "test", column = @Column(name = "SGPT_test"))
    })
    private TestProperty sgpt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "AlkalinePhosphate_value")),
            @AttributeOverride( name = "price", column = @Column(name = "AlkalinePhosphate_price")),
            @AttributeOverride( name = "test", column = @Column(name = "AlkalinePhosphate_test"))
    })
    private TestProperty AlkalinePhosphate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "BilrubinTotal_value")),
            @AttributeOverride( name = "price", column = @Column(name = "BilrubinTotal_price")),
            @AttributeOverride( name = "test", column = @Column(name = "BilrubinTotal_test"))
    })
    private TestProperty bilirubinTotal;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "BilrubinDirect_value")),
            @AttributeOverride( name = "price", column = @Column(name = "BilrubinDirect_price")),
            @AttributeOverride( name = "test", column = @Column(name = "BilrubinDirect_test"))
    })
    private TestProperty bilirubinDirect;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Bun_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Bun_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Bun_test"))
    })
    private TestProperty bun;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Creatinine_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Creatinine_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Creatinine_test"))
    })
    private TestProperty creatinine;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "UricAcid_value")),
            @AttributeOverride( name = "price", column = @Column(name = "UricAcid_price")),
            @AttributeOverride( name = "test", column = @Column(name = "UricAcid_test"))
    })
    private TestProperty uricAcid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "TotalProtein_value")),
            @AttributeOverride( name = "price", column = @Column(name = "TotalProtein_price")),
            @AttributeOverride( name = "test", column = @Column(name = "TotalProtein_test"))
    })
    private TestProperty totalProtein;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Cholesterol_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Cholesterol_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Cholesterol_test"))
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
