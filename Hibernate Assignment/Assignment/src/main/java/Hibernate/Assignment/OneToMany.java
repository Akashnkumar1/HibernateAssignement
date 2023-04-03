package Hibernate.Assignment;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.HibernateConfig;
import entity.Course4;
import entity.Student2;
import entity.Student4;

public class OneToMany {
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Student4 student1 = new Student4();
		Course4 course1 = new Course4();    
		
		Student4 student2 = new Student4();
		Course4 course2 = new Course4();
		
		Student4 student3 = new Student4();
		Course4 course3 = new Course4();
		
		Course4 course4 = new Course4();
		Course4 course5 = new Course4();
		
		student1.setName("MIKE");
		student2.setName("JOHN");
		student3.setName("PETER");
		
		course1.setCourseName("CORE JAVA");
		course2.setCourseName("DSA");
		course3.setCourseName("FULL STACK DEVOPS");
		course4.setCourseName("JAVA FRONTEND");
		course5.setCourseName("JAVA BACKEND");
		
		List<Course4> studentList1 = new ArrayList<Course4>();
		List<Course4> studentList2 = new ArrayList<Course4>();
		List<Course4> studentList3 = new ArrayList<Course4>();
		
		studentList1.add(course1);
		studentList1.add(course2);
		studentList1.add(course3);
		
		studentList2.add(course2);
		studentList2.add(course3);
		studentList2.add(course4);
		
		
		studentList3.add(course1);
		studentList3.add(course5);
		
		student1.setCourses(studentList1);
		student2.setCourses(studentList2);
		student3.setCourses(studentList3);
		
//		insertStudent4(student1); 
  //	insertStudent4(student2); 
   	insertStudent4(student3); 
 		
//		
	//	deleteStudent4(7);
//		
 //	deleteCourse4(2);
////		deleteCourse4(9);
	

	}
	
	public static void insertStudent4(Student4 student)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		  
		session.persist(student);
		
		tx.commit();
		session.close();		
	}
	
	public static void deleteCourse4(int id)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course4 course = session.get(Course4.class, id);
		
		System.out.println(course);
		  
		session.remove(course);
		
		tx.commit();
		session.close();		
	}
	
	
	public static void deleteStudent4(int id)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student4 student = session.get(Student4.class, id);
		
		System.out.println("--------"+student.getCourses()+"--------");
		
		session.remove(student);
		tx.commit();
		session.close();		
	}

}
