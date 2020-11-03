package com.furkanyilmaz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PERSONEL_TABLOSU")
public class Personel {
	
	@Id
	@Column(name = "ID")
	private int personelId;
	
	private String personelAdi;
	
	@Column(name = "SOYADI")
	private String personelSoyadi;
	

	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	
	public String getPersonelSoyadi() {
		return personelSoyadi;
	}
	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}
	

}
