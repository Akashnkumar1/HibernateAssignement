package entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column(name="projectName")
	private String pname;
	
	@ManyToMany(mappedBy="projects", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	List<Employee> employees;
	
	public Project()
	{}
	
	

	public Project(int pid, String pname, List<Employee> employees) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.employees = employees;
	}



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + "]";
	}


 



	 
	
	

}
