package org.example.author;

import org.example.author.dao.AuthorDao;
import org.example.author.model.Author;
import org.example.author.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void main(String args[])
    {
        sessionFactory= HibernateUtil.getSessionFactory();
        session=sessionFactory.openSession();
        System.out.println("Session open: "+session.isOpen());

        AuthorDao authorDao = new AuthorDao();
        Author author = new Author();
        author.setAuthId(103);
        author.setAuthName("MK");
        author.setAuthFam("Love this World in a Different Way");
        System.out.println(authorDao.saveAuthor(author));
    }
}
