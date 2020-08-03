package com.AASTU.Model;

import javax.persistence.*;

@Entity
public class Bacteriology {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "HpylorStool_value")),
            @AttributeOverride( name = "price", column = @Column(name = "HpylorStool_price")),
            @AttributeOverride( name = "test", column = @Column(name = "HpylorStool_test"))
    })
    private TestProperty hpyloriStool;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "Koh_value")),
            @AttributeOverride( name = "price", column = @Column(name = "Koh_price")),
            @AttributeOverride( name = "test", column = @Column(name = "Koh_test"))
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
