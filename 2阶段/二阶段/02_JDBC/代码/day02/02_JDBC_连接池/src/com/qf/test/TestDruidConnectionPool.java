package com.qf.test;

import com.qf.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class TestDruidConnectionPool {
    public static void main(String[] args) {
        //System.out.println(JDBCUtils.getConnection());
        //System.out.println(JDBCUtils.getConnection());

        for (int i = 0; i < 51; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Connection conn = JDBCUtils.getConnection();
                    System.out.println(conn);
                    try {
                        conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }).start();
        }

        //com.alibaba.druid.pool.GetConnectionTimeoutException
    }
}
