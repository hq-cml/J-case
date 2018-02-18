package com.Jcase.Exception;

/**
 * 最简单的异常捕获
 */
public class Exc2 {
    public static void main(String args[]) {
        int d, a;
        // monitor a block of code.
        try {
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) {
            // catch divide-by-zero error
            System.out.println("Exception: Division by zero. Detail:" + e);
        } catch (Exception e) {
            //终极捕获,所有没有被兜住的异常都在此被兜住
            System.out.println("Exception:" + e);
        }
        System.out.println("After catch statement.");
    }
}