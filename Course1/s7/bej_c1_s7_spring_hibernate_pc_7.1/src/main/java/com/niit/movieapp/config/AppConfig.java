package com.niit.movieapp.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfig {
 /*
            Use this configuration while submitting solution in hobbes.
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://" + System.getenv("MYSQL_HOST") + ":3306/" + System.getenv("MYSQL_DATABASE")
                    +"?verifyServerCertificate=false&useSSL=false&requireSSL=false");
            dataSource.setUsername(System.getenv("MYSQL_USER"));
            dataSource.setPassword(System.getenv("MYSQL_PASSWORD")); */

    /****************************************************************************/


    /*
     * Define the bean for DataSource(MYSQL). To create the DataSource bean, the below is needed:
     * 1. Driver class name
     * 2. Database URL
     * 3. UserName
     * 4. Password
     */
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        //set the URL to your database path
        ds.setUrl("");
        //set username
        ds.setUsername("");
        //set password
        ds.setPassword("");
        return ds;
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean getSessionFactory(DataSource ds)
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(ds);
        sessionFactory.setPackagesToScan("com.niit.movieapp.model");
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create");
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
