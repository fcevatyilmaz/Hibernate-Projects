package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(new Personel("Süleyman", "Demir", new Date(), "Ankara", "6000", "05413648912"));
		session.save(new Personel("Fatih", "Artman", new Date(), "Konya", "5200", "05431235261"));

		session.getTransaction().commit();

		session.close();

	}

}