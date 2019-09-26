package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Ethnicity;
import com.util.HibernateUtil;

public class EthnicityDao {

	public static void insert(Ethnicity ethnicity) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(ethnicity);
		
		tx.commit();
	}

	public static List<Ethnicity> selectAll() {
		Session ses=HibernateUtil.getSession();
		List<Ethnicity> ethnicities = ses.createQuery("from ethnicity", Ethnicity.class).list();
		
		return ethnicities;
	}
	
	public static Ethnicity select(int id) {
		
		Session ses=HibernateUtil.getSession();
		Ethnicity eth = (Ethnicity) ses.get(Ethnicity.class, id);
		
		return eth;
		
	}
	
}
