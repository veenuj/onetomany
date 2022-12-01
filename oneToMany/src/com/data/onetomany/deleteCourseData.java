package com.data.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onetoMany.Course;
import com.onetoMany.instructorDetail;
import com.onetoMany.profileInstructor;

public class deleteCourseData {
	
	
public static void main(String[] args) {
		
		
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(instructorDetail.class)
									.addAnnotatedClass(profileInstructor.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
	
		// create session
		Session session = factory.getCurrentSession();
		try {
			
			// create objects
			

			
		
			
			
	
			session.beginTransaction();
			
			int id=10;
			Course course = session.get(Course.class, id);
			
			System.out.println("deleting course");
			session.delete(course);

			
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} finally {
			
			session.close();
			factory.close();
		}
				

	}
	
	
	
	
	

}
