package com.furkanyilmaz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private int addressId;
	
	@Column(name = "STREET", length = 40)
	private String street;

	@Column(name = "CITY")
	private String city;
	
	@Column(name = "COUNTRY")
	private String country;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String country) {
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public int getAdressId() {
		return addressId;
	}

	public void setAdressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}