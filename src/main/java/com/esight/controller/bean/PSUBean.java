package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class PSUBean  {
    
    private String name;
    
    private String inputPower;
    
    private String manufacture;
    
    private String version;
    
    private int healthState;
    
    private int inputMode;

    private String moId;

    private String uuid;

    private int presentState;

    private String powerProtocol;

    private String ratePower;

    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInputPower() {
        return inputPower;
    }

    public void setInputPower(String inputPower) {
        this.inputPower = inputPower;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 电源状态，含义如下：    “0”：正常    “-1”：离线    “-2”：未知    其他：故障
     * @return
     */
    public int getHealthState() {
        return healthState;
    }

    public void setHealthState(int healthState) {
        this.healthState = healthState;
    }

    /**
     * 输入电源模式：acInput(1), dcInput(2), acInputDcInput(3)
     * @return
     */
    public int getInputMode() {
        return inputMode;
    }

    public void setInputMode(int inputMode) {
        this.inputMode = inputMode;
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

    public String getPowerProtocol() {
        return powerProtocol;
    }

    public void setPowerProtocol(String powerProtocol) {
        this.powerProtocol = powerProtocol;
    }

    public String getRatePower() {
        return ratePower;
    }

    public void setRatePower(String ratePower) {
        this.ratePower = ratePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
