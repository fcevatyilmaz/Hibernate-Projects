package com.furkanyilmaz;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
	private String personelAdi;
	private String personelSoyadi;
	private Date personelKayitTarihi;
	// private String personelAdresi;

	// -----------------------

	@Embedded // Bu alana başka bir sınıftaki bilgiler gelicek.
	@AttributeOverrides({ 
			@AttributeOverride(name = "sehir", column = @Column(name = "EV_ICIN_SEHIR_ADI")),
			@AttributeOverride(name = "cadde", column = @Column(name = "EV_ICIN_CADDE_ADI")),
			@AttributeOverride(name = "kapiNo", column = @Column(name = "EV_ICIN_KAPINO_ADI")),
			@AttributeOverride(name = "postaKodu", column = @Column(name = "EV_ICIN_POSTAKODU_ADI")),
			@AttributeOverride(name = "semt", column = @Column(name = "EV_ICIN_SEMT_ADI")) })
	private Adres evAdres;

	@Embedded // Bu alana başka bir sınıftaki bilgiler gelicek.
	private Adres isAdres;

	public Adres getEvAdres() {
		return evAdres;
	}

	public void setEvAdres(Adres evAdres) {
		this.evAdres = evAdres;
	}

	public Adres getIsAdres() {
		return isAdres;
	}

	public void setIsAdres(Adres isAdres) {
		this.isAdres = isAdres;
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
