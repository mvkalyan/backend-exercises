package com.niit.author.dao;

import com.niit.author.model.User;
import com.niit.author.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl {
    public boolean saveUser(User user) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.getTransaction();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            users = session.createQuery("from User").list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }
}
