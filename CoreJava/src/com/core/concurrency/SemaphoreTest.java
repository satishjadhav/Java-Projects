package com.core.concurrency;

import javafx.scene.control.SeparatorMenuItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreTest {

    public static void main(String []args) {
        Semaphore semaphore = new Semaphore(3);

        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> service.execute(new Task(semaphore)));

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        Semaphore semaphore ;
        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                //semaphore.acquire();
                semaphore.acquireUninterruptibly();
                System.out.println(Thread.currentThread().getName()+" acquired semaphore ");
                //Thread.sleep(1000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+" released semaphore ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
