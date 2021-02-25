package com.kktutorials.executor;

import java.util.concurrent.*;

public class ClientTest {
    public static void main(String []args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(100,
                10,
                1000, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("My Task...");
            }
        };

        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("My Task...");
        };
        MyTask task3 = new MyTask();

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();
    }

}
