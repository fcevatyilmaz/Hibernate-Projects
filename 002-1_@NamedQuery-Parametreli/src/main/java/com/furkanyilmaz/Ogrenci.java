package com.furkanyilmaz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "secilenOgrenciKaydiniGetirSetParameter", 
				query = "FROM Ogrenci o WHERE o.id = :p_id"),

		@NamedQuery(name = "secilenOgrenciKaydiniGetirStatik", 
				query = "FROM Ogrenci o WHERE o.id = 3"),
		
		@NamedQuery(name = "Ogrenci.AdiSoyadiSorgula", 
		query = "FROM Ogrenci o WHERE o.adi = :p_adi AND o.soyadi = :p_soyadi")

})

public class Ogrenci implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@Column(name = "Adi")
	private String adi;
	
	@Column(name = "Soyadi")
	private String soyadi;

	@Column(name = "Bolum")
	private String bolum;

	@Column(name = "Fakulte")
	private String fakulte;


	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public String getFakulte() {
		return fakulte;
	}

	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

}
