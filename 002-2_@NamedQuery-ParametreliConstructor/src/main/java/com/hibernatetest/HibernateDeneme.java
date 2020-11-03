package com.hibernatetest;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Ogrenci;

public class HibernateDeneme {

	public static void main(String[] args) {

		Ogrenci ogrenci = new Ogrenci();
		// ogrenci.setId(id);
		ogrenci.setNo("1299571");
		ogrenci.setAdi("Taha");
		ogrenci.setSoyadi("Yilmaz");
		ogrenci.setBolum("Endüstri");
		ogrenci.setFakulte("Mühendislik");

		// ----------------------------------

		Ogrenci ogrenci2 = new Ogrenci("Umar", "Beden Eğitimi", "SBF", "1234", "Aminu");

		Ogrenci ogrenci3 = new Ogrenci("Matias", "Besyo", "SBF", "5478", "Delgado");

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			kayitEkle(session, "Alex", "Diş Hekimliği", "Diş Hekimliği", "4785", "De Souza");
			session.save(ogrenci2);
			session.save(ogrenci3);
			kayitEkle(session, "Mehmet Akif", "Türk Dili", "Edebiyat", "64353", "Ersoy");

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			kayitlariYazHepsi(session);
			kayitlariYazSecilen(session, 2);
		}

	}

	private static void kayitlariYazSecilen(Session session, int i) {
		Query query = session.getNamedQuery("secilenOgrenciKaydiniGetirSetParameter").setParameter("p_id", i);
		List<Ogrenci> ogrenciList = query.list();

		for (Ogrenci ogr : ogrenciList) {
			System.out.println("\nID=" + ogr.getId() + ", \nADI=" + ogr.getAdi() + ", \nBÖLÜM=" + ogr.getBolum()
					+ ", \nFAKÜLTE=" + ogr.getFakulte() + ", \nNO=" + ogr.getNo() + ", \nSOYADI=" + ogr.getSoyadi());
		}

	}

	private static void kayitlariYazHepsi(Session session) {
		Query query = session.getNamedQuery("tumOgrenciKayitlariniGetir");

		List<Ogrenci> ogrenciList = query.list();

		for (Ogrenci ogr : ogrenciList) {
			System.out.println("\nID=" + ogr.getId() + ", \nADI=" + ogr.getAdi() + ", \nBÖLÜM=" + ogr.getBolum()
					+ ", \nFAKÜLTE=" + ogr.getFakulte() + ", \nNO=" + ogr.getNo() + ", \nSOYADI=" + ogr.getSoyadi());
		}

	}

	private static void kayitEkle(Session session, String adi, String bolum, String fakulte, String no, String soyadi) {
		Ogrenci ogrenciNesnesi = new Ogrenci(adi, bolum, fakulte, no, soyadi);
		session.save(ogrenciNesnesi);

	}

}