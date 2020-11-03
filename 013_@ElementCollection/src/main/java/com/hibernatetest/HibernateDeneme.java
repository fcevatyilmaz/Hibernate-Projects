package com.hibernatetest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkanyilmaz.Student;

public class HibernateDeneme {

	public static void main(String[] args) {

		List<String> emails1 = new ArrayList<String>();
		List<String> phoneNumbers1 = new ArrayList<String>();

		emails1.add("aykanferhat@gmail.com");
		emails1.add("aykanferhat@hotmail.com");
		emails1.add("aykan@hotmail.com");

		phoneNumbers1.add("055555");
		phoneNumbers1.add("066666");
		phoneNumbers1.add("077777");

		Student student1 = new Student("Ferhat", "Aykna", 1994, emails1, phoneNumbers1);

		List<String> emails2 = new ArrayList<String>();
		List<String> phoneNumbers2 = new ArrayList<String>();

		emails2.add("furkancevatyi@gmail.com");
		emails2.add("furkancevaty@gmail.com");

		phoneNumbers2.add("111111");
		phoneNumbers2.add("222222");
		phoneNumbers2.add("333333");
		phoneNumbers2.add("444444");

		Student student2 = new Student("Furkan", "Yilmaz", 1996, emails2, phoneNumbers2);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();

		session.close();

	}

}