package com.localexpress.model;

public class TravelInfo {
    private String userName;
    private String fromAddress;
    private String fromTime;
    private String toAddress;
    private String toTime;
    private int travelID;

    public int getTravelID() {
        return travelID;
    }

    public void setTravelID(int travelID) {
        this.travelID = travelID;
    }

    public TravelInfo(String userName, String fromAddress, String fromTime, String toAddress, String toTime) {
        this.userName = userName;
        this.fromAddress = fromAddress;
        this.fromTime = fromTime;
        this.toAddress = toAddress;
        this.toTime = toTime;
    }

    public TravelInfo(String userName, String fromAddress, String fromTime, String toAddress, String toTime, int travelID) {
        this.userName = userName;
        this.fromAddress = fromAddress;
        this.fromTime = fromTime;
        this.toAddress = toAddress;
        this.toTime = toTime;
        this.travelID = travelID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}
