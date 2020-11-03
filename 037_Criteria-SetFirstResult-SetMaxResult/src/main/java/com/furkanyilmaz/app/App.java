package com.furkanyilmaz.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.furkanyilmaz.map.Urun;
import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Criteria criteria = session.createCriteria(Urun.class).setFirstResult(2).setMaxResults(5);
			List<?> urunlerListesi = criteria.list();

			print(urunlerListesi);

			// session.getTransaction().commit();
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void print(List<?> urunlerListesi) {
		for (Object o : urunlerListesi) {
			System.out.println(((Urun) o).getUrunId() + " - " + ((Urun) o).getUrunAd() + "  - "
					+ ((Urun) o).getUrunFiyati() + "\n---------------------------------");
		}
	}

}
