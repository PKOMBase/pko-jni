package com.thread.sync;

public class MyThread1 extends Thread {

    private String message;

    public MyThread1(String message) {
        super();
        this.message = message;
    }

    private void doSomething(String message) {
        System.out.println("doSomething exeuted by thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {

            }
        }
        System.out.println("message:" + message);
    }

    @Override
    public void run() {
        doSomething(message);
    }
}
