1.Create webapp project

2.Update POM.xml with required dependency

1.sprintg-webmvc
2.javax.servlet-apil
3.jstl
4.hibernate-core
5.spring-orm
6.mysql-connector
7.commons-dbcp

3.create pojo class with required annoations 

@Entity
@Id
@GeneratedValue

4.create views folder in webapp/WEB-INF
5.create reuired .jsp file in views folder
6.create config folder
7.add required classes
ApplicationConfig: // hibernate.cf.xml
=> create object     
     DataSource
     LocalSessionFactory
     HibernateTransactionManager

create sperate methods.

WebIntitializerConfig: // web.xml

WebMVCConfig:// dispatcher-servlet.xml


8.create dao folder 
create interface and impl class for Employee
9.create controller and add reuired methods

