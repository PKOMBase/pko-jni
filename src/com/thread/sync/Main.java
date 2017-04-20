package com.thread.sync;

public class Main {

    public static void main(String[] args) {
        System.out.println("main excuted by thread: " + Thread.currentThread().getName());
        // 通过Runnble.run()的调用，确定代码被哪个线程执行
        MyThread1 myThread1 = new MyThread1("Hello world! thread1. ");
        myThread1.start();
        MyThread2 myThread2 = new MyThread2("Hello world! thread2. ");
        // myThread2.run();
        Thread myThread = new Thread(myThread2, "myThread");
        myThread.start();
    }

}
