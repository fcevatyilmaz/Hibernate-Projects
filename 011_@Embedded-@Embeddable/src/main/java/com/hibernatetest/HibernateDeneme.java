package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Adres;
import com.furkanyilmaz.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		Personel personel = new Personel("Ahmet", "Çalık", new Date());
		Adres adres = new Adres("Tokat", "semt1", "mahalle1", "cadde1", "kapiNo1" ,"kat1", "daireNo1",  "postaKodu1");
		personel.setAdres(adres);

		Personel personel2 = new Personel("Murat", "Demir", new Date());
		Adres adres2 = new Adres("İstanbul", "semt2", "mahalle2", "cadde2", "kapiNo2" , "kat2", "daireNo2", 
				"postaKodu2");
		personel2.setAdres(adres2);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(personel);
		session.save(personel2);
		session.getTransaction().commit();

		session.close();

	}

}