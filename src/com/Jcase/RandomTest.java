package com.Jcase;

/**
 * 随机数
 *
 */
public class RandomTest {
    public static void main(String args[]){
        int a;
        System.out.print("随机数为：");
        for(int i=1;i<=10;i++){
            a=MyRandom.random(10, 100);
            System.out.print(" "+a);
        }
        System.out.println();
    }
}

class MyRandom {
    public static int random(int min, int max) {
        return (int)((max-min+1)*Math.random()+min);
    }
}

