package com.ibm.customer_management_system;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.model.Instructor;
import com.ibm.model.InstructorDetail;

public class App1 {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.openSession();

		try {

			// create the objects
			/*
			 * Instructor tempInstructor = new Instructor("Chad", "Darby",
			 * "darby@luv2code.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new InstructorDetail(
			 * "http://www.luv2code.com/youtube", "Luv 2 code!!!");
			 */

			Instructor tempInstructor = new Instructor("Soham", "Patra", "soham@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/soham", "Code");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}