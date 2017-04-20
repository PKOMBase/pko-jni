package com.thread.state;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Object object = new Object();
        // CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread mainThread = Thread.currentThread();
        System.out.println("excute by main: " + mainThread.getName());

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Thread t1Thread = Thread.currentThread();
                System.out.println("excute by thread: " + t1Thread.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    System.out.println(object.hashCode());
                    try {
                        object.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println("step3, thread state:" + t1Thread.getState() + ", main state:"
                        + mainThread.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // countDownLatch.countDown();
            }
        }, "t1");

        System.out.println("step1, thread state:" + thread.getState() + ", main state:" + mainThread.getState());

        thread.start();
        System.out.println("step2, thread state:" + thread.getState() + ", main state:" + mainThread.getState());

        // System.out.println("join the thread: " + thread.getName());
        // try {
        // thread.join();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // System.out.println("un join the thread: " + thread.getName());

        System.out.println("step4, thread state:" + thread.getState() + ", main state:" + mainThread.getState());

        // countDownLatch.await();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object) {
            object.notify();
        }

        System.out.println("step5, thread state:" + thread.getState() + ", main state:" + mainThread.getState());

    }
}
