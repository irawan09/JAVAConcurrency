package com.concurrent_package;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.concurrent_package.Main.EOF;

public class MyConsumer implements Runnable{

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buff, String col, ReentrantLock buffLock){
        this.buffer = buff;
        this.color = col;
        this.bufferLock = buffLock;
    }

    @Override
    public void run() {
        while (true){
            bufferLock.lock();
                if(buffer.isEmpty()){
                    bufferLock.unlock();
                    continue;
                }
                if (buffer.get(0).equals(EOF)){
                    System.out.println(color+"Exiting");
                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(color+"Removed "+buffer.remove(0));
                }
            bufferLock.unlock();
        }
    }
}
