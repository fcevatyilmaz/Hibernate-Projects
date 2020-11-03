package com.furkanyilmaz;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "Personel") // Veritabanı Tablo Adı
@SecondaryTable(name = "PersonelDetay") // İkinci Tablo
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Id alanına otomatik değerler verilir.autoincrement
	private int personelId;
	private String personelAdi;
	private String personelSoyadi;

	@Column(table = "PersonelDetay")
	private Date personelKayitTarihi;

	@Column(name = "Adres", table = "PersonelDetay")
	private String personelAdresi;

	@Column(name = "Maas", table = "PersonelDetay")
	private String personelMaasi;

	public Personel(String personelAdi, String personelSoyadi, Date personelKayitTarihi, String personelAdresi,
			String personelMaasi, String personelTelefonu) {
		this.personelAdi = personelAdi;
		this.personelSoyadi = personelSoyadi;
		this.personelKayitTarihi = personelKayitTarihi;
		this.personelAdresi = personelAdresi;
		this.personelMaasi = personelMaasi;
		this.personelTelefonu = personelTelefonu;
	}

	public Personel() {
		// TODO Auto-generated constructor stub
	}

	public String getPersonelMaasi() {
		return personelMaasi;
	}

	public void setPersonelMaasi(String personelMaasi) {
		this.personelMaasi = personelMaasi;
	}

	public String getPersonelTelefonu() {
		return personelTelefonu;
	}

	public void setPersonelTelefonu(String personelTelefonu) {
		this.personelTelefonu = personelTelefonu;
	}

	@Column(table = "PersonelDetay")
	private String personelTelefonu;

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

	public String getPersonelAdresi() {
		return personelAdresi;
	}

	public void setPersonelAdresi(String personelAdresi) {
		this.personelAdresi = personelAdresi;
	}

}
