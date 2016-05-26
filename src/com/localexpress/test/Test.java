package com.localexpress.test;

import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        java.util.Date date=new java.util.Date();
        Timestamp time=new Timestamp(date.getTime());
        System.out.println(time);
    }
}
