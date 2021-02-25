package com.core.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String []args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CountDownLatch latch = new CountDownLatch(3);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        try {
            latch.await();
            System.out.println("All dependant services initialized");
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class DependentService implements Runnable {

        private CountDownLatch latch;
        public DependentService(CountDownLatch latch) { this.latch = latch; }

        @Override
        public void run() {
            System.out.println("Calling countDown by "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
