package com.Jcase.oop;

/**
 * 抽象类的应用
 */
public class AbstractClass {
    public static void main(String[] args) {
        //抽象变量
        AbsPeople t = new Teacher();
        AbsPeople d = new Driver();

        t.work();
        d.work();
    }

}

//定义一个抽象类
abstract class AbsPeople {
    private String name; //实例变量

    //getter和setter
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //定义抽象方法
    public abstract void work();
}

//实现抽象类
class Teacher extends AbsPeople{
    //实现抽象方法
    public void work() {
        System.out.println("I'm teaching");
    }
}

class Driver extends AbsPeople{
    //实现抽象方法
    public void work() {
        System.out.println("I'm driving");
    }
}