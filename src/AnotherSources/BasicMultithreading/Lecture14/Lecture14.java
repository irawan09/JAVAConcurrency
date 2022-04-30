package AnotherSources.BasicMultithreading.Lecture14;

import static AnotherSources.BasicMultithreading.Lecture14.ThreadColor.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lecture14 {

    private static Lock lock1 = new ReentrantLock(true);
    private static Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args){
        Lecture14 liveLock = new Lecture14();
        new Thread(liveLock::operation1, ANSI_BLUE+"t1").start();
        new Thread(liveLock::operation2, ANSI_RED+"t2").start();

    }

    public void operation1(){
        while (true){
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ANSI_BLUE+"Lock1 acquired, trying to acquire lock2");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (lock2.tryLock()){
                System.out.println(ANSI_BLUE+"Lock2 acquired");
            } else {
                System.out.println(ANSI_BLUE+"cannot acquired lock2, releaseing lock1");
                lock1.unlock();
                continue;
            }
            System.out.println(ANSI_BLUE+"executing first operation...");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true){
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ANSI_RED+"Lock2 acquired, trying to acquire lock1");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(lock1.tryLock()){
                System.out.println(ANSI_RED+"Lock1 acquired");
            } else {
                System.out.println(ANSI_RED+"cannot acquire lock1, releasing lock2");
                lock2.unlock();
                continue;
            }
            System.out.println(ANSI_RED+"executing second operation...");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
