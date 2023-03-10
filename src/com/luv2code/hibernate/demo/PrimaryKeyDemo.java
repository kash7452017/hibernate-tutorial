package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try 
				{
					String theDateOfBirthStr = "31/12/1998";
					 
		            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
		            
					// create 3 student objects
					System.out.println("Creating 3 student objects...");
					Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com", theDateOfBirth);
					Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com", theDateOfBirth);
					Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@luv2code.com", theDateOfBirth);
					
					// start a transaction 
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the students...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				} catch (Exception exc) {
		            exc.printStackTrace();
		        } finally {
		            factory.close();
		        }
	}

}
