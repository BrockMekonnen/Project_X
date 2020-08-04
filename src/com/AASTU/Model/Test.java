package com.AASTU.Model;


import com.AASTU.Model.LaboratoryRequest.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(LabRequest.class)
//                                 .addAnnotatedClass(Dipstick.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

//            Manager tempManager = new Manager(124, "test", "test", "123456789");
//            Doctor doctor = new Doctor(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
//            Secretary secretary = new Secretary(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");

            TestProperty test = new TestProperty("postive", 2154,true);

            Parasitology obj1 = new Parasitology(test,test,test,test,test,test,test);
            Bacteriology obj2 = new Bacteriology(test, test);
            Microscopy obj3 = new Microscopy(test,test,test,test,test);
            Chemistry obj4 = new Chemistry(test,test,test,test,test,test,test,test,test,test,test,test);
            Dipstick obj5 = new Dipstick(test,test,test,test,test,test,test,test,test,test);
            Others obj6 = new Others(test, test, test, test);
            Cbs obj7 = new Cbs(test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test);
            Serology obj8 = new Serology(test,test,test,test,test,test,test,test,test);



            LabRequest lab = new LabRequest(obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);
            LabRequest lab2 = new LabRequest(obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8);

            session.beginTransaction();

            session.save(lab);
            session.save(lab2);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

}
