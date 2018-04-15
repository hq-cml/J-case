package com.Jcase.IO;

import sun.misc.Cache;

import java.io.*;
import java.lang.reflect.Field;

/**
 * 面向字符的I/O流
 * 文件读取
 */
public class ReaderAndWriter {
    public static void main(String[] args) {
        ReaderWriter.readFile("/tmp/test.txt");
        ReaderWriter.readFileWithBuffer("/tmp/test.txt");
        ReaderWriter.writeFile("/tmp/test.txt");
        ReaderWriter.writeFileWithBuffer("/tmp/test.txt");
    }
}

class ReaderWriter {

    //读取一个文件
    public static void readFile(String file) {
        char a[]=new char[1000]; //创建可容纳 1000 个字符的数组
        FileReader b = null;
        try {
            b = new FileReader(file);
            int num = b.read(a); //将数据读入到数组 a 中，并返回字符数
            String str=new String(a, 0, num); //将字符串数组转换成字符串
            System.out.println("读取的字符个数为：" + num + ",内容为：\n");
            System.out.println(str);
            b.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (b != null) {
                try {
                    b.close();
                }catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    //利用带缓冲的reader, 读取一个文件
    public static void readFileWithBuffer(String file) {
        int count=0;
        String OneLine;
        FileReader a = null;
        BufferedReader b = null;
        try{
            //首先创建FileReader类
            a=new FileReader(file);
            //以FileReader的实例作为参数创建BufferedReader
            b=new BufferedReader(a);
            while((OneLine=b.readLine())!=null){  //每次读取 1 行
                count++;  //计算读取的行数
                System.out.println(OneLine);
            }
            System.out.println("\n共读取了"+count+"行");

        } catch(IOException io){
            System.out.println("出错了!"+io);
        } finally {
            try {
               if (b != null) b.close();
               if (a != null) a.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }

    //写入一个文件
    public static void writeFile(String file) {
        FileWriter a = null;
        try{
            //a = new FileWriter(file);       //普通写
            a = new FileWriter(file, true);   //追加写
            for(int i=32;i<126;i++){
                a.write(i);
            }
            System.out.println("写入成功");
        } catch(IOException e){
            System.out.println(e);
        } finally {
            try {
                if (a != null) a.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void writeFileWithBuffer(String file) {
        BufferedWriter out = null;
        try{
            out=new BufferedWriter(new FileWriter(file, true));
            out.newLine();    //写入换行符
            out.write("ABC"); //将1行数据写入输出流
            out.newLine();    //写入换行符
            out.write("EFG");
            out.newLine();    //写入换行符
            out.flush();
            System.out.println("写入成功");
        }catch(IOException e){
            System.out.println("出现错误"+e);
        }finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}