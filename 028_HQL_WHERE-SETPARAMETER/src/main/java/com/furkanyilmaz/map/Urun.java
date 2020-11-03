package com.furkanyilmaz.map;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URUN")
public class Urun implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "URUNID")
	private int urunId;
	@Column(name = "URUNAD")
	private String urunAd;
	@Column(name = "URUNFIYAT")
	private double urunFiyati;

	public int getUrunId() {
		return urunId;
	}

	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}

	public String getUrunAd() {
		return urunAd;
	}

	public void setUrunAd(String urunAd) {
		this.urunAd = urunAd;
	}

	public double getUrunFiyati() {
		return urunFiyati;
	}

	public void setUrunFiyati(double urunFiyati) {
		this.urunFiyati = urunFiyati;
	}

}
