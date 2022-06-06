package com.Jolt.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Jolt.hibernate.demo.entity.Student;

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
			System.out.println("Creating a new student object");
			
			// create a student object
			Student student = new Student("Jack", "Reacher", "jreacher90@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(student);
			
			// commit the transaction
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			System.out.println("Exception raised saving new student");
			ex.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
