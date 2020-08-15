package com.AASTU.Model;

import javax.persistence.*;

@Entity
@Table(name= "pricing")
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int priceId;
    @Column(name = "Price")
    private double price;

    @Column(name = "Test_name")
    private String testName;

    

    public Pricing(double price, String testName) {


    public Pricing() {}

    public Pricing(double price) {
        this.price = price;
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pricing{" +
                "priceId=" + priceId +
                ", price=" + price +
                ", testName='" + testName + '\'' +
                '}';
    }
}
