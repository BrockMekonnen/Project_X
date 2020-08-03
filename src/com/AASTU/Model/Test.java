package com.AASTU.Model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Manager.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Manager tempManager = new Manager(124, "test", "test", "123456789");

            session.beginTransaction();

            session.save(tempManager);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

}
