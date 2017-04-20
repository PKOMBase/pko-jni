package com.thread.state;

import java.util.concurrent.CountDownLatch;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread mainThread = Thread.currentThread();
        System.out.println("excute by main: " + mainThread.getName());

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Thread t1Thread = Thread.currentThread();
                System.out.println("excute by thread: " + t1Thread.getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    System.out.println("acquired the lock by thread:" + t1Thread.getName());
                    System.out.println("step3, thread state:" + t1Thread.getState() + ", main state:"
                            + mainThread.getState());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }
        }, "t1");

        System.out.println("step1, thread state:" + thread.getState() + ", main state:" + mainThread.getState());

        thread.start();

        synchronized (object) {
            System.out.println("acquired the lock by main:" + mainThread.getName());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("step2, thread state:" + thread.getState() + ", main state:" + mainThread.getState());
        }

        countDownLatch.await();

        System.out.println("step4, thread state:" + thread.getState() + ", main state:" + mainThread.getState());

    }
}
