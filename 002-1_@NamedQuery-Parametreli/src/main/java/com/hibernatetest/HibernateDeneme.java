package com.hibernatetest;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Ogrenci;



public class HibernateDeneme {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//session.save(ogrenci);

		session.getTransaction().commit();

		int gelenDeger = 2;
		Query query1 = session.getNamedQuery("secilenOgrenciKaydiniGetirSetParameter").setParameter("p_id", gelenDeger);
		Query query2 = session.getNamedQuery("secilenOgrenciKaydiniGetirStatik");
		Query query3 = session.getNamedQuery("Ogrenci.AdiSoyadiSorgula").setParameter("p_adi", "Sinan").setParameter("p_soyadi", "Aslan");
		
		List<Ogrenci> ogrenciList1 = query1.list();
		List<Ogrenci> ogrenciList2 = query2.list();
		List<Ogrenci> ogrenciList3 = query3.list();
				
		yazdir(ogrenciList1);
		yazdir(ogrenciList2);
		yazdir(ogrenciList3);
		
		

		
	}
	public static void yazdir(List<Ogrenci> ogrList) {
		for(Ogrenci ogr : ogrList) {
			System.out.println("\nID=" + ogr.getId() + ", \nADI=" + ogr.getAdi() + ", \nBÖLÜM="
					+ ogr.getBolum() + ", \nFAKÜLTE=" + ogr.getFakulte()  + ", \nSOYADI="
					+ ogr.getSoyadi());
		}
	}

}