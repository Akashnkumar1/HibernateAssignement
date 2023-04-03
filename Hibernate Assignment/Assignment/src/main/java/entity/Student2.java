package entity;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@Entity
@DynamicUpdate
@Table(name="NewStudent")
public class Student2 {
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	
	 
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address2 address;
	
	public Student2()
	{}	

	public Student2(int id, String name, Address2 address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address2 getAddress() {
		return address;
	}

	public void setAddress(Address2 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	 
	
	
	

}
