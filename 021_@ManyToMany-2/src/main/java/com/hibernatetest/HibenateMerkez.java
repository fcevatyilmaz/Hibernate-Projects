package com.hibernatetest;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Meslek;
import com.furkanyilmaz.Personel;

public class HibenateMerkez {

	public static void main(String[] args) {

		Personel personel = new Personel();
		personel.setPersonelAdi("Orhan");
		personel.setPersonelSoyadi("Eripek");
	
		
		// ----------------------------------
		
		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Mühendis");
		
		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("Yazar");
		
		
		
		
		// ----------------------------------
		personel.getMeslekList().add(meslek);
		personel.getMeslekList().add(meslek2);
		// ----------------------------------

		meslek.getPersonelList().add(personel);
		meslek2.getPersonelList().add(personel);
		

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
			session.save(personel);
			session.save(meslek);
			session.save(meslek2);
		session.getTransaction().commit();

		session.close();

	}

}