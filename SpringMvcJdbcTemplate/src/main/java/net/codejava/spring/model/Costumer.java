package net.codejava.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@Entity
//@Table(name = "Costumer")
public class Costumer {

//	@Id
//	@GeneratedValue
//	@Column(name = "id")
	private int id;
	
	@NotNull
	@Size(min = 2, message = "Field can not be null" )
//	@Column(name = "name")
	private String name;
	
	@NotNull
//	@Column(name = "email",unique = true)
	@Pattern (regexp = "[A-Z0-9a-z]+[@][A-Za-z0-9]+[.][A-Za-z0-9]+", message = "Please enter a valid e-mail")
	private String email;
	
	@NotNull(message = "Field can not be null")
	@Size(min = 2, message = "Field can not be null" )
//	@Column(name = "address")
	private String address;
	
	@Size(min = 9, max = 12, message = "Please enter a valid phone number")
//	@Column(name = "telephone", unique = true)
	private String telephone;

	public Costumer() {
	}

	public Costumer(String name, String email, String address, String telephone) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
