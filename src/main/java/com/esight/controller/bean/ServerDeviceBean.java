package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ServerDeviceBean {
    
    private String dn;
    private String ipAddress;
    private String serverName;
    private String serverModel;
    private String manufacturer;
    private String productSN;
    private String location;
    private String uuid;
    private String status;
    private String description;
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private List<ChildBladeBean> childBlades = new ArrayList<ChildBladeBean>();

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

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerModel() {
        return serverModel;
    }

    public void setServerModel(String serverModel) {
        this.serverModel = serverModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductSN() {
        return productSN;
    }

    public void setProductSN(String productSN) {
        this.productSN = productSN;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<ChildBladeBean> getChildBlades() {
        return childBlades;
    }

    public void setChildBlades(List<ChildBladeBean> childBlades) {
        this.childBlades = childBlades;
    }

    //childBlades
    @Override
    public String toString() {
//        return super.toString();
        
        try {
            ObjectWriter ow = new ObjectMapper().writer();//.withDefaultPrettyPrinter()
            String json = ow.writeValueAsString(this);
            return json;
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
