package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Course;
import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;
import com.akshay.hibernate.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure()
					 				.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();	
		//create session
		 Session session = factory.getCurrentSession();
		try {
			
			System.out.println("Begin transaction");
			session.beginTransaction();
			int id = 9;
			Course tempC = session.get(Course.class, id);
			System.out.println("Deleting Course\t"+tempC);
			session.delete(tempC);
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
