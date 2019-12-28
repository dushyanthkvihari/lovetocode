package com.vihari.learn.hibernate;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
//@GenericGenerator(name = "idgen", strategy = "assigned")
public class Employee {

//    private int id;
    @Id
    //@GeneratedValue(generator = "idgen")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int salary;

    public Employee() {}
    public Employee(String fname, String lname, int salary, Account account) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
        this.account=account;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    //    public int getId() {
//        return id;
//    }
//
//    public void setId( int id ) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary( int salary ) {
        this.salary = salary;
    }
}
