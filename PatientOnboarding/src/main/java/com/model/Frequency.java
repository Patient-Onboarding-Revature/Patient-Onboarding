package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frequency")
public class Frequency {

	@Id
	@Column(name="patient_id")
	private int Id;
	
	@Column(name="frequency")
	private String frequency;
	
}
