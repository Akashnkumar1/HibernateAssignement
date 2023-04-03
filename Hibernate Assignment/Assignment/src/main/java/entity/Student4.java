package entity;
import java.util.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
@Table(name="StudentModule")
public class Student4 {
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	private String name;
	
	  
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "student_id")
	List<Course4> courses;
	
	public Student4()
	{}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course4> getCourses() {
		return courses;
	}

	public void setCourses(List<Course4> courses) {
		this.courses = courses;
	}
	

}
