package com.furkanyilmaz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UNIVERSITY_ID")
	private int universityId;

	@Column(name = "NAME", unique = true, length = 30)
	private String name;

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public University() {
		// TODO Auto-generated constructor stub
	}

	public University(String name) {
		this.name = name;
	}

	// Set ve get metotlarını tanımlayın. Ben cok yer kaplamasın diye sildim.
}
