package com.agconnect.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="premise")
public class Premise {
	
	@Id
	@Column(name="premiseID")
	private int premiseID;
	
	@Column(name="ownerID")
	private int ownerId;
	
	@Column(name="siteName")
	private String siteName;
	
	@Column(name="latitude")
	private int latitude;
	
	@Column(name="longitude")
	private int longitude;
	
	@Column(name="createTimeStamp")
	private Timestamp createdTimeStamp;

	public int getPremiseID() {
		return premiseID;
	}

	public void setPremiseID(int premiseID) {
		this.premiseID = premiseID;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	@Override
	public String toString() {
		return "Premise [premiseID=" + premiseID + ", ownerId=" + ownerId + ", siteName=" + siteName + ", latitude="
				+ latitude + ", longitude=" + longitude + ", createdTimeStamp=" + createdTimeStamp + "]";
	}

}
