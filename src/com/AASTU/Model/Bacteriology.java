package com.AASTU.Model;

import javax.persistence.*;

@Entity
@Table(name = "Bacteriology")
public class Bacteriology {

    @Id
    @GeneratedValue
    private int bacteriologyId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "hpyloriStool_value")),
            @AttributeOverride( name = "price", column = @Column(name = "hpyloriStool_price")),
            @AttributeOverride( name = "test", column = @Column(name = "hpyloriStool_test"))
    })
    private TestProperty hpyloriStool;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "koh_value")),
            @AttributeOverride( name = "price", column = @Column(name = "koh_price")),
            @AttributeOverride( name = "test", column = @Column(name = "koh_test"))
    })


    private TestProperty koh;

    public Bacteriology(TestProperty hpyloriStool, TestProperty koh) {
        this.hpyloriStool = hpyloriStool;
        this.koh = koh;
    }

    public Bacteriology() {
    }

    public TestProperty getHpyloriStool() {
        return hpyloriStool;
    }

    public void setHpyloriStool(TestProperty hpyloriStool) {
        this.hpyloriStool = hpyloriStool;
    }

    public TestProperty getKoh() {
        return koh;
    }

    public void setKoh(TestProperty koh) {
        this.koh = koh;
    }
}
