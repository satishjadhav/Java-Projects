package com.concurrent.executer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ConcurrentHashMap;

public class ExecutorServiceTest {

	private static Future taskTwo = null;
	private static Future taskThree = null;
	public static ConcurrentHashMap<Long,Message> map=null;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
	   
                  map=new ConcurrentHashMap<Long,Message>();
		// execute the Runnable
	    Runnable task1 = new MyThread("Add1", 2, 100);
                   Runnable task2 = new MyThread("Add2", 2, 100);
                   Runnable task3 = new MyThread("Del1", 2, 100);
                   Runnable task4 = new MyThread("Del2", 2, 100);
                   Runnable task5 = new MyThread("GC", 2, 100);
                   
	    executor.execute(task1);
                   executor.execute(task2);
                   executor.execute(task3);
                   executor.execute(task4);
                   executor.execute(task5);


	    /*for(int i = 0; i < 2; i++) 
                    {
	    	// if this task is not created or is canceled or is completed
			if ((taskTwo == null) || (taskTwo.isDone()) || (taskTwo.isCancelled())) {
				// submit a task and return a Future
				taskTwo = executor.submit(new MyThread("TaskTwo", 4, 200));
			}
	
			if ((taskThree == null) || (taskThree.isDone()) || (taskThree.isCancelled())) {
				taskThree = executor.submit(new MyThread("TaskThree", 5, 100));
			}
			// if null the task has finished
			if(taskTwo.get() == null) {
				System.out.println(i+1 + ") TaskTwo terminated successfully");
			} else {
				// if it doesn't finished, cancel it
				taskTwo.cancel(true);
			}
			if(taskThree.get() == null) {
				System.out.println(i+1 + ") TaskThree terminated successfully");
			} else {
				taskThree.cancel(true);
			}
	    }*/
	    executor.shutdown();
	    System.out.println("-----------------------");
	    // wait until all tasks are finished
	    executor.awaitTermination(1, TimeUnit.SECONDS);
	    System.out.println("All tasks are finished!");
	
	}

}