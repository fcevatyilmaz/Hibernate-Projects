package com.furkanyilmaz.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.furkanyilmaz.map.Urun;
import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			System.out.println("Criteria 1");
			Criteria criteria1 = session.createCriteria(Urun.class);

			List<Urun> urunler1 = criteria1.list();
			for (Urun urun1 : urunler1) {
				System.out.println(urun1.getUrunId() + " " + urun1.getUrunAd() + " " + urun1.getUrunFiyati());
			}

			System.out.println("Criteria 2");
			Criteria criteria2 = session.createCriteria(Urun.class).addOrder(Order.asc("urunAd"));

			List<Urun> urunler2 = criteria2.list();
			for (Urun urun2 : urunler2) {
				System.out.println(urun2.getUrunId() + " " + urun2.getUrunAd() + " " + urun2.getUrunFiyati());
			}

			System.out.println("Criteria 3");
			Criteria criteria3 = session.createCriteria(Urun.class).addOrder(Order.desc("urunFiyati")).addOrder(Order.asc("urunAd"));

			List<Urun> urunler3 = criteria3.list();
			for (Urun urun3 : urunler3) {
				System.out.println(urun3.getUrunId() + " " + urun3.getUrunAd() + " " + urun3.getUrunFiyati());
			}

			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
