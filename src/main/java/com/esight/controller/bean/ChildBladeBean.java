package com.esight.controller.bean;

public class ChildBladeBean {

	private String dn;
	
	private String ipAddress;

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public ChildBladeBean(){

	}

	public ChildBladeBean(String dn, String ipAddress) {
		this.dn = dn;
		this.ipAddress = ipAddress;
	}

}
