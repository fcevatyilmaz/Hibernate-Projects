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

		try {
			transaction = session.beginTransaction();

			String sql5 = "SELECT u.urunId, u.urunAd, u.urunFiyati FROM Urun AS u "
					+ "WHERE u.urunFiyati < :pUrunFiyati";
			Query query5 = session.createSQLQuery(sql5).addEntity(Urun.class).setParameter("pUrunFiyati", 45.0);

			List<?> urunlerListesi = query5.list();

			for (Object o : urunlerListesi) {
				System.out.println(((Urun) o).getUrunId() + " - " + ((Urun) o).getUrunAd() + "  - "
						+ ((Urun) o).getUrunFiyati());
			}

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("BAŞARILI OLARAK Listelendi.");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
