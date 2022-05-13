package AnotherSources.ConcurrentLibrary.BlockingQueue;

import static AnotherSources.ConcurrentLibrary.BlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable{

    BlockingQueue<String> blockingQueue;

    public SecondWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ANSI_PURPLE+"Content of BLockingQueue : " + blockingQueue ) ;
    }
}
