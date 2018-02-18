package com.Jcase.Exception;

/**
 * 最简单的异常
 * 运行起来用于查看异常的堆栈打印
 */
public class Exc1 {
    static void subroutine() {
        int d = 0;
        int a = 10 / d;
    }
    public static void main(String args[]) {
        Exc1.subroutine();
    }
}

