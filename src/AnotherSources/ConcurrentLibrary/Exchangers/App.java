package AnotherSources.ConcurrentLibrary.Exchangers;

import java.util.concurrent.Exchanger;

public class App {
    /**
     * With the help of Exchanger -> two threads can exchange objects
     *
     * exchange() -> exchanging objects is done via one of the two exchange()
     * methods
     *
     * 	For example: genetic algorithms, training neural networks
     *
     */

    public static void main(String[] args){

        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new FirstWorker(exchanger)).start();
        new Thread(new SecondWorker(exchanger)).start();
    }
}
