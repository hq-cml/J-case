package com.Jcase.oop;

import java.util.Objects;

/**
 * 类的继承
 * super关键字用法
 * 多态, 动态绑定
 * instance 运算符
 */
public class AnimalTest {
    public static void main(String[] args) {
        Bird bird = new Bird("haha", 5);
        bird.move();
        bird.say();

        //多肽, 父类引用可以存储父类变量或者子类变量,并且表现出不同行为
        Animal obj = new Animal("Ha");
        obj.say();

        //instance 运算符
        if (obj instanceof Object) {
            System.out.println("Obj is Object");
        }
        if (obj instanceof Animal) {
            System.out.println("Obj is Animal");
        }
        if (obj instanceof Bird) {
            System.out.println("Obj is Bird");
        }

        obj = new Bird("haha", 10);
        obj.say();

        //instance 运算符
        if (obj instanceof Object) {
            System.out.println("Obj is Object");
        }
        if (obj instanceof Animal) {
            System.out.println("Obj is Animal");
        }
        if (obj instanceof Bird) {
            System.out.println("Obj is Bird");
        }
    }
}

class Animal {
    private String desc = "Aminals's Desc";
    String name;

    public Animal(String name) { //构造函数
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void move() {
        System.out.println("Animal move");
    }

    public void say() {
        System.out.println("Animal say ");
    }
}

class Bird extends Animal {
    int age;

    public Bird(String name, int age) {
        super(name); //调用父类构造函数
        this.age = age;
    }

    //覆盖父类的方法
    public void move() {
        super.move(); //通过super调用父类的同名方法
        System.out.println("Bird move");

        //通过getter方法调用弗雷隐藏的成员变量
        System.out.println("Animal's desc: " + super.getDesc());
    }

    //覆盖父类的方法
    public void say() {
        System.out.println("Name is " + this.name + ". Age is " + this.age);
    }
}
