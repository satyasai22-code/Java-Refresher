package com.javarefresher.week03.CallableAndFuture07;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFutureTest
{
  public static void main(String[] args) throws Exception
  {
    FutureTask[] randomNumberTasks = new FutureTask[5];
    for (int i = 0; i < 5; i++) {
      Callable callable = new CustomCallable();
      randomNumberTasks[i] = new FutureTask(callable);
      Thread t = new Thread(randomNumberTasks[i]);
      t.start();
    }
    for (int i = 0; i < 5; i++){
      System.out.println(randomNumberTasks[i].get());
    }
  }
}