package com.Jcase.Multithreaded;

/**
 * 线程互斥
 * synchronized就相当于互斥锁的功效
 * 它可以修饰一个方法, 或者修饰一个语句块
 */
public class mutexThread {
    public static void main(String args[]) {
        Callee target = new Callee();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
        //wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

class Callee {
    //synchronized相当于临界区或者说互斥锁的功效
    //synchronized放在这里, 相当于修饰方法
    //synchronized void call(String msg) {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callee target;
    Thread t;
    public Caller(Callee targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    public void run() {
        //target.call(msg);
        //synchronized用于修饰一个语句块
        synchronized(target) {
            target.call(msg);
        }
    }
}
