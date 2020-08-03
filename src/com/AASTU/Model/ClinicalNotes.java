package com.AASTU.Model;

import java.time.LocalDate;

public class ClinicalNotes {
    private LocalDate date;
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
