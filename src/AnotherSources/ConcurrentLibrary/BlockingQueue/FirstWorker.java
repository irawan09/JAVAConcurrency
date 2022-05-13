package AnotherSources.ConcurrentLibrary.BlockingQueue;

import static AnotherSources.ConcurrentLibrary.BlockingQueue.ThreadColor.*;
import java.util.concurrent.BlockingQueue;

public class FirstWorker implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public FirstWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(ANSI_BLUE+"A");
            blockingQueue.put(ANSI_RED+"B");
            blockingQueue.put(ANSI_GREEN+"C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
