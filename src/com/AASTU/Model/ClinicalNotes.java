package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Clinical_notes")
public class ClinicalNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noteId;
    @Column(name = "added_date")
    private LocalDate date;
    @Column(name = "note")
    private String notes;
    //to identify The Doctor who writes the Clinical note or who treats the patient
    private String DoctorId;

    public ClinicalNotes() {}

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

    @Override
    public String toString() {
        return "ClinicalNotes{" +
                "id='" + noteId + '\'' +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                '}';
    }
}
