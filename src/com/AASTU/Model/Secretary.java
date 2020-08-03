package com.AASTU.Model;

import java.time.LocalDate;

public class Secretary {
    private int secretaryId;
    private String firstName;
    private String lastName;
    private LocalDate addedDate;
    private String password;
    private int workingHourStartHour;
    private int workingHourStartMin;
    private int workingHourEndHour;
    private int workingHourEndMin;
    private String phoneNumber;
    private String City;
    private String Subcity;
    private String kebele;

    public Secretary(int secretaryId, String firstName, String lastName, LocalDate addedDate, String password, int workingHourStartHour, int workingHourStartMin, int workingHourEndHour, int workingHourEndMin, String phoneNumber, String city, String subcity, String kebele) {
        this.secretaryId = secretaryId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addedDate = addedDate;
        this.password = password;
        this.workingHourStartHour = workingHourStartHour;
        this.workingHourStartMin = workingHourStartMin;
        this.workingHourEndHour = workingHourEndHour;
        this.workingHourEndMin = workingHourEndMin;
        this.phoneNumber = phoneNumber;
        City = city;
        Subcity = subcity;
        this.kebele = kebele;
    }

    public int getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(int secretaryId) {
        this.secretaryId = secretaryId;
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

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWorkingHourStartHour() {
        return workingHourStartHour;
    }

    public void setWorkingHourStartHour(int workingHourStartHour) {
        this.workingHourStartHour = workingHourStartHour;
    }

    public int getWorkingHourStartMin() {
        return workingHourStartMin;
    }

    public void setWorkingHourStartMin(int workingHourStartMin) {
        this.workingHourStartMin = workingHourStartMin;
    }

    public int getWorkingHourEndHour() {
        return workingHourEndHour;
    }

    public void setWorkingHourEndHour(int workingHourEndHour) {
        this.workingHourEndHour = workingHourEndHour;
    }

    public int getWorkingHourEndMin() {
        return workingHourEndMin;
    }

    public void setWorkingHourEndMin(int workingHourEndMin) {
        this.workingHourEndMin = workingHourEndMin;
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
        return Subcity;
    }

    public void setSubcity(String subcity) {
        Subcity = subcity;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }
}
