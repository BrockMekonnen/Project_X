package com.AASTU.Model;

import javax.persistence.*;

@Entity
@Table(name= "pricing")
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int priceId;
    @Column(name = "Price")
    private double price;

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
}
