package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="Patient")
public class Patient {
    @Id
    @Column(name="Patient_Id")
    private int patientId;
    @Column(name="First_name")
    private String firstName;
    @Column(name="Last_name")
    private String lastName;
    @Column(name="Age")
    private int age;
    @Column(name="Sex")
    private char sex;
    @Column(name="Date")
    private LocalDate date;
    @Column(name="Phone_Number")
    private String phoneNumber;
    @Column(name="City")
    private String City;
    @Column(name="Sub_City")
    private String subcity;
    @Column(name="Kebele")
    private String kebele;
    @Column(name="House_Number")
    private String houseNumber;
    @Column(name="Notes")
    @OneToMany
    private Collection<ClinicalNotes> notes=new ArrayList<ClinicalNotes>();
    @Column(name="Lab_Request")
    @OneToMany
    private Collection<LabRequest> labRequest=new ArrayList<LabRequest>();

    public Patient(String firstName, String lastName, int age, char sex, LocalDate date, String phoneNumber, String city, String subcity, String kebele, String houseNumber, Collection notes, Collection labRequest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.City = city;
        this.subcity = subcity;
        this.kebele = kebele;
        this.houseNumber = houseNumber;
        this.notes = notes;
        this.labRequest = labRequest;
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

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Collection<ClinicalNotes> getNotes() {
        return notes;
    }

    public void setNotes(Collection<ClinicalNotes> notes) {
        this.notes = notes;
    }

    public Collection<LabRequest> getLabRequest() {
        return labRequest;
    }

    public void setLabRequest(Collection<LabRequest> labRequest) {
        this.labRequest = labRequest;
    }
}
