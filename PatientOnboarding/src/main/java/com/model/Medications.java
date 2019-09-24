package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medications")
public class Medications {

	@Id
	@Column(name="medication_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="medication_name")
	private String meds;
	
	@Column(name="prescribed_dose")
	private String dose;
	
	@Column(name="frequency_taken")
	private String freq;
	
	@Column(name="currently_taking")
	private boolean bool;
	
}
