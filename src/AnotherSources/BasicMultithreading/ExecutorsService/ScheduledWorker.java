package AnotherSources.BasicMultithreading.ExecutorsService;

import static AnotherSources.BasicMultithreading.ExecutorsService.ThreadColor.*;

public class ScheduledWorker implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Scheduled worker updated");
    }
}
