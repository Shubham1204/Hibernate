package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session s = factory.openSession();
        Transaction tx =  s.beginTransaction();
//        Student s1 = new Student();
//        s1.setStudentName("Shyam");
//        
//        
//        Course c1 = new Course();
//        c1.setCourseName("html");
//        
//        Course c2 = new Course();
//        c2.setCourseName("css");
//        
//        
//        Course c4 = new Course();
//        c4.setCourseName("js");
//        
//        Course c5 = new Course();
//        c5.setCourseName("bootstrap");
//        
//        List<Course> courseList = new ArrayList<Course>();
//        courseList.add(c1);
//        courseList.add(c2);
//        courseList.add(c4);
//        courseList.add(c5);
//        
//        s1.setCourses(courseList);
//        s.save(c1);
//        s.save(c2);
//        s.save(c4);
//        s.save(c5);
//        s.save(s1);
        
//        Student s1 = (Student)s.get(Student.class, 1);
//        System.out.println(s1.getStudentName());
//        for(Course c1 : s1.getCourses()) {
//        	System.out.println(c1.getCourseName());
//        }
        
        Query<Student> q = s.createQuery("from Student");
        List<Student> list = q.list();
        System.out.println("-------------------");
        list.stream().forEach(e->System.out.println(e));
        System.out.println("-------------------");
        tx.commit();
        s.close();
        factory.close();
        
    }
}
