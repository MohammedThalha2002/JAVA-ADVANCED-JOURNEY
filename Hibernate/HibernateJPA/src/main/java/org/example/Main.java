package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        insertValues(factory);
        getRecords(factory);
//        getOneRecord(factory, 1L);
    }

    public static void insertValues(SessionFactory factory){
        Student student = new Student();
        // Adding values to a table
        student.setName("Harish");
        student.setEmail("harish@gmail.com");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();

        //
        session.close();
    }

    public static void getRecords(SessionFactory factory){
        Session session = factory.openSession();
        List<Student> students = session
                .createQuery("SELECT students FROM students_details students", Student.class)
                .getResultList();
        System.out.println(students);
    }

    public static void getOneRecord(SessionFactory factory, Long id){
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);
        System.out.println(student);
        factory.close();
    }
}