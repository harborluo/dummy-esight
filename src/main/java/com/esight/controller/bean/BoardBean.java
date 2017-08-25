package com.esight.controller.bean;

/**
 *
 */
public class BoardBean  {

	private String name;

	/**
	 *   0：主板
	 *  1：交换板
	 * @return
	 */
	private String type;

	private String sn;

	private String partNumber;

	private String manufacture;

	private String manuTime;

	private String productSn;

	private int healthState;

	private String uuid;

	private String moId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getManuTime() {
		return manuTime;
	}

	public void setManuTime(String manuTime) {
		this.manuTime = manuTime;
	}

	public String getProductSn() {
		return productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	/**
	   0   ：正常
	  -1   ：离线
	  -2   ：未知

	 * @return
	 */
	public int getHealthState() {
		return healthState;
	}

	public void setHealthState(int healthState) {
		this.healthState = healthState;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMoId() {
		return moId;
	}

	public void setMoId(String moId) {
		this.moId = moId;
	}
}
