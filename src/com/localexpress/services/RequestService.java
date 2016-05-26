package com.localexpress.services;

import com.localexpress.model.DBbean;
import com.localexpress.model.RequestInfo;
import com.localexpress.model.TravelInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RequestService {

    //发送快递请求,即向数据库requestInfo新增记录
    public boolean sendRequest(RequestInfo requestInfo) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "insert into requestInfo (requestName,acceptName,travelID,time) values(?,?,?,?)";


        //获取当前时间
        java.util.Date date = new java.util.Date();
        Timestamp time = new Timestamp(date.getTime());

        List attr = new ArrayList();
        attr.add(requestInfo.getRequestName());
        attr.add(requestInfo.getAcceptName());
        attr.add(requestInfo.getTravelID());
        attr.add(time.toString());

        //更新数据库成功则返回真
        try {
            dBbean.update(sql, attr);
            dBbean.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            dBbean.close();
            return false;
        }
    }

    //为当前登录用户获取所有其他用户发来的快递请求
    public List<RequestInfo> getAllRequest(String userName) throws Exception {
        DBbean dBbean = new DBbean();
        List<RequestInfo> list = new ArrayList<RequestInfo>();
        String sql = "select * from requestInfo where acceptName=?";
        List attr = new ArrayList();
        attr.add(userName);
        ResultSet rs = dBbean.select(sql, attr);
        while (rs.next()) {
            list.add(new RequestInfo(rs.getString("requestName"), rs.getString("acceptName"),
                    rs.getInt("travelID"), rs.getString("time")));
        }
        dBbean.close();
        return list;
    }

    //得到请求的具体快递信息
    public TravelInfo getRequestTravelInfo(String userName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select * from travelInfo where username=?";

        List attr = new ArrayList();
        attr.add(userName);

        ResultSet rs = dBbean.select(sql, attr);
        TravelInfo travelInfo = null;
        if (rs.next()) {
            travelInfo = new TravelInfo(rs.getString("username"), rs.getString("fromAddress"), rs.getString("fromTime"),
                    rs.getString("toAddress"), rs.getString("toTime"));
        }
        dBbean.close();
        return travelInfo;
    }

    //为当前登录用户接受众多请求的一个
    public void acceptRequest(String requestName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select * from requestInfo where requestName=?";
        List attr = new ArrayList();
        attr.add(requestName);
        String acceptName = "";
        ResultSet rs = dBbean.select(sql, attr);

        //从requestInfo获取参数
        if (rs.next()) {
            attr.clear();
            attr.add(rs.getString("requestName"));
            acceptName = rs.getString("acceptName");
            attr.add(acceptName);
        }
        sql = "select * from travelInfo where username='" + acceptName + "'";
        rs = dBbean.select(sql);

        //从travelInfo获取参数
        if (rs.next()) {
            attr.add(rs.getString("fromAddress"));
            attr.add(rs.getString("toAddress"));

            //初始化path信息
            attr.add(rs.getString("fromAddress") + "->");
        }
        //将请求信息和路线信息从数据库中删除,将信息存储至expressPath中
        dBbean.update("delete from travelInfo where username='"+acceptName+"'");
        dBbean.update("delete from requestInfo where requestName='"+requestName+"'");

        sql = "insert into expressPath (requestName,acceptName,fromAddress,toAddress,path)" +
                "values(?,?,?,?,?)";
        dBbean.update(sql, attr);

        dBbean.close();
    }
}
