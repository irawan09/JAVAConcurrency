package reference1.ConcurrentLibrary.BlockingQueue;

import static reference1.ConcurrentLibrary.BlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable{

    BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            int counter = blockingQueue.take();
            System.out.println(ANSI_RED+"Taking the item out off the queue "+counter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ANSI_PURPLE+"Content of BLockingQueue : " + blockingQueue ) ;
    }
}
