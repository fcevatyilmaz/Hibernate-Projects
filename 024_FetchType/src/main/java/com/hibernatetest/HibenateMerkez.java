package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Document;
import com.furkanyilmaz.SubDocument;

public class HibenateMerkez {

	public static void main(String[] args) {
		
		
		
		Document d1 = new Document();

		SubDocument sd1 = new SubDocument();
		sd1.setParentDocument(d1);
		sd1.setName("Belge1");

		Document d2 = new Document();

		SubDocument sd2 = new SubDocument();
		sd2.setParentDocument(d2);
		sd2.setName("Belge2");

		

		Document d3 = new Document();

		SubDocument sd3 = new SubDocument();
		sd3.setParentDocument(d3);
		sd3.setName("Belge3");

		

		Document d4 = new Document();

		SubDocument sd4 = new SubDocument();
		sd4.setParentDocument(d4);
		sd4.setName("Belge4");


		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		//session.persist(sd1);
		//session.persist(sd2);
		//session.persist(sd3);
		//session.persist(sd4);
		
		SubDocument sub = (SubDocument) session.get(SubDocument.class, 1L);
		
		session.getTransaction().commit();

		session.close();

	}

}