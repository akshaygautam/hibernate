package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Course;
import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;
import com.akshay.hibernate.entity.Student;

public class CreateCoursesDemo {

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
			
			//get instuctor
			int id = 7;
			Instructor tempInst = session.get(Instructor.class, id);
			System.out.println(tempInst);
			System.out.println(tempInst.getCourses());
			//create courses
			Course tempCourse1 = new Course("Hibernate");
			Course tempCourse2 = new Course("Kick box");
			
			//add courses to inst
			tempInst.add(tempCourse1);
			tempInst.add(tempCourse2);
			//save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
