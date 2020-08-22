package com.AASTU.Model;


import com.AASTU.Controller.DataLoader;
import com.AASTU.Model.LaboratoryRequest.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(DiseaseType.class)

                                .addAnnotatedClass(Pricing.class)
                                .addAnnotatedClass(DiseaseType.class)
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
                                .addAnnotatedClass(IncomeAnalysis.class)
                                .addAnnotatedClass(DiseaseRecord.class)
                                .addAnnotatedClass(PatientAnalysis.class)
                                .addAnnotatedClass(AgeScale.class)

                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();


//            Laboratory laboratory = new Laboratory(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");

//            Manager tempManager = new Manager(124, "test", "test", "123");
//            Doctor doctor = new Doctor(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
//            Secretary secretary = new Secretary(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
//
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
//
//
//
//            LabRequest lab = new LabRequest("docId","labId",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);
//            LabRequest lab2 = new LabRequest("docId","labid",LocalDate.now(),obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);

//            Pricing hpaylori = new Pricing(50,"hpaylori");
//            Pricing koh = new Pricing(50,"koh");
//
//            DiseaseRecord record2=new DiseaseRecord(LocalDate.now(),"tiphoyid",new AgeScale(4,5,1,2,3,4,7,8,4,5,8,6));
//
//

//            Patient patient1 = new Patient("Abrish","TD",44,'m',LocalDate.now(),"124578","city","cc","kk","5");
//            Patient patient2 = new Patient("Alex","AD",44,'m',LocalDate.now(),"326598","city","cc","kk","5");
//            Patient patient3 = new Patient("Dagi","AB",44,'m',LocalDate.now(),"125465","city","cc","kk","5");
//            Patient patient4 = new Patient("Dagi","KB",44,'m',LocalDate.now(),"985412","city","cc","kk","5");
//            Patient patient5 = new Patient("Amani","AL",44,'m',LocalDate.now(),"124578","city","cc","kk","5");

//
//            ClinicalNotes clinicalNote = new ClinicalNotes(LocalDate.now(),"this is for test!","docId");
//            ClinicalNotes clinicalNote2 = new ClinicalNotes(LocalDate.now(),"this is for another test!!","docId");
//
//            patient1.addClincalNote(clinicalNote);
//            patient1.addClincalNote(clinicalNote2);
//            patient1.addLabRequest(lab);
//            patient1.addLabRequest(lab2);
//



//            session.save(patient2);
//            session.save(patient1);
//            session.save(patient3);
//            session.save(patient4);
//            session.save(patient5);


//            List<Patient> patientList = session.createQuery("from Patient where patientStatus = 1").list();
//            for(Patient temp : patientList){
//                temp.setDocActives(true);
//            }

//            List<IncomeAnalysis> list = new ArrayList<>();
//
//            for(int i=0, j=5000; i<19; i++){
//                list.add(i,new IncomeAnalysis(LocalDate.of(2020,8,i+1), j-=70));
//            }
//            for(IncomeAnalysis temp: list){
//                session.save(temp);
//            }

            AgeScale scale = new AgeScale(4,5,1,2,3,4,7,8,4,5,8,6);
            AgeScale scale2 = new AgeScale(9,11,0,7,14,3,7,12,18,1,9,4);
            AgeScale scale3 = new AgeScale(5,1,10,4,1,13,7,2,8,10,3,6);
            AgeScale scale4 = new AgeScale(55,97,168,502,706,910,77,220,812,1001,1204,656);
            List<DiseaseRecord> diseaseRecordList = new ArrayList<>();
//            for(int i=0; i<22;i++){
//                diseaseRecordList.add(i,new DiseaseRecord(LocalDate.of(2020,8,i+1),"Corona virus", scale4));
//            }
//            for(DiseaseRecord temp: diseaseRecordList){
//                session.save(temp);
//            }
//
            session.save(new DiseaseRecord(LocalDate.now(),"Ebola", new AgeScale( 1, 3, 5, 11, 7 , 12, 0, 13, 14, 11, 12, 15)));


            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

    }

}












