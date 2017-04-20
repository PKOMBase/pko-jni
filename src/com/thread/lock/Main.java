package com.thread.lock;

import java.util.concurrent.CountDownLatch;

public class Main {
    static MyLock lock = new MyLock();
    static Integer num = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(20);
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("==currentThread start==" + Thread.currentThread().getName());
                    // Thread.sleep(500);
                    num++;
                    System.out.println("==currentThread end==");
                    countDownLatch.countDown();
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread thread = null;
        for (int i = 0; i < 20; i++) {
            thread = new Thread(runnable, "t" + i);
            thread.start();
        }

        countDownLatch.await();

        System.out.println("==end==" + num);
    }
}
