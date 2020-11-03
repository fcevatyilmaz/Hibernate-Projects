package com.furkanyilmaz.map;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIPARIS")
public class Siparis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SIPARISID")
	private int siparisId;
	@Column(name = "SIPARISURUNID")
	private int siparisUrunId;
	@Column(name = "SIPARISURUNADI")
	private String siparisUrunAdi;
	@Column(name = "SIPARISURUNFIYATI")
	private double siparisUrunFiyati;

	// -------------------------------------
	public int getSiparisId() {
		return siparisId;
	}

	public void setSiparisId(int siparisId) {
		this.siparisId = siparisId;
	}

	public int getSiparisUrunId() {
		return siparisUrunId;
	}

	public void setSiparisUrunId(int siparisUrunId) {
		this.siparisUrunId = siparisUrunId;
	}

	public String getSiparisUrunAdi() {
		return siparisUrunAdi;
	}

	public void setSiparisUrunAdi(String siparisUrunAdi) {
		this.siparisUrunAdi = siparisUrunAdi;
	}

	public double getSiparisUrunFiyati() {
		return siparisUrunFiyati;
	}

	public void setSiparisUrunFiyati(double siparisUrunFiyati) {
		this.siparisUrunFiyati = siparisUrunFiyati;
	}

}
