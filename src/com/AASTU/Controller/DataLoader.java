package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("ALL")
public class DataLoader {

    public List<Patient> loadSpecificPatientData(String SelectiveCommand){
        List<Patient> patientList;

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

            patientList = session.createQuery(SelectiveCommand).list();

            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }

        return patientList;
    }

    public List<DiseaseRecord> loadDiseaseData(String command){
        List<DiseaseRecord> diseaseRecords;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(DiseaseRecord.class)
                .addAnnotatedClass(AgeScale.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            diseaseRecords = session.createQuery(command).list();

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

        return  diseaseRecords;
    }

    public LabRequest loadLabRequest(Patient tempPateint) {
        List<LabRequest> labRequestList;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(LabRequest.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            String quiry = "from LabRequest where patient_id = " + tempPateint.getPatientId();
            labRequestList = session.createQuery(quiry).list();

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
        LabRequest labRequest;
        if(labRequestList.size() != 0){
            labRequest = labRequestList.get(labRequestList.size() - 1);
        } else {
            labRequest = null;
        }

        return labRequest;

    }

    public List<ClinicalNotes> loadClincalNotes(Patient tempPateint) {
        List<ClinicalNotes> clinicalNotesList;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(LabRequest.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            String quiry = "from ClinicalNotes where patient_id = " + tempPateint.getPatientId();
            clinicalNotesList = session.createQuery(quiry).list();

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

        return clinicalNotesList;

    }
    // this function return each testProperty price
    public double prices(int id) {
        Pricing price = null;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pricing.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            try {
                price = session.get(Pricing.class, id);
            }catch (Exception e){
                e.printStackTrace();
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }


        return price.getPrice();

    }

    public List<LabRequest> labRequest(Patient tempPateint) {
        List<LabRequest>  labRequest;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(LabRequest.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            System.out.println(tempPateint.getPatientId());
            labRequest = session.createQuery("from LabRequest where patient_id = " + tempPateint.getPatientId()).list();

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

        return labRequest;

    }
    // this method return each pricing obj
    public Pricing priceObj(int id) {
        Pricing price = null;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pricing.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            try {
                price = session.get(Pricing.class, id);
            }catch (Exception e){
                e.printStackTrace();
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }


        return price;

    }
}
