package com.Jcase.IO;

import java.io.*;

/**
 * 面向字节的I/O流
 */
public class IOStream {
    public static void main(String[] args) {
        //ByteIO.readFile("/tmp/test.txt");
        ByteIO.writeFile("/tmp/test.txt");
    }
}

class ByteIO {
    public static void readFile(String file) {
        int data;
        FileInputStream in = null;
        FileOutputStream out = null;
        try{
            //创建输入流
            in=new FileInputStream(file);
            //创建输出流
            out=new FileOutputStream(FileDescriptor.out);

            //in.available表示还剩多少
            while(in.available()>0){
                data = in.read();
                out.write(data);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("找不到该文件！");
        } catch(IOException e){
            System.out.println(e);
        }finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void writeFile(String file) {

        try{
            //FileOutputStream out=new FileOutputStream(file);      //创建文件输出流对象
            FileOutputStream out=new FileOutputStream(file, true);  //创建文件输出流对象, 追加模式
            String s = "XYZ";
            for (int i=0; i<s.length(); i++) {
                out.write((byte)s.toCharArray()[i]);
            }
            out.close();
        }
        catch(FileNotFoundException e){
            System.out.println("找不到该文件！");
        }
        catch(IOException e){}
    }

}
