package com.esight.controller.bean;





public class DiskBean  {
    
    private String name;
    
    private String location;
    
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHealthState() {
        return healthState;
    }

    public void setHealthState(int healthState) {
        this.healthState = healthState;
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
