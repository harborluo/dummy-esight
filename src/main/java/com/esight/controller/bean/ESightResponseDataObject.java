package com.esight.controller.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harbor on 6/21/2017.
 */
public class ESightResponseDataObject<T> {

    private int size;

    private int totalPage;

    private int code;

    private List<T> data = new ArrayList<T>();

    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

}

