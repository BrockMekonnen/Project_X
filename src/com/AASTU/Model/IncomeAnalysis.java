package com.AASTU.Model;

import javafx.beans.property.SimpleObjectProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "incomeAnalysis")
public class IncomeAnalysis {

    @Id
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "totalIncome")
    private double totalIncome;

    public IncomeAnalysis() { }

    public IncomeAnalysis(LocalDate date, double totalIncome) {
        this.date = date;
        this.totalIncome = totalIncome;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public SimpleObjectProperty<LocalDate> tableDateGetter(){ return new SimpleObjectProperty<LocalDate>(this.date); }

    public SimpleObjectProperty<Double> tableIncomeGetter(){
        return new SimpleObjectProperty<>(totalIncome);
    }
}
