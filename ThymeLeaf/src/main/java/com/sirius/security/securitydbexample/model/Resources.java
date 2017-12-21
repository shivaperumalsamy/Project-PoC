package com.sirius.security.securitydbexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="resource")
public class Resources {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "data_id")
	private int data_id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="role_id")
	private String role;
	
	@Column(name="permission")
	private String permission;
	
	public Resources() {
		
	}
	
	public Resources(Resources resource) {
		this.data_id = resource.getData_id();
		this.companyName = resource.getCompanyName();
		this.role = resource.getRole();
		this.permission = resource.getPermission();
	}

	public int getData_id() {
		return data_id;
	}

	public void setData_id(int data_id) {
		this.data_id = data_id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
	
	
}
