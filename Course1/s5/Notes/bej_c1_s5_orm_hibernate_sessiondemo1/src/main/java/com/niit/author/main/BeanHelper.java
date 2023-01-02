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
      user.setUserId(103);
      user.setUsername("abc1");
      user.setEmail("abc1.com");
      System.out.println(userDAO.saveUser(user));


  }
}
