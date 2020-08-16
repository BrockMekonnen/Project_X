package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Secretary")
public class Secretary {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "secretary_id")
    private int secretaryId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

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
    private String cubcity;

    @Column(name = "kebele")
    private String kebele;

    public Secretary(String firstName, String lastName, LocalDate addedDate, String password, LocalTime workingStartTime, LocalTime workingEndTime, String phoneNumber, String city, String cubcity, String kebele) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addedDate = addedDate;
        this.password = password;
        this.workingStartTime = workingStartTime;
        this.workingEndTime = workingEndTime;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.cubcity = cubcity;
        this.kebele = kebele;
    }

    public Secretary(){}

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

    public String getCubcity() {
        return cubcity;
    }

    public void setCubcity(String cubcity) {
        this.cubcity = cubcity;
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

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }
}
