package com.localexpress.model;

public class User {
    private String userName;
    private String password;
    private String sex;
    private String tel;
    private String address;
    private String email;
    private String realName;
    private String flag;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User(String userName, String password, String sex, String tel, String address, String email, String realName, String flag, int money) {

        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.realName = realName;
        this.flag = flag;
        this.money = money;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public User(String userName, String password, String sex, String tel,
                String address, String email, String realName, String flag) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.realName = realName;
        this.flag = flag;

    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
