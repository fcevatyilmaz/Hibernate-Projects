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
		personel.setPersonelAdi("Yunus");
		personel.setPersonelSoyadi("Savaş");
		personel.setPersonelKayitTarihi(new Date());
		// ----------------------------------
		Adres adres1 = new Adres();
		adres1.setSehir("Tokat");
		adres1.setSemt("Merkez");
		adres1.setCadde("Karşıyaka");
		adres1.setKapiNo("13");
		adres1.setPostaKodu("60");
		
		personel.getAdresListesi().add(adres1);

		// ----------------------------------
		Adres adres2 = new Adres();
		adres2.setSehir("İstanbul");
		adres2.setSemt("Beylikdüzü");
		adres2.setCadde("İzmir");
		adres2.setKapiNo("21");
		adres2.setPostaKodu("34");
		
		personel.getAdresListesi().add(adres2);
		
		
		
		
		Personel personel2 = new Personel();
		// personel.setPersonelId(1);
		personel2.setPersonelAdi("Sami");
		personel2.setPersonelSoyadi("İpek");
		personel2.setPersonelKayitTarihi(new Date());
		// ----------------------------------
		Adres adres3 = new Adres();
		adres3.setSehir("Aydın");
		adres3.setSemt("Merkez");
		adres3.setCadde("Çukurca");
		adres3.setKapiNo("23");
		adres3.setPostaKodu("15");
		
		personel2.getAdresListesi().add(adres3);

		// ----------------------------------
		Adres adres4 = new Adres();
		adres4.setSehir("Niğde");
		adres4.setSemt("Merkez");
		adres4.setCadde("Omcalık");
		adres4.setKapiNo("12");
		adres4.setPostaKodu("74");
		
		personel2.getAdresListesi().add(adres4);
		

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			session.save(personel);
			session.save(personel2);
		session.getTransaction().commit();

		session.close();




	}

}