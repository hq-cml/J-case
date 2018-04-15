package com.Jcase.Multithreaded;

/**
 * join的使用:
 * 用于主线程等待子线程全部退出
 */
public class joinThread {
    public static void main(String args[]) {
        NewThread3 ob1 = new NewThread3("One");
        NewThread3 ob2 = new NewThread3("Two");
        NewThread3 ob3 = new NewThread3("Three");
        System.out.println("Thread One is alive: "+ ob1.t.isAlive());
        System.out.println("Thread Two is alive: "+ ob2.t.isAlive());
        System.out.println("Thread Three is alive: "+ ob3.t.isAlive());

        // wait for threads to finish
        //主线程阻塞
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Thread One is alive: "+ ob1.t.isAlive());
        System.out.println("Thread Two is alive: "+ ob2.t.isAlive());
        System.out.println("Thread Three is alive: "+ ob3.t.isAlive());
        System.out.println("Main thread exiting.");
    }
}

//实现Runable接口的方式创建线程
class NewThread3 implements Runnable {
    Thread t; //Thread类的对象
    String name;

    //构造函数, 无返回值
    NewThread3(String threadName) {
        //在类内部实例化一个Thread类的对象, 将this作为参数
        this.name = threadName;
        t = new Thread(this, threadName);
        System.out.println("New thread: " + t);

        //调用Thread对象的start方法,本质上调用了run方法
        t.start();
    }

    //实现run方法
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(this.name + " : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(this.name + " interrupted.");
        }
        System.out.println(this.name + " Exiting.");
    }
}