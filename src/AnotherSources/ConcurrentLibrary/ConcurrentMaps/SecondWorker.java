package AnotherSources.ConcurrentLibrary.ConcurrentMaps;

import static AnotherSources.ConcurrentLibrary.ConcurrentMaps.ThreadColor.*;
import java.util.concurrent.ConcurrentMap;

public class SecondWorker implements Runnable{

    private ConcurrentMap<String, Integer> map;

    public SecondWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            System.out.println(ANSI_CYAN+"Get the value: "+map.get("B"));
            System.out.println(ANSI_BLUE+"Remove: "+map.remove("B"));
            Thread.sleep(2000);
            System.out.println(ANSI_RED+"Remove: "+map.remove("Z"));
            System.out.println(ANSI_GREEN+"Remove: "+map.remove("A"));
            Thread.sleep(2000);
            System.out.println(ANSI_PURPLE+"Remove: "+map.remove("D"));
            System.out.println("All the map after remove: "+ map);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
