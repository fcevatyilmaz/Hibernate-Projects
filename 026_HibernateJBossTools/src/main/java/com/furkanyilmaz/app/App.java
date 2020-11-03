package com.furkanyilmaz.app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkanyilmaz.map.Personel;
import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		App obj = new App();
		Long personelId1 = obj.personelKaydet("Mimar", "Aslan"); // INSERT - CREATE
		Long personelId2 = obj.personelKaydet("Ali", "Can");
		Long personelId3 = obj.personelKaydet("Haydar", "Koç");
		Long personelId4 = obj.personelKaydet("Barış", "Sinan");
		Long personelId5 = obj.personelKaydet("Reis", "Kamil");
		Long personelId6 = obj.personelKaydet("Mustafa", "Türkyılmaz");

		obj.personelListe(); // SELECT - READ

		obj.personelGuncelle(personelId1, "Salih", "Nezir"); // UPDATE

		obj.personelSil(personelId4); // DELETE
		obj.personelSil(personelId6);
		
		obj.personelGuncelle(personelId2, "İKİ", "güncel2");
		obj.personelGuncelle(personelId3, "ÜÇ", "güncel3");
		obj.personelGuncelle(personelId5, "BEŞ", "güncel5");

		obj.personelListe();

	}

	private void personelSil(Long personelIdSecilen) {

		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Personel personel = (Personel) session.get(Personel.class, personelIdSecilen);

			session.delete(personel);

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("BAŞARILI OLARAK SİLİNDİ.\n");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void personelGuncelle(Long personelIdSecilen, String personelAdYeni, String personelSoyadYeni) {

		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Personel personel = (Personel) session.get(Personel.class, personelIdSecilen);
			personel.setPersonelAd(personelAdYeni);
			personel.setPersonelSoyad(personelSoyadYeni);
			session.update(personel);

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("BAŞARILI OLARAK GÜNCELLENDİ.\n");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void personelListe() {

		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			List<?> personeller = session.createQuery("FROM Personel").list();

			for (Iterator<?> iterator = personeller.iterator(); iterator.hasNext();) {
				Personel personel = (Personel) iterator.next();
				System.out.println(personel.getPersonelAd() + " " + personel.getPersonelSoyad());
			}

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("BAŞARILI OLARAK LİSTELENDİ.\n");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private Long personelKaydet(String personelAd, String personelSoyad) {

		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		Long personelId = null;

		try {
			transaction = session.beginTransaction();

			Personel personel = new Personel();
			personel.setPersonelAd(personelAd);
			personel.setPersonelSoyad(personelSoyad);
			personelId = (Long) session.save(personel);

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("\nBAŞARILI OLARAK KAYDEDİLDİ. ---> " + personelId);

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return personelId;
	}

}
