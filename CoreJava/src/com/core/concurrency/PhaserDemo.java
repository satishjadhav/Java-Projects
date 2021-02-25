package com.core.concurrency;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String []args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(1);
        service.execute(new Service(phaser));
        service.execute(new Service(phaser));
        phaser.arriveAndAwaitAdvance();
        phaser.bulkRegister(4);
        System.out.println("Terminating executor service...");
        service.shutdown();
        while (service.isShutdown()) {
            service.shutdown();
        }
    }
    private static void detectDeadLock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        boolean deadLock = threadIds!=null && threadIds.length > 0;
        System.out.println("Deadlocks found: " + deadLock);
    }

    public static class Service implements Runnable {

        private Phaser phaser;
        public Service(Phaser phaser) { this.phaser = phaser; }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+ " registering phaser..");
                phaser.register();
                System.out.println(Thread.currentThread().getName()+ " arrived phaser..");
                phaser.arrive();
            } catch (Exception e) {

            }
        }
    }
}
