package com.data.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onetoMany.instructorDetail;
import com.onetoMany.profileInstructor;



public class CreateInstructorProfile {
public static void main(String[] args) {
		
		
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(instructorDetail.class)
									.addAnnotatedClass(profileInstructor.class)
									.buildSessionFactory();
		
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
	
			
	
			session.beginTransaction();
			
			int theId=3;
			
			profileInstructor instructorDetail = session.get(profileInstructor.class, theId);
			
			System.out.println("instructor detail obj "+instructorDetail);
			
			System.out.println("associated instrcutor "+ instructorDetail.getInstructor());
			
			
			
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
			session.close();
			factory.close();
		}
				

	}

	
	
}
