package com.AASTU.Model;

import javax.persistence.*;

@Entity
@Table(name="Manager")
public class Manager {
    @Id
    @Column(name="managerId")
    private int managerId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="password")
    private String password;

    public Manager(int managerId, String firstName, String lastName, String password) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Manager(){    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
