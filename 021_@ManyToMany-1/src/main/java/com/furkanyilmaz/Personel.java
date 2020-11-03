package com.furkanyilmaz;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personel") // Veritabanı Tablo Adı
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Id alanına otomatik değerler verilir.autoincrement
	private int personelId;
	private String personelAdi;
	private String personelSoyadi;

	// -----------------------

	@ManyToMany // n-n bağlantı - many to many //Bir personelin birden fazla mesleği olabilir.
	// @JoinColumn(name = "FK_PERSONEL_ID")

	private Collection<Meslek> meslekList = new ArrayList<Meslek>();

	// -----------------------

	public Collection<Meslek> getMeslekList() {
		return meslekList;
	}

	public void setMeslekList(Collection<Meslek> meslekList) {
		this.meslekList = meslekList;
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

}
