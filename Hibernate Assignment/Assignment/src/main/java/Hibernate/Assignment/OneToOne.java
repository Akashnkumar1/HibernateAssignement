package Hibernate.Assignment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.HibernateConfig;
import entity.Student;
import entity.Address;

public class OneToOne {
	
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		
		Student student1 = new Student();
		Address address1 = new Address();
		Student student2 = new Student();
		Address address2 = new Address();
		Student student3 = new Student();
		Address address3 = new Address();
		
		student1.setName("JOHN");
		student2.setName("MIKE");
		address1.setAddress("WALL Street");
		address2.setAddress("Southall united");
		student3.setName("BEN");
		address3.setAddress("SpringDale Street");
		
		
		student1.setAddress(address1);
		student2.setAddress(address2);
		student3.setAddress(address3);
		
//		insertStudent(student1);
//		insertStudent(student2);
//		insertStudent(student3);
		
//		deleteStudent(13);
//		deleteStudent(14);
//		deleteStudent(15);
		
		deleteAddress(14);
	}
	
	public static void insertStudent(Student student)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(student);
		tx.commit();
		session.close();
		
	}
	
	public static void deleteStudent(int id)
	{
		// Create a session
		// DML commit => transaction
		
		 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student student1 = session.get(Student.class, id);
		
		session.remove(student1);
		tx.commit();
		session.close();	
	}
	
	public static void deleteAddress(int id)
	{
		// Create a session
		// DML commit => transaction
		
		
		 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Address address1 = session.get(Address.class, id);
		
		session.remove(address1);
		tx.commit();
		session.close();	
	}
	
	 

}
