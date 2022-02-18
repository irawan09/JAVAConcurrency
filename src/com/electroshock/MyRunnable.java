package com.electroshock;

import static com.electroshock.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello from Runnable Class Thread");
    }
}
