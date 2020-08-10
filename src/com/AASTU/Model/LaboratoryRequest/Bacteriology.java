package com.AASTU.Model.LaboratoryRequest;

import javax.persistence.*;

@Embeddable
public class Bacteriology {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "hpyloriStool_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "hpyloriStool_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "hpyloriStool_test", length = 20))
    })
    private TestProperty hpyloriStool;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "value", column = @Column(name = "koh_value", length = 20)),
            @AttributeOverride( name = "priceId", column = @Column(name = "koh_price_id", length = 20)),
            @AttributeOverride( name = "test", column = @Column(name = "koh_test", length = 20))
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
