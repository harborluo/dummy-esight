package com.esight.controller.bean;

/**
 * Created by harbor on 7/18/2017.
 */
public class PCIEBean {

    private String name;

    private int pcieSsdCardHealthStatus;

    private String pcieSsdCardLifeLeft;

    private String uuid;

    private String pciecardManufacturer;

    private String moId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPcieSsdCardHealthStatus() {
        return pcieSsdCardHealthStatus;
    }

    public void setPcieSsdCardHealthStatus(int pcieSsdCardHealthStatus) {
        this.pcieSsdCardHealthStatus = pcieSsdCardHealthStatus;
    }

    public String getPcieSsdCardLifeLeft() {
        return pcieSsdCardLifeLeft;
    }

    public void setPcieSsdCardLifeLeft(String pcieSsdCardLifeLeft) {
        this.pcieSsdCardLifeLeft = pcieSsdCardLifeLeft;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPciecardManufacturer() {
        return pciecardManufacturer;
    }

    public void setPciecardManufacturer(String pciecardManufacturer) {
        this.pciecardManufacturer = pciecardManufacturer;
    }

    public String getMoId() {
        return moId;
    }

    public void setMoId(String moId) {
        this.moId = moId;
    }
}
