package com.advanced.Jcase.Phoenix;

/**
 * 利用Phoenix访问Hbase
 *
 * 封装出一个Client，将所有的hbase访问转化成一个json
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.phoenix.jdbc.PhoenixResultSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PhoenixClient {

    /**
     * 利用静态块的方式初始化Driver，防止Tomcat加载不到（有时候比较诡异）
     */
    static {
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个Hbase-Phoenix的连接
     *
     * @param host
     *            zookeeper的master-host
     * @param port
     *            zookeeper的master-port
     * @return
     */
    private static Connection getConnection(String host, String port) {
        Connection cc = null;
        final String url = "jdbc:phoenix:" + host + ":" + port;

        if (cc == null) {
            try {
                // Phoenix DB不支持直接设置连接超时
                // 所以这里使用线程池的方式来控制数据库连接超时
                final ExecutorService exec = Executors.newFixedThreadPool(1);
                Callable<Connection> call = new Callable<Connection>() {
                    public Connection call() throws Exception {
                        return DriverManager.getConnection(url);
                    }
                };
                Future<Connection> future = exec.submit(call);
                // 如果在5s钟之内，还没得到 Connection 对象，则认为连接超时，不继续阻塞，防止服务夯死
                cc = future.get(1000 * 20, TimeUnit.MILLISECONDS);
                exec.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        return cc;
    }

    /**
     * 根据host、port，以及sql查询hbase中的内容;根据phoenix支持的SQL格式，查询Hbase的数据，并返回json格式的数据
     *
     * @param host
     *            zookeeper的master-host
     * @param port
     *            zookeeper的master-port
     * @param phoenixSQL
     *            sql语句
     * @return json-string
     * @return
     */
    public static String execSql(String host, String port, String phoenixSQL) {
        if (host == null || port == null || host.trim() == ""
                || port.trim() == "") {
            return "必须指定hbase master的IP和端口";
        } else if (phoenixSQL == null || phoenixSQL.trim() == "") {
            return "请指定合法的Phoenix SQL！";
        }

        String result = "";
        try {
            // 耗时监控：记录一个开始时间
            long startTime = System.currentTimeMillis();

            // 获取一个Phoenix DB连接
            Connection conn = PhoenixClient.getConnection(host, port);
            if (conn == null) {
                return "Phoenix DB连接超时！";
            }

            // 准备查询
            Statement stmt = conn.createStatement();
            PhoenixResultSet set = (PhoenixResultSet) stmt.executeQuery(phoenixSQL);

            //查询出来的列是不固定的，所以这里通过遍历的方式获取列名
            ResultSetMetaData meta = set.getMetaData();
            ArrayList<String> cols = new ArrayList<String>();

            //把最终数据都转成JSON返回
            JSONArray jsonArr = new JSONArray();
            while (set.next()) {
                if (cols.size() == 0) {
                    for (int i = 1, count = meta.getColumnCount(); i <= count; i++) {
                        cols.add(meta.getColumnName(i));
                    }
                }

                JSONObject json = new JSONObject();
                for (int i = 0, len = cols.size(); i < len; i++) {
                    json.put(cols.get(i), set.getString(cols.get(i)));
                }
                jsonArr.put(json);
            }
            // 耗时监控：记录一个结束时间
            long endTime = System.currentTimeMillis();

            // 结果封装
            JSONObject data = new JSONObject();
            data.put("data", jsonArr);
            data.put("cost", (endTime - startTime) + " ms");
            result = data.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "SQL执行出错：" + e.getMessage();
        } catch (JSONException e) {
            e.printStackTrace();
            return "JSON转换出错：" + e.getMessage();
        }
        return result;
    }

    /**
     * Just for phoenix test！
     * @param args
     */
    public static void main(String[] args) {
        String pheonixSQL = "select * from PINGJIA.SPIDER limit 10";
        String host = "192.168.221.133";
        if(args.length >= 1) {
            host = args[0];
        }
        String result = PhoenixClient.execSql(host, "2181", pheonixSQL);
        System.out.println(result);
    }
}

