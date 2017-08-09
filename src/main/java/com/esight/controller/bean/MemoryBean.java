package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MemoryBean  {

	private String name;
	
	private String capacity;
	
	private String manufacture;
	
	private String frequency;
	
	private int healthState;

	private String moId;

	private String uuid;

	private int presentState=1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getHealthState() {
		return healthState;
	}

	public void setHealthState(int healthState) {
		this.healthState = healthState;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMoId() {
		return moId;
	}

	public void setMoId(String moId) {
		this.moId = moId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getPresentState() {
		return presentState;
	}

	public void setPresentState(int presentState) {
		this.presentState = presentState;
	}
}
