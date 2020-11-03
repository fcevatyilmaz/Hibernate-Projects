package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Adres;
import com.furkanyilmaz.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		Personel personel = new Personel();
		// personel.setPersonelId(1);
		personel.setPersonelAdi("Ahmet");
		personel.setPersonelSoyadi("Çalık");
		personel.setPersonelKayitTarihi(new Date());
		// ----------------------------------
		Adres evAdres1 = new Adres();
		evAdres1.setSehir("Tokat");
		evAdres1.setSemt("Merkez");
		evAdres1.setCadde("Karşıyaka");
		evAdres1.setKapiNo("13");
		evAdres1.setPostaKodu("60");
		
		personel.setEvAdres(evAdres1);
		
		
		Personel personel2 = new Personel();
		// personel.setPersonelId(1);
		personel2.setPersonelAdi("Murat");
		personel2.setPersonelSoyadi("Demir");
		personel2.setPersonelKayitTarihi(new Date());
		// ----------------------------------
		Adres isAdres1 = new Adres();
		isAdres1.setSehir("İstanbul");
		isAdres1.setSemt("Beylikdüzü");
		isAdres1.setCadde("İzmir");
		isAdres1.setKapiNo("21");
		isAdres1.setPostaKodu("34");
		
		
		personel2.setIsAdres(isAdres1);
		

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			session.save(personel);
			session.save(personel2);
		session.getTransaction().commit();

		session.close();




	}

}