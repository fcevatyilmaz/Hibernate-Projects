package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		Personel personel = new Personel();
		// personel.setPersonelId(1);
		personel.setPersonelAdi("Murat");
		personel.setPersonelSoyadi("Aslan");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Turkiye");
		// ----------------------------------

		Personel personel2 = new Personel();
		// personel.setPersonelId(1);
		personel2.setPersonelAdi("Furkan");
		personel2.setPersonelSoyadi("Yilmaz");
		personel2.setPersonelKayitTarihi(new Date());
		personel2.setPersonelAdresi("Almanya");

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(personel);
		session.save(personel2);

		session.getTransaction().commit();

		session.close();

		personel = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		personel = (Personel) session.get(Personel.class, 1);
		System.out.println("ID : " + personel.getPersonelId());
		System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		System.out.println("KAYIT TARİHİ : " + personel.getPersonelKayitTarihi());
		System.out.println("ADRESİ : " + personel.getPersonelAdresi());
		
		System.out.println("---------------");
		
		personel = (Personel) session.get(Personel.class, 2);
		System.out.println("ID : " + personel.getPersonelId());
		System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		System.out.println("KAYIT TARİHİ : " + personel.getPersonelKayitTarihi());
		System.out.println("ADRESİ : " + personel.getPersonelAdresi());

		
		
	}

}