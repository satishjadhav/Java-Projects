package com.kktutorials.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsPeriodicTest {

    public static void main(String []args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        MyTask myTask = new MyTask();
        scheduledExecutorService.scheduleAtFixedRate(myTask, 0, 3, TimeUnit.SECONDS);
        //scheduledExecutorService.shutdown();
    }
}
