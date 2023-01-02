package org.example.author.dao;

import org.example.author.model.Author;
import org.example.author.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDao {
    public boolean saveAuthor(Author author) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.getTransaction();
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public List<Author> getAllAuthors() {
        List<Author> users = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            users = session.createQuery("from Author").list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }

}
