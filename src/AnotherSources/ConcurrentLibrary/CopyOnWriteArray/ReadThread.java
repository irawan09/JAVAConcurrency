package AnotherSources.ConcurrentLibrary.CopyOnWriteArray;

import static AnotherSources.ConcurrentLibrary.CopyOnWriteArray.ThreadColor.*;
import java.util.Iterator;
import java.util.List;

public class ReadThread extends Thread{

    private List<Integer> list;

    public ReadThread(String name, List<Integer> list){
        this.list = list;
        super.setName(name);
    }

    public void run(){
        String output = "\n" + super.getName() + ":";

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            Integer next = iterator.next();
            output += " "+next;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(ANSI_RED+output);
        }
    }
}
