package com.esight.controller.bean;





public class CPUBean  {
	
	private String name;
	
	private int healthState;
	
	private String frequency;
	
	private String manufacture;
	
	private String model;

	private String moId;

	private String uuid;

	private int presentState;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
