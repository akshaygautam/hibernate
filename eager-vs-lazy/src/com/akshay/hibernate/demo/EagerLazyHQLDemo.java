package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.akshay.hibernate.entity.Course;
import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;

public class EagerLazyHQLDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();	
		//create session
		 Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Begin transaction");
			session.beginTransaction();
			
			int id = 6;
			Query<Instructor> query = session.createQuery("select i from Instructor i"
					+"JOIN FETCH i.courses"
					+"where i.id=:theid"
					,Instructor.class );
			query.setParameter("theid", id);
			Instructor ins = query.getSingleResult();
			
			System.out.println("Instructor:\t"+ins);
			
			session.getTransaction().commit();
			
			session.close();
			System.out.println("Courses:\t"+ins.getCourses());
			
			
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
