package com.AASTU.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class WorkActivity {

    @GeneratedValue
    @Id
    private int ActivityId;
    @Column(name="date")
    private LocalDate Activity_day;
    @Column(name="patient_id")
    private int PatientId;
    @Column(name="doctor_id")
    private int DoctorId;
    @Column(name="secretary_id")
    private int SecretaryId;
    @Column(name="lab_id")
    private int LabTechnicianId;
    @Column(name="activity")
    @Lob
    private String Activity;

    public int getActivityId() {
        return ActivityId;
    }


    public LocalDate getActivity_day() {
        return Activity_day;
    }

    public void setActivity_day(LocalDate activity_day) {
        Activity_day = activity_day;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int patientId) {
        PatientId = patientId;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int doctorId) {
        DoctorId = doctorId;
    }

    public int getSecretaryId() {
        return SecretaryId;
    }

    public void setSecretaryId(int secretaryId) {
        SecretaryId = secretaryId;
    }

    public int getLabTechnicianId() {
        return LabTechnicianId;
    }

    public void setLabTechnicianId(int labTechnicianId) {
        LabTechnicianId = labTechnicianId;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }
}
