package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Meslek;
import com.furkanyilmaz.Personel;

public class HibenateMerkez {

	public static void main(String[] args) {

		Personel personel1 = new Personel();
		personel1.setPersonelAdi("Orhan");
		personel1.setPersonelSoyadi("Eripek");

		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Furkan");
		personel2.setPersonelSoyadi("Yilmaz");

		Personel personel3 = new Personel();
		personel3.setPersonelAdi("Ahmet");
		personel3.setPersonelSoyadi("Sami");

		// ----------------------------------

		Meslek meslek1 = new Meslek();
		meslek1.setMeslekAdi("Mühendis");

		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("Yazar");

		Meslek meslek3 = new Meslek();
		meslek3.setMeslekAdi("Pazarlamacı");

		// ----------------------------------
		personel1.getMeslekList().add(meslek1);
		personel1.getMeslekList().add(meslek2);
		personel2.getMeslekList().add(meslek2);
		personel2.getMeslekList().add(meslek3);
		personel3.getMeslekList().add(meslek2);
		// ----------------------------------

		meslek1.getPersonelList().add(personel1);
		meslek2.getPersonelList().add(personel1);
		meslek2.getPersonelList().add(personel2);
		meslek2.getPersonelList().add(personel3);
		meslek3.getPersonelList().add(personel2);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(personel1);
		session.save(personel2);
		session.save(personel3);
		session.save(meslek1);
		session.save(meslek2);
		session.save(meslek3);
		session.getTransaction().commit();

		session.close();

	}

}