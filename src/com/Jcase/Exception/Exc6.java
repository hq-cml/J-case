package com.Jcase.Exception;

/**
 * finally语句使用
 */
public class Exc6 {
    public static void main(String args[]) {
        try {
            FinallyDemo.procA();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        FinallyDemo.procB();
        FinallyDemo.procC();
    }
}

// Demonstrate finally.
class FinallyDemo {
    //try中出现异常,finally将被执行
    static void procA() {
        try {
            System.out.println("inside procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("procA's finally");
        }
    }

    //try中出返回,finally将被执行
    static void procB() {
        try {
            System.out.println("inside procB");
            return;
        } finally {
            System.out.println("procB's finally");
        }
    }

    //try中正常执行完毕,finally仍然将被执行
    static void procC() {
        try {
            System.out.println("inside procC");
        } finally {
            System.out.println("procC's finally");
        }
    }


}