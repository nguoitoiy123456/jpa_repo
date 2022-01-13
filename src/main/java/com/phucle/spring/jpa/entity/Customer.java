package com.phucle.spring.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	 @Size(min = 1,message = "This box cannot be left empty") 
	private String firstName;

	@Column(name = "last_name")
	 @Size(min = 1,message = "This box cannot be left empty") 
	private String lastName;

	@Column(name = "email")
	@Size(min = 1,message = "This box cannot be left empty")
	private String email;

	@ManyToOne
	@JoinColumn(name = "province_id")
	/*
	 * @NotNull(message = "This box cannot be left empty"
	 * 
	 * @Size(min = 1,message = "This box cannot be left empty")
	 */
	private Province province;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "customers_hobbies", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "hobby_id"))
	/*
	 * @NotNull(message = "This box cannot be left empty")
	 * 
	 * @Size(min = 1,message = "This box cannot be left empty")
	 */
	private List<Hobby> hobbies = new ArrayList();

	public Customer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	/**
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * @return the hobbies
	 */
	public List<Hobby> getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public Customer(int id, String firstName, String lastName, String email, Province province, List<Hobby> hobbies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.province = province;
		this.hobbies = hobbies;
	}

	public Customer(String firstName, String lastName, String email, Province province, List<Hobby> hobbies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.province = province;
		this.hobbies = hobbies;
	}

}
