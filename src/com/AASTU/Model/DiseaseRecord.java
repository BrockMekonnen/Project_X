package com.AASTU.Model;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class DiseaseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name="disease_Name")
    private String diseaseName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "mLess1", column = @Column(name = "MaleLessThan_1", length = 20)),
            @AttributeOverride( name = "m1to4", column = @Column(name = "Male1_4", length = 20)),
            @AttributeOverride( name = "m5to14", column = @Column(name = "Male5_14", length = 20)),
            @AttributeOverride( name = "m15to29", column = @Column(name = "Male15_29", length = 20)),
            @AttributeOverride( name = "m30to64", column = @Column(name = "Male30_64", length = 20)),
            @AttributeOverride( name = "mGreater65", column = @Column(name = "MaleGreaterThan_65", length = 20)),
            @AttributeOverride( name = "fLess1", column = @Column(name = "FemaleLessThan_1", length = 20)),
            @AttributeOverride( name = "f1to4", column = @Column(name = "Female1_4", length = 20)),
            @AttributeOverride( name = "f5to14", column = @Column(name = "Female5_14", length = 20)),
            @AttributeOverride( name = "f15to29", column = @Column(name = "Female15_29", length = 20)),
            @AttributeOverride( name = "f30to64", column = @Column(name = "Female30_64", length = 20)),
            @AttributeOverride( name = "fGreater65", column = @Column(name = "FemaleGreaterThan_65", length = 20))
    })
    private AgeScale age;

    public DiseaseRecord(){ }

    public DiseaseRecord(LocalDate date, String diseasName, AgeScale age) {
        this.date = date;
        this.diseaseName = diseasName;
        this.age = age;
    }

    public SimpleObjectProperty<LocalDate> getDate() {
        return new SimpleObjectProperty<LocalDate>(this.date);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SimpleStringProperty getDiseaseName() {
        return new SimpleStringProperty(this.diseaseName);
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public AgeScale getAge() {
        return age;
    }

    public void setAge(AgeScale age) {
        this.age = age;
    }

    public SimpleObjectProperty<Integer> mLess1ForTable() {
        return new SimpleObjectProperty<>(age.getmLess1());
    }

    public ReadOnlyObjectWrapper<Integer> M1to4ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getM1to4());
    }

    public ReadOnlyObjectWrapper<Integer> M5to14ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getM5to14());
    }

    public ReadOnlyObjectWrapper<Integer> M15to29ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getM15to29());
    }
    public ReadOnlyObjectWrapper<Integer> M30to64ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getM30to64());
    }
    public ReadOnlyObjectWrapper<Integer> mGreater65ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getmGreater65());
    }
    /////////
    public ReadOnlyObjectWrapper<Integer> fLess1ForTable() {
        return new ReadOnlyObjectWrapper<Integer>(age.getfLess1());
    }

    public ReadOnlyObjectWrapper<Integer> F1to4ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getF1to4());
    }

    public ReadOnlyObjectWrapper<Integer> F5to14ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getF5to14());
    }

    public ReadOnlyObjectWrapper<Integer> F15to29ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getF15to29());
    }
    public ReadOnlyObjectWrapper<Integer> F30to64ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getF30to64());
    }
    public ReadOnlyObjectWrapper<Integer> fGreater65ForTable() {
        return new ReadOnlyObjectWrapper<>(age.getfGreater65());
    }

}
