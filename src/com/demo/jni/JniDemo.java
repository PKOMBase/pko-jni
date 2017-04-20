package com.demo.jni;

/**
 * 
 * JNI: Java Native Interface
 * 
 * 动态库：win(.dll)，mac(.dylib)
 * 
 * @author sunjie at 2017年2月11日
 *
 */
public class JniDemo {

    public native int add(int a, int b);

    public static native void start(String s);

    public static void main(String[] args) throws InterruptedException {

        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("sun.boot.library.path"));
        System.out.println(System.mapLibraryName("jniDemo"));

        System.out.println("start jni====");

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.loadLibrary("jniDemo");
            }
        });
        thread1.start();

        Thread.sleep(1000);
        JniDemo.start("hello jni!");

        JniDemo jniDemo = new JniDemo();
        System.out.println("add result:" + jniDemo.add(1, 5));
        System.out.println("end jni====");
    }
}
