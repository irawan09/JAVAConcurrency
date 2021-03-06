package reference1.ConcurrentLibrary.BlockingQueue;

import static reference1.ConcurrentLibrary.BlockingQueue.ThreadColor.*;
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
                Thread.sleep(100);
                blockingQueue.put(counter);
                System.out.println(ANSI_BLUE+"Append item into the queue "+counter);
                counter++;
                System.out.println(ANSI_PURPLE+"Content of BLockingQueue : " + blockingQueue ) ;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
