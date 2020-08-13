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

//                                .addAnnotatedClass(Patient.class)
//                                .addAnnotatedClass(OutPatient.class)
//                                .addAnnotatedClass(ClinicalNotes.class)
//                                .addAnnotatedClass(TestProperty.class)
//                                .addAnnotatedClass(Parasitology.class)
//                                .addAnnotatedClass(Bacteriology.class)
//                                .addAnnotatedClass(Microscopy.class)
//                                .addAnnotatedClass(Chemistry.class)
//                                .addAnnotatedClass(Dipstick.class)
//                                .addAnnotatedClass(Others.class)
//                                .addAnnotatedClass(Cbs.class)
//                                .addAnnotatedClass(Serology.class)
//                                .addAnnotatedClass(LabRequest.class)
//                                .addAnnotatedClass(DiseaseRecord.class)
                                .addAnnotatedClass(Pricing.class)

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
                                .addAnnotatedClass(DiseaseRecord.class)
//                                .addAnnotatedClass(AgeScale.class)


                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


//              Laboratory laboratory = new Laboratory(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
//            Manager tempManager = new Manager(124, "test", "test", "123");
//            Doctor doctor = new Doctor(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
//            Secretary secretary = new Secretary(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");

//            TestProperty test = new TestProperty("TEST", 01,true);
//
//            Parasitology obj1 = new Parasitology(test,test,test,test,test,test,test);
//            Bacteriology obj2 = new Bacteriology(test, test);
//            Microscopy obj3 = new Microscopy(test,test,test,test,test);
//            Chemistry obj4 = new Chemistry(test,test,test,test,test,test,test,test,test,test,test,test);
//            Dipstick obj5 = new Dipstick(test,test,test,test,test,test,test,test,test,test);
//            Others obj6 = new Others(test, test, test, test);
//            Cbs obj7 = new Cbs(test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test);
//            Serology obj8 = new Serology(test,test,test,test,test,test,test,test,test);



//            LabRequest lab = new LabRequest("docId","labId",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);
//            LabRequest lab2 = new LabRequest("docId","labid",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);
//            Pricing hpaylori = new Pricing(50);
//            Pricing koh = new Pricing(50);

//            DiseaseRecord record2=new DiseaseRecord(LocalDate.now(),"tiphoyid",new AgeScale(4,5,1,2,3,4,7,8,4,5,8,6));
//
//            OutPatient patient = new OutPatient("Brock","Mk",44,'m',LocalDate.now(),"215487","city","cc","kk","5",LocalDate.now(),LocalDate.now());
//            Patient patient1 = new Patient("Brook","ML",44,'m',LocalDate.now(),"124578","city","cc","kk","5");
//            Patient patient2 = new Patient("Aman","Ab",44,'m',LocalDate.now(),"326598","city","cc","kk","5");
//            Patient patient3 = new Patient("Biruk","Molla",44,'m',LocalDate.now(),"125465","city","cc","kk","5");
//            Patient patient4 = new Patient("Biruk","Mekonnen",44,'m',LocalDate.now(),"985412","city","cc","kk","5");
//
//            ClinicalNotes clinicalNote = new ClinicalNotes(LocalDate.now(),"this is for test!","docId");
//            ClinicalNotes clinicalNote2 = new ClinicalNotes(LocalDate.now(),"this is for another test!!","docId");

//            patient.addClincalNote(clinicalNote);
//            patient.addClincalNote(clinicalNote2);
//            patient.addLabRequest(lab);
//            patient.addLabRequest(lab2);
//
//            patient.setDocActives(true);
//            patient1.setLabActives(true);
//            patient2.setSecActives(true);
//            patient3.setSecActives(true);
//            patient4.setLabActives(true);

            session.beginTransaction();
            Pricing pricing = new Pricing(12);
            Pricing pricing1 = new Pricing(22);
            Pricing pricing2 = new Pricing(32);
            Pricing pricing3 = new Pricing(42);
            Pricing pricing4 = new Pricing(32);
            Pricing pricing5 = new Pricing(86);
            Pricing pricing6 = new Pricing(25);
            Pricing pricing7 = new Pricing(44);
            Pricing pricing8 = new Pricing(33);
            Pricing pricing9 = new Pricing(23);
            Pricing pricing10 = new Pricing(45);
            Pricing pricing11 = new Pricing(66);
            Pricing pricing12 = new Pricing(57);
            Pricing pricing13 = new Pricing(88);
            Pricing pricing14 = new Pricing(23);
            Pricing pricing15 = new Pricing(55);
            Pricing pricing16 = new Pricing(33);
            Pricing pricing17 = new Pricing(13);
            Pricing pricing18 = new Pricing(32);
            Pricing pricing19 = new Pricing(23);
            Pricing pricing20 = new Pricing(25);
            Pricing pricing21 = new Pricing(26);
            Pricing pricing22 = new Pricing(26);
            Pricing pricing23 = new Pricing(27);
            Pricing pricing24 = new Pricing(19);
            Pricing pricing25 = new Pricing(20);
            Pricing pricing26 = new Pricing(56);
            Pricing pricing27 = new Pricing(43);
            Pricing pricing28 = new Pricing(34);
            Pricing pricing29 = new Pricing(68);
            Pricing pricing30 = new Pricing(12);
            Pricing pricing31 = new Pricing(12);
            Pricing pricing32 = new Pricing(12);
            Pricing pricing33 = new Pricing(12);
            Pricing pricing34 = new Pricing(12);
            Pricing pricing35 = new Pricing(12);
            Pricing pricing36 = new Pricing(12);
            Pricing pricing37 = new Pricing(12);
            Pricing pricing38 = new Pricing(12);
            Pricing pricing39 = new Pricing(12);
            Pricing pricing40 = new Pricing(12);
            Pricing pricing41 = new Pricing(12);
            Pricing pricing42 = new Pricing(12);
            Pricing pricing43 = new Pricing(12);
            Pricing pricing44 = new Pricing(12);
            Pricing pricing45 = new Pricing(12);
            Pricing pricing46 = new Pricing(12);
            Pricing pricing47 = new Pricing(12);
            Pricing pricing48 = new Pricing(12);
            Pricing pricing49 = new Pricing(12);
            Pricing pricing50 = new Pricing(12);
            Pricing pricing51 = new Pricing(12);
            Pricing pricing52 = new Pricing(12);
            Pricing pricing53 = new Pricing(12);
            Pricing pricing54 = new Pricing(12);
            Pricing pricing55 = new Pricing(12);
            Pricing pricing56 = new Pricing(12);
            Pricing pricing57 = new Pricing(12);
            Pricing pricing58 = new Pricing(12);
            Pricing pricing59 = new Pricing(12);
            Pricing pricing60 = new Pricing(12);
            Pricing pricing61 = new Pricing(12);
            Pricing pricing62 = new Pricing(12);
            Pricing pricing63 = new Pricing(12);
            Pricing pricing64 = new Pricing(12);
            Pricing pricing65 = new Pricing(12);
            Pricing pricing66 = new Pricing(12);
            Pricing pricing67 = new Pricing(12);

            session.save(pricing);
            session.save(pricing1);
            session.save(pricing2);
            session.save(pricing3);
            session.save(pricing4);
            session.save(pricing5);
            session.save(pricing6);
            session.save(pricing7);
            session.save(pricing8);
            session.save(pricing9);
            session.save(pricing10);
            session.save(pricing11);
            session.save(pricing12);
            session.save(pricing13);
            session.save(pricing14);
            session.save(pricing15);
            session.save(pricing16);
            session.save(pricing17);
            session.save(pricing18);
            session.save(pricing19);
            session.save(pricing20);
            session.save(pricing21);
            session.save(pricing22);
            session.save(pricing23);
            session.save(pricing24);
            session.save(pricing25);
            session.save(pricing26);
            session.save(pricing27);
            session.save(pricing28);
            session.save(pricing29);
            session.save(pricing30);
            session.save(pricing31);
            session.save(pricing32);
            session.save(pricing33);
            session.save(pricing34);
            session.save(pricing35);
            session.save(pricing36);
            session.save(pricing37);
            session.save(pricing38);
            session.save(pricing39);
            session.save(pricing40);
            session.save(pricing41);
            session.save(pricing42);
            session.save(pricing43);
            session.save(pricing44);
            session.save(pricing45);
            session.save(pricing46);
            session.save(pricing47);
            session.save(pricing48);
            session.save(pricing49);
            session.save(pricing50);
            session.save(pricing51);
            session.save(pricing52);
            session.save(pricing53);
            session.save(pricing54);
            session.save(pricing55);
            session.save(pricing56);
            session.save(pricing57);
            session.save(pricing58);
            session.save(pricing59);
            session.save(pricing60);
            session.save(pricing61);
            session.save(pricing62);
            session.save(pricing63);
            session.save(pricing64);
            session.save(pricing65);
            session.save(pricing66);
            session.save(pricing67);
//            session.save(patient);

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


            Patient patient1 = new Patient("Abrish","TD",44,'m',LocalDate.now(),"124578","city","cc","kk","5");
            Patient patient2 = new Patient("Alex","AD",44,'m',LocalDate.now(),"326598","city","cc","kk","5");
            Patient patient3 = new Patient("Dagi","AB",44,'m',LocalDate.now(),"125465","city","cc","kk","5");
            Patient patient4 = new Patient("Dagi","KB",44,'m',LocalDate.now(),"985412","city","cc","kk","5");
            Patient patient5 = new Patient("Amani","AL",44,'m',LocalDate.now(),"124578","city","cc","kk","5");

            ClinicalNotes clinicalNote = new ClinicalNotes(LocalDate.now(),"this is for test!","docId");
            ClinicalNotes clinicalNote2 = new ClinicalNotes(LocalDate.now(),"this is for another test!!","docId");

            patient1.addClincalNote(clinicalNote);
            patient1.addClincalNote(clinicalNote2);
            patient1.addLabRequest(lab);
            patient1.addLabRequest(lab2);

            patient1.setLabActives(true);
            patient2.setSecActives(true);
            patient3.setSecActives(true);
            patient4.setLabActives(true);

            session.beginTransaction();





//            session.save(patient2);
//            session.save(patient1);
//            session.save(patient3);
//            session.save(patient4);


//            List<Patient> patientList = session.createQuery("from Patient where patientStates = true").list();
//            for(Patient temp : patientList){
//                temp.setPatientStates(false);
//            }

//            List<Patient> patientList = session.createQuery("from Patient where patientId = 1").list();
//            List<Patient> patientList = session.createQuery("from Patient where patientId = 1").list();
//            for(Patient temp : patientList){
//                temp.setPatientStates(true);
//            }
            Patient obj = (Patient) session.load(Patient.class, 8);
            obj.setSecActives(true);
            obj.setOutPatinet(true);




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
