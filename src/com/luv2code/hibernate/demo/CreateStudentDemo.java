package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
            // create a student object
            System.out.println("creating a new student object ...");
 
            String theDateOfBirthStr = "30/12/1998";
 
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
 
            Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);
 
            // start transaction
            session.beginTransaction();
 
            // save the student object
            System.out.println("Saving the student ...");
            session.save(tempStudent);
 
            // commit transaction
            session.getTransaction().commit();
 
            System.out.println("Success!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
	}

}
