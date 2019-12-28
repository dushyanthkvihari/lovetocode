package com.vihari.learn.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;

public class Hibernate {
    public static void main( String vv[])
    {
        try {
            Student stu = new Student();
            stu.setName("Dushyanth");
            stu.setId("7");
            stu.setGroup("cse");
            Configuration cfg = new Configuration();

            SessionFactory hSF = cfg.buildSessionFactory();
            Session hS = hSF.openSession();
            hS.save(stu);
        }
        catch(HibernateException he)
        {

        }
    }
}
