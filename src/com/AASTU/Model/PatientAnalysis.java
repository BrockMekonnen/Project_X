package com.AASTU.Model;

import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "patientAnalysis")
public class PatientAnalysis {

    @Id
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "totalPatient")
    private int totalPatient;

    public PatientAnalysis() {    }

    public PatientAnalysis(LocalDate date, int totalPatinet) {
        this.date = date;
        this.totalPatient = totalPatinet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalPatient() {
        return totalPatient;
    }

    public void setTotalPatient(int totalPatient) {
        this.totalPatient = totalPatient;
    }

    public SimpleObjectProperty<LocalDate> tableDateGetter(){
        return new SimpleObjectProperty<LocalDate>(this.date);
    }

    public SimpleObjectProperty<Integer> tableTotalPatinetGetter(){
        return new SimpleObjectProperty<>(totalPatient);
    }

}
