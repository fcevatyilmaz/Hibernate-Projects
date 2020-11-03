package com.furkanyilmaz.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.furkanyilmaz.map.Urun;
import com.furkanyilmaz.util.HibernateUtil;

public class App {

	public static void print(List<?> urunlerListesi) {
		for (Object o : urunlerListesi) {
			System.out.println(((Urun) o).getUrunId() + " " + ((Urun) o).getUrunAd() + " " + ((Urun) o).getUrunFiyati());
		}System.out.println("-----");
		
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Criteria criteria1 = session.createCriteria(Urun.class).add(Restrictions.eq("urunFiyati", 10.0));
			List<?> urunlerListesi1 = criteria1.list();
			System.out.println("Criteria 1");
			print(urunlerListesi1);

			// == eq equal esit

			Criteria criteria2 = session.createCriteria(Urun.class).add(Restrictions.ne("urunFiyati", 800.0));
			List<?> urunlerListesi2 = criteria2.list();
			System.out.println("Criteria 2");
			print(urunlerListesi2);
			// != <> ne not equal esit degil

			Criteria criteria3 = session.createCriteria(Urun.class).add(Restrictions.lt("urunFiyati", 45.0));
			List<?> urunlerListesi3 = criteria3.list();
			System.out.println("Criteria 3");
			print(urunlerListesi3);
			// < lt less than kucuk

			Criteria criteria4 = session.createCriteria(Urun.class).add(Restrictions.gt("urunFiyati", 45.0));
			List<?> urunlerListesi4 = criteria4.list();
			System.out.println("Criteria 4");
			print(urunlerListesi4);
			// < gt greater than buyuk

			Criteria criteria5 = session.createCriteria(Urun.class).add(Restrictions.like("urunAd", "t%"));
			List<?> urunlerListesi5 = criteria5.list();
			System.out.println("Criteria 5");
			print(urunlerListesi5);
			// ILK HARFI onemli degil 2.harfi a olan devami onemli degil

			Criteria criteria6 = session.createCriteria(Urun.class).add(Restrictions.like("urunAd", "%e%"))
					.add(Restrictions.between("urunFiyati", 14.0, 53.0));
			List<?> urunlerListesi6 = criteria6.list();
			System.out.println("Criteria 6");
			print(urunlerListesi6);

			
			Criteria criteria7 = session.createCriteria(Urun.class).setFirstResult(2).setMaxResults(5);
			List<?> urunlerListesi7 = criteria7.list();
			System.out.println("Criteria 7");
			print(urunlerListesi7);

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
