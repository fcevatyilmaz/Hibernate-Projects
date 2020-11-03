package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		Personel personel1 = new Personel("Murat", "Aslan", new Date(), "Türkiye");
		Personel personel2 = new Personel("Furkan", "Yilmaz", new Date(), "Almanya");
		Personel personel3 = new Personel("Ahmet", "Aksu", new Date(), "İngiltere");

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(personel1);
		session.save(personel2);
		session.save(personel3);

		session.getTransaction().commit();

		session.close();

		personel1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("---------------");

		personel1 = (Personel) session.get(Personel.class, 3);
		System.out.println("ID : " + personel1.getPersonelId());
		System.out.println("ADI SOYADI : " + personel1.getPersonelAdi() + " " + personel1.getPersonelSoyadi());
		System.out.println("KAYIT TARİHİ : " + personel1.getPersonelKayitTarihi());
		System.out.println("ADRESİ : " + personel1.getPersonelAdresi());

	}

}