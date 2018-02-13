package com.Jcase.oop;

/**
 * OOP例子.
 */
public class Dog {
    //成员变量
    String name;
    int    age;

    //构造方法, 无返回值
    Dog(String strName, int iAge) {
        name = strName;
        age = iAge;
        System.out.println("Dog " + name + " is created!");
    }

    //普通方法
    void bark() {
        System.out.println("My name is " + name );
    }

    public static void main(String[] args) {
        //实例化
        Dog dog1 = new Dog("Jack", 5);
        dog1.bark();

        //访问成员变量
        System.out.println("The dog's age is " + dog1.age);
    }

}
