package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		
		Personel personel = new Personel();
		personel.setPersonelId(1);
		personel.setPersonelAdi("Murat");
		personel.setPersonelSoyadi("Aslan");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Turkiye");
		//----------------------------------
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(personel);
		
		
		session.getTransaction().commit();
	}

}