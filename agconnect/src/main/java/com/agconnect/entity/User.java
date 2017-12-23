package com.agconnect.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private int userID;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date createdTimeStamp;
	
	private Date lastLoginTimeStamp;
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Date getLastLoginTimeStamp() {
		return lastLoginTimeStamp;
	}

	public void setLastLoginTimeStamp(Date lastLoginTimeStamp) {
		this.lastLoginTimeStamp = lastLoginTimeStamp;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", createdTimeStamp=" + createdTimeStamp + ", lastLoginTimeStamp=" + lastLoginTimeStamp + "]";
	}

}
