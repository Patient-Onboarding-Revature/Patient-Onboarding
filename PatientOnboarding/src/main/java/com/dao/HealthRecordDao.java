package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.HealthRecord;

@Transactional
@Repository("healthRecordDao")
public class HealthRecordDao {
	
	private SessionFactory sf;
	
	public HealthRecordDao() {}
	
	@Autowired
	public HealthRecordDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(HealthRecord obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<HealthRecord> selectAll() {
		List<HealthRecord> list = sf.getCurrentSession().createQuery("from health_record", HealthRecord.class).list();
		
		return list;
	}
	
	public HealthRecord select(int id) {
		
		HealthRecord obj = (HealthRecord) sf.getCurrentSession().get(HealthRecord.class, id);
		
		return obj;
		
	}

}
