package reference1.BasicMultithreading.Lecture13;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static reference1.BasicMultithreading.Lecture13.ThreadColor.*;

public class Lecture13 {

    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args){

        Lecture13 deadlock = new Lecture13();

        new Thread(deadlock::operation1, ANSI_BLUE+"t1").start();
        new Thread(deadlock::operation2, ANSI_RED+"t2").start();
    }

    public void operation1(){
        lock1.lock();
        System.out.println(ANSI_BLUE+"Lock1 acquired, waiting to acquire lock2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println(ANSI_BLUE+"Lock2 acquired");

        System.out.println(ANSI_BLUE+"Executing first operation...");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2(){
        lock2.lock();
        System.out.println(ANSI_RED+"Lock2 acquired, waiting to acquire lock1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println(ANSI_RED+"Lock1 acquired");

        System.out.println(ANSI_RED+"Executing second operation...");

        lock1.unlock();
        lock2.unlock();
    }
}
