package com.AASTU.Model;

import javax.persistence.*;

@Entity
public class Bacteriology {
    @Id
    @GeneratedValue
    private int labformid;
    @OneToOne
    private TestProperty hpyloriStool;
    @OneToOne
    private TestProperty koh;

    public Bacteriology(TestProperty hpyloriStool, TestProperty koh) {
        this.hpyloriStool = hpyloriStool;
        this.koh = koh;
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
