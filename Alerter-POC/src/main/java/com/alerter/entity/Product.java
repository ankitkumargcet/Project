package com.alerter.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private String bizArea;
	private String bizOwner;
	private int unitsAvailable;
	private String url;
	private String schedule;
	private int upperLimit;
	private int lowerLimit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getUnitsAvailable() {
		return unitsAvailable;
	}

	public void setUnitsAvailable(int unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

}
