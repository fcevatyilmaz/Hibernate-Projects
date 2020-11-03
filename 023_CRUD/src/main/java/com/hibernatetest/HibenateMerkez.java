package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Personel;

public class HibenateMerkez {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		insert("Furkan", "Yilmaz", session);
		insert("Ahmet", "Kaçar", session);
		read(1, session);
		delete(1, session);
		read(2, session);
		insert("Seyit", "Sami", session);
		update(2, session);
		insert("Berk", "Koca", session);
		read(4, session);
		delete(3,session);
		session.getTransaction().commit();

		session.close();

	}

	public static void insert(String name, String surname, Session session) {
		Personel personel = new Personel();
		personel.setPersonelAdi(name);
		personel.setPersonelSoyadi(surname);
		session.save(personel);
		System.out.println("Eklendi:");
	}

	public static void update(int id, Session session) {
		Personel personel = (Personel) session.get(Personel.class, id);
		personel.setPersonelAdi("updateName");
		personel.setPersonelSoyadi("updateSurname");
		session.update(personel);
		System.out.println("Güncellendi:");
	}

	public static void delete(int id, Session session) {
		Personel personel = (Personel) session.get(Personel.class, id);
		session.delete(personel);
		System.out.println("Silindi:");
	}

	public static void read(int id, Session session) {
		Personel personel = (Personel) session.get(Personel.class, id);
		System.out.println("Çekilen veri : " + personel.getPersonelId() + " " + personel.getPersonelAdi() + " "
				+ personel.getPersonelSoyadi());
	}
}