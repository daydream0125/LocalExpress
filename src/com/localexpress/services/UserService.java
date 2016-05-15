package com.localexpress.services;

import com.localexpress.model.DBbean;
import com.localexpress.model.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//完成用户操作的类
public class UserService {

    //登陆时检查用户有效性
    public boolean checkUser(String userName, String password) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select * from user where username=? and password=?";

        List attr = new ArrayList<String>();
        attr.add(userName);
        attr.add(password);

        ResultSet rs = dBbean.select(sql, attr);
        if (rs.next()) {
            dBbean.close();
            return true;
        } else {
            dBbean.close();
            return false;
        }
    }
    //根据用户名判断user表中是否存在已存在该用户名,用于用户注册时防止用户名重复
    public boolean userNameIsExist(String userName) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "select * from user where username=?";
        List attr = new ArrayList();
        attr.add(userName);
        ResultSet rs = dBbean.select(sql,attr);

        //查找到数据则返回假
        if (rs.next()) {
            dBbean.close();
            return true;
        } else {
            dBbean.close();
            return false;
        }
    }

    //根据注册信息添加用户
    public void addUser(User user) throws Exception {
        DBbean dBbean = new DBbean();
        String sql = "insert into user (username,password,sex,realname,email,address,tel) values(?,?,?,?,?,?,?)";
        List attr = new ArrayList();
        //设置参数
        attr.add(user.getUserName());
        attr.add(user.getPassword());
        attr.add(user.getSex());
        attr.add(user.getRealName());
        attr.add(user.getEmail());
        attr.add(user.getAddress());
        attr.add(user.getTel());

        //添加记录
        dBbean.update(sql, attr);

        //关闭连接
        dBbean.close();
    }
}
