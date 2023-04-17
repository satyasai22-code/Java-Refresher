package com.javarefresher.week03.Executors05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<String> {
    private String message;
 
    public Task(String message)
    {
        this.message = message;
    }
 
    public String call() throws Exception
    {
        return "Hi " + message + "!";
    }
}

public class FixedThreadPool {

    public static void main(String[] args)
    {

        Task task = new Task("Task1");
 
        // Creating object of ExecutorService class and
        // Future object Class
        ExecutorService executorService
            = Executors.newFixedThreadPool(4);
        Future<String> result
            = executorService.submit(task);
        try {
            System.out.println(result.get());
        }
 
        catch (InterruptedException
               | ExecutionException e) {
 
            // Display message only
            System.out.println(
                "Error occurred while executing the submitted task");
 
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}