package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class DataSaver {

    public void saveLabResult(Patient patient, LabRequest result){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)
                .addAnnotatedClass(TestProperty.class)
                .addAnnotatedClass(Parasitology.class)
                .addAnnotatedClass(Bacteriology.class)
                .addAnnotatedClass(Microscopy.class)
                .addAnnotatedClass(Chemistry.class)
                .addAnnotatedClass(Dipstick.class)
                .addAnnotatedClass(Others.class)
                .addAnnotatedClass(Cbs.class)
                .addAnnotatedClass(Serology.class)
                .addAnnotatedClass(LabRequest.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            int id = patient.getPatientId();

            Patient obj = (Patient) session.load(Patient.class, id);
            obj.addLabRequest(result);

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void saveClinicalNote(Patient patient, ClinicalNotes note){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)
                .addAnnotatedClass(TestProperty.class)
                .addAnnotatedClass(Parasitology.class)
                .addAnnotatedClass(Bacteriology.class)
                .addAnnotatedClass(Microscopy.class)
                .addAnnotatedClass(Chemistry.class)
                .addAnnotatedClass(Dipstick.class)
                .addAnnotatedClass(Others.class)
                .addAnnotatedClass(Cbs.class)
                .addAnnotatedClass(Serology.class)
                .addAnnotatedClass(LabRequest.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            int id = patient.getPatientId();

            Patient obj = (Patient) session.load(Patient.class, id);
            obj.addClincalNote(note);

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void saveOutPatient(Patient patient, LocalDate startDate, LocalDate endDate){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)
                .addAnnotatedClass(TestProperty.class)
                .addAnnotatedClass(Parasitology.class)
                .addAnnotatedClass(Bacteriology.class)
                .addAnnotatedClass(Microscopy.class)
                .addAnnotatedClass(Chemistry.class)
                .addAnnotatedClass(Dipstick.class)
                .addAnnotatedClass(Others.class)
                .addAnnotatedClass(Cbs.class)
                .addAnnotatedClass(Serology.class)
                .addAnnotatedClass(LabRequest.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            int id = patient.getPatientId();

            Patient obj = (Patient) session.load(Patient.class, id);
            obj.setStartDate(startDate);
            obj.setEndDate(endDate);
            obj.setOutPatinet(true);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void saveEditedClinicalNote(int id, String note){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)
                .addAnnotatedClass(TestProperty.class)
                .addAnnotatedClass(Parasitology.class)
                .addAnnotatedClass(Bacteriology.class)
                .addAnnotatedClass(Microscopy.class)
                .addAnnotatedClass(Chemistry.class)
                .addAnnotatedClass(Dipstick.class)
                .addAnnotatedClass(Others.class)
                .addAnnotatedClass(Cbs.class)
                .addAnnotatedClass(Serology.class)
                .addAnnotatedClass(LabRequest.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            ClinicalNotes obj = (ClinicalNotes) session.load(ClinicalNotes.class, id);
            obj.setNotes(note);

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
}
