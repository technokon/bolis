package com.tkont.data.bolis;

import java.util.Date;

/**
 * Created by iakoupov on 2019-08-19.
 */
public class DeviceData {

    private String name;
    private int temp;
    private int operationCapacity;
    private Date start;
    private int itemProcessingId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getOperationCapacity() {
        return operationCapacity;
    }

    public void setOperationCapacity(int operationCapacity) {
        this.operationCapacity = operationCapacity;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getItemProcessingId() {
        return itemProcessingId;
    }

    public void setItemProcessingId(int itemProcessingId) {
        this.itemProcessingId = itemProcessingId;
    }
}
