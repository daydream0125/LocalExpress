package com.localexpress.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail {

    /*
     * 利用 Apache Commons Email 组件（commons-email-1.1）发送邮件
     */


    //获得随机生成的六位码
    private static String getRandomKey() {
        return ""+(int) ((Math.random()*9+1)*100000);
    }
    public static String sendMail(String  address) {
        //如果发送普通的邮件，使用这个类就可以了
        SimpleEmail email = new SimpleEmail();

        //指定要使用的邮件服务器
        email.setHostName("121.195.178.51");

        //使用163的邮件服务器需提供在163已注册的用户名、密码
        email.setAuthentication("15755127166@163.com", "15755127166");
        email.setCharset("UTF-8");
        String msg = getRandomKey();
        try {

            email.setFrom("15755127166@163.com");//设置发件人
            email.addTo(address);//设置收件人
            email.setSubject("同城快递");//设置主题
            email.setMsg("欢迎您注册同城快递,您的验证码是"+msg);//设置邮件内容
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return msg;
    }
    public static void main(String[] args) {

        System.out.println(sendMail("237131504@qq.com"));
    }

}
