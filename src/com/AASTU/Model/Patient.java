package com.AASTU.Model;

import java.time.LocalDate;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private int age;
    private char sex;
    private LocalDate date;
    private String phoneNumber;
    private String City;
    private String subcity;
    private String kebele;
    private String houseNumber;
    private ClinicalNotes notes;
    private LabRequest labRequest;

    public Patient(String firstName, String lastName, int age, char sex, LocalDate date, String phoneNumber, String city, String subcity, String kebele, String houseNumber, ClinicalNotes notes, LabRequest labRequest) {
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

    public ClinicalNotes getNotes() {
        return notes;
    }

    public void setNotes(ClinicalNotes notes) {
        this.notes = notes;
    }

    public LabRequest getLabRequest() {
        return labRequest;
    }

    public void setLabRequest(LabRequest labRequest) {
        this.labRequest = labRequest;
    }
}
