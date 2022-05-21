package reference1.ConcurrentLibrary.Exchangers;

import static reference1.ConcurrentLibrary.Exchangers.ThreadColor.*;
import java.util.concurrent.Exchanger;

public class SecondWorker implements Runnable{

    private int counter;
    private Exchanger<Integer> exchanger;

    public SecondWorker(Exchanger<Integer> exchanger) {
        this.exchanger= exchanger;
    }

    @Override
    public void run() {
        while (true){
            counter = counter-1;
            System.out.println(ANSI_RED+"SecondWorker decremented the counter: "+counter);

            try {
                counter = exchanger.exchange(counter);
                System.out.println(ANSI_RED+"SecondWorker counter value after exchange: "+counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
