package com.AASTU.Model;

public class Parasitology {
    private int labFormId;
    private TestProperty stoolTest;
    private TestProperty occultBlood;
    private TestProperty consistency1;
    private TestProperty consistency2;
    private TestProperty ovalParasite1;
    private TestProperty ovalParasite2;
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
