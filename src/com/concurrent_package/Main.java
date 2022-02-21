package com.concurrent_package;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args){

        //ArrayBlockingQueue
        //https://www.geeksforgeeks.org/arrayblockingqueue-poll-method-in-java/
//        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        List<String> buffer = new ArrayList<>();

        //Reentrant Lock in Java
        //https://www.geeksforgeeks.org/reentrant-lock-java/
        ReentrantLock bufferLock = new ReentrantLock();

        //ThreadPool
        //https://www.geeksforgeeks.org/thread-pools-java/
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_WHITE+"I am being printed from callable class");
            return "This is the callable results";
        });

        try {
            System.out.println(future.get());
        }catch (ExecutionException e){
            System.out.println("Something went wrong");
        }catch (InterruptedException e){
            System.out.println("Running thread was interrupted");
        }
        executorService.shutdown();

    }
}
