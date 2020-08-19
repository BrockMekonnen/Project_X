package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private char sex;

    @Column(name = "added_date")
    private LocalDate addedDate;

    @Column(name = "password")
    private String password;

    @Column(name = "start_time")
    private LocalTime workingStartTime;


    @Column(name = "end_time")
    private LocalTime workingEndTime;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "sub_city")
    private String subcity;

    @Column(name = "kebele")
    private String kebele;

    public Doctor(String firstName, String lastName, char sex, LocalDate addedDate, String password, LocalTime workingStartTime, LocalTime workingEndTime, String phoneNumber, String city, String subcity, String kebele) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.addedDate = addedDate;
        this.password = password;
        this.workingStartTime = workingStartTime;
        this.workingEndTime = workingEndTime;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.subcity = subcity;
        this.kebele = kebele;
    }


    public Doctor(){}

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

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

    public LocalTime getWorkingStartTime() {
        return workingStartTime;
    }

    public void setWorkingStartTime(LocalTime workingStartTime) {
        this.workingStartTime = workingStartTime;
    }

    public LocalTime getWorkingEndTime() {
        return workingEndTime;
    }

    public void setWorkingEndTime(LocalTime workingEndTime) {
        this.workingEndTime = workingEndTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", addedDate=" + addedDate +
                ", password='" + password + '\'' +
                ", workingStartTime=" + workingStartTime +
                ", workingEndTime=" + workingEndTime +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", subcity='" + subcity + '\'' +
                ", kebele='" + kebele + '\'' +
                '}';
    }
}
