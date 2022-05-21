package reference1.BasicMultithreading.ThreadPooling.ExecutorsService;

import static reference1.BasicMultithreading.ThreadPooling.ExecutorsService.ThreadColor.*;

public class Worker implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(ANSI_BLUE+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
