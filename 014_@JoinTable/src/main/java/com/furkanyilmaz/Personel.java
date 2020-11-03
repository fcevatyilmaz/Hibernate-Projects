package com.furkanyilmaz;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "personeltablosu") // Veritabanı Tablo Adı
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Id alanına otomatik değerler verilir.autoincrement
	private int personelId;
	private String personelAdi;
	private String personelSoyadi;
	private Date personelKayitTarihi;
	// private String personelAdresi;

	// -----------------------

	@ElementCollection // Child detay tablolarını oluşturmaya yarar
	@JoinTable(name = "personeladrestablosu")
	private Set<Adres> adresListesi = new HashSet<Adres>();
	
	public Set<Adres> getAdresListesi() {
		return adresListesi;
	}

	public void setAdresListesi(Set<Adres> adresListesi) {
		this.adresListesi = adresListesi;
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

	/*
	 * public String getPersonelAdresi() { return personelAdresi; }
	 * 
	 * public void setPersonelAdresi(String personelAdresi) { this.personelAdresi =
	 * personelAdresi; }
	 */

}
