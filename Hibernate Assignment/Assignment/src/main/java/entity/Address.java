package entity;

import jakarta.persistence.*;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "addressId")
	private int id;
	@Column(name = "addreess")
	private String address;
	
	

	public Address() {
	}

	public Address(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	 
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}

}
