package com.localexpress.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBbean {
    private Connection conn = null;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    public DBbean() {
        String url = "jdbc:mysql://localhost:3306/local_express?characterEncoding=UTF-8";
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("获取连接失败");
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }
    }

    //准备SQL语句,即填充占位符
    private void preparedSql(String sql, List parm) {
        try {
            p = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (parm != null) {
            for (int i = 0; i < parm.size(); i++) {
                try {
                    p.setObject(i + 1, parm.get(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //执行SQL语句
    public void update(String sql, List parm) {
        preparedSql(sql, parm);
        try {
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet select(String sql,List parm) {
        preparedSql(sql,parm);

        try {
            rs = p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet select(String sql) throws SQLException {
        p = conn.prepareStatement(sql);
        rs = p.executeQuery();
        return rs;
    }
    public void close () throws Exception {
        if(conn!=null) {
            conn.close();
        }
        if(p != null) {
            p.close();
        }
        if(rs != null) {
            rs.close();
        }
    }
    public static void main(String[] args) throws SQLException {

    }
}
