package com.Jcase;

/**
 * 包装类:
 * 8中基础类型均有各自的包装类
 *
 * 通常用于字符串和数据类型互转的时候很有用
 */
public class WrapperClassDemo {
    public static void main(String[] args) {
        WrapperClass wc = new WrapperClass();
        wc.Test();
    }
}

class WrapperClass {
    public void Test() {
        int m = 500;
        Integer obj1 = new Integer(m);  // 手动装箱
        int n = obj1.intValue();        // 手动拆箱
        System.out.println("n = " + n);

        Integer obj2 = new Integer(500);
        System.out.println("obj1 等价于 obj1？" + obj1.equals(obj2));

        //JAVA 1.5 之后支持自动装箱和拆箱
        int i = 500;
        Integer obj3 = i; //自动装箱
        int j = obj3;     //自动拆箱
        System.out.println("j=" + j);

        Integer obj4 = 500;
        System.out.println("obj3 等价于 obj4? " + obj3.equals(obj4));


        //字符串和数字的互转
        String str = "1234";
        int k = 0;
        try {
            k = Integer.parseInt(str, 10);
            System.out.println("转换成功: " + k);
        } catch (Exception e){
            System.out.println("转换失败");
        }

        String s = Integer.toString(k);
        System.out.println("Str: " + s);
    }
}
