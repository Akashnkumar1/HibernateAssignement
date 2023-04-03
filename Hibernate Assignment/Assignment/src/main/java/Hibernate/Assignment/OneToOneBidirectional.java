package Hibernate.Assignment;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.HibernateConfig;
import entity.Address;
import entity.Address2;
import entity.Student2;

public class OneToOneBidirectional {
	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Address2 address1 = new Address2();
		Address2 address2 = new Address2();
		Address2 address3 = new Address2();
		
		Student2 student1 = new Student2();		
		Student2 student2 = new Student2();		
		Student2 student3 = new Student2();
		
		
		student1.setName("PETER");
		student2.setName("ROBIN");
		student3.setName("JANE");
		
		address1.setAddress("Riverhood Street");
		address2.setAddress("TownHall Street");
		address3.setAddress("Bridge Street");
		
		
		student1.setAddress(address1);
		student2.setAddress(address2);
		student3.setAddress(address3);
		
//		address1.setStudent(student1);
//		address2.setStudent(student2);
//		address3.setStudent(student3);
//		
//		insertAddress2(address1);
//		insertAddress2(address2);
//		insertAddress2(address3);
		
//		insertStudent2(student1);
//		insertStudent2(student2);
//		insertStudent2(student3);
//		
//		deleteAddress2(11);
//		deleteAddress2(13);
//		deleteAddress2(3);
		
//		deleteStudent2(7);
//		deleteStudent2(3);
//		deleteStudent2(4);

	}
	
	public static void insertStudent2(Student2 student)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		  
		session.persist(student);
		
		tx.commit();
		session.close();		
	}
	
	public static void insertAddress2(Address2 address)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(address);
		
		
		tx.commit();
		session.close();		
	}
	
	public static void deleteStudent2(int id)
	{
		// Create a session
		// DML commit => transaction
		
		
		 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student2 student= session.get(Student2.class, id);
		
		session.remove(student);
		tx.commit();
		session.close();	
	}
	
	
	public static void deleteAddress2(int id)
	{
		// Create a session
		// DML commit => transaction
		
		
		 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Address2 address = session.get(Address2.class, id);
		
		session.remove(address);
		tx.commit();
		session.close();	
	}

}
