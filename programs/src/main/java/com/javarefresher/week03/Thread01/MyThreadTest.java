package com.javarefresher.week03.Thread01;

public class MyThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();

        thread1.start();
        thread2.start();
        System.out.println("MyThreads has been started");
    }
}
