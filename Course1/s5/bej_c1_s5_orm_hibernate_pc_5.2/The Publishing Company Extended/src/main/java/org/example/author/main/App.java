package org.example.author.main;

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

    public static void main( String[] args )
    {
        sessionFactory= HibernateUtil.getSessionFactory();
        session=sessionFactory.openSession();
        System.out.println("Session open: "+session.isOpen());

        AuthorDao authorDao = new AuthorDao();
        Author author = new Author();
        author.setAuthName("MVK");
        author.setAuthFam("Love this World in a Different Way1312321321");

        authorDao.getAllAuthors().forEach(i-> System.out.println(i));
    }
}
