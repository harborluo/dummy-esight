package com.esight.controller.bean;

/**
 * Created by harbor on 7/18/2017.
 */
public class RAIDBean {
    private String name;
    private int healthState;
    private String raidType;
    private String interfaceType;
    private String bbuType;
    private String moId;
    private String uuid;

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

    public String getRaidType() {
        return raidType;
    }

    public void setRaidType(String raidType) {
        this.raidType = raidType;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getBbuType() {
        return bbuType;
    }

    public void setBbuType(String bbuType) {
        this.bbuType = bbuType;
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
}
