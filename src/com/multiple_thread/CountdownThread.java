package com.multiple_thread;

public class CountdownThread extends Thread{
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }

    public void run(){
        threadCountdown.doCountDown();
    }
}
