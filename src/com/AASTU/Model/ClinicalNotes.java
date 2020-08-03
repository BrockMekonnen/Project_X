package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ClinicalNotes {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="Date")
    private LocalDate date;
    @Column(name="Clinical_Notes")
    private String notes;

    public ClinicalNotes(LocalDate date, String notes) {
        this.date = date;
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
