package com.Jcase;

/**
 * StringBuffer效率比String高出1000倍
 */
public class TestStringBuffer {
    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("Hello");
        str1.append(" world");

        System.out.println(str1);

        StringBuffer str2 = new StringBuffer("abcdefhijklmn"); //删除指定的字符
        str2. deleteCharAt(3);
        System.out.println(str2);

        str2.delete(1, 4);//delete()方法一次性删除多个字符, 删除索引值为1~4之间的字符包括索引值1，但不包括4
        System.out.println(str2);

        StringBuffer str3 = new StringBuffer("abcdef");
        str3.insert(3, "xyz");
        System.out.println(str3);

        StringBuffer str4 = new StringBuffer("abcdef");
        str4.setCharAt(3, 'z');
        System.out.println(str4);
    }
}
