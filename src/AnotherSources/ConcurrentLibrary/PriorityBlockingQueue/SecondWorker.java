package AnotherSources.ConcurrentLibrary.PriorityBlockingQueue;

import static AnotherSources.ConcurrentLibrary.PriorityBlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public SecondWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            System.out.println(ANSI_BLUE+"Remove "+blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(ANSI_RED+"Remove "+blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(ANSI_GREEN+"Remove "+blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(ANSI_BLUE+"Remove "+blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(ANSI_GREEN+"Remove "+blockingQueue.take());

            System.out.println(ANSI_PURPLE+"All the queue : "+blockingQueue);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
