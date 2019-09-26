package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_name")
public class InsuranceName {

	@Id
	@Column(name="insurance_name_id")
	private int Id;
	
	@Column(name="insurance_name")
	private String name;
	
}
