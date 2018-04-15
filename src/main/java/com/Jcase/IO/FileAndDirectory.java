package com.Jcase.IO;

import java.io.*;

/**
 * 目录和文件操作例子
 * 判断输入的绝对路径是代表一个文件或一个目录。
 * 若是文件输出此文件的绝对路径，并判断此文件的文件属性（是否可读写或隐藏）;
 * 若是目录则输出该目录下所有文件（不包括隐藏文件）
 */
public class FileAndDirectory {
    public static void main(String args[]) {
        String FilePath;
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader a=new BufferedReader(in);
        System.out.println("请输入一个绝对路径：");
        try {
            FilePath=a.readLine();  //将 FilePath 作为输入值
            FileDirectory.ScanFile(FilePath);
        }catch (IOException e) {
            System.out.println(e);
        }

    }
}

class FileDirectory{
    public static void ScanFile(String FilePath) throws IOException{
        File FileName=new File(FilePath);  //获得此路径的文件名称
        if (FileName.isDirectory()){  //判断此文件是否为目录
            System.out.println((FileName.getName())+"为一个目录");
            System.out.println("================");
            File FileList[]=FileName.listFiles();  //将目录下所有文件存入数组
            for(int i=0;i<FileList.length;i++){
                if(FileList[i].isHidden()==false){  //判断是否为隐藏文件
                    System.out.println(FileList[i].getName());  //输出非隐藏文件
                }
            }
        }
        else{
            System.out.println((FileName.getName())+"为一个文件");
            System.out.println("================");
            //获得文件绝对路径
            System.out.println("绝对路径为："+FileName.getAbsolutePath());
            //判断此文件是否可读取
            System.out.println(FileName.canRead()?"可读取":"不可读取");
            //判断此文件是否可修改
            System.out.println(FileName.canWrite()?"可修改":"不可修改");
            //判断此文件是否为隐藏
            System.out.println(FileName.isHidden()?"为隐藏文件":"非隐藏文件");
        }
    }
}