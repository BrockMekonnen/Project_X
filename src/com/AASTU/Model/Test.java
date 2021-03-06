package com.AASTU.Model;


import com.AASTU.Controller.DataLoader;
import com.AASTU.Controller.DataSaver;
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

//            List<DiseaseType> diseaseTypeList = new ArrayList<>();
//
//            diseaseTypeList.add(new DiseaseType("Acinetobacter"));
//            diseaseTypeList.add(new DiseaseType("Actinomycosis"));
//            diseaseTypeList.add(new DiseaseType("African sleeping sickness"));
//            diseaseTypeList.add(new DiseaseType("AIDS"));
//            diseaseTypeList.add(new DiseaseType("Amoebiasis"));
//            diseaseTypeList.add(new DiseaseType("Anaplasmosis"));
//            diseaseTypeList.add(new DiseaseType("Angiostrongyliasis"));
//            diseaseTypeList.add(new DiseaseType("Anisakiasis"));
//            diseaseTypeList.add(new DiseaseType("Anthrax"));
//            diseaseTypeList.add(new DiseaseType("Arcanobacterium haemolyticum "));
//            diseaseTypeList.add(new DiseaseType("Argentine hemorrhagic fever"));
//            diseaseTypeList.add(new DiseaseType("Ascariasis"));
//
//            diseaseTypeList.add(new DiseaseType("Aspergillosis"));
//            diseaseTypeList.add(new DiseaseType("Astrovirus"));
//            diseaseTypeList.add(new DiseaseType("Babesiosis"));
//            diseaseTypeList.add(new DiseaseType("Bacillus cereus infection"));
//            diseaseTypeList.add(new DiseaseType("Bacterial meningitis"));
//            diseaseTypeList.add(new DiseaseType("Bacterial pneumonia"));
//            diseaseTypeList.add(new DiseaseType("Bacterial vaginosis"));
//            diseaseTypeList.add(new DiseaseType("Bacteroides infection"));
//
//            diseaseTypeList.add(new DiseaseType("Balantidiasis"));
//            diseaseTypeList.add(new DiseaseType("Bartonellosis"));
//            diseaseTypeList.add(new DiseaseType("Baylisascaris infection"));
//            diseaseTypeList.add(new DiseaseType("BK virus infection"));
//            diseaseTypeList.add(new DiseaseType("Black piedra"));
//            diseaseTypeList.add(new DiseaseType("Blastocystosis"));
//            diseaseTypeList.add(new DiseaseType("Blastomycosis"));
//            diseaseTypeList.add(new DiseaseType("Bolivian hemorrhagic fever"));
//            diseaseTypeList.add(new DiseaseType("Botulism"));
//            diseaseTypeList.add(new DiseaseType("Brazilian hemorrhagic fever"));
//            diseaseTypeList.add(new DiseaseType("Brucellosis"));
//            diseaseTypeList.add(new DiseaseType("Bubonic plague"));
//            diseaseTypeList.add(new DiseaseType("Burkholderia infection"));
//            diseaseTypeList.add(new DiseaseType("Buruli ulcer"));
//            diseaseTypeList.add(new DiseaseType("Calicivirus infection"));
//            diseaseTypeList.add(new DiseaseType("Campylobacteriosis"));
//            diseaseTypeList.add(new DiseaseType("Candidiasis "));
//            diseaseTypeList.add(new DiseaseType("Capillariasis"));
//            diseaseTypeList.add(new DiseaseType("Carrion's disease"));
//            diseaseTypeList.add(new DiseaseType("Cat-scratch disease"));
//            diseaseTypeList.add(new DiseaseType("Cellulitis"));
//            diseaseTypeList.add(new DiseaseType("Chagas disease"));
//            diseaseTypeList.add(new DiseaseType("Chancroid"));
//            diseaseTypeList.add(new DiseaseType("Chickenpox"));
//            diseaseTypeList.add(new DiseaseType("Chikungunya"));
//            diseaseTypeList.add(new DiseaseType("Chlamydia"));
//            diseaseTypeList.add(new DiseaseType("Chlamydophila pneumoniae"));
//            diseaseTypeList.add(new DiseaseType("Cholera"));
//            diseaseTypeList.add(new DiseaseType("Chromoblastomycosis"));
//            diseaseTypeList.add(new DiseaseType("Chytridiomycosis"));
//            diseaseTypeList.add(new DiseaseType("Clonorchiasis"));
//
//            diseaseTypeList.add(new DiseaseType("Clostridium difficile colitis"));
//            diseaseTypeList.add(new DiseaseType("Coccidioidomycosis"));
//            diseaseTypeList.add(new DiseaseType("Colorado tick fever"));
//            diseaseTypeList.add(new DiseaseType("Common cold"));
//            diseaseTypeList.add(new DiseaseType("Coronavirus disease 2019"));
//            diseaseTypeList.add(new DiseaseType("Creutzfeldt–Jakob disease "));
//            diseaseTypeList.add(new DiseaseType("Crimean-Congo hemorrhagic fever "));
//            diseaseTypeList.add(new DiseaseType("Cryptococcosis"));
//            diseaseTypeList.add(new DiseaseType("Cryptosporidiosis"));
//            diseaseTypeList.add(new DiseaseType("Cutaneous larva migrans"));
//            diseaseTypeList.add(new DiseaseType("Cyclosporiasis"));
//            diseaseTypeList.add(new DiseaseType("Cysticercosis"));
//            diseaseTypeList.add(new DiseaseType("Cytomegalovirus infection"));
//            diseaseTypeList.add(new DiseaseType("Dengue fever"));
//            diseaseTypeList.add(new DiseaseType("Desmodesmus infection"));
//            diseaseTypeList.add(new DiseaseType("Dientamoebiasis"));
//            diseaseTypeList.add(new DiseaseType("Diphtheria"));
//            diseaseTypeList.add(new DiseaseType("Diphyllobothriasis"));
//            diseaseTypeList.add(new DiseaseType("Dracunculiasis"));
//            diseaseTypeList.add(new DiseaseType("Ebola hemorrhagic fever"));
//            diseaseTypeList.add(new DiseaseType("Echinococcosis"));
//            diseaseTypeList.add(new DiseaseType("Ehrlichiosis"));
//            diseaseTypeList.add(new DiseaseType("Enterococcus infection "));
//            diseaseTypeList.add(new DiseaseType("Enterobiasis "));
//            diseaseTypeList.add(new DiseaseType("Enterovirus infection"));
//            diseaseTypeList.add(new DiseaseType("Epidemic typhus"));
//            diseaseTypeList.add(new DiseaseType("Erythema infectiosum "));
//            diseaseTypeList.add(new DiseaseType("Exanthem subitum"));
//            diseaseTypeList.add(new DiseaseType("Fasciolasis"));
//            diseaseTypeList.add(new DiseaseType("Fasciolopsiasis"));
//
//            diseaseTypeList.add(new DiseaseType("Fatal familial insomnia"));
//            diseaseTypeList.add(new DiseaseType("Filariasis"));
//            diseaseTypeList.add(new DiseaseType("Food poisoning by Clostridium perfringens"));
//            diseaseTypeList.add(new DiseaseType("Free-living amebic infection"));
//            diseaseTypeList.add(new DiseaseType("Fusobacterium infection"));
//            diseaseTypeList.add(new DiseaseType("Gas gangrene "));
//            diseaseTypeList.add(new DiseaseType("Geotrichosis"));
//            diseaseTypeList.add(new DiseaseType("Gerstmann-Sträussler-Scheinker syndrome (GSS)"));
//            diseaseTypeList.add(new DiseaseType("Giardiasis"));
//            diseaseTypeList.add(new DiseaseType("Glanders"));
//            diseaseTypeList.add(new DiseaseType("Gnathostomiasis"));
//            diseaseTypeList.add(new DiseaseType("Gonorrhea"));
//            diseaseTypeList.add(new DiseaseType("Granuloma inguinale"));
//            diseaseTypeList.add(new DiseaseType("Group A streptococcal infection"));
//            diseaseTypeList.add(new DiseaseType("Group B streptococcal infection"));
//            diseaseTypeList.add(new DiseaseType("Haemophilus influenzae infection"));
//            diseaseTypeList.add(new DiseaseType("Hand, foot and mouth disease (HFMD)"));
//            diseaseTypeList.add(new DiseaseType("Hantavirus Pulmonary Syndrome (HPS)"));
//            diseaseTypeList.add(new DiseaseType("Heartland virus disease"));
//            diseaseTypeList.add(new DiseaseType("Helicobacter pylori infection"));
//            diseaseTypeList.add(new DiseaseType("Hemolytic-uremic syndrome (HUS)"));
//            diseaseTypeList.add(new DiseaseType("Hemorrhagic fever with renal syndrome (HFRS)"));
//            diseaseTypeList.add(new DiseaseType("Hendra virus infection"));
//            diseaseTypeList.add(new DiseaseType("Hepatitis A"));
//            diseaseTypeList.add(new DiseaseType("Hepatitis B"));
//            diseaseTypeList.add(new DiseaseType("Hepatitis C"));
//            diseaseTypeList.add(new DiseaseType("Hepatitis D"));
//            diseaseTypeList.add(new DiseaseType("Hepatitis E"));
//            diseaseTypeList.add(new DiseaseType("Herpes simplex"));
//            diseaseTypeList.add(new DiseaseType("Histoplasmosis"));
//            diseaseTypeList.add(new DiseaseType("Hookworm infection"));
//            diseaseTypeList.add(new DiseaseType("Human bocavirus infection"));
//            diseaseTypeList.add(new DiseaseType("Human ewingii ehrlichiosis"));
//            diseaseTypeList.add(new DiseaseType("Human granulocytic anaplasmosis (HGA)"));
//            diseaseTypeList.add(new DiseaseType("Human metapneumovirus infection"));
//            diseaseTypeList.add(new DiseaseType("Human monocytic ehrlichiosis"));
//
//            diseaseTypeList.add(new DiseaseType("Human papillomavirus (HPV) infection"));
//            diseaseTypeList.add(new DiseaseType("Human parainfluenza virus infection\n"));
//            diseaseTypeList.add(new DiseaseType("Hymenolepiasis"));
//            diseaseTypeList.add(new DiseaseType("Epstein–Barr virus infectious mononucleosis (Mono)"));
//            diseaseTypeList.add(new DiseaseType("Influenza (flu)"));
//            diseaseTypeList.add(new DiseaseType("Isosporiasis"));
//            diseaseTypeList.add(new DiseaseType("Kawasaki disease"));
//            diseaseTypeList.add(new DiseaseType("Keratitis"));
//            diseaseTypeList.add(new DiseaseType("Kingella kingae infection"));
//            diseaseTypeList.add(new DiseaseType("Kuru"));
//            diseaseTypeList.add(new DiseaseType("Lassa fever"));
//            diseaseTypeList.add(new DiseaseType("Legionellosis (Legionnaires' disease)"));
//            diseaseTypeList.add(new DiseaseType("Pontiac fever"));
//            diseaseTypeList.add(new DiseaseType("Leishmaniasis"));
//            diseaseTypeList.add(new DiseaseType("Leprosy"));
//            diseaseTypeList.add(new DiseaseType("Leptospirosis"));
//            diseaseTypeList.add(new DiseaseType("Listeriosis"));
//            diseaseTypeList.add(new DiseaseType("Lyme disease "));
//            diseaseTypeList.add(new DiseaseType("Lymphatic filariasis "));
//            diseaseTypeList.add(new DiseaseType("Lymphocytic choriomeningitis"));
//            diseaseTypeList.add(new DiseaseType("Malaria"));
//            diseaseTypeList.add(new DiseaseType("Marburg hemorrhagic fever (MHF)"));
//            diseaseTypeList.add(new DiseaseType("Measles"));
//            diseaseTypeList.add(new DiseaseType("Middle East respiratory syndrome (MERS)"));
//            diseaseTypeList.add(new DiseaseType("Melioidosis (Whitmore's disease)"));
//            diseaseTypeList.add(new DiseaseType("Meningitis"));
//            diseaseTypeList.add(new DiseaseType("Meningococcal disease"));
//            diseaseTypeList.add(new DiseaseType("Metagonimiasis"));
//            diseaseTypeList.add(new DiseaseType("Microsporidiosis"));
//            diseaseTypeList.add(new DiseaseType("Molluscum contagiosum (MC)"));
//            diseaseTypeList.add(new DiseaseType("Monkeypox"));
//            diseaseTypeList.add(new DiseaseType("Mumps"));
//
//            diseaseTypeList.add(new DiseaseType("Murine typhus (Endemic typhus)"));
//            diseaseTypeList.add(new DiseaseType("Mycoplasma pneumonia"));
//            diseaseTypeList.add(new DiseaseType("Mycoplasma genitalium infection"));
//            diseaseTypeList.add(new DiseaseType("Mycetoma"));
//            diseaseTypeList.add(new DiseaseType("Myiasis"));
//            diseaseTypeList.add(new DiseaseType("Neonatal conjunctivitis (Ophthalmia neonatorum)"));
//            diseaseTypeList.add(new DiseaseType("Nipah virus infection"));
//            diseaseTypeList.add(new DiseaseType("Norovirus"));
//            diseaseTypeList.add(new DiseaseType("Nocardiosis"));
//            diseaseTypeList.add(new DiseaseType("Onchocerciasis (River blindness)"));
//            diseaseTypeList.add(new DiseaseType("Opisthorchiasis"));
//            diseaseTypeList.add(new DiseaseType("Paracoccidioidomycosis "));
//            diseaseTypeList.add(new DiseaseType("Paragonimiasis"));
//            diseaseTypeList.add(new DiseaseType("Pasteurellosis"));
//            diseaseTypeList.add(new DiseaseType("Pediculosis capitis (Head lice)"));
//            diseaseTypeList.add(new DiseaseType("Pediculosis corporis (Body lice)"));
//            diseaseTypeList.add(new DiseaseType("Pediculosis pubis (pubic lice, crab lice)"));
//            diseaseTypeList.add(new DiseaseType("Pelvic inflammatory disease (PID)"));
//            diseaseTypeList.add(new DiseaseType("Pertussis (whooping cough)"));
//            diseaseTypeList.add(new DiseaseType("Plague"));
//            diseaseTypeList.add(new DiseaseType("Pneumococcal infection"));
//            diseaseTypeList.add(new DiseaseType("Pneumocystis pneumonia (PCP)"));
//            diseaseTypeList.add(new DiseaseType("Pneumonia"));
//            diseaseTypeList.add(new DiseaseType("Poliomyelitis"));
//            diseaseTypeList.add(new DiseaseType("Prevotella infection"));
//            diseaseTypeList.add(new DiseaseType("Primary amoebic meningoencephalitis (PAM)"));
//            diseaseTypeList.add(new DiseaseType("Progressive multifocal leukoencephalopathy"));
//            diseaseTypeList.add(new DiseaseType("Psittacosis"));
//            diseaseTypeList.add(new DiseaseType("Q fever"));
//            diseaseTypeList.add(new DiseaseType("Rabies"));
//            diseaseTypeList.add(new DiseaseType("Relapsing fever"));
//            diseaseTypeList.add(new DiseaseType("Respiratory syncytial virus infection"));
//
//            diseaseTypeList.add(new DiseaseType("Rhinosporidiosis"));
//            diseaseTypeList.add(new DiseaseType("Rhinovirus infection"));
//            diseaseTypeList.add(new DiseaseType("Rickettsial infection"));
//            diseaseTypeList.add(new DiseaseType("Rickettsialpox"));
//            diseaseTypeList.add(new DiseaseType("Rift Valley fever (RVF)"));
//            diseaseTypeList.add(new DiseaseType("Rocky Mountain spotted fever (RMSF)"));
//            diseaseTypeList.add(new DiseaseType("Rotavirus infection"));
//            diseaseTypeList.add(new DiseaseType("Rubella"));
//            diseaseTypeList.add(new DiseaseType("Salmonellosis"));
//            diseaseTypeList.add(new DiseaseType("SARS (severe acute respiratory syndrome)"));
//            diseaseTypeList.add(new DiseaseType("Scabies"));
//            diseaseTypeList.add(new DiseaseType("Scarlet fever"));
//            diseaseTypeList.add(new DiseaseType("Schistosomiasis"));
//            diseaseTypeList.add(new DiseaseType("Sepsis"));
//            diseaseTypeList.add(new DiseaseType("Shigellosis (bacillary dysentery)"));
//            diseaseTypeList.add(new DiseaseType("Shingles (Herpes zoster)"));
//            diseaseTypeList.add(new DiseaseType("Smallpox (variola)"));
//            diseaseTypeList.add(new DiseaseType("Sporotrichosis"));
//            diseaseTypeList.add(new DiseaseType("Staphylococcal food poisoning"));
//            diseaseTypeList.add(new DiseaseType("Staphylococcal infection"));
//            diseaseTypeList.add(new DiseaseType("Strongyloidiasis"));
//            diseaseTypeList.add(new DiseaseType("Subacute sclerosing panencephalitis"));
//            diseaseTypeList.add(new DiseaseType("Bejel, Syphilis, and Yaws"));
//            diseaseTypeList.add(new DiseaseType("Taeniasis"));
//            diseaseTypeList.add(new DiseaseType("Tetanus (lockjaw)"));
//            diseaseTypeList.add(new DiseaseType("Tinea barbae (barber's itch)"));
//            diseaseTypeList.add(new DiseaseType("Tinea capitis (ringworm of the scalp)"));
//            diseaseTypeList.add(new DiseaseType("Tinea corporis (ringworm of the body)"));
//            diseaseTypeList.add(new DiseaseType("Tinea cruris (Jock itch)"));
//            diseaseTypeList.add(new DiseaseType("Tinea manum (ringworm of the hand)"));
//            diseaseTypeList.add(new DiseaseType("Tinea nigra"));
//            diseaseTypeList.add(new DiseaseType("Tinea pedis (athlete’s foot)"));
//
//            diseaseTypeList.add(new DiseaseType("Tinea unguium (onychomycosis)"));
//            diseaseTypeList.add(new DiseaseType("Tinea versicolor (Pityriasis versicolor)"));
//            diseaseTypeList.add(new DiseaseType("Toxocariasis (ocular larva migrans (OLM))"));
//            diseaseTypeList.add(new DiseaseType("Toxocariasis (visceral larva migrans (VLM))"));
//            diseaseTypeList.add(new DiseaseType("Toxoplasmosis"));
//            diseaseTypeList.add(new DiseaseType("Trachoma"));
//            diseaseTypeList.add(new DiseaseType("Trichinosis"));
//            diseaseTypeList.add(new DiseaseType("Trichomoniasis"));
//            diseaseTypeList.add(new DiseaseType("Trichuriasis"));
//            diseaseTypeList.add(new DiseaseType("Tuberculosis"));
//            diseaseTypeList.add(new DiseaseType("Tularemia"));
//            diseaseTypeList.add(new DiseaseType("Typhoid fever"));
//            diseaseTypeList.add(new DiseaseType("Typhus fever"));
//            diseaseTypeList.add(new DiseaseType("Ureaplasma urealyticum infection"));
//            diseaseTypeList.add(new DiseaseType("Valley fever"));
//            diseaseTypeList.add(new DiseaseType("Venezuelan equine encephalitis"));
//            diseaseTypeList.add(new DiseaseType("Venezuelan hemorrhagic fever"));
//            diseaseTypeList.add(new DiseaseType("Vibrio vulnificus infection"));
//            diseaseTypeList.add(new DiseaseType("Vibrio parahaemolyticus enteritis"));
//            diseaseTypeList.add(new DiseaseType("Viral pneumonia"));
//            diseaseTypeList.add(new DiseaseType("West Nile fever"));
//            diseaseTypeList.add(new DiseaseType("White piedra (tinea blanca)"));
//            diseaseTypeList.add(new DiseaseType("Yersinia pseudotuberculosis infection"));
//            diseaseTypeList.add(new DiseaseType("Yersiniosis"));
//            diseaseTypeList.add(new DiseaseType("Yellow fever"));
//            diseaseTypeList.add(new DiseaseType("Zeaspora"));
//            diseaseTypeList.add(new DiseaseType("Zika fever"));
//            diseaseTypeList.add(new DiseaseType("Zygomycosis"));
//
//            for(DiseaseType temp : diseaseTypeList){
//                session.save(temp);
//            }

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
//
//            Patient patient1 = new Patient("Abrish","TD",44,'m',LocalDate.now(),"124578","city","cc","kk","5");
//            Patient patient2 = new Patient("Alex","AD",34,'m',LocalDate.now(),"326598","city","cc","kk","5");
//            Patient patient3 = new Patient("Dagi","AB",24,'m',LocalDate.now(),"125465","city","cc","kk","5");
//            Patient patient4 = new Patient("Dagi","KB",14,'m',LocalDate.now(),"985412","city","cc","kk","5");
//            Patient patient5 = new Patient("Amani","AL",4,'m',LocalDate.now(),"124578","city","cc","kk","5");
//
////
//            ClinicalNotes clinicalNote = new ClinicalNotes(LocalDate.now(),"this is for test!","docId");
//            ClinicalNotes clinicalNote2 = new ClinicalNotes(LocalDate.now(),"this is for another test!!","docId");
//
//            patient1.addClincalNote(clinicalNote);
//            patient1.addClincalNote(clinicalNote2);
//            patient1.addLabRequest(lab);
//            patient1.addLabRequest(lab2);
//


//            System.out.println(LocalDate.now());
//                new DataSaver().saveIncomeAnalysis(new IncomeAnalysis(LocalDate.now(), 0));



//            session.save(patient2);
//            session.save(patient1);
//            session.save(patient3);
//            session.save(patient4);
//            session.save(patient5);


//            List<Patient> patientList = session.createQuery("from Patient where patientStatus = false").list();
//            for(Patient temp : patientList){
//                temp.setPatientStatus(true);
//                temp.setDocActives(true);
//            }
//
//            for(Patient temp : patientList){
//                session.save(temp);
//            }

//            List<IncomeAnalysis> list = new ArrayList<>();
//
//            for(int i=0, j=6000; i<31; i++){
//                list.add(i,new IncomeAnalysis(LocalDate.of(2021,3,i+1), j+=35));
//            }
//            for(IncomeAnalysis temp: list){
//                session.save(temp);
//            }

//            List<PatientAnalysis> list = new ArrayList<>();
//
//            for(int i=0, j=7000; i<28; i++){
//                list.add(i,new PatientAnalysis(LocalDate.of(2021,2,i+1), j-=37));
//
//            }
//            for(PatientAnalysis temp: list){
//                session.save(temp);
//            }

//            System.out.println(LocalDate.now());
//            AgeScale scale = new AgeScale(4,5,1,2,3,4,7,8,4,5,8,6);
//            AgeScale scale2 = new AgeScale(9,11,0,7,14,3,7,12,18,1,9,4);
//            AgeScale scale3 = new AgeScale(5,1,10,4,1,13,7,2,8,10,3,6);
//            AgeScale scale4 = new AgeScale(55,97,168,502,706,910,77,220,812,1001,1204,656);
//            List<DiseaseRecord> diseaseRecordList = new ArrayList<>();
//
//            for(int i=0; i<2;i++) {
//                diseaseRecordList.add(i, new DiseaseRecord(LocalDate.of(2021, 3, i + 1), "Ebola", scale3));
//            }
//            for(int j=0; j<2;j++){
//                diseaseRecordList.add(j,new DiseaseRecord(LocalDate.of(2021,3,j+1),"Corona virus", scale4));
//
//            }
//            for(DiseaseRecord temp: diseaseRecordList){
//                session.save(temp);
//            }
//
//            session.save(new DiseaseRecord(LocalDate.now(),"Ebola", new AgeScale( 1, 3, 5, 11, 7 , 12, 0, 13, 14, 11, 12, 15)));




//            Pricing pricing = new Pricing(20,"Card");
//                session.save(pricing);


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

            new DataSaver().updateIncomeAnalysis(LocalDate.now(), 100);

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }

    }

}












