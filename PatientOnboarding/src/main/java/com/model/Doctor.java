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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Doctor(int id, String firstName, String lastName, String username, String pass, String specialty,
			Hospital hospital, List<Patient> patients, UserRole role) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.pass = pass;
		this.specialty = specialty;
		this.hospital = hospital;
		this.patients = patients;
		this.role = role;
	}

	public Doctor(String firstName, String lastName, String username, String pass, String specialty, Hospital hospital,
			List<Patient> patients, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.pass = pass;
		this.specialty = specialty;
		this.hospital = hospital;
		this.patients = patients;
		this.role = role;
	}
	
	public Doctor() {}

	@Override
	public String toString() {
		return "Doctor [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", pass=" + pass + ", specialty=" + specialty + ", hospital=" + hospital + ", patients=" + patients
				+ ", role=" + role + "]";
	}
	
}
