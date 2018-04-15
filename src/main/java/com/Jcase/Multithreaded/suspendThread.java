package com.Jcase.Multithreaded;

/**
 * 线程的挂起(暂停) & 恢复
 */
public class suspendThread {
    public static void main(String args[]) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resuming thread One");
            ob2.mysuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}

class NewThread implements Runnable {
    String name; // name of thread
    Thread t;
    boolean suspendFlag;  //自定义标记用于标识是否suspend

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start(); // Start the thread
    }

    public void run() {
        try {
            for(int i = 0; i < 15; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                //互斥临界区
                synchronized(this) {
                    while(suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    //挂起
    void mysuspend() {
        suspendFlag = true;
    }

    //恢复
    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}
