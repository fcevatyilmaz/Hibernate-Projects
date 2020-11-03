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
		
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Furkan");
		personel2.setPersonelSoyadi("Yilmaz");
		personel2.setPersonelKayitTarihi(new Date());
		// ----------------------------------
		
		Meslek meslek1 = new Meslek();
		meslek1.setMeslekAdi("Organizatör");
		
		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("Ekonomist");
		
		
		// ----------------------------------
		personel1.getMeslek().add(meslek1);
		personel1.getMeslek().add(meslek2);
		personel2.getMeslek().add(meslek2);
		// ----------------------------------

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
			session.save(personel1);
			session.save(personel2);
			session.save(meslek1);
			session.save(meslek2);
		session.getTransaction().commit();

		session.close();

	}

}