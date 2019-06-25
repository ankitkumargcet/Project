package com.alerter.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
public class Alerts {
	@Id
	private int count;
	private String id;
	private String bizArea;
	private String bizOwner;
	private int rank;
	private String reoccurrence;
	private Timestamp changeDate;
	private String alertTitle;
	private String alertDescription;
	private String url;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBizArea() {
		return bizArea;
	}

	public void setBizArea(String bizArea) {
		this.bizArea = bizArea;
	}

	public String getBizOwner() {
		return bizOwner;
	}

	public void setBizOwner(String bizOwner) {
		this.bizOwner = bizOwner;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getReoccurrence() {
		return reoccurrence;
	}

	public void setReoccurrence(String reoccurrence) {
		this.reoccurrence = reoccurrence;
	}

	public Timestamp getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}

	public String getAlertTitle() {
		return alertTitle;
	}

	public void setAlertTitle(String alertTitle) {
		this.alertTitle = alertTitle;
	}

	public String getAlertDescription() {
		return alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
