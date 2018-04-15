package com.Jcase.net;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * 发送http get请求
 */
public class HttpDemo {
    public static void main(String args[]){
        HttpRequest.readByURL("http://www.baidu.com");
    }
}

class HttpRequest {

    public static void readByURL(String urlName){
        try{
            URL url = new URL(urlName);             //由网址创建URL对象
            URLConnection tc = url.openConnection();//获得URLConnection对象
            tc.connect();                           //建立连接
            InputStreamReader in = new InputStreamReader(tc.getInputStream());
            BufferedReader dis = new BufferedReader(in);//采用缓冲式输入
            String inline;
            while((inline = dis.readLine())!=null){
                //showArea.append(inline +”\n”);
                System.out.println(inline);
            }
            dis.close();//网上资源使用结束后，数据流及时关闭
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
