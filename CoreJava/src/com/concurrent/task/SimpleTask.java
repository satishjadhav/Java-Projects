package com.concurrent.task;

public class SimpleTask implements Runnable
{
      int threadCount;

@Override
      public void run() 
      {
            threadCount=Thread.activeCount();
            System.out.println("==============>"+threadCount);
            System.out.println("SimpleTask, Runnable: Executing Logic");

      }        

}