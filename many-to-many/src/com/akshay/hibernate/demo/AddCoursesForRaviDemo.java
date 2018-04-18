package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Course;
import com.akshay.hibernate.entity.Instructor;
import com.akshay.hibernate.entity.InstructorDetail;
import com.akshay.hibernate.entity.Student;

public class AddCoursesForRaviDemo {

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
			
			//get instuctor
			
			Course tempCourse1 = new Course("Arkham city");
			session.save(tempCourse1);
			System.out.println("Courses Saved.");
			
			Student temp1 = new Student("Wah","bro","wah.bro@whabro.com");
			Student temp2 = new Student("Ravi","daas","ravidas@kalidas.com");
			
			tempCourse1.addStudent(temp1);
			tempCourse1.addStudent(temp2);
			
			System.out.println("Sving student.");
			session.save(temp1);
			session.save(temp2);
			
			System.out.println("Added Students:\t"+tempCourse1.getStudent());
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
