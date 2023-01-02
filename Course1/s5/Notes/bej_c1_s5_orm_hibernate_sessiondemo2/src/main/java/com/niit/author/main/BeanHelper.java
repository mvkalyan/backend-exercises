package com.niit.author.main;

import com.niit.author.dao.UserDAOImpl;
import com.niit.author.model.User;
import com.niit.author.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class BeanHelper {
  private static SessionFactory sessionFactory;
  private static Session session;
  public static void main(String args[])
  {
      sessionFactory= HibernateUtil.getSessionFactory();
      session=sessionFactory.openSession();
      System.out.println("Session open: "+session.isOpen());

      UserDAOImpl userDAO = new UserDAOImpl();
      User user = new User();
      user.setUsername("jhon");
      user.setEmail("jhon@gmail.com");
      System.out.println(userDAO.saveUser(user));

      userDAO.getAllUsers().forEach(i-> System.out.println(i));

  }
}
