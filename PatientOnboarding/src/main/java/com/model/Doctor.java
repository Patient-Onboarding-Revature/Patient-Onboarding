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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@Column(name="doctor_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String pass;
	
	@Column(name="specialty", nullable=false)
	private String specialty;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Hospital hospital;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="doctors")
	private List<Patient> patients;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_role")
	private UserRole role;
	
}
