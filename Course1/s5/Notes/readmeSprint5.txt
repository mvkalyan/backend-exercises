1.Domain class:user

2.create hibernate.cfg.xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>

    <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/wave30?useSSL=false</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">root</property>
    <property name="hibernate.hbm2ddl.auto">create</property>
    <property name="show_sql">true</property>
    <mapping resource="user.hbm.xml"></mapping>
  </session-factory>
</hibernate-configuration>


3.HibernateUtil.java

4.implement userDao

	 Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.getTransaction();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

5.Crate test.java

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

6.user.hbm.xml
<hibernate-mapping>
    <class name="com.niit.author.model.User" table="USER">
        <id name="userId" type="int">
            <column name="USERID" />
  <!--            <generator class="assigned" />-->
        </id>

        <property name="username" type="string" column ="USERNAME" length="30"/>
        <property name="email" type="string" column ="EMAIL" length="45">
        </property>
    </class>
</hibernate-mapping>






