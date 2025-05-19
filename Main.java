package org.croissant;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


public class Main {
    public static void main(String[] args) {


        Buyer buyer = new Buyer("Ali", "09123456789", "ali@mail.com", "123456", "BUYER", "Tehran");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(buyer);
        session.getTransaction().commit();
        session.close();

    }
}