package com.furkanyilmaz;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meslek") // Veritabanı Tablo Adı
public class Meslek {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int meslekId;
	private String meslekAdi;
	// --------------------
	@ManyToMany(mappedBy = "meslekList" ) // n-n - many to many
	private Collection<Personel> personelList = new ArrayList<Personel>();

	// -----------------------

	

	// --------------------

	public Collection<Personel> getPersonelList() {
		return personelList;
	}

	public void setPersonelList(Collection<Personel> personelList) {
		this.personelList = personelList;
	}

	public int getMeslekId() {
		return meslekId;
	}

	public void setMeslekId(int meslekId) {
		this.meslekId = meslekId;
	}

	public String getMeslekAdi() {
		return meslekAdi;
	}

	public void setMeslekAdi(String meslekAdi) {
		this.meslekAdi = meslekAdi;
	}

}
