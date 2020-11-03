package com.furkanyilmaz;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CALİSANLAR" ) // Veritabanı Tablo Adı
public class Personel {

	@Id
	@GeneratedValue //Id alanına otomatik değerler verilir.autoincrement
	private int personelId;
	private String personelAdi;
	private String personelSoyadi;
	
	@Temporal(TemporalType.DATE)
	private Date personelKayitTarihi;
	
	@Lob
	private String personelAdresi;

	public Personel() {
	}
	
	
	public Personel(String personelAdi, String personelSoyadi, Date personelKayitTarihi,
			String personelAdresi) {
		this.personelAdi = personelAdi;
		this.personelSoyadi = personelSoyadi;
		this.personelKayitTarihi = personelKayitTarihi;
		this.personelAdresi = personelAdresi;
	}

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
