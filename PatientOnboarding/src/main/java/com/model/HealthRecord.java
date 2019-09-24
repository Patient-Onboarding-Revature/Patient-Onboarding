package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="health_record")
public class HealthRecord {

	@Id
	@Column(name="record_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Patient patient;
	
	@Column(name="high_blood_pressure", nullable=false)
	private boolean b;
	
	@Column(name="heart_disease", nullable=false)
	private boolean b1;
	
	@Column(name="stroke", nullable=false)
	private boolean b2;
	
	@Column(name="diabetes", nullable=false)
	private boolean b3;
	
	@Column(name="digestive_problems", nullable=false)
	private boolean b4;
	
	@Column(name="lung_problems", nullable=false)
	private boolean b5;
	
	@Column(name="visual_impairment", nullable=false)
	private boolean b6;
	
	@Column(name="back_or_joint_problems", nullable=false)
	private boolean b7;
	
	@Column(name="depression_or_severe_anxiety", nullable=false)
	private boolean b8;
	
	@Column(name="cancer", nullable=false)
	private boolean b9;
	
	@Column(name="liver_problems", nullable=false)
	private boolean b10;
	
	@Column(name="thyroid_problems", nullable=false)
	private boolean b11;
	
	@Column(name="hearing_problems", nullable=false)
	private boolean b12;
	
	@Column(name="smoke", nullable=false)
	private boolean b13;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="smoke_freq")
	private Frequency smoke;
	
	@Column(name="chewing_tobacco_snuff", nullable=false)
	private boolean b14;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="chewing_freq")
	private Frequency chew;
	
	@Column(name="alcohol", nullable=false)
	private boolean b15;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="alcohol_freq")
	private Frequency alc;
	
	@Column(name="caffein", nullable=false)
	private boolean b16;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="caffein_freq")
	private Frequency caff;
	
	@Column(name="drugs", nullable=false)
	private boolean b17;
	
	@Column(name="sexual_active", nullable=false)
	private boolean b18;
	
	@Column(name="exercise_regularly", nullable=false)
	private boolean b19;
	
	@Column(name="living_will", nullable=false)
	private boolean b20;
	
}
