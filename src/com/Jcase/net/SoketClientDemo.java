package com.Jcase.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by didi on 18/2/20.
 */
public class SoketClientDemo {
    public static void main(String args[]){
        //ServerDemo.server();
        ClientDemo.client();
    }
}

class ClientDemo{
    public static void client(){
        String s = null;
        Socket mySocket;
        DataInputStream in = null;
        DataOutputStream out = null;
        try{
            mySocket = new Socket("localhost",9527);
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
            out.writeUTF("Good Server");
            while(true){
                s = in.readUTF();
                if(s==null)
                    break;
                else
                    System.out.println(s);
            }
            mySocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}