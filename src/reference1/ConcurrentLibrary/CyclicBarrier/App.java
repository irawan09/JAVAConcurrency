package reference1.ConcurrentLibrary.CyclicBarrier;

import static reference1.ConcurrentLibrary.CyclicBarrier.ThreadColor.*;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    /**
     *
     * Latch --> multiple threads can wait for each other
     *
     * A CyclicBarrier is used in situations where you want to create a group of
     * tasks to perform work in parallel + wait until they are all finished before
     * moving on to the next step -> something like join() -> something like
     * CountDownLatch
     *
     * CountDownLatch: one-shot event CyclicBarrier: it can be reused over and over
     * again
     *
     * + cyclicBarrier has a barrier action: a runnable, that will run automatically
     * when the count reaches 0 !!
     *
     * new CyclicBarrier(N) -> N threads will wait for each other
     *
     * WE CAN NOT REUSE LATCHES BUT WE CAN REUSE CyclicBarriers --> reset() !!!
     *
     */

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_PURPLE+"We are able to use the trained neural network...");
            }
        });

        for(int i=0; i<5;i++){
            executorService.execute(new Worker(i+1, cyclicBarrier));
        }

        executorService.shutdown();
    }
}
