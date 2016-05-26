package com.localexpress.services;

import com.localexpress.model.DBbean;
import com.localexpress.model.ExpressPath;
import com.localexpress.model.ExpressRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SendExpressService {

    public void updatePath(String acceptName,String path) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "update expressPath set path=concat(path,?),time=? where acceptName=?";
        List attr = new ArrayList();

        //获取当前时间
        java.util.Date date = new java.util.Date();
        Timestamp time = new Timestamp(date.getTime());

        //将路径信息拼接起来
        attr.add("->"+path);
        attr.add(time.toString());
        attr.add(acceptName);

        dBbean.update(sql,attr);
        dBbean.close();
    }

    //提供用户查看自己的快递派送信息
    public ExpressPath getExpressPath(String requestName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select * from expressPath where requestName=?";

        List attr = new ArrayList();
        attr.add(requestName);
        ExpressPath expressPath = null;
        ResultSet rs = dBbean.select(sql,attr);
        if(rs.next()) {
            expressPath = new ExpressPath(rs.getString("requestName"),rs.getString("acceptName"),
                    rs.getString("fromAddress"),rs.getString("toAddress"),rs.getString("path"),rs.getString("time"));
        }
        dBbean.close();
        return  expressPath;
    }

    //提供派送人查看派送的快递信息
    public ExpressPath getExpressPath2(String userName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select * from expressPath where acceptName=?";

        List attr = new ArrayList();
        attr.add(userName);
        ExpressPath expressPath = null;
        ResultSet rs = dBbean.select(sql,attr);
        if(rs.next()) {
            expressPath = new ExpressPath(rs.getString("requestName"),rs.getString("acceptName"),
                    rs.getString("fromAddress"),rs.getString("toAddress"),rs.getString("path"),rs.getString("time"));
        }
        dBbean.close();
        return  expressPath;
    }

    public void updateFinish1(String acceptName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "update expressPath set finish1=1 where acceptName='"+acceptName+"'";
        dBbean.update(sql);
        dBbean.close();

    }
    public void updateFinish2(String userName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "update expressPath set finish2=1 where requestName='"+userName+"'";
        dBbean.update(sql);
        dBbean.close();
    }
    public boolean isFinish(String userName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select finish1,finish2 from expressPath where acceptName='"+userName+"'";

        ResultSet rs = dBbean.select(sql);
        if(rs.next()) {
            if(rs.getInt("finish1") == rs.getInt("finish2")) {
                dBbean.close();
                return true;
            }

        }
        dBbean.close();
        return false;
    }
    //通过发送快递的人得到请求人
    private String getRequestName(String acceptName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select requestName from expressPath  where acceptName='"+acceptName+"'";
        ResultSet rs = dBbean.select(sql);
        String requestName="";
        if(rs.next()) {
            requestName = rs.getString("requestName");
        }
        dBbean.close();
        return requestName;
    }
    public void updateMoney(String userName) throws Exception {
        DBbean dBbean = new DBbean();

        //做相应的金额操作,发送成功发送人获得5元,请求人减少5员
        dBbean.update("update user set money=money+5 where username='"+userName+"'");
        dBbean.update("update user set money=money-5 where username='"+getRequestName(userName)+"'");


        //将此快递信息保存至快递记录中


        List attr = new ArrayList();
        ResultSet rs = dBbean.select("select * from expressPath where acceptName='"+userName+"'");
        while(rs.next()) {
            attr.add(rs.getString("requestName"));
            attr.add(rs.getString("requestName"));
            attr.add(rs.getString("requestName"));
            attr.add(rs.getString("requestName"));
            attr.add(rs.getString("requestName"));
        }

        String insertSQL = "insert into expressRecord(requestName,requestName,requestName,requestName,requestName)" +
                "values(?,?,?,?,?)";
        dBbean.update(insertSQL,attr);

        //将快递行程信息删除
        String sql = "delete from expressPath where acceptName='"+userName+"'";
        dBbean.update(sql);
        dBbean.close();
    }

    public static void main(String[] args) throws Exception {
        SendExpressService sendExpressService = new SendExpressService();
        sendExpressService.updateFinish2("hanhao");
    }


    public List getExpressInfo(String requestName) throws SQLException {
        DBbean dBbean = new DBbean();
        ResultSet rs = dBbean.select("select * from expressRecord where requestName='"+requestName+"'");
        List list = new ArrayList();
        while(rs.next()) {
            list.add(new ExpressRecord(rs.getString("requestName"),rs.getString("acceptName"),rs.getString("fromAddress")
            ,rs.getString("toAddress"),rs.getString("time")));
        }
        return list;
    }
}
