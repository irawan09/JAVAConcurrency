package AnotherSources.ConcurrentLibrary.BlockingQueue;

import static AnotherSources.ConcurrentLibrary.BlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class FirstWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        try {
            while(true){
                blockingQueue.put(counter);
                System.out.println(ANSI_BLUE+"Append item into the queue "+counter);
                counter++;
                System.out.println(ANSI_PURPLE+"Content of BLockingQueue : " + blockingQueue ) ;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
