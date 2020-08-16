package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Parasitology {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "stoolTest_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "stoolTest_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "stoolTest_test", length = 20))
    })
    private TestProperty stoolTest;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "occultBlood_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "occultBlood_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "occultBlood_test", length = 20))
    })
    private TestProperty occultBlood;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "consistency1_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "consistency1_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "consistency1_test", length = 20))
    })
    private TestProperty consistency1;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "consistency2_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "consistency2_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "consistency2_test", length = 20))
    })
    private TestProperty consistency2;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ovalParasite1_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "ovalParasite1_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "ovalParasite1_test", length = 20))
    })
    private TestProperty ovalParasite1;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ovalParasite2_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "ovalParasite2_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "ovalParasite2_test", length = 20))
    })
    private TestProperty ovalParasite2;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "ovalParasite_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "ovalParasite3_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "ovalParasite3_test", length = 20))
    })
    private TestProperty ovalParasite3;

    public Parasitology(TestProperty stoolTest, TestProperty occultBlood, TestProperty consistency1, TestProperty consistency2, TestProperty ovalParasite1, TestProperty ovalParasite2, TestProperty ovalParasite3) {
        this.stoolTest = stoolTest;
        this.occultBlood = occultBlood;
        this.consistency1 = consistency1;
        this.consistency2 = consistency2;
        this.ovalParasite1 = ovalParasite1;
        this.ovalParasite2 = ovalParasite2;
        this.ovalParasite3 = ovalParasite3;
    }

    public Parasitology() {
        this.stoolTest = new TestProperty("",51,false);
        this.occultBlood = new TestProperty("",52,false);
        this.consistency1 = new TestProperty("",53,false);
        this.consistency2 = new TestProperty("",54,false);
        this.ovalParasite1 = new TestProperty("",55,false);
        this.ovalParasite2 = new TestProperty("",56,false);
        this.ovalParasite3 = new TestProperty("",57,false);
    }


    public TestProperty getStoolTest() {
        return stoolTest;
    }

    public void setStoolTest(TestProperty stoolTest) {
        this.stoolTest = stoolTest;
    }

    public TestProperty getOccultBlood() {
        return occultBlood;
    }

    public void setOccultBlood(TestProperty occultBlood) {
        this.occultBlood = occultBlood;
    }

    public TestProperty getConsistency1() {
        return consistency1;
    }

    public void setConsistency1(TestProperty consistency1) {
        this.consistency1 = consistency1;
    }

    public TestProperty getConsistency2() {
        return consistency2;
    }

    public void setConsistency2(TestProperty consistency2) {
        this.consistency2 = consistency2;
    }

    public TestProperty getOvalParasite1() {
        return ovalParasite1;
    }

    public void setOvalParasite1(TestProperty ovalParasite1) {
        this.ovalParasite1 = ovalParasite1;
    }

    public TestProperty getOvalParasite2() {
        return ovalParasite2;
    }

    public void setOvalParasite2(TestProperty ovalParasite2) {
        this.ovalParasite2 = ovalParasite2;
    }

    public TestProperty getOvalParasite3() {
        return ovalParasite3;
    }

    public void setOvalParasite3(TestProperty ovalParasite3) {
        this.ovalParasite3 = ovalParasite3;
    }
}
