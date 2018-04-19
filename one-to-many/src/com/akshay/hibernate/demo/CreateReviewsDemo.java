package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Course;
import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;
import com.akshay.hibernate.entity.Review;

public class CreateReviewsDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();	
		//create session
		 Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Begin transaction");
			session.beginTransaction();

			Course tempCourse = new Course("Treasure hunt");
			Review r1 = new Review("Best course");
			Review r2 = new Review("wow amazing course");
			Review r3 = new Review("Fan of this guy");
			Review r4 = new Review("at the best");
			tempCourse.addReview(r1);
			tempCourse.addReview(r2);
			tempCourse.addReview(r3);
			tempCourse.addReview(r4);
			session.save(tempCourse);
			
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
