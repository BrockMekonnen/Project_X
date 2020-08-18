package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class DataLoader {

    public List<Doctor> loadDoctorsData(){
        List<Doctor> doctorsList;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            doctorsList = session.createQuery("from Doctor").list();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return doctorsList;
    }

    public List<Laboratory> loadLaboratoriestData(){
        List<Laboratory> laboratoryList;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Laboratory.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            laboratoryList = session.createQuery("from Laboratory").list();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return laboratoryList;
    }
    public Laboratory laboratoryObj(String password, String userName){
        Laboratory laboratory;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Laboratory.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Laboratory where password = :password and first_name = :name");
            query.setParameter("password", password);
            query.setParameter("name", userName);
            laboratory = (Laboratory) query.uniqueResult();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return laboratory;
    }
    public Doctor doctorObj(String password, String userName){
        Doctor doctor;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Doctor where password = :password and first_name = :name");
            query.setParameter("password", password);
            query.setParameter("name", userName);
            doctor = (Doctor) query.uniqueResult();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return doctor;
    }

    public Secretary secretaryObj(String password, String userName){
        Secretary secretary;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Secretary.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Secretary where password = :password and first_name = :name");
            query.setParameter("password", password);
            query.setParameter("name", userName);
            secretary = (Secretary) query.uniqueResult();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return secretary;
    }
    public List<Secretary> loadSecretariesData(){
        List<Secretary> secretaryList;
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Secretary.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            secretaryList = session.createQuery("from Secretary").list();
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }

        return secretaryList;
    }
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

    public ClinicalNotes loadClinicalNote(Patient object){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(LabRequest.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(ClinicalNotes.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        List<ClinicalNotes> clinicalNotesList;
        ClinicalNotes note = null;
        try {

            session.beginTransaction();
            String quiry = "from ClinicalNotes where patient_id = " + object.getPatientId();
            clinicalNotesList = session.createQuery(quiry).list();


            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
        for(ClinicalNotes temp: clinicalNotesList){
            if(temp.isEditable()){
                note = temp;
            }
        }
        return  note;
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
    // this method return one pricing obj at a time
    public Pricing priceObj(int id) {
        Pricing price = null;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pricing.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();



        session.beginTransaction();
        try {
            price = session.get(Pricing.class, id);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
            session.close();
        }
            return price;


    }

    public List<Pricing> loadPricing() {
        List<Pricing>  pricings;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(Pricing.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            pricings = session.createQuery("from Pricing").list();

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

        return pricings;

    }

    public Patient loadSinglePatinetObject(Patient patient){

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
        Patient obj;
        try{
            session.beginTransaction();

            int id = patient.getPatientId();

            obj = (Patient) session.load(Patient.class, id);

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
        return obj;
    }
      
    public ArrayList<String> loadDiseaseType(){

        ArrayList<String> list = new ArrayList<String>();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .addAnnotatedClass(DiseaseType.class)

                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            String quiry = "select name from DiseaseType";
            list = (ArrayList<String>) session.createQuery(quiry).list();

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

        return list;
    }

}
