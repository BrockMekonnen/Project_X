package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "clinical_notes")
public class ClinicalNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noteId;

    @Column(name = "added_date")
    private LocalDate date;

    @Lob
    @Column(name = "note", columnDefinition="BLOB")
    private String notes;

    //to identify The Doctor who writes the Clinical note or who treats the patient
    @Column(name = "doctorId")
    private String DoctorId;

    @Column(name = "editable")
    private boolean editable;

    public ClinicalNotes() {
        date = LocalDate.now();
        notes = "";
        editable = true;
    }

    public ClinicalNotes(LocalDate date, String notes, String doctorId) {
        this.date = date;
        this.notes = notes;
        DoctorId = doctorId;
    }

    public int getNoteId() {
        return noteId;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
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

    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String doctorId) {
        DoctorId = doctorId;
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
