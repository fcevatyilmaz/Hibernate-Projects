package com.furkanyilmaz.app;

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
		Query sorgu = null;
		String hql = null;

		try {
			transaction = session.beginTransaction();

			hql = "FROM Urun AS u";

			sorgu = session.createQuery(hql);

			sorgu.setFirstResult(3);// Bu kayıtta başla
			sorgu.setMaxResults(7);// Bu kadar kayıt getir

			session.flush();

			List<Urun> urunler = (List<Urun>) sorgu.list();
			for (Urun urun : urunler) {
				System.out.println(urun.getUrunId() + " " + urun.getUrunAd() + " " + urun.getUrunFiyati());
			}

			System.out.println("----------");
			hql = "FROM Urun AS u";

			sorgu = session.createQuery(hql);

			sorgu.setFirstResult(2);// Bu kayıtta başla
			sorgu.setMaxResults(5);// Bu kadar kayıt getir

			session.flush();

			List<Urun> urunler2 = (List<Urun>) sorgu.list();
			for (Urun urun2 : urunler2) {
				System.out.println(urun2.getUrunId() + " " + urun2.getUrunAd() + " " + urun2.getUrunFiyati());
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
