package com.AASTU.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "OutPatient")
public class OutPatient extends Patient {

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    public OutPatient() {}

    public OutPatient(String firstName, String lastName, int age, char sex, LocalDate date, String phoneNumber, String city, String subcity, String kebele, String houseNumber, LocalDate startDate, LocalDate endDate) {
        super(firstName, lastName, age, sex, date, phoneNumber, city, subcity, kebele, houseNumber);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OutPatient{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
