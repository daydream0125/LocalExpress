package com.localexpress.model;

public class RequestInfo {
    private String requestName;
    private String acceptName;
    private int travelID;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public RequestInfo(String requestName, String acceptName, int travelID, String time) {
        this.requestName = requestName;
        this.acceptName = acceptName;
        this.travelID = travelID;
        this.time = time;
    }

    public RequestInfo(String requestName, String acceptName, int travelID) {
        this.requestName = requestName;
        this.acceptName = acceptName;
        this.travelID = travelID;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public int getTravelID() {
        return travelID;
    }

    public void setTravelID(int travelID) {
        this.travelID = travelID;
    }
}
