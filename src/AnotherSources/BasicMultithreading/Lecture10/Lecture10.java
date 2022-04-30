package AnotherSources.BasicMultithreading.Lecture10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static AnotherSources.BasicMultithreading.Lecture10.ThreadColor.*;

public class Lecture10 {

    private static int counter  = 0;
    private static Lock lock = new ReentrantLock();

    public static void main (String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                firstThread();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                secondThread();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_PURPLE+"Counter: "+counter);
    }

    public static void increment(){
        lock.lock();
        counter++;
        lock.unlock();
    }

    public static void firstThread(){
        System.out.println(ANSI_BLUE+"First Thread started...");
        for(int i=0;i<1000;i++){
            increment();
        }
    }

    public static void secondThread(){
        System.out.println(ANSI_RED+"Second Thread started...");
        for(int i=0; i<1000;i++){
            increment();
        }
    }
}
