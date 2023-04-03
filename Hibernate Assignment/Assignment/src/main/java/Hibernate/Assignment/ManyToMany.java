package Hibernate.Assignment;

import entity.Course4;
import entity.Employee;
import entity.Project;
import entity.Student4;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.HibernateConfig;

public class ManyToMany {
	private static SessionFactory factory = HibernateConfig.getSessionFactory();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		
		Project pro1 = new Project();
		Project pro2 = new Project();
		Project pro3 = new Project();
		
		emp1.setEname("JOHN");
		emp2.setEname("MIKE");
		emp3.setEname("RYAN");
		
		pro1.setPname("JAVA project");
		pro2.setPname("PYTHON project");
		pro3.setPname("SPRING BOOT project");
		
		List<Employee> emps1 = new ArrayList<Employee>();
		List<Project> pros1 = new ArrayList<Project>();
		
		List<Employee> emps2 = new ArrayList<Employee>();
		List<Project> pros2 = new ArrayList<Project>();
		
		emps1.add(emp1);
		emps1.add(emp3);
		
		emps2.add(emp2);
		emps2.add(emp3);
		
		pros1.add(pro2);
		pros1.add(pro3);
		
		pros2.add(pro1);
		pros2.add(pro3);
		
		emp1.setProjects(pros1);
		emp2.setProjects(pros2);
		
				
		
		//insertEmployee(emp2);
		
		System.out.println("-----"+getProject(6)+"-----");
		
		System.out.println("-----"+getEmployee(4)+"-----");

	}
	
	public static void insertEmployee(Employee emp)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
			  
		session.persist(emp);
		
		tx.commit();
		session.close();		
	}
	
	public static List<Employee> getEmployee(int id)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Project project = (Project)session.get(Project.class, id);
						
		tx.commit();
		session.close();
		
		return project.getEmployees();
	}
	
	public static List<Project> getProject(int id)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee)session.get(Employee.class, id);
		 
		tx.commit();
		session.close();
		
		return employee.getProjects();
	}

}
