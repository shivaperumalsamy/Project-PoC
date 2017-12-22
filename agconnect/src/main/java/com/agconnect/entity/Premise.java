package com.agconnect.entity;

import java.sql.Date;

public class Premise {
	
	private int premiseID;
	private int ownerId;
	private String siteName;
	private int latitude;
	private int longitude;
	private Date createdTimeStamp;

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

	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	@Override
	public String toString() {
		return "Premise [premiseID=" + premiseID + ", ownerId=" + ownerId + ", siteName=" + siteName + ", latitude="
				+ latitude + ", longitude=" + longitude + ", createdTimeStamp=" + createdTimeStamp + "]";
	}

}
