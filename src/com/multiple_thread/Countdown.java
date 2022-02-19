package com.multiple_thread;

public class Countdown {

//    https://www.guru99.com/java-stack-heap.html
//    Object instance store in the heap memory, which is share across the thread in the application.
//    private int i;

    public void doCountDown(){
        String color;

        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
                break;
        }

        for(int i=10; i>0;i--){
            System.out.println(color+Thread.currentThread().getName()+": i = "+i);
        }
    }
}
