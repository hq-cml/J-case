package com.advanced.Jcase.GenericType;

/**
 * 泛型的通配
 */
import java.util.*;

public class WildcardDemo {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);
    }

    //HQ：这个方法不是泛型方法，只不过他的参数是一个泛型类的父类
    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }
}