package com.hibernatetest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Ogrenci;



public class HibernateDeneme {

	public static void main(String[] args) {

		Ogrenci ogrenci = new Ogrenci();
		//ogrenci.setId(id);
		ogrenci.setAdi("Ahmet");
		ogrenci.setSoyadi("Alışık");
		ogrenci.setBolum("Türk Dili");
		ogrenci.setFakulte("Edebiyat");
		
		Ogrenci ogrenci2 = new Ogrenci();
		//ogrenci.setId(id);
		ogrenci2.setAdi("Selin");
		ogrenci2.setSoyadi("Çiçek");
		ogrenci2.setBolum("Heykel");
		ogrenci2.setFakulte("GSF");
		// ----------------------------------

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(ogrenci);
		session.save(ogrenci2);

		session.getTransaction().commit();

		
		Query query = session.getNamedQuery("tumOgrenciKayitlariniGetir");
		List<Ogrenci> ogrenciList = query.list();

		for(Ogrenci ogr : ogrenciList) {
			System.out.println("\nID=" + ogr.getId() + ", \nADI=" + ogr.getAdi() + ", \nBÖLÜM="
					+ ogr.getBolum() + ", \nFAKÜLTE=" + ogr.getFakulte() +  ", \nSOYADI=" + ogr.getSoyadi());
		}

		
	}

}