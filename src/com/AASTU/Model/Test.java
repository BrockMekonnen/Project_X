package com.AASTU.Model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Serology.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

//            Manager tempManager = new Manager(124, "test", "test", "123456789");
//            Doctor doctor = new Doctor(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");
//            Secretary secretary = new Secretary(111,"test", "fff",  LocalDate.now(),"123",12,3,2,4,"+2517777777","city","subcity","kebele");

            TestProperty test = new TestProperty("postive", 2154,true);
//            Others obj = new Others(test, test, test, test);
//            Bacteriology bacteriology = new Bacteriology(test, test);
            Serology serology = new Serology(test,test,test,test,test,test,test,test,test);
            session.beginTransaction();

            session.save(serology);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

}
