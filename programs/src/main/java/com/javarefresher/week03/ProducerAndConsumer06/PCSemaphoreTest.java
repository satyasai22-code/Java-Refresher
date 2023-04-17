package com.javarefresher.week03.ProducerAndConsumer06;

import java.util.concurrent.Semaphore;

class PCSemaphore {
    // an item
    int item;
  

    static Semaphore semCon = new Semaphore(0);
  
    static Semaphore semProd = new Semaphore(1);
  
    // to get an item from buffer
    void get()
    {
        try {
            // Before consumer can consume an item,
            // it must acquire a permit from semCon
            semCon.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
  
        // consumer consuming an item
        System.out.println("Consumer consumed item : " + item);
  
        // After consumer consumes the item,
        // it releases semProd to notify producer
        semProd.release();
    }
  
    // to put an item in buffer
    void put(int item)
    {
        try {
            // Before producer can produce an item,
            // it must acquire a permit from semProd
            semProd.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
  
        // producer producing an item
        this.item = item;
  
        System.out.println("Producer produced item : " + item);
  
        // After producer produces the item,
        // it releases semCon to notify consumer
        semCon.release();
    }
}
  
// Producer class
class Producer implements Runnable {
    PCSemaphore q;
    Producer(PCSemaphore q)
    {
        this.q = q;
        new Thread(this, "Producer").start();
    }
  
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // producer put items
            q.put(i);
    }
}
  
// Consumer class
class Consumer implements Runnable {
    PCSemaphore q;
    Consumer(PCSemaphore q)
    {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
  
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // consumer get items
            q.get();
    }
}
  
// Driver class
public class PCSemaphoreTest {
    public static void main(String args[])
    {

        PCSemaphore q = new PCSemaphore();
        new Consumer(q);
        new Producer(q);
    }
}