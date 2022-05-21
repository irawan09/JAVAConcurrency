package reference2.concurrent_package;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MyProducer implements Runnable{

    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buff, String col, ReentrantLock buffLock){
        this.buffer = buff;
        this.color = col;
        this.bufferLock = buffLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4"};

        for(String num: nums){
            try {
                System.out.println(color+"Adding..."+num);
                bufferLock.lock();
                try{
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                System.out.println("Producer was Interrupted");
            }
        }

        System.out.println(color+"Adding EOF and exiting...");
        bufferLock.lock();
        try{
            buffer.add("EOF");
        }finally {
            bufferLock.unlock();
        }
    }
}
