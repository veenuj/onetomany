package com.data.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onetoMany.Course;
import com.onetoMany.instructorDetail;
import com.onetoMany.profileInstructor;



public class createCourseData {

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
		
				

			
		
			
			
	
			session.beginTransaction();
			
			int id=1;
			instructorDetail instructor = session.get(instructorDetail.class, id);
			
			// create some course
			Course tempCourse1 = new Course("HTML");
			Course tempCourse2 = new Course("Mathematics");
			Course tempCourse3 = new Course("Science");

			instructor.add(tempCourse1);

			instructor.add(tempCourse2);
			

			instructor.add(tempCourse3);
			
			session.save(tempCourse1);
			
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			session.getTransaction().commit();
			
			System.out.println("DONE !!!!!");
			
			
		} finally {
			
			session.close();
			factory.close();
		}
				

	}
	
	
	
	
	
}
