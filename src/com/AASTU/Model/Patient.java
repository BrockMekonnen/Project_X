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
    private String city;
    @Column(name = "sub_city")
    private String subcity;
    @Column(name = "kebele")
    private String kebele;
    @Column(name = "house_number")
    private String houseNumber;

    //********* new **********

    @Column(name = "patientStates")
    private boolean patientStates;

    @Column(name = "docActives")
    private boolean docActives;

    @Column(name = "labActives")
    private boolean labActives;

    @Column(name = "secActievs")
    private boolean secActives;

    @Column(name = "fromLab")
    private boolean fromLab;

    @Column(name = "fromSec")
    private boolean fromSec;

    @Column(name = "payed")
    private boolean payed;

    @Column(name = "onWaiting")
    private boolean onWaiting;

    @Column(name = "payment")
    private double payment;

    //**********************

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private List<ClinicalNotes> notes;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private List<LabRequest> requests;

    public Patient(){}

    public Patient(String firstName, String lastName, int age, char sex, LocalDate date, String phoneNumber, String city, String subcity, String kebele, String houseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.subcity = subcity;
        this.kebele = kebele;
        this.houseNumber = houseNumber;

    }

    public boolean isFromLab() {
        return fromLab;
    }

    public void setFromLab(boolean fromLab) {
        this.fromLab = fromLab;
    }

    public boolean isFromSec() {
        return fromSec;
    }

    public void setFromSec(boolean fromSec) {
        this.fromSec = fromSec;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isOnWaiting() {
        return onWaiting;
    }

    public void setOnWaiting(boolean onWaiting) {
        this.onWaiting = onWaiting;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public boolean isPatientStates() {
        return patientStates;
    }

    public void setPatientStates(boolean patientStates) {
        this.patientStates = patientStates;
    }

    public boolean isDocActives() {
        return docActives;
    }

    public void setDocActives(boolean docActives) {
        this.docActives = docActives;
    }

    public boolean isLabActives() {
        return labActives;
    }

    public void setLabActives(boolean labActives) {
        this.labActives = labActives;
    }

    public boolean isSecActives() {
        return secActives;
    }

    public void setSecActives(boolean secActives) {
        this.secActives = secActives;
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
        return this.city;
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

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", date=" + date +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", City='" + city + '\'' +
                ", subcity='" + subcity + '\'' +
                ", kebele='" + kebele + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
