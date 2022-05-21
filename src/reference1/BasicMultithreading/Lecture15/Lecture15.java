package reference1.BasicMultithreading.Lecture15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lecture15 {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<15;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.downloadData();
                }
            });
        }
    }
}
