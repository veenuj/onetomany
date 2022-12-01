package com.data.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onetoMany.instructorDetail;
import com.onetoMany.profileInstructor;



public class deleteInstructor {
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
			
			int theId = 1;
			instructorDetail temInstructor =
					session.get(instructorDetail.class, theId);
			

			// delete it
			if(temInstructor != null) {
				System.out.println("delete instructor"+temInstructor);
		
				session.delete(temInstructor);
			}
			
			
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} finally {
			factory.close();
		}
				

	}
}
