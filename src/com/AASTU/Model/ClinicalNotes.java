package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
@Embeddable
public class ClinicalNotes {
    @Id
    @GeneratedValue
    private String id;
    @AttributeOverrides({
            @AttributeOverride( name = "Date", column = @Column(name = "Date")),
    })
    private LocalDate date;
    @AttributeOverrides({
            @AttributeOverride( name = "Notes", column = @Column(name = "Note")),
    })
    private String notes;

    public ClinicalNotes(LocalDate date, String notes) {
        this.date = date;
        this.notes = notes;
    }

    public ClinicalNotes() {
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
