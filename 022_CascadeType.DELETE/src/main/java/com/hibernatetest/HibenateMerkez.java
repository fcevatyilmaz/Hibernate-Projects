package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Meslek;
import com.furkanyilmaz.Personel;

public class HibenateMerkez {

	public static void main(String[] args) {

		Personel personel1 = new Personel();
		personel1.setPersonelAdi("Yunus");
		personel1.setPersonelSoyadi("Savaş");
		personel1.setPersonelKayitTarihi(new Date());
		// ----------------------------------

		Meslek meslek1 = new Meslek();
		meslek1.setMeslekAdi("Organizatör");

		// ----------------------------------
		personel1.setMeslek(meslek1);
		// ----------------------------------

		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Furkan");
		personel2.setPersonelSoyadi("Yilmaz");
		personel2.setPersonelKayitTarihi(new Date());
		// ----------------------------------

		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("Mühendis");

		// ----------------------------------
		personel2.setMeslek(meslek2);
		// ----------------------------------

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.persist(personel1);
		session.persist(personel2);
		session.delete(personel1);
		session.getTransaction().commit();

		session.close();

	}

}