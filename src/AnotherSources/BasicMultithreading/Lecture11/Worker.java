package AnotherSources.BasicMultithreading.Lecture11;

import static AnotherSources.BasicMultithreading.Lecture11.ThreadColor.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println(ANSI_BLUE+"Produce method...");
        condition.await();
        System.out.println(ANSI_BLUE+"Producer method again...");
    }

    public void consume() throws InterruptedException {
        lock.lock();
        Thread.sleep(2000);
        System.out.println(ANSI_RED+"Consumer method...");
        Thread.sleep(3000);
        condition.signal();
        lock.unlock();
    }
}
