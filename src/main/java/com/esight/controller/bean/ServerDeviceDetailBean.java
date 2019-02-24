package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
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

    private String productSn;

    private String bmcMacAddr;

    private String mode;

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

    @JsonProperty("RAID")
    private List<RAIDBean> RAID = new ArrayList<>();

    @JsonProperty("NetworkCard")
    private List<NetworkCardBean> NetworkCard = new ArrayList<>();

    @JsonProperty("PCIE")
    private List<PCIEBean> PCIE = new ArrayList<>();
    
    private List<BoardBean> board = new ArrayList<>();

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

    @JsonProperty("MemoryCapacity")
    public String getMemoryCapacity() {
        return memoryCapacity;
    }

    @JsonProperty("MemoryCapacity")
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


    @JsonProperty("CPU")
    public List<CPUBean> getCPU() {
        return CPU;
    }

    @JsonProperty("CPU")
    public void setCPU(List<CPUBean> cPU) {
        CPU = cPU;
    }

    @JsonProperty("Memory")
    public List<MemoryBean> getMemory() {
        return Memory;
    }

    @JsonProperty("Memory")
    public void setMemory(List<MemoryBean> memory) {
        Memory = memory;
    }

    @JsonProperty("Disk")
    public List<DiskBean> getDisk() {
        return Disk;
    }

    @JsonProperty("Disk")
    public void setDisk(List<DiskBean> disk) {
        Disk = disk;
    }

    @JsonProperty("PSU")
    public List<PSUBean> getPSU() {
        return PSU;
    }

    @JsonProperty("PSU")
    public void setPSU(List<PSUBean> pSU) {
        PSU = pSU;
    }

    @JsonProperty("Fan")
    public List<FanBean> getFan() {
        return Fan;
    }

    @JsonProperty("Fan")
    public void setFan(List<FanBean> fan) {
        Fan = fan;
    }

    public List<BoardBean> getBoard() {
        return board;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getBmcMacAddr() {
        return bmcMacAddr;
    }

    public void setBmcMacAddr(String bmcMacAddr) {
        this.bmcMacAddr = bmcMacAddr;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setBoard(List<BoardBean> board) {
        this.board = board;
    }

    @JsonProperty("RAID")
    public List<RAIDBean> getRAID() {
        return RAID;
    }

    @JsonProperty("RAID")
    public void setRAID(List<RAIDBean> RAID) {
        this.RAID = RAID;
    }

    @JsonProperty("NetworkCard")
    public List<NetworkCardBean> getNetworkCard() {
        return NetworkCard;
    }

    @JsonProperty("NetworkCard")
    public void setNetworkCard(List<NetworkCardBean> networkCard) {
        NetworkCard = networkCard;
    }

    @JsonProperty("PCIE")
    public List<PCIEBean> getPCIE() {
        return PCIE;
    }

    @JsonProperty("PCIE")
    public void setPCIE(List<PCIEBean> PCIE) {
        this.PCIE = PCIE;
    }

    @Override
    public String toString() {
        try {
            ObjectWriter ow = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false).writer();
            //.withDefaultPrettyPrinter()

            String json = ow.writeValueAsString(this);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
