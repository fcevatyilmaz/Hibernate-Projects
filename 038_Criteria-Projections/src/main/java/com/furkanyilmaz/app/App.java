package com.furkanyilmaz.app;

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
			
			Criteria criteria1 = session.createCriteria(Urun.class)
					.setProjection(Projections.max("urunFiyati"));			
			Double maxDeger = (Double) criteria1.uniqueResult();
			System.out.println("En pahali urunun fiyati = " + maxDeger);
		
					
			Criteria criteria2 = session.createCriteria(Urun.class)
					.setProjection(Projections.min("urunFiyati"));		
			Double minDeger = (Double) criteria2.uniqueResult();
			System.out.println("En ucuz urunun fiyati = " + minDeger);
			
			
			Criteria criteria3 = session.createCriteria(Urun.class)
					.setProjection(Projections.avg("urunFiyati"));			
			Double avgDeger = (Double) criteria3.uniqueResult();
			System.out.println("Urunlerin ortalama fiyati = " + avgDeger);
			
			
			Criteria criteria4 = session.createCriteria(Urun.class)
					.setProjection(Projections.sum("urunFiyati"));		
			Double sumDeger = (Double) criteria4.uniqueResult();
			System.out.println("Urunlerin toplam fiyati = " + sumDeger);
			
			Criteria criteria5 = session.createCriteria(Urun.class)
					.setProjection(Projections.rowCount());			
			System.out.println("Urunlerin sayisi = " + criteria5.uniqueResult());
			
			
		   
	
			//session.getTransaction().commit();
			transaction.commit();
			
 
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
		   session.close();
		} 
	}


}

