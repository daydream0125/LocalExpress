package com.localexpress.model;

public class ExpressRecord {
    private String requestName;
    private String acceptName;
    private String fromAddress;
    private String toAddress;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public ExpressRecord(String requestName, String acceptName, String fromAddress, String toAddress, String time) {
        this.requestName = requestName;
        this.acceptName = acceptName;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.time = time;
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

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

}
