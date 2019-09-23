package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Suffix;
import com.util.HibernateUtil;

public class SuffixDao {

	public static void insert(Suffix suffix) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(suffix);
		
		tx.commit();
	}

	public static List<Suffix> selectAll() {
		Session ses=HibernateUtil.getSession();
		List<Suffix> suffixes = ses.createQuery("from suffix", Suffix.class).list();
		
		return suffixes;
	}
	
}
