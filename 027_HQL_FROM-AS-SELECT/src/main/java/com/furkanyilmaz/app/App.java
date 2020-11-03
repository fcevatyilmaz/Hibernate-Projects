package com.furkanyilmaz.app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkanyilmaz.map.Urun;
import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			// FROM
			System.out.println("-----FROM SORGUSU-----");
			Query query1 = session.createQuery("FROM Urun");
			List<?> urunler1 = query1.list();

			Iterator<?> iterator1 = urunler1.iterator();
			while (iterator1.hasNext()) {
				Urun object1 = (Urun) iterator1.next();
				System.out.println(object1.getUrunId() + " " + object1.getUrunAd() + " " + object1.getUrunFiyati());

			}

			// AS

			// Query sorgu = session.createQuery("from Urun u");
			// Query sorgu = session.createQuery("FROM Urun u");
			// Query sorgu = session.createQuery("from Urun AS U");
			// Query sorgu = session.createQuery("FROM Urun as u");
			// Query sorgu = session.createQuery("FROM Urun AS u");

			System.out.println("-----AS SORGUSU-----");
			String hql2 = "FROM Urun as U";
			Query query2 = session.createQuery(hql2);
			List<?> urunler2 = query2.list();

			Iterator<?> iterator2 = urunler2.iterator();
			while (iterator2.hasNext()) {
				Urun object2 = (Urun) iterator2.next();
				System.out.println(object2.getUrunId() + " " + object2.getUrunAd() + " " + object2.getUrunFiyati());

			}

			// SELECT

			// Query sorgu = session.createQuery("select U.urunId,U.urunAdi from Urun as U");
			// Query sorgu = session.createQuery("select u.urunId,u.urunAdi from Urun u");
			// Query sorgu = session.createQuery("select ab.urunId,ab.urunAdi from Urun AS ab");
			// Query sorgu = session.createQuery("SELECT ab.urunId,ab.urunAdi from Urun ab");
			// Query sorgu = session.createQuery("select ab.urunId,ab.urunAdi FROM Urun ab");
			// Query sorgu = session.createQuery("SELECT ab.urunId,ab.urunAdi FROM Urun ab");

			System.out.println("-----SELECT SORGUSU-----");
			String hql3 = "select u.urunId,u.urunAd from Urun as u";
			Query query3 = session.createQuery(hql3);
			List<?> urunler3 = query3.list();

			Iterator<?> iterator3 = urunler3.iterator();
			while (iterator3.hasNext()) {
				Object o[] = (Object[]) iterator3.next();
				System.out.println(o[0] + " " + o[1]);
			}

			// session.getTransaction().commit();
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
