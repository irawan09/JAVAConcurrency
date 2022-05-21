package reference1.ConcurrentLibrary.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    /**
     *
     * 	BlockingQueue -> an interface that represents a queue that is thread safe
     * 		Put items or take items from it ...
     *
     * 		For example: one thread putting items into the queue and another thread taking items from it
     * 			at the same time !!!
     * 				We can do it with producer-consumer pattern !!!
     *
     * 		put() putting items to the queue
     * 		take() taking items from the queue
     *
     */

    public static void main(String[] args){

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        FirstWorker firstWorker = new FirstWorker(queue);
        SecondWorker secondWorker = new SecondWorker(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
