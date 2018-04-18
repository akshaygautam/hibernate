package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;
import com.akshay.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();	
		//create session
		 Session session = factory.getCurrentSession();
		try {
			Instructor instructor = new Instructor("Akshay", "Gautam", "javaBro.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("askd", "asld,fa");
			
			instructor.setInstructorDetail(instructorDetail);
			
			System.out.println("Begin transaction");
			session.beginTransaction();
			
			System.out.println("Saving Instructor");
			session.save(instructor);
			
			

			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
