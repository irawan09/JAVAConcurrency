package reference1.ConcurrentLibrary.CountDownLatch;

import static reference1.ConcurrentLibrary.CountDownLatch.ThreadColor.*;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private int id;
    private CountDownLatch latch;

    public Worker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        doWork();
        latch.countDown();
    }

    private void doWork() {
        try {
            System.out.println(ANSI_BLUE+"Thread with ID: "+this.id+" starts working");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
