package com.javarefresher.week04.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class ForkJoinAdd extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 2;

    public ForkJoinAdd(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinAdd(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        int length = end - start;
        if (length <= THRESHOLD) {
            return add();
        }
        int mid = start + length/2;
        ForkJoinAdd firstTask = new ForkJoinAdd(numbers, start, mid);
        ForkJoinAdd secondTask = new ForkJoinAdd(numbers, mid, end);
        firstTask.fork(); 
        secondTask.fork();
        return firstTask.join() + secondTask.join();

    }

    private long add() {
        long result = 0;
        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }
}
public class NumberSumTest {
    public static void main(String[] args) {
        long[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinTask<Long> task = new ForkJoinAdd(numbers);
        Long result = pool.invoke(task);
        System.out.println(result);
    }
}
