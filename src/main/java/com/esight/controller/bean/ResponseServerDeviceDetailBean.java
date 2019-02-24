package com.esight.controller.bean;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ResponseServerDeviceDetailBean extends ESightResponseDataObject<ServerDeviceDetailBean> {


    @Override
    public String toString() {
//        return super.toString();

        try {
            ObjectWriter ow = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false).writer();//.withDefaultPrettyPrinter()
            String json = ow.writeValueAsString(this);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

}
