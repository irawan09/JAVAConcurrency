package com.electroshock;

import static com.electroshock.ThreadColor.ANSI_GREEN;
import static com.electroshock.ThreadColor.ANSI_PURPLE;

public class Main {

    public static void main(String[] args){
        System.out.println(ANSI_PURPLE+"Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("ANOTHER THREAD");
        anotherThread.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"Hello from anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE+"Hello again from main thread");
    }
}
