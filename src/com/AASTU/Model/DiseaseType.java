package com.AASTU.Model;

import javax.persistence.*;

@Entity
@Table(name = "diseaseType")
public class DiseaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "diseaseName")
    private String name;

    public DiseaseType(String name) {
        this.name = name;
    }

    public DiseaseType(){ }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
