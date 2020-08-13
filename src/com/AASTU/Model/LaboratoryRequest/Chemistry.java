package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Chemistry {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "fbs_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "fbs_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "fbs_test", length = 20))
    })
    private TestProperty fbs;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "rbs_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "rbs_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "rbs_test", length = 20))
    })
    private TestProperty rbs;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "sgot_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "sgot_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "sgot_test", length = 20))
    })
    private TestProperty sgot;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "sgpt_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "sgpt_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "sgpt_test", length = 20))
    })
    private TestProperty sgpt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "alkalinePhosphate_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "alkalinePhosphate_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "alkalinePhosphate_test", length = 20))
    })
    private TestProperty AlkalinePhosphate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "bilrubinTotal_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "bilrubinTotal_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "bilrubinTotal_test", length = 20))
    })
    private TestProperty bilirubinTotal;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "bilrubinDirect_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "bilrubinDirect_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "bilrubinDirect_test", length = 20))
    })
    private TestProperty bilirubinDirect;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "bun_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "bun_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "bun_test", length = 20))
    })
    private TestProperty bun;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "creatinine_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "creatinine_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "creatinine_test", length = 20))
    })
    private TestProperty creatinine;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "uricAcid_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "uricAcid_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "uricAcid_test", length = 20))
    })
    private TestProperty uricAcid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "totalProtein_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "totalProtein_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "totalProtein_test", length = 20))
    })
    private TestProperty totalProtein;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "cholesterol_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "cholesterol_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "cholesterol_test", length = 20))
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
        this.fbs = new TestProperty("",61,false);
        this.rbs = new TestProperty("",62,false);
        this.sgot = new TestProperty("",63,false);
        this.sgpt = new TestProperty("",64,false);
        this.AlkalinePhosphate = new TestProperty("",65,false);
        this.bilirubinTotal = new TestProperty("",66,false);
        this.bilirubinDirect = new TestProperty("",67,false);
        this.bun = new TestProperty("",68,false);
        this.creatinine = new TestProperty("",69,false);
        this.uricAcid = new TestProperty("",70,false);
        this.totalProtein = new TestProperty("",71,false);
        this.cholesterol = new TestProperty("",72,false);
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
