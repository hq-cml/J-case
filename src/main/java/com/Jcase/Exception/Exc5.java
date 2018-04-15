package com.Jcase.Exception;

/**
 * 异常的主动抛出
 * throw语句主动抛出异常
 * throws语句声明可能抛出的不被处理的异常
 */
public class Exc5 {
    public static void main(String args[]) {
        try {
            ThrowDemo.demoproc();
        } catch(NullPointerException e) {
            System.out.println("Recaught: " + e);
        }

        try {
            ThrowsDemo.throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Caught: " + e);
        }
    }
}

class ThrowDemo {
    static void demoproc() {
        try {
            //创建并抛出异常
            throw new NullPointerException("demo");
        } catch(NullPointerException e) {
            System.out.println("Caught inside demoproc.");
            //再次抛出异常
            throw e; // rethrow the exception
        }
    }
}

// This is now correct.
class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("Inside throwOne.");
        throw new IllegalAccessException("demo");
    }

}