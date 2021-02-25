package com.core.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String []args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        service.execute(new Task(cyclicBarrier));
        service.execute(new Task(cyclicBarrier));
        service.execute(new Task(cyclicBarrier));

        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+" terminated main thread.");
    }

    public static class Task implements Runnable {

        private CyclicBarrier barrier;
        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println(Thread.currentThread().getName()+" awaiting on barrier.");
                    barrier.await();
                    break;
                }catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
