package reference1.BasicMultithreading.Lecture15;

import static reference1.BasicMultithreading.Lecture15.ThreadColor.*;
import java.util.concurrent.Semaphore;

enum Downloader {

    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true);

    public void downloadData(){
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public void download(){
        System.out.println(ANSI_BLUE+"Downloading data from the web...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
