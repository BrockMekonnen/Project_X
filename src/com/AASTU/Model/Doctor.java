package com.AASTU.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="Doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private int doctorID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "added_date")
    private LocalDate addedDate;

    @Column(name = "password")
    private String password;

    @Column(name = "start_hour")
    private int workingHourStartHour;

    @Column(name = "start_minute")
    private int workingHourStartMin;

    @Column(name = "end_hour")
    private int workingHourEndHour;

    @Column(name = "end_minute")
    private int workingHourEndMin;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city")
    private String City;

    @Column(name = "sub_city")
    private String Subcity;

    @Column(name = "kebele")
    private String kebele;

    public Doctor(int doctorID, String firstName, String lastName, LocalDate addedDate, String password, int workingHourStartHour, int workingHourStartMin, int workingHourEndHour, int workingHourEndMin, String phoneNumber, String city, String subcity, String kebele) {
        this.doctorID = doctorID;
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

    public Doctor(){}

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
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

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addedDate=" + addedDate +
                ", password='" + password + '\'' +
                ", workingHourStartHour=" + workingHourStartHour +
                ", workingHourStartMin=" + workingHourStartMin +
                ", workingHourEndHour=" + workingHourEndHour +
                ", workingHourEndMin=" + workingHourEndMin +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", City='" + City + '\'' +
                ", Subcity='" + Subcity + '\'' +
                ", kebele='" + kebele + '\'' +
                '}';
    }
}
