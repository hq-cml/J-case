package com.advanced.Jcase.reflect;

/**
 * 反射
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private String gender;
    private int age;

    public Person() {

    }
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    //getter和setter方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "姓名:"+name+"  性别:"+gender+"  年龄:"+age;
    }

}

/*
 * 通过用户输入类的全路径，来获取该类的成员方法和属性
 * Declared获取全部不管是私有和公有
 * 1.获取访问类的Class对象
 * 2.调用Class对象的方法返回访问类的方法和属性信息
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            //获取Person类的Class对象
            Class clazz=Class.forName("com.advanced.Jcase.reflect.Person");

            //获取Person类的所有方法信息
            Method[] method=clazz.getDeclaredMethods();
            for(Method m:method){
                System.out.println(m.toString());
            }
            System.out.println();

            //获取Person类的所有成员属性信息
            Field[] field=clazz.getDeclaredFields();
            for(Field f:field){
                System.out.println(f.toString());
            }
            System.out.println();

            //获取Person类的所有构造方法信息
            Constructor[] constructor=clazz.getDeclaredConstructors();
            for(Constructor c:constructor){
                System.out.println(c.toString());
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //利用反射创建对象
        try {
            //获取Person类的Class对象
            Class clazz=Class.forName("com.advanced.Jcase.reflect.Person");
            /**
             * 第一种方法创建对象
             */
            //创建对象
            Person p=(Person) clazz.newInstance();
            //设置属性
            p.setName("张三");
            p.setAge(16);
            p.setGender("男");
            System.out.println(p.toString());

            /**
             * 第二种方法创建
             */
            //先使用Class对象获取指定的Constructor对象
            Constructor c=clazz.getDeclaredConstructor(String.class,String.class,int.class);
            //创建对象并设置属性
            Person p1=(Person) c.newInstance("李四","男",20);
            System.out.println(p1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}