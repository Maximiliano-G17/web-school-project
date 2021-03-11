package com.web.school.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Pattern(regexp = "[0-9]{8}", message = "The length of the D.N.I can be only 7")
	private String dni;
	@Column
	@Pattern(regexp = "[a-zA-Z\s]{2,20}", message = "The length of the name can be from 2 to 20")
	private String name;	
	@Column	
	@Pattern(regexp = "[a-zA-Z]{2,20}", message = "The length of the surname can be from 2 to 20")
	private String surname;
	@Column
	@Pattern(regexp = "[0-9]{5,20}", message = "The phone cannot be empty")
	private String phone;
	@Column
	@Pattern(regexp = "[A-Za-z0-9\s]{2,50}", message = "The address cannot be empty")
	private String address;
	@Column
	private String rol;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + surname + ", phone=" + phone
				+ ", address=" + address + ", rol=" + rol + "]";
	}
}