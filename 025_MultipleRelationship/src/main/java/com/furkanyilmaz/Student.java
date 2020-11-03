package com.furkanyilmaz;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;

	@Column(name = "NAME", unique = false)
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@OneToOne()
	@JoinColumn(name = "FK_ADDRESS_ID")
	private Address address;

	@ManyToOne()
	@JoinColumn(name = "FK_UNIVERSITY_ID")
	private University university;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String surname, Address address, University university) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.university = university;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address address) {
		this.address = address;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}