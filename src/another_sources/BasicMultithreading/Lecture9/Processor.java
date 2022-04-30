package another_sources.BasicMultithreading.Lecture9;

import java.util.ArrayList;
import java.util.List;

import static another_sources.BasicMultithreading.Lecture9.ThreadColor.ANSI_BLUE;
import static another_sources.BasicMultithreading.Lecture9.ThreadColor.ANSI_RED;

public class Processor {

    private List<Integer> list = new ArrayList<>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {

        synchronized (lock){

            while (true){
                if(list.size() == LIMIT){
                    System.out.println(ANSI_BLUE+"Waiting for removing items from the list...");
                    lock.wait();
                } else {
                    System.out.println(ANSI_BLUE+"Adding: "+value);
                    list.add(value);
                    value++;
                    lock.notify();
                }

                Thread.sleep(1000);
            }
        }
    }

    public void consumer() throws InterruptedException {

        synchronized (lock){

            while (true){

                if(list.size() == BOTTOM){
                    System.out.println(ANSI_RED+"Waiting for adding items to the list...");
                    lock.wait();
                } else {
                    System.out.println(ANSI_RED+"Removed: "+list.remove(--value));
                    lock.notify();
                }

                Thread.sleep(1000);
            }
        }
    }
}
