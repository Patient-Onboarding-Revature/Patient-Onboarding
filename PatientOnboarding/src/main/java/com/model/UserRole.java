package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {

	@Id
	@Column(name="role_id")
	private int Id;
	
	@Column(name="role")
	private String role;
	
}
