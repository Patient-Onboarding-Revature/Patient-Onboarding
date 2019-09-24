package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Salutation;
import com.util.HibernateUtil;

public class SalutationDao {

	public static void insert(Salutation salutation) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(salutation);
		
		tx.commit();
	}

	public static List<Salutation> selectAll() {
		Session ses=HibernateUtil.getSession();
		List<Salutation> salutations = ses.createQuery("from salutation", Salutation.class).list();
		
		return salutations;
	}
	
	public static Salutation select(int id) {
		
		Session ses=HibernateUtil.getSession();
		Salutation sal = (Salutation) ses.get(Salutation.class, id);
		
		return sal;
		
	}
	
}
