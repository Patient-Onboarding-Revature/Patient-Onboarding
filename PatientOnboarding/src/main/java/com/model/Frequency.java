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
	
	public Frequency() {}

	public Frequency(int id, String frequency) {
		super();
		Id = id;
		this.frequency = frequency;
	}

	public Frequency(String frequency) {
		super();
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Frequency [Id=" + Id + ", frequency=" + frequency + "]";
	}
	
}
