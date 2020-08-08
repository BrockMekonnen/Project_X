package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@DiscriminatorColumn(name = "pType")
public class Patient {

    @Column(insertable = false, updatable = false)
    private String pType;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int patientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private char sex;
    @Column(name = "added_date")
    private LocalDate date;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city")
    private String City;
    @Column(name = "sub_city")
    private String subcity;
    @Column(name = "kebele")
    private String kebele;
    @Column(name = "house_number")
    private String houseNumber;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private List<ClinicalNotes> notes;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private List<LabRequest> requests;
    public Patient(){}

    public Patient(String firstName, String lastName, int age, char sex, LocalDate date, String phoneNumber, String city, String subcity, String kebele, String houseNumber) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.date = date;
        this.phoneNumber = phoneNumber;
        City = city;
        this.subcity = subcity;
        this.kebele = kebele;
        this.houseNumber = houseNumber;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getSubcity() {
        return subcity;
    }

    public void setSubcity(String subcity) {
        this.subcity = subcity;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public List<ClinicalNotes> getNotes() {
        return notes;
    }

    public void setNotes(List<ClinicalNotes> notes) {
        this.notes = notes;
    }

    public List<LabRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<LabRequest> requests) {
        this.requests = requests;
    }

    public void addClincalNote(ClinicalNotes clinicalNote) {

        if (notes == null) {
            notes = new ArrayList<>();
        }

        notes.add(clinicalNote);
    }

    public void addLabRequest(LabRequest labRequest) {

        if (requests == null) {
            requests = new ArrayList<>();
        }

        requests.add(labRequest);
    }
}
