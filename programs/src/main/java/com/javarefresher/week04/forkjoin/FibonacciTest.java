package com.javarefresher.week04.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// fork and join program to find the Fibonacci number by using recursive loop - RecursiveAction

class Fibonacci extends RecursiveAction{

    private static final long THRESHOLD = 8;
    private long number;

    public Fibonacci(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    protected void compute() {
        long n = number;
        if (n <= THRESHOLD) {
            number = calculateFib(n);
        } else {
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
                        // ForkJoinTask.invokeAll(f1, f2);
            f1.fork();
            f2.fork();
            f1.join();
            f2.join();
            number = f1.number + f2.number;
        }
    }

    private static long calculateFib(long n) {
        if (n <= 1) return n;
        return calculateFib(n - 1) + calculateFib(n - 2);
    }
    
}

public class FibonacciTest{
    public static void main(String[] args) {
        Fibonacci task = new Fibonacci(40);
        ForkJoinPool.commonPool().invoke(task);
        System.out.println(task.getNumber());
    }
}
