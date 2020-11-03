package com.hibernatetest;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Address;
import com.furkanyilmaz.Student;
import com.furkanyilmaz.University;

public class Test {

	public static void main(String[] args) {

		Address adress1 = new Address("Cumhuriyet cad.", "Ankara", "Turkiye");
		Address adress2 = new Address("Çankaya cad", "Ankara", "Turkiye");
		Address adress3 = new Address("Kazım Karabekir cad.", "Ankara", "Turkiye");
		Address adress4 = new Address("Seyhan cad.", "Adana", "Turkiye");

		University university1 = new University("Dumlupınar Universitesi");
		University university2 = new University("Hacettepe Universitesi");

		Student student1 = new Student("Ferhat", "Aykan", adress3, university1);
		Student student2 = new Student("Enes", "Çınar", adress1, university2);
		Student student3 = new Student("Uğur", "Baş", adress2, university2);
		Student student4 = new Student("Furkan", "Uslu", adress4, university1);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);

		session.save(adress1);
		session.save(adress2);
		session.save(adress3);
		session.save(adress4);

		
		session.save(university1);
		session.save(university2);

		session.getTransaction().commit();
		session.close();

	}
}