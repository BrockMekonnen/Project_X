package com.AASTU.Model;

import javax.persistence.Embeddable;
import java.time.LocalDate;
@Embeddable
public class DiseaseRecord {
    private LocalDate date;
    private String diseasName;
    private AgeScale age;

    public DiseaseRecord(LocalDate date, String diseasName, AgeScale age) {
        this.date = date;
        this.diseasName = diseasName;
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiseasName() {
        return diseasName;
    }

    public void setDiseasName(String diseasName) {
        this.diseasName = diseasName;
    }

    public AgeScale getAge() {
        return age;
    }

    public void setAge(AgeScale age) {
        this.age = age;
    }
}
