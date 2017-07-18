package com.esight.controller.bean;

/**
 * Created by harbor on 7/18/2017.
 */
public class NetworkCardBean {
    private String netWorkCardName;
    private String macAdress;
    private String moId;
    private String uuid;

    public String getNetWorkCardName() {
        return netWorkCardName;
    }

    public void setNetWorkCardName(String netWorkCardName) {
        this.netWorkCardName = netWorkCardName;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
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
