package com.Jcase;

/**
 * 内部类的使用
 */

public class InnerClassDemo {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        inner.doStuff();
        System.out.println(outer.size);
        System.out.println(inner.counter);
    }
}

//内部类的定义,必须先有外部类
class Outer {
    public int size;

    //内部类
    public class Inner {
        public int counter = 10;
        public void doStuff() {
            size ++;
        }
    }
}
