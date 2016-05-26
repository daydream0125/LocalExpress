package com.localexpress.services;

import com.localexpress.model.DBbean;
import com.localexpress.model.TravelInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelInfoService {

    //发布自己的行程信息供他人查看
    public void issueInfo(TravelInfo travelInfo) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "insert into travelInfo (username,fromAddress,fromTime,toAddress,toTime) values(?,?,?,?,?)";
        //构造参数
        List attr = new ArrayList<String>();
        attr.add(travelInfo.getUserName());
        attr.add(travelInfo.getFromAddress());
        attr.add(travelInfo.getFromTime());
        attr.add(travelInfo.getToAddress());
        attr.add(travelInfo.getToTime());

        dBbean.update(sql, attr);
        dBbean.close();
    }

    //获取全部行程信息 (登陆用户发布的除外)
    public List<TravelInfo> getAllTravleInfo(String userName) throws SQLException {
        DBbean dBbean = new DBbean();
        //根据用户评分排序
        String sql = "select * from travelInfo where username!='"+userName+"' order by assess desc";
        ResultSet rs = dBbean.select(sql);
        List<TravelInfo> list = new ArrayList<TravelInfo>();
        while (rs.next()) {
            list.add(new TravelInfo(rs.getString("username"), rs.getString("fromAddress"), rs.getString("fromTime")
                    , rs.getString("toAddress"), rs.getString("toTime"),rs.getInt("travelID")));
        }
        return list;
    }

    //获取根据搜索调教的行程信息 (登陆用户发布的除外)
    public List<TravelInfo> getTravelInfoBySearch(String fromAddress, String toAddress,String userName) throws SQLException {
        DBbean dBbean = new DBbean();
        String sql = "select * from travelInfo where fromAddress=? and toAddress=? and username!='"+userName+"'";

        List attr = new ArrayList();
        attr.add(fromAddress);
        attr.add(toAddress);

        List<TravelInfo> list = new ArrayList<TravelInfo>();

        ResultSet rs = dBbean.select(sql, attr);
        while (rs.next()) {
            list.add(new TravelInfo(rs.getString("username"), rs.getString("fromAddress"), rs.getString("fromTime")
                    , rs.getString("toAddress"), rs.getString("toTime")));
        }
        return list;
    }
}
