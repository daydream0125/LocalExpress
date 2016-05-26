package com.localexpress.model;

public class ExpressPath {
    private String requestName;
    private String acceptName;
    private String fromAddress;
    private String toAddress;
    private String path;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public ExpressPath(String requestName, String acceptName, String fromAddress, String toAddress, String path, String time) {
        this.requestName = requestName;
        this.acceptName = acceptName;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
