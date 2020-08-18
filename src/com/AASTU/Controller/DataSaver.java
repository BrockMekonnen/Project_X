package com.AASTU.Controller;

import com.AASTU.Model.ClinicalNotes;
import com.AASTU.Model.LabRequest;
import com.AASTU.Model.Laboratory;
import com.AASTU.Model.LaboratoryRequest.*;
import com.AASTU.Model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

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
            Patient obj = (Patient) session.load(Patient.class, patient.getPatientId());
            obj.addLabRequest(result);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void updateLabresult(Patient patient,LabRequest result,int LabId){
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
           LabRequest request=(LabRequest) session.load(LabRequest.class,LabId);
           request=result;
            session.update(request);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void saveEditedLabResult(LabRequest request, boolean viewable){
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

            int id = request.getId();

            LabRequest obj = (LabRequest) session.load(LabRequest.class, id);
            obj.setViewable(viewable);

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

    public void saveEditedPatient(Patient patient){
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

            obj.setFirstName(patient.getFirstName());
            obj.setLastName(patient.getLastName());
            obj.setAge(patient.getAge());
            obj.setSex(patient.getSex());
            obj.setDate(patient.getDate());
            obj.setPhoneNumber(patient.getPhoneNumber());
            obj.setCity(patient.getCity());
            obj.setSubcity(patient.getSubcity());
            obj.setKebele(patient.getKebele());
            obj.setHouseNumber(patient.getHouseNumber());
            obj.setPatientStatus(patient.isPatientStatus());
            obj.setDocActives(patient.isDocActives());
            obj.setLabActives(patient.isLabActives());
            obj.setSecActives(patient.isSecActives());
            obj.setFromLab(patient.isFromLab());
            obj.setFromSec(patient.isFromSec());
            obj.setPayed(patient.isPayed());
            obj.setOnWaiting(patient.isOnWaiting());
            obj.setPayment(patient.getPayment());
            obj.setOutPatinet(patient.isOutPatinet());
            obj.setStartDate(patient.getStartDate());
            obj.setEndDate(patient.getEndDate());
            session.update(obj);
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

    public void saveEditedClinicalNote(int id, boolean editable){
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
            obj.setEditable(editable);

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
}
