package entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
@Table(name="CourseModule")
public class Course4 {
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  	
	private int id;
	
	@Column(name="courseName")
	private String courseName;
	
	@ManyToOne
	@JoinColumn(name = "student_id")	
	private Student4 student;
	
	public Course4()
	{}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student4 getStudent() {
		return student;
	}

	public void setStudent(Student4 student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "Course4 [id=" + id + ", courseName=" + courseName + ", student=" + student + "]";
	}
	

}
