package com.Jcase.Multithreaded;

/**
 * 线程同步, 实现一个生产消费者
 */
public class syncThread {
    public static void main(String args[]) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q, "ConsumerA");
        new Consumer(q, "ConsumerB");
        System.out.println("Press Control-C to stop.");
    }
}

class Q {
    int n;
    boolean valueSet = false;
    synchronized int get(String name) {
        if (!valueSet) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println(name + " Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    String Name;
    Consumer(Q q, String name) {
        this.q = q;
        this.Name = name;
        new Thread(this, name).start();
    }
    public void run() {
        while(true) {
            q.get(this.Name);
        }
    }
}
