package com.Jcase.Multithreaded;

/**
 * 线程创建, JAVA提供了两种方法
 * 1. 实现Runable接口
 * 2. 继承Thread类
 */
public class createThread {
    public static void main(String args[]) {
        new NewThread1(); // create a new thread
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread Middle.");
        System.out.println();
        System.out.println();

        new NewThread2(); // create a new thread
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}

//实现Runable接口的方式创建线程
//步骤:
//1. 定义类实现Runable接口(实现un方法)
//2. 在类内部实例化一个Thread类的对象
//3. 调用Thread对象的start方法,本质上调用了run方法
class NewThread1 implements Runnable {
    Thread t; //Thread类的对象

    //构造函数, 无返回值
    NewThread1() {
        //在类内部实例化一个Thread类的对象, 将this作为参数
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);

        //调用Thread对象的start方法,本质上调用了run方法
        t.start();
    }

    //实现run方法
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

//实现继承Thread类的方式创建线程
//步骤:
//1. 继承Thread类
//2. 覆盖run()方法
//3. 调用Thread对象的start方法,本质上调用了run方法
class NewThread2 extends Thread {
    NewThread2() {
        //调用父类构造方法
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        //调用start
        start();
    }

    //覆盖run方法
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

