package com.advanced.Jcase.Phoenix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 使用phoenix提供的api操作hbase读取数据
 */
public class PhoenixDemo {
    public static void main(String[] args) throws Throwable {
        try {
            // 下面的驱动为Phoenix老版本使用2.11使用，对应hbase0.94+
            // Class.forName("com.salesforce.phoenix.jdbc.PhoenixDriver");

            // phoenix4.3用下面的驱动对应hbase0.98+
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 这里配置zookeeper的地址，可单个，也可多个。可以是域名或者ip
        //String url = "jdbc:phoenix:41.byzoro.com,42.byzoro.com,43.byzoro.com:2181";
        String url = "jdbc:phoenix:192.168.221.133:2181";

        Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        String sql = "select count(1) as num from PINGJIA.SPIDER";

        long time = System.currentTimeMillis();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int count = rs.getInt("num");
            System.out.println("row count is " + count);
        }
        long timeUsed = System.currentTimeMillis() - time;
        System.out.println("time " + timeUsed + "mm");
        // 关闭连接
        rs.close();

        //select
        sql = "select * from PINGJIA.SPIDER limit 10";
        time = System.currentTimeMillis();
        rs = statement.executeQuery(sql);
        while (rs.next()) {
            String id = rs.getString("id");
            String platform = rs.getString("platform");
            String xinhao = rs.getString("xinhao");
            String color = rs.getString("color");
            String date = rs.getString("zhuaqutime");//获取date字段值,数据库中字段为Date类型，这里代码会自动转化为string类型
            System.out.println("id:"+id+"\tplatform:"+platform+"\txinhao:"+xinhao+"\tdate:"+date+"\tcolor:"+color);
        }
        timeUsed = System.currentTimeMillis() - time;
        System.out.println("time " + timeUsed + "mm");


        statement.close();
        conn.close();
    }
}