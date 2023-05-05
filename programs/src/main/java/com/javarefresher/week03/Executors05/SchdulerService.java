package com.javarefresher.week03.Executors05;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchdulerService {
    
    public static void main(String[] args)
    {
        System.out.println(
            "A count-down-clock program that counts from 10 to 0");
  
        // creating a ScheduledExecutorService object
        ScheduledExecutorService scheduler
            = Executors.newScheduledThreadPool(11);

            // printing the current time
        System.out.println(
            "Current time : "
            + Calendar.getInstance().get(Calendar.SECOND));
  
        // Scheduling the tasks
        for (int i = 10; i >= 0; i--) {
            scheduler.schedule(new Task(i), 10 - i,
                               TimeUnit.SECONDS);
        }
  
        scheduler.shutdown();
    }
}
  
class Task implements Runnable {
    private int num;
    public Task(int num) { this.num = num; }
    public void run()
    {
        System.out.println(
            "Number " + num + " Current time : "
            + Calendar.getInstance().get(Calendar.SECOND));
    }
}
