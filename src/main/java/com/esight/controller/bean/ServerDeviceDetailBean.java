package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class ServerDeviceDetailBean {

	private String dn;
	
    private String ipAddress;
    
    private String name;
    
    private String type;
    
    private String uuid;
    
    private int status;
    
    private String desc;
    
    private int cpuNums;
    
    private int cpuCores;
    
    @JsonProperty("MemoryCapacity")
    private String memoryCapacity;
    
    @JsonProperty("CPU")
	private List<CPUBean> CPU = new ArrayList<CPUBean>();
	
	@JsonProperty("Memory")
	private List<MemoryBean> Memory = new ArrayList<MemoryBean>();
	
	@JsonProperty("Disk")
	private List<DiskBean> Disk = new ArrayList<DiskBean>();
	
	@JsonProperty("PSU")
	private List<PSUBean> PSU = new ArrayList<PSUBean>();
	
	@JsonProperty("Fan")
	private List<FanBean> Fan = new ArrayList<FanBean>();
	
	private List<BoardBean> board = new ArrayList<BoardBean>();

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMemoryCapacity() {
		return memoryCapacity;
	}

	public void setMemoryCapacity(String memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}

	public int getCpuNums() {
		return cpuNums;
	}

	public void setCpuNums(int cpuNums) {
		this.cpuNums = cpuNums;
	}

	public int getCpuCores() {
		return cpuCores;
	}

	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}
	
	

	public List<CPUBean> getCPU() {
		return CPU;
	}

	public void setCPU(List<CPUBean> cPU) {
		CPU = cPU;
	}

	public List<MemoryBean> getMemory() {
		return Memory;
	}

	public void setMemory(List<MemoryBean> memory) {
		Memory = memory;
	}

	public List<DiskBean> getDisk() {
		return Disk;
	}

	public void setDisk(List<DiskBean> disk) {
		Disk = disk;
	}

	public List<PSUBean> getPSU() {
		return PSU;
	}

	public void setPSU(List<PSUBean> pSU) {
		PSU = pSU;
	}

	public List<FanBean> getFan() {
		return Fan;
	}

	public void setFan(List<FanBean> fan) {
		Fan = fan;
	}

	public List<BoardBean> getBoard() {
		return board;
	}

	public void setBoard(List<BoardBean> board) {
		this.board = board;
	}

	@Override
	public String toString() {
//		return super.toString();
		
		try {
			ObjectWriter ow = new ObjectMapper().writer();//.withDefaultPrettyPrinter()
			String json = ow.writeValueAsString(this);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
