package com.furkanyilmaz.app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkanyilmaz.map.Siparis;
import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		Query sorgu = null;
		String hql = null;

		try {
			transaction = session.beginTransaction();

			hql = "INSERT INTO Siparis (siparisUrunId, siparisUrunAdi, siparisUrunFiyati) "
				+ "SELECT U.urunId, U.urunAd, U.urunFiyati  " 
				+ "FROM Urun AS U " 
				+ "WHERE U.urunId = :urun_id ";

			sorgu = session.createQuery(hql);
			sorgu.setParameter("urun_id", 2);
			
			int result1 = sorgu.executeUpdate();

			System.out.println("Girilen Kayıt sayısı 1. : " + result1);

			hql = "INSERT INTO Siparis (siparisUrunId, siparisUrunAdi, siparisUrunFiyati) "
				+ "SELECT U.urunId, U.urunAd, U.urunFiyati  "
				+ "FROM Urun AS U "
				+ "WHERE U.urunId = ? ";
			sorgu = session.createQuery(hql);
			sorgu.setParameter(0, 3);
			int result2 = sorgu.executeUpdate();

			System.out.println("Girilen Kayıt sayısı 2. : " + result2);
			session.flush();

			hql = "FROM Siparis ";
			sorgu = session.createQuery(hql);

			List<?> liste = sorgu.list();

			System.out.println("Kayıt sayısı : " + liste.size());
			System.out.println("----------");

			Iterator<?> iterator = liste.iterator();

			while (iterator.hasNext()) {

				Siparis siparis = (Siparis) iterator.next();
				System.out.println(siparis.getSiparisId() + " " + siparis.getSiparisUrunId() + " "
						+ siparis.getSiparisUrunAdi() + " " + siparis.getSiparisUrunFiyati());

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
