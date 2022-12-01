package com.data.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.onetoMany.Course;
import com.onetoMany.instructorDetail;
import com.onetoMany.profileInstructor;

public class createInstructorDetails {

	
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
			

			
			instructorDetail tempInstructor = 
					new instructorDetail("Rahul","Dravid","rahul@gmail.com");
			
			profileInstructor tempInstructorDetail = 
						new profileInstructor("http://www.rahul.com/youtube", "Volleyball");
			
			
			// associate objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			
			
	
			session.beginTransaction();
			

			System.out.println("saving instructor::::"+tempInstructor);
			session.save(tempInstructor);

			
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} finally {
			
			session.close();
			factory.close();
		}
				

	}
	
}
