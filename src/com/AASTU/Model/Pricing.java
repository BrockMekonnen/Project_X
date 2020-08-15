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


    public Pricing() {}

    public Pricing(double price) {
        this.price = price;
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
                '}';
    }
}
