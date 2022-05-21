package reference1.BasicMultithreading.Lecture12;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends Thread {

    AtomicInteger count;

    Counter(){
        count = new AtomicInteger();
    }

    public void run(){

        int max = 1_000_000;

        for (int i=0; i<max;i++){
            count.addAndGet(1);
        }
    }
}
