package com.Jcase.net;

import java.net.*;
/**
 * Java 网络
 * InetAddress类
 */
public class InetAddressDemo {
    public static void main(String args[]){
        try{ //以下代码通过域名建立InetAddress对象：
            InetAddress addr = InetAddress.getByName("www.baidu.com");
            String domainName = addr.getHostName();//获得主机名
            String IPName = addr.getHostAddress(); //获得IP地址
            System.out.println(domainName);
            System.out.println(IPName);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
}
