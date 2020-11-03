package com.furkanyilmaz.map;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONEL")
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSONELID")
	private long personelId;
	@Column(name = "PERSONELAD")
	private String personelAd;
	@Column(name = "PERSONELSOYAD")
	private String personelSoyad;
	
	
	public long getPersonelId() {
		return personelId;
	}
	public void setPersonelId(long personelId) {
		this.personelId = personelId;
	}
	public String getPersonelAd() {
		return personelAd;
	}
	public void setPersonelAd(String personelAd) {
		this.personelAd = personelAd;
	}
	public String getPersonelSoyad() {
		return personelSoyad;
	}
	public void setPersonelSoyad(String personelSoyad) {
		this.personelSoyad = personelSoyad;
	}

	
}
