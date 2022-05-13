package AnotherSources.ConcurrentLibrary.BlockingQueue;

import static AnotherSources.ConcurrentLibrary.BlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable{

    BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            int counter = blockingQueue.take();
            System.out.println(ANSI_RED+"Taking the item out off the queue "+counter);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ANSI_PURPLE+"Content of BLockingQueue : " + blockingQueue ) ;
    }
}
