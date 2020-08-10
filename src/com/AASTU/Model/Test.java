package com.AASTU.Model;


import com.AASTU.Controller.DataLoader;
import com.AASTU.Model.LaboratoryRequest.*;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Patient.class)
                                .addAnnotatedClass(OutPatient.class)
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
                                .addAnnotatedClass(DiseaseRecord.class)
//                                .addAnnotatedClass(AgeScale.class)

                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

              Laboratory laboratory = new Laboratory(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
            Manager tempManager = new Manager(124, "test", "test", "123");
            Doctor doctor = new Doctor(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
            Secretary secretary = new Secretary(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");

            TestProperty test = new TestProperty("TEST", 01,true);

            Parasitology obj1 = new Parasitology(test,test,test,test,test,test,test);
            Bacteriology obj2 = new Bacteriology(test, test);
            Microscopy obj3 = new Microscopy(test,test,test,test,test);
            Chemistry obj4 = new Chemistry(test,test,test,test,test,test,test,test,test,test,test,test);
            Dipstick obj5 = new Dipstick(test,test,test,test,test,test,test,test,test,test);
            Others obj6 = new Others(test, test, test, test);
            Cbs obj7 = new Cbs(test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test);
            Serology obj8 = new Serology(test,test,test,test,test,test,test,test,test);



            LabRequest lab = new LabRequest("docId","labId",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);
            LabRequest lab2 = new LabRequest("docId","labid",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);
            Pricing hpaylori = new Pricing(50);
            Pricing koh = new Pricing(50);

            DiseaseRecord record2=new DiseaseRecord(LocalDate.now(),"tiphoyid",new AgeScale(4,5,1,2,3,4,7,8,4,5,8,6));

            OutPatient patient = new OutPatient("Brock","Mk",44,'m',LocalDate.now(),"215487","city","cc","kk","5",LocalDate.now(),LocalDate.now());
            Patient patient1 = new Patient("Brook","ML",44,'m',LocalDate.now(),"124578","city","cc","kk","5");
            Patient patient2 = new Patient("Aman","Ab",44,'m',LocalDate.now(),"326598","city","cc","kk","5");
            Patient patient3 = new Patient("Biruk","Molla",44,'m',LocalDate.now(),"125465","city","cc","kk","5");
            Patient patient4 = new Patient("Biruk","Mekonnen",44,'m',LocalDate.now(),"985412","city","cc","kk","5");

            ClinicalNotes clinicalNote = new ClinicalNotes(LocalDate.now(),"this is for test!","docId");
            ClinicalNotes clinicalNote2 = new ClinicalNotes(LocalDate.now(),"this is for another test!!","docId");

            patient.addClincalNote(clinicalNote);
            patient.addClincalNote(clinicalNote2);
            patient.addLabRequest(lab);
            patient.addLabRequest(lab2);

            patient.setDocActives(true);
            patient1.setLabActives(true);
            patient2.setSecActives(true);
            patient3.setSecActives(true);
            patient4.setLabActives(true);

            session.beginTransaction();


            session.save(patient);
            session.save(patient2);
            session.save(patient1);
            session.save(patient3);
            session.save(patient4);
//            session.save(laboratory);
//            session.save(hpaylori);
//            session.save(koh);
//            session.save(record2);


            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
    }

}
