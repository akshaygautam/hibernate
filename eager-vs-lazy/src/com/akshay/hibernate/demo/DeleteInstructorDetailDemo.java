package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			System.out.println("Begin transaction");
			session.beginTransaction();
			
			
			int id = 6455;
			InstructorDetail tempDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("tempDetail:\t"+tempDetail);
			
			System.out.println("Associated Instructor:\t"+tempDetail.getInstructor());
			
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//To handle leak issue
			session.close();
			factory.close();
		}

	}

}
