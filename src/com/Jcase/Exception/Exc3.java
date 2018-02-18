package com.Jcase.Exception;

/**
 * 嵌套的Try
 * 通常用于函数内部和外部均有try的场景
 */
class Exc3 {
    static void nesttry(int a) {
        try { // nested try block
            //a == 1, 除以0异常
            if(a==1) a = a/(a-a);

            //a ==2, 数组越界异常
            if(a==2) {
                int c[] = { 1 };
                c[42] = 99;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            //函数内部只是不活了数组越界
            System.out.println("Array index out-of-bounds: " + e);
        }
    }

    public static void main(String args[]) {
        try {
            int a = args.length;

            int b = 42 / a;
            System.out.println("a = " + a);
            //函数外部捕获了除以0异常
            nesttry(a);
        } catch(ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
    }
}