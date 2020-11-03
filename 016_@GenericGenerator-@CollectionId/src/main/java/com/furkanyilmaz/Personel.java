package com.furkanyilmaz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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

	@Embedded // Bu alana başka bir sınıftaki bilgiler gelicek.
	@ElementCollection // Child detay tablolarını oluşturmaya yarar
	@JoinTable(name = "adreslistesitablosu" ,  //Kalıtım tablosu
	joinColumns = @JoinColumn(name = "PERSONEL_ID")
	//Child alt detay tablodaki id kolonunun adını değiştirir - Kalıtım sütunu

	)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(
			columns = { @Column(name = "ADRES_ID") },
			generator = "hilo-gen",
			type = @Type(type = "long"))
	private Collection<Adres> adresListesi = new ArrayList<Adres>();
	
	public Collection<Adres> getAdresListesi() {
		return adresListesi;
	}

	public void setAdresListesi(Collection<Adres> adresListesi) {
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
