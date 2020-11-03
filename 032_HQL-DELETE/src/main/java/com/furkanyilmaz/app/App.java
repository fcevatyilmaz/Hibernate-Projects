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
		Query sorgu = null;
		String hql = null;

		try {
			transaction = session.beginTransaction();

			hql = "DELETE FROM Urun AS u "
				+ "WHERE u.urunId=:urun_id";

			sorgu = session.createQuery(hql);

			sorgu.setParameter("urun_id", 4);

			// hql = "DELETE FROM Urun AS u WHERE u.urunId = ?";
			// sorgu = session.createQuery(hql);
			// sorgu.setParameter(0, 4);

			int result = sorgu.executeUpdate();

			System.out.println("Değistirilen Kayıt Sayısı : " + result);

			session.flush();

			hql = "FROM Urun ";
			sorgu = session.createQuery(hql);

			List<?> liste = sorgu.list();

			System.out.println("Kayıt sayısı : " + liste.size());
			System.out.println("----------");

			Iterator<?> iterator = liste.iterator();

			while (iterator.hasNext()) {

				Urun urun = (Urun) iterator.next();
				System.out.println(urun.getUrunId() + " - " + urun.getUrunAd() + "  - " + urun.getUrunFiyati());
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
