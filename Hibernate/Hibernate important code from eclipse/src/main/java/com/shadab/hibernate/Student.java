package com.shadab.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String Name;
	private String city;
	private String phonenumber;
	private Certificate certi;
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", city=" + city + ", phonenumber=" + phonenumber + "]";
	}
	public int getId() {
		return id;
	}
	public void setCertificate(Certificate c) {
		this.certi=c;
		
	}
	public Certificate getCertificate() {
		return certi;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.Name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
