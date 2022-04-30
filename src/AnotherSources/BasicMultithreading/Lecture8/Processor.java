package AnotherSources.BasicMultithreading.Lecture8;

import static AnotherSources.BasicMultithreading.Lecture8.ThreadColor.ANSI_BLUE;
import static AnotherSources.BasicMultithreading.Lecture8.ThreadColor.ANSI_RED;

public class Processor {

    public void produce() throws InterruptedException {

        synchronized (this){
            System.out.println(ANSI_BLUE+"We are in the producer method...");
            wait(10000);
            System.out.println(ANSI_BLUE+"Still on producer method...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (this){
            System.out.println(ANSI_RED+"We are in the Consumer method...");
            notify();
            notifyAll();
            Thread.sleep(3000);
        }
    }
}
