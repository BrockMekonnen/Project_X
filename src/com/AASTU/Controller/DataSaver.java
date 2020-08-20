package com.AASTU.Controller;

import com.AASTU.Model.*;
import com.AASTU.Model.LaboratoryRequest.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.AASTU.Controller.LaboratoryWindowController.currentLaboratory;

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
            updateActivity(patient.getPatientId(),LaboratoryWindowController.currentLaboratory.getFirstName()+" "+LaboratoryWindowController.currentLaboratory.getLastName()+" Send Patient's Laboratory Result to Doctor",2,LocalDate.now(),currentLaboratory.getLaboratoryId());
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

    public void saveActivity(WorkActivity activity){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WorkActivity.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(activity);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }

    public void Activity(String activity,int Secretaryid,int PatientId){
        WorkActivity activity1=new WorkActivity();
        activity1.setActivity_day(LocalDate.now());
        activity1.setActivity(Secretaryid+": "+activity+"\n");
        activity1.setSecretaryId(Secretaryid);
        activity1.setPatientId(PatientId);
        saveActivity(activity1);

    }

    public void updateActivity(int patientid,String Activity,int identify,LocalDate date1,int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WorkActivity.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            boolean check=false;
            session.beginTransaction();
            WorkActivity obj1=new DataLoader().SpecificloadActivity("from WorkActivity where date ="+ DateTimeFormatter.BASIC_ISO_DATE.format(date1),patientid);
            if(obj1!=null){
            WorkActivity obj=session.load(WorkActivity.class,obj1.getActivityId());
            if(identify==1){
            obj.setActivity(obj.getActivity()+Activity);
            obj.setDoctorId(new DoctorWindowController().DoctorId);
            session.update(obj);
            }
            else if(identify==2){
                obj.setActivity(obj.getActivity()+Activity);
                obj.setLabTechnicianId(new LaboratoryWindowController().LaboratoryId);
                session.update(obj);
            }
            session.getTransaction().commit();}
            else saveOther(Activity,identify,id,date1,patientid);
        } finally {
            factory.close();
            session.close();
        }
    }

    public void saveOther(String activity,int identify,int id,LocalDate date,int Patientid){
        WorkActivity obj=new WorkActivity();
        obj.setActivity(activity);
        obj.setActivity_day(date);
        obj.setPatientId(Patientid);
        if(identify==1){
            obj.setDoctorId(id);
        }
        else if(identify==2)
            obj.setLabTechnicianId(id);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WorkActivity.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            session.beginTransaction();

            session.save(obj);
            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
}
