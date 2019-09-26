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
	
	@Column(name="sexually_active", nullable=false)
	private boolean b18;
	
	@Column(name="exercise_regularly", nullable=false)
	private boolean b19;
	
	@Column(name="living_will", nullable=false)
	private boolean b20;

	public HealthRecord(Patient patient, boolean b, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5,
			boolean b6, boolean b7, boolean b8, boolean b9, boolean b10, boolean b11, boolean b12, boolean b13,
			Frequency smoke, boolean b14, Frequency chew, boolean b15, Frequency alc, boolean b16, Frequency caff,
			boolean b17, boolean b18, boolean b19, boolean b20) {
		super();
		this.patient = patient;
		this.b = b;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.b5 = b5;
		this.b6 = b6;
		this.b7 = b7;
		this.b8 = b8;
		this.b9 = b9;
		this.b10 = b10;
		this.b11 = b11;
		this.b12 = b12;
		this.b13 = b13;
		this.smoke = smoke;
		this.b14 = b14;
		this.chew = chew;
		this.b15 = b15;
		this.alc = alc;
		this.b16 = b16;
		this.caff = caff;
		this.b17 = b17;
		this.b18 = b18;
		this.b19 = b19;
		this.b20 = b20;
	}

	public HealthRecord(int id, Patient patient, boolean b, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5,
			boolean b6, boolean b7, boolean b8, boolean b9, boolean b10, boolean b11, boolean b12, boolean b13,
			Frequency smoke, boolean b14, Frequency chew, boolean b15, Frequency alc, boolean b16, Frequency caff,
			boolean b17, boolean b18, boolean b19, boolean b20) {
		super();
		Id = id;
		this.patient = patient;
		this.b = b;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.b5 = b5;
		this.b6 = b6;
		this.b7 = b7;
		this.b8 = b8;
		this.b9 = b9;
		this.b10 = b10;
		this.b11 = b11;
		this.b12 = b12;
		this.b13 = b13;
		this.smoke = smoke;
		this.b14 = b14;
		this.chew = chew;
		this.b15 = b15;
		this.alc = alc;
		this.b16 = b16;
		this.caff = caff;
		this.b17 = b17;
		this.b18 = b18;
		this.b19 = b19;
		this.b20 = b20;
	}

	public HealthRecord() {
		super();
	}

	@Override
	public String toString() {
		return "HealthRecord [Id=" + Id + ", patient=" + patient + ", b=" + b + ", b1=" + b1 + ", b2=" + b2 + ", b3="
				+ b3 + ", b4=" + b4 + ", b5=" + b5 + ", b6=" + b6 + ", b7=" + b7 + ", b8=" + b8 + ", b9=" + b9
				+ ", b10=" + b10 + ", b11=" + b11 + ", b12=" + b12 + ", b13=" + b13 + ", smoke=" + smoke + ", b14="
				+ b14 + ", chew=" + chew + ", b15=" + b15 + ", alc=" + alc + ", b16=" + b16 + ", caff=" + caff
				+ ", b17=" + b17 + ", b18=" + b18 + ", b19=" + b19 + ", b20=" + b20 + "]";
	}
	
}
