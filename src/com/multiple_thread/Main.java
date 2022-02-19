package com.multiple_thread;

public class Main {

    public static void main(String[] args){
        // countdown instance is share during the execution of the thread
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
