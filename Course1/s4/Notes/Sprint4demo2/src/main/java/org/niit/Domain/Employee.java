package org.niit.Domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

    private int id;
    private String firstname;
    private String lastname;

    // Autowring with property
   // @Autowired
    private Address empAdd;

    public Employee() {
    }


    public Employee(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    //@Autowired
    public Employee(Address empAdd){
        this.empAdd=empAdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getEmpAdd() {
        return empAdd;
    }

    // Autowring with setter
  //  @Autowired
    public void setEmpAdd(Address empAdd) {
        this.empAdd = empAdd;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", empAdd=" + empAdd +
                '}';
    }
}
