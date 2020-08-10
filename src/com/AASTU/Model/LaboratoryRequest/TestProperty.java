package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TestProperty {

    private String value;

    private int priceId;

    private boolean test;

    public TestProperty(String value, int priceId, boolean test) {
        this.value = value;
        this.priceId = priceId;
        this.test = test;
    }
    public TestProperty(){

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}
