package com.Jcase.oop;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

/**
 * 接口应用
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        //接口引用存放实例变量
        AIntfs a1 = new A();
        a1.doSthA();

        //接口引用存放一个更加宽的实例变量
        AIntfs a2 = new AB();
        a2.doSthA();

        BIntfs a3 = new AB();
        a3.doSthB();

        //将实例变量根据实际情况进行类型转换
        BIntfs a4 = (BIntfs)a2;
        a4.doSthB();

        //接口的合并,类似golang的使用习惯
        ABIntfs a5 = new AB();
        a5.doSthA();
        a5.doSthB();
    }
}

//定义一枚接口
interface AIntfs {
    public int doSthA();
}
interface BIntfs {
    public int doSthB();
}
//接口的多重继承
interface ABIntfs extends AIntfs,BIntfs {}

//A实现了接口A
class A implements AIntfs {
    public int doSthA() {
        System.out.println("A doSthA");
        return 0;
    }
}

//AB实现了接口A, 接口B, 接口AB
class AB implements AIntfs, BIntfs, ABIntfs {
    public int doSthA() {
        System.out.println("AB doSthA");
        return 0;
    }

    public int doSthB() {
        System.out.println("AB doSthB");
        return 0;
    }
}