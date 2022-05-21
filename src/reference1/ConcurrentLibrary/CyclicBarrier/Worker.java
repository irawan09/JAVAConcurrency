package reference1.ConcurrentLibrary.CyclicBarrier;

import static reference1.ConcurrentLibrary.CyclicBarrier.ThreadColor.*;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable{

    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    public Worker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.random = new Random();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println(ANSI_BLUE+"Thread with ID  "+id+" starts the task...");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_RED+"Thread with ID "+id+" finished...");

        try {
            cyclicBarrier.await();
            System.out.println(ANSI_GREEN+"After await...");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return ""+this.id;
    }
}
