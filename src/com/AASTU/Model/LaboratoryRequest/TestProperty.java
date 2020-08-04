package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TestProperty {

    private String value;

    private double price;

    private boolean test;

    public TestProperty(String value, double price, boolean test) {
        this.value = value;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestProperty{" +
                "value='" + value + '\'' +
                ", price=" + price +
                ", test=" + test +
                '}';
    }
}
