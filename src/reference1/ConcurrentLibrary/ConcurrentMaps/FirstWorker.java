package reference1.ConcurrentLibrary.ConcurrentMaps;

import java.util.concurrent.ConcurrentMap;

public class FirstWorker implements Runnable{

    private ConcurrentMap<String, Integer> map;

    public FirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("B", 12);
            Thread.sleep(1000);
            map.put("Z", 5);
            map.put("A", 25);
            Thread.sleep(2000);
            map.put("D", 19);
            System.out.println("All the map: "+map);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
