package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class FanBean {
	
	private String name;
	
	private String rotate;
	
	private String rotatePercent;
	
	private String controlModel;
	
	private int healthState;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRotate() {
		return rotate;
	}

	public void setRotate(String rotate) {
		this.rotate = rotate;
	}

	public String getRotatePercent() {
		return rotatePercent;
	}

	public void setRotatePercent(String rotatePercent) {
		this.rotatePercent = rotatePercent;
	}

	/**
	 * 风扇模式，含义如下：	0：自动	1：手动
	 * @return
	 */
	public String getControlModel() {
		return controlModel;
	}

	public void setControlModel(String controlModel) {
		this.controlModel = controlModel;
	}

	/**
	 * 风扇状态，含义如下：0：正常;	-1：离线;	-2：未知;	其他：故障
	 * @return
	 */
	public int getHealthState() {
		return healthState;
	}

	public void setHealthState(int healthState) {
		this.healthState = healthState;
	}

	

}
