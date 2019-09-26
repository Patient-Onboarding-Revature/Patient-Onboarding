package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Patient;
import com.util.HibernateUtil;

public class PatientDao {

	public static void insert(Patient patient) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(patient);
		
		tx.commit();
	}

	public static List<Patient> selectAll() {
		Session ses=HibernateUtil.getSession();
		List<Patient> patients = ses.createQuery("from patient", Patient.class).list();
		
		return patients;
	}
	
}
