package com.furkanyilmaz;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Personel") // Veritabanı Tablo Adı
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Id alanına otomatik değerler verilir.autoincrement
	private int personelId;
	@Column(name = "Adı")
	private String personelAdi;
	private String personelSoyadi;
	private Date personelKayitTarihi;

	@Embedded // Bu alana başka bir sınıftaki bilgiler gelicek.
	private Adres adres;

	
	
	// -----------------------

	public Personel() {

	}

	public Personel(String personelAdi, String personelSoyadi, Date personelKayitTarihi) {
		this.personelAdi = personelAdi;
		this.personelSoyadi = personelSoyadi;
		this.personelKayitTarihi = personelKayitTarihi;
	}

	
	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	// -----------------------

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

	public Date getPersonelKayitTarihi() {
		return personelKayitTarihi;
	}

	public void setPersonelKayitTarihi(Date personelKayitTarihi) {
		this.personelKayitTarihi = personelKayitTarihi;
	}

}
