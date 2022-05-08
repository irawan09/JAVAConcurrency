package AnotherSources.BasicMultithreading.ThreadPooling.ExecutorsService;

import static AnotherSources.BasicMultithreading.ThreadPooling.ExecutorsService.ThreadColor.*;

public class ScheduledWorker implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Scheduled worker updated");
    }
}
