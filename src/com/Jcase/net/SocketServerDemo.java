package com.Jcase.net;

import java.io.*;
import java.net.*;

/**
 * Socket server例子
 */
public class SocketServerDemo {
    public static void main(String args[]){
        ServerDemo.server();
        //ClientDemo.client();
    }
}

class ServerDemo{
    public static void server(){
        ServerSocket server = null;
        Socket you = null;
        String s = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try{
            server = new ServerSocket(9527);
        }catch(IOException e1){
            e1.printStackTrace();
        }

        try{
            you = server.accept();
            in = new DataInputStream(you.getInputStream());
            out = new DataOutputStream(you.getOutputStream());
            while(true){
                s = in.readUTF();
                if(s!=null)
                    break;
                else
                    System.out.println(s);
            }
            out.writeUTF("客户，你好，我是服务器");
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

