package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Doctor;

@Transactional
@Repository("doctorDao")
public class DoctorDao {

	private SessionFactory sf;

	public DoctorDao() {
	}

	@Autowired
	public DoctorDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Doctor obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Doctor> selectAll() {
		List<Doctor> list = sf.getCurrentSession().createQuery("from doctor", Doctor.class).list();

		return list;
	}

	public Doctor select(int id) {

		Doctor obj = (Doctor) sf.getCurrentSession().get(Doctor.class, id);

		return obj;

	}

}
