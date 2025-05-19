package org.croissant;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAO {


    public User login(String phone, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            String hql = "FROM User u WHERE u.number = :phone";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("phone", phone);
            user = query.uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage());
        } finally {
            session.close();
        }
        System.out.println("Phone: " + phone);
        System.out.println("User from DB: " + (user != null ? user.getNumber() : "null"));

        return null;
    }

}


