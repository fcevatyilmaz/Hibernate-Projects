package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Adres;
import com.furkanyilmaz.Personel;

public class HibenateMerkez {

	public static void main(String[] args) {

		Personel personel1 = new Personel();
		personel1.setPersonelAdi("Yunus");
		personel1.setPersonelSoyadi("Savaş");
		personel1.setPersonelKayitTarihi(new Date());

		// ----------------------------------

		Adres adres1 = new Adres();
		adres1.setCadde("cadde1");
		adres1.setMahalle("mahalle1");
		adres1.setPersonel(personel1);

		Adres adres2 = new Adres();
		adres2.setCadde("cadde2");
		adres2.setMahalle("mahalle2");
		adres2.setPersonel(personel1);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(personel1);
		session.save(adres1);
		session.save(adres2);
		session.getTransaction().commit();

		session.close();

	}

}