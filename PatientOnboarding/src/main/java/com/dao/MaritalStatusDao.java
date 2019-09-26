package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.MaritalStatus;
import com.util.HibernateUtil;

public class MaritalStatusDao {

	public static void insert(MaritalStatus marital_status) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(marital_status);
		
		tx.commit();
	}

	public static List<MaritalStatus> selectAll() {
		Session ses=HibernateUtil.getSession();
		List<MaritalStatus> marital_status = ses.createQuery("from marital_status", MaritalStatus.class).list();
		
		return marital_status;
	}
	
	public static MaritalStatus select(int id) {
		
		Session ses=HibernateUtil.getSession();
		MaritalStatus ms = (MaritalStatus) ses.get(MaritalStatus.class, id);
		
		return ms;
		
	}
	
}
