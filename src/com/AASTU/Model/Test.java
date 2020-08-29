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
                                .addAnnotatedClass(Pricing.class)

//                                .addAnnotatedClass(Pricing.class)
//                                .addAnnotatedClass(DiseaseType.class)
//                                .addAnnotatedClass(Patient.class)
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
//                                .addAnnotatedClass(IncomeAnalysis.class)
//                                .addAnnotatedClass(DiseaseRecord.class)
//                                .addAnnotatedClass(PatientAnalysis.class)
//                                .addAnnotatedClass(AgeScale.class)

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


//            AgeScale scale = new AgeScale(4,5,1,2,3,4,7,8,4,5,8,6);
//            AgeScale scale2 = new AgeScale(9,11,0,7,14,3,7,12,18,1,9,4);
//            AgeScale scale3 = new AgeScale(5,1,10,4,1,13,7,2,8,10,3,6);
//            AgeScale scale4 = new AgeScale(55,97,168,502,706,910,77,220,812,1001,1204,656);
//            List<DiseaseRecord> diseaseRecordList = new ArrayList<>();
//            for(int i=0; i<22;i++){
//                diseaseRecordList.add(i,new DiseaseRecord(LocalDate.of(2020,8,i+1),"Corona virus", scale4));
//            }
//            for(DiseaseRecord temp: diseaseRecordList){
//                session.save(temp);
//            }
//
//            session.save(new DiseaseRecord(LocalDate.now(),"Ebola", new AgeScale( 1, 3, 5, 11, 7 , 12, 0, 13, 14, 11, 12, 15)));



//            Pricing pricing1 = new Pricing(20,"H.PYLORI STOOL");
//            Pricing pricing2 = new Pricing(20,"KOH");
//            Pricing pricing3 = new Pricing(20,"WBC");
//            Pricing pricing4 = new Pricing(20,"LYM");
//            Pricing pricing5 = new Pricing(20,"MID");
//            Pricing pricing6 = new Pricing(20,"GRA");
//            Pricing pricing7 = new Pricing(20,"RBC");
//            Pricing pricing8 = new Pricing(20,"HGB");
//            Pricing pricing9 = new Pricing(20,"MCHC");
//            Pricing pricing10 = new Pricing(20,"MCH");
//            Pricing pricing11 = new Pricing(20,"MCV");
//            Pricing pricing12 = new Pricing(20,"RDW-CV");
//            Pricing pricing13 = new Pricing(20,"HCT");
//            Pricing pricing14 = new Pricing(20,"PLT");
//            Pricing pricing15 = new Pricing(20,"PCT");
//            Pricing pricing16 = new Pricing(20,"P-LCR");
//            Pricing pricing17 = new Pricing(20,"ESR");
//            Pricing pricing18 = new Pricing(20,"BLOOD GROUP");
//            Pricing pricing19 = new Pricing(20,"BLOOD FILM");
//            Pricing pricing20 = new Pricing(20,"FBS");
//            Pricing pricing21 = new Pricing(20,"RBS");
//            Pricing pricing22 = new Pricing(20,"SGOT");
//            Pricing pricing23 = new Pricing(20,"SGPT");
//            Pricing pricing24 = new Pricing(20,"Alkaline PhO");
//            Pricing pricing25 = new Pricing(20,"Birubin (total)");
//            Pricing pricing26 = new Pricing(20,"Birubin (Dir..)");
//            Pricing pricing27 = new Pricing(20,"BUN");
//            Pricing pricing28 = new Pricing(20,"Creatinine");
//            Pricing pricing29 = new Pricing(20,"Uric Acid");
//            Pricing pricing30 = new Pricing(20,"Total Protein");
//            Pricing pricing31 = new Pricing(20,"Cholestrol");
//            Pricing pricing32 = new Pricing(20,"Color");
//            Pricing pricing33 = new Pricing(20,"Appearance");
//            Pricing pricing34 = new Pricing(20,"PH");
//            Pricing pricing35 = new Pricing(20,"PSG");
//            Pricing pricing36 = new Pricing(20,"Protein");
//            Pricing pricing37 = new Pricing(20,"Glucose");
//            Pricing pricing38 = new Pricing(20,"Ketone");
//            Pricing pricing39 = new Pricing(20,"Birubin");
//            Pricing pricing40 = new Pricing(20,"Urobilinogen");
//            Pricing pricing41 = new Pricing(20,"Blood");
//            Pricing pricing42 = new Pricing(20,"Epit Cells");
//            Pricing pricing43 = new Pricing(20,"WBC");
//            Pricing pricing44 = new Pricing(20,"RBC");
//            Pricing pricing45 = new Pricing(20,"Casts");
//            Pricing pricing46 = new Pricing(20,"Bacteria");
//            Pricing pricing47 = new Pricing(20,"GramStain");
//            Pricing pricing48 = new Pricing(20,"WetFilm");
//            Pricing pricing49 = new Pricing(20,"Afb");
//            Pricing pricing50 = new Pricing(20,"Hiv Aids");
//            Pricing pricing51 = new Pricing(20,"Stool Test");
//            Pricing pricing52 = new Pricing(20,"Occult Blood");
//            Pricing pricing53 = new Pricing(20,"Consistency1");
//            Pricing pricing54 = new Pricing(20,"Consistency2");
//            Pricing pricing55 = new Pricing(20,"Oval Parasite1");
//            Pricing pricing56 = new Pricing(20,"Oval Parasite2");
//            Pricing pricing57 = new Pricing(20,"Oval Parasite3");
//            Pricing pricing58 = new Pricing(20,"VDRL");
//            Pricing pricing59 = new Pricing(20,"Widal II H");
//            Pricing pricing60 = new Pricing(20,"Widal II O");
//            Pricing pricing61 = new Pricing(20,"Well Felix");
//            Pricing pricing62 = new Pricing(20,"HBsag");
//            Pricing pricing63= new Pricing(20,"CRP");
//            Pricing pricing64 = new Pricing(20,"ASO");
//            Pricing pricing65 = new Pricing(20,"Rhenumatoid..");
//            Pricing pricing66 = new Pricing(20,"H.Pylori Serum");
//            Pricing pricing67 = new Pricing(20,"Card");
//
//            session.save(pricing1);
//            session.save(pricing2);
//            session.save(pricing3);
//            session.save(pricing4);
//            session.save(pricing5);
//            session.save(pricing6);
//            session.save(pricing7);
//            session.save(pricing8);
//            session.save(pricing9);
//            session.save(pricing10);
//            session.save(pricing11);
//            session.save(pricing12);
//            session.save(pricing13);
//            session.save(pricing14);
//            session.save(pricing15);
//            session.save(pricing16);
//            session.save(pricing17);
//            session.save(pricing18);
//            session.save(pricing19);
//            session.save(pricing20);
//            session.save(pricing21);
//            session.save(pricing22);
//            session.save(pricing23);
//            session.save(pricing24);
//            session.save(pricing25);
//            session.save(pricing26);
//            session.save(pricing27);
//            session.save(pricing28);
//            session.save(pricing29);
//            session.save(pricing30);
//            session.save(pricing31);
//            session.save(pricing32);
//            session.save(pricing33);
//            session.save(pricing34);
//            session.save(pricing35);
//            session.save(pricing36);
//            session.save(pricing37);
//            session.save(pricing38);
//            session.save(pricing39);
//            session.save(pricing40);
//            session.save(pricing41);
//            session.save(pricing42);
//            session.save(pricing43);
//            session.save(pricing44);
//            session.save(pricing45);
//            session.save(pricing46);
//            session.save(pricing47);
//            session.save(pricing48);
//            session.save(pricing49);
//            session.save(pricing50);
//            session.save(pricing51);
//            session.save(pricing52);
//            session.save(pricing53);
//            session.save(pricing54);
//            session.save(pricing55);
//            session.save(pricing56);
//            session.save(pricing57);
//            session.save(pricing58);
//            session.save(pricing59);
//            session.save(pricing60);
//            session.save(pricing61);
//            session.save(pricing62);
//            session.save(pricing63);
//            session.save(pricing64);
//            session.save(pricing65);
//            session.save(pricing66);
//            session.save(pricing67);
            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

    }

}












