package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Dipstick {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "testColor_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "testColor_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "testColor_test", length = 20))
    })
    private TestProperty testColor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "appearance_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "appearance_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "appearance_test", length = 20))
    })
    private TestProperty appearance;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ph_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "ph_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "ph_test", length = 20))
    })
    private TestProperty ph;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "psg_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "psg_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "psg_test", length = 20))
    })
    private TestProperty psg;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "protein_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "protein_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "protein_test", length = 20))
    })
    private TestProperty protein;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "glucose_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "glucose_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "glucose_test", length = 20))
    })
    private TestProperty glucose;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ketone_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "ketone_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "ketone_test", length = 20))
    })
    private TestProperty ketone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "bilrubin_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "bilrubin_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "bilrubin_test", length = 20))
    })
    private TestProperty bilrubin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "urobilinogen_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "urobilinogen_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "urobilinogen_test", length = 20))
    })
    private TestProperty urobilinogen;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "blood_value", length = 20)),
            @AttributeOverride( name = "price", column = @Column(name = "blood_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "blood_test", length = 20))
    })
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
