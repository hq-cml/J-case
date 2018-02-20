package com.Jcase;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * 时间相关的操作
 */
public class TimeDemo {
    public static void main(String args[]){
        TimeStr.showTime();
    }
}

class TimeStr {
    public static void showTime() {
        Date da=new Date();
        System.out.println(da);
        SimpleDateFormat ma=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(ma.format(da));
    }
}