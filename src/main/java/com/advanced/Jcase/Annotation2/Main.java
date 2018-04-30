package com.advanced.Jcase.Annotation2;

public class Main {

    public static void main(String[] args) {
        User f1 = new User();
        f1.setId(10);

        User f2 = new User();
        f2.setUserName("huaqi");

        User f3 = new User();
        f3.setNickName("hq");

        String sql1 = Util.query(f1);
        String sql2 = Util.query(f2);
        String sql3 = Util. query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }
}