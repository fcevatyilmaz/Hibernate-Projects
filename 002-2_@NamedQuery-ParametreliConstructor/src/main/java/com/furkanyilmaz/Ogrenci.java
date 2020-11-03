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
				query = "SELECT o FROM Ogrenci o WHERE o.id = :p_id"),

		@NamedQuery(name = "secilenOgrenciKaydiniGetirStatik", 
				query = "SELECT o FROM Ogrenci o WHERE o.id = 3"),
		
		@NamedQuery(name = "Ogrenci.AdiSoyadiSorgula", 
		query = "SELECT o FROM Ogrenci o WHERE o.adi = :p_adi AND o.soyadi = :p_soyadi"),
		
		@NamedQuery(name = "tumOgrenciKayitlariniGetir", 
		query = "SELECT o FROM Ogrenci o")

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

	@Column(name = "Bolum")
	private String bolum;

	@Column(name = "Fakulte")
	private String fakulte;

	@Column(name = "No")
	private String no;

	@Column(name = "Soyadi")
	private String soyadi;

	public Ogrenci() {
		
	}
	
	public Ogrenci(String adi, String bolum, String fakulte, String no, String soyadi) {

		this.adi = adi;
		this.bolum = bolum;
		this.fakulte = fakulte;
		this.no = no;
		this.soyadi = soyadi;
	}




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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

}
