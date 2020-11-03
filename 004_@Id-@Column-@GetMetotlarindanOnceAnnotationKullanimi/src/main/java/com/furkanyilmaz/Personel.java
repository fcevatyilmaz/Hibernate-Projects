package com.furkanyilmaz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PERSONEL_TABLOSU") // Veritabanı Tablo Adı
public class Personel {

	private int personelId;
	private String personelAdi;
	private String personelSoyadi;

	@Id
	@Column(name = "ID") // Tablodaki Kolon adı
	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	@Column(name = "ADI")
	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	@Column(name = "SOYADI")
	public String getPersonelSoyadi() {
		return personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}

}
