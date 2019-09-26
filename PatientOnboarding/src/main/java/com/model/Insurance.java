package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="insurance")
public class Insurance {

	@Id
	@Column(name="insurance_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="insurance_name", nullable=false)
	private InsuranceName insurance;
	
	@Column(name="member_id")
	private String memberId;
	
	@Column(name="group_id")
	private String groupId;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="insurance")
	private List<Patient> patients;
	
}
