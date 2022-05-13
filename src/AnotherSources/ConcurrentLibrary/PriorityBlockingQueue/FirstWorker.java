package AnotherSources.ConcurrentLibrary.PriorityBlockingQueue;

import static AnotherSources.ConcurrentLibrary.PriorityBlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class FirstWorker implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public FirstWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Inserting data ");
            blockingQueue.put(ANSI_BLUE+"A");
            System.out.println("Inserting data ");
            blockingQueue.put(ANSI_RED+"B");
            System.out.println("Inserting data ");
            blockingQueue.put(ANSI_GREEN+"C");
            System.out.println(ANSI_PURPLE+"All the Queue "+ blockingQueue);
            Thread.sleep(2000);
            System.out.println("Inserting data ");
            blockingQueue.put(ANSI_BLUE+"A");
            Thread.sleep(1000);
            System.out.println("Inserting data ");
            blockingQueue.put(ANSI_GREEN+"C");
            System.out.println(ANSI_PURPLE+"All the Queue"+ blockingQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
