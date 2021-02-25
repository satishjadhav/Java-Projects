package com.core.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableTest1 {

    public static void main(String args[]) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future> allFutures = new ArrayList<>();

        for (int i=0;i<100;i++) {
            Future<Integer> future = service.submit(()->{
                    Thread.sleep(3000);
                    return new Random().nextInt();
            });
            allFutures.add(future);
        }

        for(int i=0;i<100;i++) {
            Future<Integer> future = allFutures.get(i);
            Integer result = null;
            try {
                result = future.get();
                System.out.println("Result of future "+i+" = "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
