package AnotherSources.ConcurrentLibrary.DelayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

import static AnotherSources.ConcurrentLibrary.DelayQueue.ThreadColor.*;

public class App {
    /**
     * This is an unbounded BlockingQueue of objects that implement the Delayed
     * interface
     *
     * - DelayQueue keeps the elements internally until a certain delay has expired
     *
     * - an object can only be taken from the queue when its delay has expired !!! -
     *
     * We cannot place null items in the queue - The queue is sorted so that the
     * object at the head has a delay that has expired for the longest time.
     *
     * If no delay has expired, then there is no head element and poll( ) will
     * return null
     *
     * size() return the count of both expired and unexpired items !!!
     *
     */

    public static void main(String[] args){

        BlockingQueue<DelayedWorker> delayedWorkers = new DelayQueue<>();

        try {
            delayedWorkers.put(new DelayedWorker(2000, ANSI_BLUE+"This is the first message..."));
            delayedWorkers.put(new DelayedWorker(10000, ANSI_RED+"This is the second message..."));
            delayedWorkers.put(new DelayedWorker(4500, ANSI_GREEN+"This is the second message..."));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(delayedWorkers.isEmpty()){
            try {
                System.out.println(delayedWorkers.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
