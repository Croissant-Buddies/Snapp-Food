package org.croissant;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Buyer.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Food.class)
                    .addAnnotatedClass(UserDAO.class)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Use openSession() instead of getCurrentSession() for standalone apps
//    public static Session openSession() {
//        return sessionFactory.openSession();
//    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
