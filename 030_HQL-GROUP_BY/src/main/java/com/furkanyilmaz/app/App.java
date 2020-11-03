package com.furkanyilmaz.app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			System.out.println("GROUP BY 1");
			String hql1 = "SELECT U.urunId,U.urunAd,SUM(U.urunFiyati) " 
						+ "FROM Urun AS U " 
						+ "GROUP BY U.urunAd ";
			Query query1 = session.createQuery(hql1);
			List<?> urunler1 = query1.list();

			Iterator<?> iterator1 = urunler1.iterator();
			while (iterator1.hasNext()) {
				Object[] urun1 = (Object[]) iterator1.next();
				System.out.println(urun1[0] + " " + urun1[1] + " TOPLAM FİYAT : " + urun1[2]);

			}
			System.out.println("GROUP BY 2");
			String hql2 = "SELECT U.urunId,U.urunAd,MAX(U.urunFiyati) " 
						+ "FROM Urun AS U " 
						+ "GROUP BY U.urunAd "
						+ "ORDER BY U.urunAd ASC";
			Query query2 = session.createQuery(hql2);
			List<?> urunler2 = query2.list();

			Iterator<?> iterator2 = urunler2.iterator();
			while (iterator2.hasNext()) {
				Object[] urun2 = (Object[]) iterator2.next();
				System.out.println(urun2[0] + " " + urun2[1] + " MAX FİYAT:" + urun2[2]);

			}
			System.out.println("GROUP BY 3");
			String hql3 = "SELECT U.urunId,U.urunAd,MIN(U.urunFiyati) " 
						+ "FROM Urun AS U " 
						+ "GROUP BY U.urunAd "
						+ "ORDER BY U.urunAd DESC";
			Query query3 = session.createQuery(hql3);
			List<?> urunler3 = query3.list();

			Iterator<?> iterator3 = urunler3.iterator();
			while (iterator3.hasNext()) {
				Object[] urun3 = (Object[]) iterator3.next();
				System.out.println(urun3[0] + " " + urun3[1] + " MİN FİYAT:" + urun3[2]);

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
