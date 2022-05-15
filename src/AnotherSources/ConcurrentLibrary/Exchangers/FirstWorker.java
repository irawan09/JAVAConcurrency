package AnotherSources.ConcurrentLibrary.Exchangers;

import static AnotherSources.ConcurrentLibrary.Exchangers.ThreadColor.*;
import java.util.concurrent.Exchanger;

public class FirstWorker implements Runnable {

    private int counter;
    private Exchanger<Integer> exchanger;

    public FirstWorker(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            counter = counter+1;
            System.out.println(ANSI_BLUE+"FirstWorker incremented the counter: "+counter);

            try {
                counter = exchanger.exchange(counter);
                System.out.println(ANSI_BLUE+"FirstWorker counter value after exchange: "+counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
