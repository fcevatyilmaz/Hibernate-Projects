package com.furkanyilmaz;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "CALİSANLAR" ) // Veritabanı Tablo Adı
public class Personel {

	@Id
	private int personelId;

	private String personelAdi;

	private String personelSoyadi;
	
	@Temporal(TemporalType.TIME)
	private Date personelKayitTarihi;
	
	@Lob
	private String personelAdresi;

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
