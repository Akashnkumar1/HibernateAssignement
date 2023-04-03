package entity;
import jakarta.persistence.*;


@Entity
@Table(name="NewAddress")
public class Address2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	 
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="address")
	private Student2 student;
	
	
	public Address2()
	{}	

	public Address2(int id, String address, Student2 student) {
		super();
		this.id = id;
		this.address = address;
		this.student = student;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student2 getStudent() {
		return student;
	}

	public void setStudent(Student2 student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address2 [id=" + id + ", address=" + address + ", student=" + student + "]";
	}
	
	
	

}
