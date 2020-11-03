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

			System.out.println("ORDER BY 1");
			String hql1 = "FROM Urun AS U WHERE U.urunId >= 3 ORDER BY U.urunFiyati";
			// String hql1 = "FROM Urun AS U WHERE U.urunId >= 3 ORDER BY U.urunAd ASC";
			// String hql1 = "FROM Urun AS U WHERE U.urunId >= 3 ORDER BY U.urunAd asc";
			Query query1 = session.createQuery(hql1);
			List<?> urunler1 = query1.list();

			Iterator<?> iterator1 = urunler1.iterator();
			while (iterator1.hasNext()) {
				Urun object1 = (Urun) iterator1.next();
				System.out.println(object1.getUrunId() + " " + object1.getUrunAd() + " " + object1.getUrunFiyati());

			}

			System.out.println("ORDER BY 2");
			String hql2 = "FROM Urun AS U WHERE U.urunId >= 3 ORDER BY U.urunFiyati DESC , U.urunAd DESC";
			// String hql2 = "FROM Urun AS U WHERE U.urunId >= 3 ORDER BY U.urunAd desc";
			Query query2 = session.createQuery(hql2);
			List<?> urunler2 = query2.list();

			Iterator<?> iterator2 = urunler2.iterator();
			while (iterator2.hasNext()) {
				Urun object2 = (Urun) iterator2.next();
				System.out.println(object2.getUrunId() + " " + object2.getUrunAd() + " " + object2.getUrunFiyati());

			}

			System.out.println("ORDER BY 3");
			String hql3 = "FROM Urun AS U " 
						+ "WHERE U.urunId >= 3 AND U.urunAd LIKE 'T%' "
						+ "ORDER BY U.urunFiyati DESC";
			// String hql2 = "FROM Urun AS U WHERE U.urunId >= 3 ORDER BY U.urunAd desc";
			Query query3 = session.createQuery(hql3);
			List<?> urunler3 = query3.list();

			Iterator<?> iterator3 = urunler3.iterator();
			while (iterator3.hasNext()) {
				Urun object3 = (Urun) iterator3.next();
				System.out.println(object3.getUrunId() + " " + object3.getUrunAd() + " " + object3.getUrunFiyati());

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
