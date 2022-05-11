package AnotherSources.ConcurrentLibrary.CountDownLatch;

import static AnotherSources.ConcurrentLibrary.CountDownLatch.ThreadColor.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {


    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            service.execute(new Worker(i, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_RED+"All tasks have been finished...");
        service.shutdown();
    }

}
