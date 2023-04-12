package com.javarefresher.week03.Thread01;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }
}
