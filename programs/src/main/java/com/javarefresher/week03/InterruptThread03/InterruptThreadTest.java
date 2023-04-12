package com.javarefresher.week03.InterruptThread03;

public class InterruptThreadTest {
    public static void main(String[] args)
            throws InterruptedException
    {
        InterruptThread thread = new InterruptThread();
        thread.start();

        thread.interrupt();
        System.out.println("Main thread execution is completed");
    }
}