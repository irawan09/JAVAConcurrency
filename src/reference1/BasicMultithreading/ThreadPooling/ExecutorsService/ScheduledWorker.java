package reference1.BasicMultithreading.ThreadPooling.ExecutorsService;

import static reference1.BasicMultithreading.ThreadPooling.ExecutorsService.ThreadColor.*;

public class ScheduledWorker implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Scheduled worker updated");
    }
}
