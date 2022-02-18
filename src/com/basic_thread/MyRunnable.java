package com.basic_thread;

import static com.basic_thread.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello from Runnable Class Thread");
    }
}
