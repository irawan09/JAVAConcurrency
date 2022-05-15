package AnotherSources.ConcurrentLibrary.ConcurrentMaps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class App {

    public static void main(String[] args){

        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        FirstWorker firstWorker = new FirstWorker(map);
        SecondWorker secondWorker = new SecondWorker(map);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
