package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Sex;
import com.util.HibernateUtil;

public class SexDao {

	public static void insert(Sex sex) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(sex);
		
		tx.commit();
	}

	public static List<Sex> selectAll() {
		Session ses=HibernateUtil.getSession();
		List<Sex> sexes = ses.createQuery("from sex", Sex.class).list();
		
		return sexes;
	}
	
	public static Sex select(int id) {
		
		Session ses=HibernateUtil.getSession();
		Sex sex = (Sex) ses.get(Sex.class, id);
		
		return sex;
		
	}
	
}
