package AnotherSources.ConcurrentLibrary.PriorityBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class App {

    /**
     * It implements the BlockingQueue interface
     *
     * 	- unbounded concurrent queue
     * 	- it uses the same ordering rules as the java.util.PriorityQueue class -> have to implement the COmparable interface
     * 			The comparable interface will determine what will the order in the queue
     *
     * 			The priority can be the same compare() == 0 case
     *
     *  - no null items !!!
     *
     *
     */

    public static void main(String[] args){

        BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();

        FirstWorker firstWorker = new FirstWorker(blockingQueue);
        SecondWorker secondWorker = new SecondWorker(blockingQueue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
