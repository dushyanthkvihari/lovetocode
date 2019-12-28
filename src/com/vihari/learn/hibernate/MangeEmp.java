package com.vihari.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MangeEmp {
    public static void main(String vv[])
    {
        Employee e1 = new Employee();
        Account e1Acc = new Account();
        e1Acc.setAccount_id(1234);
        e1.setAccount(e1Acc);
        e1.setSalary(200000);
        e1.setFirstName("abce");
        e1.setLastName("def");
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        tx.begin();
        s.save(e1);
        tx.commit();
    }
}
