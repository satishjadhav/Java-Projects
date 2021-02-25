package com.kktutorials.future;


import java.util.concurrent.*;

public class ClientTestCallable {

    public static void main(String []args) {
        Callable<String> task = () -> "My task is done";

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(task);
        System.out.println("Task started");
        if(future.isDone()) {
            try {
                System.out.println(future.get());
                System.out.println("Task completed");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main completed");
    }
}
